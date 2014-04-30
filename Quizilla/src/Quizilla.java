import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.xml.sax.*;
import org.w3c.dom.*;


public class Quizilla 
{
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
	{	
		String value = null;
		
		File file = new File("Fragen.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
		        .newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(file);
	    
		document.getElementById("Fragen");
		NodeList nl = document.getChildNodes();
		
	    System.out.println(nl);
		
	}
}
