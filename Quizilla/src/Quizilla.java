
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;



public class Quizilla 
{
	
	
	
	public static void main(String[] args)
	{	
		File xmlQuesstionsFile = new File("Fragen.xml");
		QuestionsSerializer questionSerializer = new QuestionsSerializer();
		Questions questions = questionSerializer.readQuestionsFromXml(xmlQuesstionsFile);
		
	 
		
	}
}
