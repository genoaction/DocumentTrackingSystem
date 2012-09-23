package controller;

import java.sql.Date;
import java.util.ArrayList;

import model.Document;
import model.Institute;
import model.Log;

/**
 * this is interface use for connect and query data with database ,file or another.
 * @author Witsarut Mongkonphak
 *
 */
public interface Connector {
	/**
	 * Add only document to database.
	 * @param doc
	 * @throws Exception
	 */
	public void addDocument(Document doc) throws Exception;
	
	/**
	 * Add only Log to database.
	 * @param barcode
	 * @param log
	 * @throws Exception
	 */
	public void addLog(String barcode,Log log) throws Exception;
	
	/**
	 * Add only institute to database.
	 * @param institute
	 * @throws Exception
	 */
	public void addInstitute(Institute institute) throws Exception;
	
	// read
	/**
	 * Get Document like keyword by barcode.
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Document> getDoccumetByBarcode(String keyword) throws Exception;
	
	/**
	 * Get Document like keyword by name of service.
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Document> getDoccumetByNameOfService(String keyword)  throws Exception;
	
	/**
	 * Get Document like keyword by destination.
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Document> getDoccumetByDestination(String keyword) throws Exception;
	
	/**
	 * Get Document like keyword by subject.
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Document> getDoccumetBySubject(String keyword) throws Exception;
	
	/**
	 * Get Log like keyword by barcode.
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Log> getLogByBarcode(String keyword) throws Exception;
	
	/**
	 * Get Log like keyword by destination name.
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Log> getLogByDestination(String keyword) throws Exception;
	
	/**
	 * Get Log like keyword by destination name.
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Log> getLogByType(String keyword) throws Exception;
	
	/**
	 * Get Log like keyword by Date.
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Log> getLogByDate(Date date) throws Exception;
	
	/**
	 * Get Institure like keyword by name.
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Institute> getInstituteByName(String keyword) throws Exception;
	
	/**
	 * Get Institure like keyword by type.
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Institute> getInstituteByType(String keyword) throws Exception;
	
	// update
	/**
	 * Update document details.
	 * @param doc
	 * @throws Exception
	 */
	public void UpdateDocument(Document doc) throws Exception;
	/**
	 * Update Institute details and 
	 * it will be update all table it have old name in destination column to new name if you change a name.
	 * @param institute
	 * @param old
	 * @throws Exception
	 */
	public void UpdateInstitute(Institute institute,Institute old) throws Exception;
	//public void UpdateLog(Log log) throws SQLException; //should not use.
	
	
	// delete
	// no delete method.
}
