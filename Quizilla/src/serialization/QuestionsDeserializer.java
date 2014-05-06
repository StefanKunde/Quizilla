package serialization;
import game.Answer;
import game.Question;
import game.Questions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import config.Config;
import design.Designer;

//! Diese Klasse ist dazu da, um eine XML Datei in ein Highscoreobject zu laden (Deserialisation).
/*
 * @author Stefan Kunde
 * @date 02.05.2014
 * @version 1.0
 * 
 */
public class QuestionsDeserializer 
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
	public QuestionsDeserializer()
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
	
	
	// Methoden.

	
	//! Liest eine XML-Datei in einem bestimmtes Schema ein, speichert die Daten in eine Instanz von Questions und gibt diese zurück.
	/*!
	 * Das Format der XML-Datei MUSS aktuell noch exakt in folgendem Format vorliegen:
	 * <Fragen>
	 * 	 <Frage value="Fragesatz (z.B. Wie heißt Obama mit Vornamen?)">
	 *      <Antwort correct="true">Barack</Antwort>  <--- Das Attribur correct kennzeichnet eine Antwort als korrekt.
			<Antwort>Martin</Antwort> 
		    <Antwort>Alexander</Antwort> 
		    <Antwort>Gerhard</Antwort>
	 * 	 </Frage>
	 * </Fragen>
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @xmlQuesstionsFile Pfad zur XML-File, die eingelesen werden soll.
	 * 
	 * 
	 * @return Zurückgegeben wird die durch die XML-Datei befüllte Instanz von Questions.
	 * 
    */
	public Questions readQuestionsFromXml(File xmlQuesstionsFile)
	{
		// Wenn die übergebene Datei exisitiert und gelesen werden kann, beschreibe die Instanz dieser Klasse mit allen Fragen der XML-File.
		if(xmlQuesstionsFile.exists() && xmlQuesstionsFile.canRead())
		{
			try {
				doc = new SAXBuilder().build( xmlQuesstionsFile );
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (IOException e) {
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
		}
		else
		{
			System.out.println(Designer.createInvalidInputMsg(Config._ERROR_CANT_LOAd_XML_FILE_TEXT));
			System.out.println(Designer.createInvalidInputMsg(Config._ERROR_CLOSE_APPLICATION_TEXT) );
			System.exit(0);
		}
		
		
		return questions;
	}
}
