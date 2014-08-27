package org.loftjob.pdfhandler.model;

public class Aka implements Taxon{

	private String name = "";
	
	/**
	 * Create Object with name
	 * 
	 * @param name
	 */
	public Aka(String name) {
		super();
		this.name = name;
	}


	/**
	 * Return the aka name
	 * 
	 */
	public String getName() {
		return this.name;
	}

}
