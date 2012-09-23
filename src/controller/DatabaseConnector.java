package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.print.attribute.DateTimeSyntax;
import javax.swing.JOptionPane;

import model.Document;
import model.Institute;
import model.Log;


/**
 * this class use for connect with database and query the document database.
 * @author Witsarut Mongkonphak
 *
 */
public class DatabaseConnector implements Connector{
	Connection con;
	Statement stmt;

	/**
	 * constructer will connect the database.
	 * @param user
	 * @param pass
	 */
	public DatabaseConnector(String user,String pass) 
	{

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/documentdb",user,pass);
			stmt = con.createStatement();

		}
		catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "ไม่สามารถติดต่อกับฐานข้อมูลได้ jdbc not found", "alert", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "ไม่สามารถติดต่อกับฐานข้อมูลได้", "alert", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}


	@Override
	public void addDocument(Document doc) throws SQLException {
		// TODO Auto-generated method stub
		stmt.execute("INSERT INTO  `documentdb`.`document` (`barcode` ,`nsf` ,`doc_num` ,`destination` ,`subject` , `date` ,`attach`) "
				+	"VALUES ('"+doc.getBarcode()+"',  '"+doc.getNameOfService()+"',  '"+doc.getDocumentNO()+"',  '"+doc.getDestination()+"',  '"+doc.getSubject()+"','"+doc.getDate()+"','"+doc.getAttach()+"');");
	}

	@Override
	public void addLog(String barcode,Log log) throws SQLException {
		// TODO Auto-generated method stub
		stmt.execute("INSERT INTO  `documentdb`.`log` ("
				+	"`barcode` ,`destination` ,`type` ,`datetime`) "
				+	"VALUES ('"+barcode+"',  '"+log.getDestinaion()+"',  '"+log.getType()+"',  '"+log.getDatetime()+"');");
	}

	@Override
	public void addInstitute(Institute institute) throws SQLException {
		// TODO Auto-generated method stub
		stmt.execute("INSERT INTO  `documentdb`.`institute` (`name` ,`type`)"
				+ " VALUES ('"+institute.getName()+"',  '"+institute.getType()+"');");
	}

	@Override
	public ArrayList<Document> getDoccumetByBarcode(String keyword)
			throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs  = stmt.executeQuery("SELECT * FROM `document` where barcode LIKE '"+keyword+"'");
		return pullDocumentResult(rs);
	}

	@Override
	public ArrayList<Document> getDoccumetByDestination(String keyword)
			throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs  = stmt.executeQuery("SELECT * FROM `document` where destination LIKE '"+keyword+"'");
		return pullDocumentResult(rs);
	}

	@Override
	public ArrayList<Document> getDoccumetBySubject(String keyword)
			throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs  = stmt.executeQuery("SELECT * FROM `document` where subject LIKE '"+keyword+"'");
		return pullDocumentResult(rs);
	}

	
	@Override
	public ArrayList<Document> getDoccumetByNameOfService(String keyword)
			throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs  = stmt.executeQuery("SELECT * FROM `document` where nfs LIKE '"+keyword+"'");
		return pullDocumentResult(rs);
	}
	
	/**
	 * convert Resultset to ArrayList of Document.
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private ArrayList<Document> pullDocumentResult(ResultSet rs) throws SQLException{
		ArrayList<Document> ans = new ArrayList<Document>();
        while (rs.next()) {
            String barcode = rs.getString("barcode");
            String nsf = rs.getString("nsf");
            String doc_num = rs.getString("doc_num");
            String s3 = rs.getString("destination");
            Institute institute = pullInstituteByname(s3);
            String subject = rs.getString("subject");
            String date = rs.getString("date");
            String attach = rs.getString("attach");
            ResultSet logrs  = con.createStatement().executeQuery("SELECT * FROM `Log` where barcode='"+barcode+"'");
            ans.add(new Document(barcode,pullLogResult(logrs), nsf, doc_num, institute, subject, Date.valueOf(date) ,attach));
            
        }
        rs.close();
		return ans;
	}
	
	@Override
	public ArrayList<Log> getLogByBarcode(String keyword) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs  = stmt.executeQuery("SELECT * FROM `Log` where barcode LIKE '"+keyword+"'");
		return pullLogResult(rs);
	}

	@Override
	public ArrayList<Log> getLogByDestination(String keyword)
			throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs  = stmt.executeQuery("SELECT * FROM `Log` where destination LIKE '"+keyword+"'");
		return pullLogResult(rs);
	}

	@Override
	public ArrayList<Log> getLogByDate(Date date) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs  = stmt.executeQuery("SELECT * FROM `Log` where datetime="+date.toString());
		return pullLogResult(rs);
	}
	
	public ArrayList<Log> getLogByType(String keyword) throws Exception{
		ResultSet rs  = stmt.executeQuery("SELECT * FROM `Log` where type LIKE '"+keyword+"'");
		return pullLogResult(rs);
	}
	
	/**
	 * Convert result set to Arraylist of Log
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private ArrayList<Log> pullLogResult(ResultSet rs) throws SQLException{
		ArrayList<Log> ans = new ArrayList<Log>();
        while (rs.next()) {
            String barcode = rs.getString("barcode");
            String name = rs.getString("destination");
            String type = rs.getString("type");
            Timestamp timestamp = rs.getTimestamp("datetime");
            //System.out.println(date);
            ans.add(new Log(barcode,pullInstituteByname(name), type, timestamp));
        }
        rs.close();
		return ans;
	}
	
	/**
	 * Get institute object form database by name.
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	private Institute pullInstituteByname(String name) throws SQLException{
		// ResultSet rs  = stmt.executeQuery("SELECT * FROM `institute` where name='"+name+"'");
		 ResultSet rs  = con.createStatement().executeQuery("SELECT * FROM `institute` where name='"+name+"'");
		 Institute i;
         if(rs.next()){
         	i = new Institute(rs.getString("name"), rs.getString("type"));
         	
         }else{
            i = new Institute(rs.getString("incorrect institute name"), rs.getString("null"));
         }
         rs.close();
         return i;
	}
	
	/**
	 * Convert Resultset to Arraylist if Institute.
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private ArrayList<Institute> pullInstituteResult(ResultSet rs) throws SQLException{
		ArrayList<Institute> ans = new ArrayList<Institute>();
        while (rs.next()) {
            String name = rs.getString("name");
            String type = rs.getString("type");
            ans.add(new Institute(name, type));
        }
        rs.close();
		return ans;
	}

	@Override
	public ArrayList<Institute> getInstituteByName(String keyword)
			throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs  = stmt.executeQuery("SELECT * FROM `institute` where name LIKE '"+keyword+"'");
		return pullInstituteResult(rs);
	}

	@Override
	public ArrayList<Institute> getInstituteByType(String keyword)
			throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs  = stmt.executeQuery("SELECT * FROM `institute` where type='"+keyword+"'");
		return pullInstituteResult(rs);
	}

	@Override
	public void UpdateDocument(Document doc) throws SQLException {
		// TODO Auto-generated method stub
		stmt.executeUpdate("UPDATE  `documentdb`.`document` SET `nsf`='"+doc.getNameOfService()+"' ,`doc_num`='"+doc.getDocumentNO()+"'"+
		" ,`destination`='"+doc.getDestination()+"' ,`subject`='"+doc.getSubject()+"' ,`date`='"+doc.getDate()+"' ,`attach`='"+doc.getAttach()+"' WHERE `barcode`='"+doc.getBarcode()+"'");
	}

	@Override
	public void UpdateInstitute(Institute institute,Institute old) throws SQLException {
		// TODO Auto-generated method stub
		stmt.executeUpdate("UPDATE  `documentdb`.`institute` SET `name`='"+institute.getName()+"' ,`type`='"+institute.getType()+"'"+
							" WHERE `name`='"+old.getName()+"' and`type`='"+old.getType()+"'");
		stmt.executeUpdate("UPDATE  `documentdb`.`document` SET `destination`='"+institute.getName()+"'"+
				" WHERE `destination`='"+old.getName()+"'");
		stmt.executeUpdate("UPDATE  `documentdb`.`log` SET `destination`='"+institute.getName()+"'"+
				" WHERE `destination`='"+old.getName()+"'");
	}

	/*@Override
	public void UpdateLog(Log log) throws SQLException {
		// TODO Auto-generated method stub
		stmt.execute("UPDATE  `documentdb`.`log` SET"
				+	"`destination`='"+log.getDestinaion()+"' ,`type`='"+log.getType()+"' ,`datetime`='"+log.getDatetime()+"' WHRER ");
	}
	*/






}


