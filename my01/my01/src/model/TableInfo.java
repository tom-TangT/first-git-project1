package model;


public class TableInfo {

	private String name;
	private String id;
	
	
	public String getBookname() {
		return name;
	}


	public void setBookname(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public TableInfo(String name, String id) {
		super();
		this.name = name;
		this.id=id;
	}
}

