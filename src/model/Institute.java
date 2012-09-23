package model;

/**
 * this class store details of Institute.
 * @author Witsarut Mongkonphak
 *
 */

public class Institute {
	
	private String name;
	private String type;
	
	public Institute(String name,String type){
		this.name = name;
		this.type = type;
	}
	
	
	//----------getter setter ----------------------
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return this.name;
	}

}
