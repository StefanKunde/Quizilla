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
	private Document doc;
	private Questions questions;
	private List<Answer> answers;
	private List<Element> questionElements;
	private List<Element> questionsElements;
	private Attribute valueAttribute;
	private Element rootElement;
	private Answer answer;
	private boolean answerIsCorrect;
	
	// Konstruktor.
	public QuestionsSerializer()
	{
		doc = null;
		questions = new Questions();
		answers = null;
		questionElements = null;
		questionsElements = null;
		valueAttribute = null;
		rootElement = null;
		answer = null;
		answerIsCorrect = false;
	}
	
	
	// Methoden:
	
	/* Liest eine XML-Datei in einem bestimmtes Schema ein, serialisiert die Daten mit einem Questions-Objekt und gibt dieses wieder zurück.
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
			questions.add(new Question());								// Erstellt eine neue Frage und fügt sie der erweiterten Liste [Questions question] hinzu.
			valueAttribute = questionsElements.get(i).getAttribute("value"); // Weist einem Attributobjekt das Attribut [value] zu.
			questions.get(i).setQuestion(valueAttribute.getValue());			// Setzt die aktuelle Frage (der Value des aktuellen Attributes) im aktuellen Questionobjekt fest.
			questionElements = questionsElements.get(i).getChildren();  // Speichert alle Childelemente des aktuellen Elements in einer List<Element>.
			answers = new ArrayList<Answer>();	// Initialisiert die Arraylist<Answer>,
			
			// Durchläuft die Childelemente vom aktuellen Childelement des Rootelements (<Antwort> ... </Antwort>).
			for(int j = 0; j < questionElements.size(); j++) 
			{
				answer = new Answer(questionElements.get(j).getText()); // Erstellt ein neues Answerobjekt und übergibt im Konstruktor den Textinhalt des aktuellen Antwortelements
				answerIsCorrect = questionElements.get(j).hasAttributes(); // Wenn das Element <Antwort> Attributen hat, muss die Antwort korrekt sein, weil nur Antworten die korrekt sind ein Attribut haben.
				answer.setIsCorrect(answerIsCorrect);
				answers.add( answer );
			}
			questions.get(i).addAnswers(answers);
			
		}
		
		return questions;
	}
}
