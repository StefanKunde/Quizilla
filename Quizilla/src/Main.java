
import java.io.File;
import java.io.IOException;

public class Main 
{
	public static void main(String[] args)
	{	
		// Variablen.
		DeserializeGeneric<Highscore> deSerHighscore = new DeserializeGeneric<Highscore>(DesignConfig.FILE_NAME_HIGHSCORE);
		Highscore highscore = Highscore.create( deSerHighscore, DesignConfig.FILE_NAME_HIGHSCORE);
		QuestionsDeserializer questionsDeserializer = new QuestionsDeserializer();
		Questions questions ;
		questions = questionsDeserializer.readQuestionsFromXml(new File(DesignConfig.FILE_XML_QUESTIONS_FILE));
		SerializeGeneric<Highscore> serHighscore = null;
		Player player = new Player();
		Game game = new Game( (Questions) questions.clone(), highscore );
		
		int userChoice = 0;
		game.addPlayer(player);
		
		
		while(!game.player.getWantsToExit())
		{
			userChoice = game.menu.show();
			switch(userChoice)
			{
				case DesignConfig.MENU_NUMBER_ONE: // Spielen
					game.askForName();
					System.out.println(UiDesigner.createDelimiterLine(DesignConfig.FILL_CHAR_FOR_TITLES, DesignConfig.BORDER_CHAR_DEFAULT));
					game.printStartMessage();
					game.startPlay();
					game.player.score.save();
					game.over(); 
					serHighscore = new SerializeGeneric<Highscore>(DesignConfig.FILE_NAME_HIGHSCORE, highscore); // Initialisieren des Highscore Objektes.
					serHighscore.serialize(); // Serialisierung des Highscore Objektes..
					game.player.score.show(); // Ergebnis printen.
					break;
					
				case DesignConfig.MENU_NUMBER_TWO: // Anleitung
					System.out.println(UiDesigner.createDelimiterLine(DesignConfig.FILL_CHAR_FOR_TITLES, DesignConfig.BORDER_CHAR_DEFAULT));
					game.manual.show(); // @ TODO: Die Anleitung Muss noch ausgearbeitet werden.
					break;
					
				case DesignConfig.MENU_NUMBER_THREE: // Highscore
					System.out.println(UiDesigner.createDelimiterLine(DesignConfig.FILL_CHAR_FOR_TITLES, DesignConfig.BORDER_CHAR_DEFAULT));
					game.highscore.show(); // @TODO Noch erstellen.
					break;
					
				case DesignConfig.MENU_NUMBER_FOUR: // Spiel beenden
					game.player.setWantsToExit(true);
					game.showGoodByeMsg();
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
