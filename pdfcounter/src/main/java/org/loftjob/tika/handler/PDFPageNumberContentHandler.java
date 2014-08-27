package org.loftjob.tika.handler;

import java.util.HashMap;
import java.util.Map;

import org.loftjob.pdfhandler.model.Aka;
import org.loftjob.pdfhandler.model.Chunk;
import org.loftjob.pdfhandler.model.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PDFPageNumberContentHandler extends DefaultHandler {

	// word to search
	// Result map<pageNum,word>
	private Map<Integer, Tag> map = new HashMap<Integer, Tag>();
	// page number counter
	private int pageNum = 0;
	// PDF page generate a div tag with class property of value "page"
	private String pageTag = "div";
	private String classPage = "page";
	private Chunk chunk = new Chunk();
	private Tag tag = null;
	private static final Logger log = LoggerFactory
			.getLogger(PDFPageNumberContentHandler.class.getName());

	public PDFPageNumberContentHandler(Tag tag) {
		this.tag = tag;
	}

	@Override
	public void startElement(String uri, String localName, String name,
			Attributes atts) throws SAXException {
		if (this.pageTag.equalsIgnoreCase(name) && atts != null) {
			String value = atts.getValue("class");
			if (this.classPage.equals(value)) {
				this.pageNum++;
			}
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (length > 0) {
			StringBuilder builder = new StringBuilder(length);
			builder.append(ch);
			String text = builder.toString().trim();
			if (text.contains(tag.getName())) {
				Tag kw = new Tag(tag.getName());
				kw.setFoundAt(this.pageNum);
				this.chunk.addKeyword(kw);
				if(log.isDebugEnabled()){
					log.debug("\n Add Tag"+kw.toString()+" to chunk");
				}
			} else {
				for (Aka aka : this.tag.getAkas()) {
					String name = aka.getName();
					if (text.contains(name)) {
						Tag kw = new Tag(name);
						kw.setFoundAt(this.pageNum);
						this.chunk.addKeyword(kw);
						if(log.isDebugEnabled()){
							log.debug("\n Add Tag"+kw.toString()+" to chunk");
						}
					}
				}
			}
		}
	}

	public Chunk getResults() {
		return this.chunk;
	}
}
