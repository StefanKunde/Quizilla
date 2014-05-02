
import java.io.File;




public class Quizilla 
{
	public static void main(String[] args)
	{	
		// Variablen.
		File xmlQuesstionsFile = new File("Fragen.xml");
		QuestionsSerializer questionsSerializer = new QuestionsSerializer();
		Questions questions = questionsSerializer.readQuestionsFromXml(xmlQuesstionsFile);
		Player player = new Player();
		Game game = new Game(questions);
		

		game.addPlayer(player);
		game.start();
		
		
		
		
		
	}
}
