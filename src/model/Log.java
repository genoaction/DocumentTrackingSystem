package model;

import java.sql.Timestamp;

/**
 * this class store details of Log
 * @author Witsarut Mongkonphak
 *
 */

public class Log {
	private String barcode;
	private Institute Destinaion;
	private Timestamp datetime;
	private String type;
	
	public  Log(String barcode,Institute dest,String type,Timestamp datetime) {
		this.barcode = barcode;
		this.Destinaion = dest;
		this.datetime = datetime;
		this.setType(type);
	}
	
	//---------------getter setter ------------------------
	public Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
	public Institute getDestinaion() {
		return Destinaion;
	}
	public void setDestinaion(Institute destinaion) {
		Destinaion = destinaion;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBarcode() {
		return barcode;
	}

}
