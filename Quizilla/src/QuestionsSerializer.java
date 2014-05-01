import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class QuestionsSerializer 
{
	
	// Variablen.
	Document doc;
	Questions questions;
	List<Answer> answers;
	List<Element> questionElements;
	List<Element> questionsElements;
	Attribute valueAttribute;
	Attribute isCorrectAttribute;
	Element rootElement;

	// Konstruktor.
	public QuestionsSerializer()
	{
		doc = null;
		questions = new Questions();
		answers = null;
		questionElements = null;
		questionsElements = null;
		valueAttribute = null;
		isCorrectAttribute = null;
		rootElement = null;
	}
	
	
	// Methoden:
	
	/* Liest eine XML-Datei in einem bestimmten Schema ein, serialisiert die Daten mit einem Questions-Objekt und gibt dieses wieder zurück.
	 * 
	 * Schema:
	 */
	public Questions readQuestionsFromXml(File xmlQuesstionsFile)
	{
		
		try {
			doc = new SAXBuilder().build( xmlQuesstionsFile );
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rootElement = doc.getRootElement();
		questionsElements = rootElement.getChildren();
		
		// Durchläuft alle Childelement des Rootelements (<Frage>...</Frage>)
		for(int i = 0; i < questionsElements.size(); i++)
		{
			answers = new ArrayList<Answer>();	// Initialisiert die Arraylist<Answer>,
			questions.add(new Question());								// Erstellt eine neue Frage und fügt sie der erweiterten Liste [Questions question] hinzu.
			valueAttribute = questionsElements.get(i).getAttribute("value"); // Weist einem Attributobjekt das Attribut [value] zu.
			questions.get(i).setQuestion(valueAttribute.getValue());			// Setzt die aktuelle Frage (der Value des aktuellen Attributes) im aktuellen Questionobjekt fest.
			questionElements = questionsElements.get(i).getChildren();  // Speichert alle Childelemente des aktuellen Elements in einer List<Element>.
			
			
			// Durchläuft die Childelemente vom aktuellen Childelement des Rootelements (<Antwort> ... </Antwort>).
			for(int j = 0; j < questionElements.size(); j++) 
			{
				Answer answer = new Answer(questionElements.get(j).getText()); // Erstellt ein neues Answerobjekt und übergibt im Konstruktor den Textinhalt des aktuellen Antwortelements
				boolean answerIsCorrect = questionElements.get(j).hasAttributes(); // Wenn das Element <Antwort> Attributen hat, muss die Antwort korrekt sein, weil nur Antworten die korrekt sind ein Attribut haben.
				if(answerIsCorrect) 
				{
					isCorrectAttribute = questionElements.get(j).getAttribute("correct");
					answer.setIsCorrect(true);
				}
				answers.add( answer );
			}
			questions.get(i).addAnswers(answers);
			
		}
		
		return questions;
	}
}
