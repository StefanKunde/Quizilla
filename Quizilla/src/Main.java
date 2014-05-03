
import java.io.File;

public class Main 
{
	public static void main(String[] args)
	{	
		// Variablen.
		final File XML_QUESTIONS_FILE = new File("Questions\\Fragen.xml");
		final String FILE_NAME_HIGHSCORE = "Highscore.data";
		
		DeserializeGeneric<Highscore> deSerHighscore = new DeserializeGeneric<Highscore>(FILE_NAME_HIGHSCORE);
		Highscore highscore = Highscore.create( deSerHighscore, FILE_NAME_HIGHSCORE);
		QuestionsDeserializer questionsDeserializer = new QuestionsDeserializer();
		Questions questions = questionsDeserializer.readQuestionsFromXml(XML_QUESTIONS_FILE);
		SerializeGeneric<Highscore> serHighscore = null;
		Player player = new Player();
		Game game = new Game( (Questions) questions.clone(), highscore );
		
		
		// settings.loadDefault(); @ TODO noch erstellen.
		int userChoice = 0;
		
		game.addPlayer(player);
		
		while(!game.player.getWantsToExit())
		{
			userChoice = game.menu.show();
			switch(userChoice)
			{
				case 1: // Spielen
					game.askForName();
					game.goodLuckWishes();
					game.startPlay();
					game.over();
					game.player.score.save();
					serHighscore = new SerializeGeneric<Highscore>(FILE_NAME_HIGHSCORE, highscore); // Highscore-object serialisieren.
					serHighscore.serialize();														// Highscore-object serialisieren.
					game.player.score.show(); //@ TODO
					break;
					
				case 2: // Anleitung
					game.manual.show(); // @ TODO: Die Anleitung Muss noch ausgearbeitet werden.
					break;
					
				case 3: // Highscore
					game.highscore.show(); // @TODO Noch erstellen.
					break;
					
				case 4: // Spiel beenden
					game.player.setWantsToExit(true);
					
					System.out.println("#############[Good Bye]##############");
					break;
					
				default:
			}
			
			if(!game.player.getWantsToExit())
			{
				game.resetGameStatus( (Questions) questions.clone() );
			}
				
		}	
	}
	
}
