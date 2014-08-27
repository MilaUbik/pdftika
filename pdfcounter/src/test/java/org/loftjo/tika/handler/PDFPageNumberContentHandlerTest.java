package org.loftjo.tika.handler;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.pdf.PDFParser;
import org.loftjob.pdfhandler.model.Aka;
import org.loftjob.pdfhandler.model.Chunk;
import org.loftjob.pdfhandler.model.Tag;
import org.loftjob.tika.handler.PDFPageNumberContentHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

public class PDFPageNumberContentHandlerTest extends TestCase {
	
	private static final Logger log = LoggerFactory.getLogger(PDFPageNumberContentHandlerTest.class.getName());
	private PDFPageNumberContentHandler handler;

	public void setUp() throws IOException, SAXException, TikaException{
		InputStream is = TikaInputStream.get(this.getClass().getClassLoader().getResourceAsStream("Milan.pdf"));
		Parser parser = new PDFParser();
		Metadata metadata = new Metadata();
		Tag tag = new Tag("Italy");
		tag.addAka(new Aka("italian"));
		handler = new PDFPageNumberContentHandler(tag);
		parser.parse(is, handler, metadata, new ParseContext());	
	}
	
	public void testGetResults()  {
		Chunk results = handler.getResults();
		System.out.println(results.toString());
		assertEquals(74, results.getKeywords().size());
		assertEquals("Italy",results.getKeywords().get(0).getName());
		assertEquals("italian",results.getKeywords().get(69).getName());
	}

}
