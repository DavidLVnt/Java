package trees;

import trees.Logger;

public class Test {
	private String name;
	private String prereqs;
	
	public Test( String name, String prereqs ) {
		setName( name );
		setPrereqs( prereqs );
	}
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	public String getPrereqs() {
		return prereqs;
	}
	
	public void setPrereqs( String pr ) {
		this.prereqs = pr;
	}
	
	public boolean run() {
		// This should be implemented by children
		Logger.println("");
		Logger.println("");
		Logger.header2( "TEST SET: " + getName() );
		Logger.println( "* Prerequisites: " + getPrereqs() + "\n" );
		return false;
	}
}
