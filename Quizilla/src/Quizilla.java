
import java.io.File;




public class Quizilla 
{
	public static void main(String[] args)
	{	
		File xmlQuesstionsFile = new File("Fragen.xml");
		QuestionsSerializer questionSerializer = new QuestionsSerializer();
		Questions questions = questionSerializer.readQuestionsFromXml(xmlQuesstionsFile);
		
		questions.printAllQuestionsAndAnswers();
		
		
	}
}
