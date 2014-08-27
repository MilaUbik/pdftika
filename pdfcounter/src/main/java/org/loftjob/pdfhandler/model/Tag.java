/**
 * 
 */
package org.loftjob.pdfhandler.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author valis
 *
 */
public class Tag implements Taxon{
	
	
	private String name = "";
	private int foundAt =  0;
	private Set<Aka> akas= new HashSet<Aka>();
	
	
	
	
	
	
	/**
	 * Generate a tag object with name and no akas
	 * 
	 * @param name
	 */
	public Tag(String name) {
		super();
		this.name = name;
	}

	/**
	 * Generate a tag object with name and akas
	 * 
	 * @param name
	 * @param akas
	 */
	public Tag(String name, Set<Aka> akas) {
		super();
		this.name = name;
		this.akas = akas;
	}

	/**
	 * Set the name of the Tag
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Return the name of the Tag
	 * 
	 */
	public String getName() {
		return this.name;
	}


	/**
	 * Get the Page where it has been found
	 * 
	 * @return the foundAt
	 */
	public int getFoundAt() {
		return foundAt;
	}


	/**
	 * Set the Page where it has been found
	 * 
	 * @param foundAt the foundAt to set
	 */
	public void setFoundAt(int foundAt) {
		this.foundAt = foundAt;
	}


	/**
	 * Get a list of Akas
	 * 
	 * @return the akas
	 */
	public Set<Aka> getAkas() {
		return akas;
	}


	/**
	 * Set the list of Akas
	 * 
	 * @param akas the akas to set
	 */
	public void setAkas(Set<Aka> akas) {
		this.akas = akas;
	}
	
	/**
	 * Add aka to list
	 * 
	 */
	public void addAka(Aka aka){
		this.akas.add(aka);
	}


	public String toString(){
		StringBuilder string = new StringBuilder();
		string.append("Name: "+this.name+"\n");
		string.append("Found at: "+this.foundAt);
//		Aka[] akasArray = this.akas.toArray(new Aka[this.akas.size()]);
//		string.append("Akas: ");
//		for(Aka tmp: akasArray){
//			string.append(tmp.getName()+"\n");
//		}
		return string.toString();
	}
	
	
	
	
}
