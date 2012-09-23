package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 * this class store details of Document.
 * @author Witsarut Mongkonphak
 *
 */
public class Document {
	private String barcode;
	private ArrayList<Log> logArray;
	private String nameOfService;
	private String documentNO;
	private String subject;
	private Institute destination;
	private Date date;
	private String attach;
	
	public Document(String barcode,ArrayList<Log> logArray,String nameofservice ,String documentNO,Institute destination,String subject,Date date){
		this.barcode  = barcode;
		this.logArray = logArray;
		this.nameOfService  = nameofservice;
		this.documentNO = documentNO;
		this.destination = destination;
		this.subject =  subject;
		this.date = date;
	}
	
	public Document(String barcode,ArrayList<Log> logArray,String nameofservice ,String documentNO,Institute destination,String subject,Date date,String attach){
		this.barcode  = barcode;
		this.setLogArray(logArray);
		this.nameOfService  = nameofservice;
		this.documentNO = documentNO;
		this.destination = destination;
		this.subject =  subject;
		this.date = date;
		this.setAttach(attach);
	}
	
	public Document(String barcode,String nameofservice ,String documentNO,Institute destination,String subject,Date date,String attach){
		this.logArray = new ArrayList<Log>();
		this.barcode  = barcode;
		this.nameOfService  = nameofservice;
		this.documentNO = documentNO;
		this.destination = destination;
		this.subject =  subject;
		this.date = date;
		this.attach = attach;
	}
	
	//---------getter setter -----------------------
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Institute getDestination() {
		return destination;
	}
	public void setDestination(Institute destination) {
		this.destination = destination;
	}
	public String getDocumentNO() {
		return documentNO;
	}
	public void setDocumentNO(String documentNO) {
		this.documentNO = documentNO;
	}
	public String getNameOfService() {
		return nameOfService;
	}
	public void setNameOfService(String nameOfService) {
		this.nameOfService = nameOfService;
	}
	public String getBarcode() {
		return barcode;
	}
	
	public ArrayList<Log> getLogArray() {
		return logArray;
	}
	public void setLogArray(ArrayList<Log> logArray) {
		this.logArray = logArray;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAttach() {
		return this.attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}
	
}
