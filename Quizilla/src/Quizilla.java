
import java.io.File;




public class Quizilla 
{
	public static void main(String[] args)
	{	
		// Variablen.
		File xmlQuesstionsFile = new File("Fragen.xml");
		QuestionsSerializer questionsSerializer = new QuestionsSerializer();
		Questions questions = questionsSerializer.readQuestionsFromXml(xmlQuesstionsFile);
		Game game = new Game(questions);
		int userChoice = 0;
		
		userChoice = game.menu.showMenu();
		
		switch(userChoice) // -1 um mit den MenuChoice-Enums eine korrekte Übereinstimmung zu erhalten.
		{
		case 1:
			// game.setSettings(); @TODO
			game.goodLuckWishes();
			game.startPlay();
			// game.gameOver(); @TODO
			// game.saveScore(); @TODO
			game.menu.showMenu();
			break;
		case 2:
			// game.ShowHighscore();
			
		case 3:
		case 4:
		default:
		}	
		
		
		
		
		
	}
}
