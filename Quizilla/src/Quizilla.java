
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
		int userChoice = 0;
		
		game.addPlayer(player);
		
		while(!game.player.getWantsToExit())
		{
			userChoice = game.menu.show();
			switch(userChoice)
			{
				case 1:
					// game.setSettings(); @ TODO
					game.goodLuckWishes();
					game.startPlay();
					game.over();
					// game.saveScore(); @ TODO
					// game.score.show(); @ TODO
					break;
				case 2:
					// game.ShowHighscore(); @ TODO
					
				case 3:
				case 4:
					game.player.setWantsToExit(true);
					System.out.println("#############[Good Bye]##############");
					break;
				default:
			}	
		}
		
		
		
		
		
		
	}
}
