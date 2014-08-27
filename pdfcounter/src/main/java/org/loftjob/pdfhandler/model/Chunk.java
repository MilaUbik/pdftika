/**
 * 
 */
package org.loftjob.pdfhandler.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author valis
 *
 */
public class Chunk {
	
	private String text = "";
	private List<Tag> keywords = new ArrayList<Tag>();
	
	public Chunk() {
		super();
	}
	
	public Chunk(String text) {
		super();
		this.text = text;
	}
	
	public Chunk(String text, List<Tag> keywords) {
		this(text);
		this.keywords = keywords;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the keywords
	 */
	public List<Tag> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<Tag> keywords) {
		this.keywords = keywords;
	}
	
	public boolean addKeyword(Tag tag){
		return this.keywords.add(tag);
	}
	
	public boolean removeKeyword(Tag tag){
		return this.keywords.remove(tag);
	}
	
	public String toString(){
		StringBuilder string = new StringBuilder();
		string.append("Title: "+this.text+"\n");
		string.append("Keywords: \n");
		Map<String,String> map = new HashMap<String,String>();
		for(Tag tmp: this.keywords){
			String tagName = tmp.getName();
			String foundAt = ""+tmp.getFoundAt();
			String occurence = map.get(tagName);
			if(occurence != null){
				occurence = occurence + "," + tmp.getFoundAt(); 
			}else{
				occurence = foundAt;
			}
			map.put(tagName, occurence);
		}
		Set<String> keySet = map.keySet();
		String[] keys = keySet.toArray(new String[keySet.size()]);
		for(int x = 0; x < keys.length; x++){
			String name = keys[x];
			String foundPage = map.get(name);
			string.append("Tag: "+name+"\n");
			string.append("Found At :"+foundPage+"\n");
		}
		return string.toString();
	}

}
