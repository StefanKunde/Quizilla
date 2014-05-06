
import game.Game;
import game.Highscore;
import game.Manual;
import game.Player;
import game.Questions;

import java.io.File;
import java.io.IOException;

import serialization.Deserialize;
import serialization.QuestionsDeserializer;
import serialization.Serialize;
import config.Config;
import design.Designer;

//! Diese Klasse behinhaltet die Main-Methode und führt das Spiel in Ihr aus.
/*  
 * 
 * @author Stefan Kunde
 * @date 01.05.2014
 * @version 1.0
 * 
 */
public class Main 
{
	public static void main(String[] args)
	{	
		// Variablen.
		Deserialize<Highscore> deSerHighscore = new Deserialize<Highscore>(Config._FILE_NAME_HIGHSCORE);
		Highscore highscore = Highscore.create( deSerHighscore );
		QuestionsDeserializer questionsDeserializer = new QuestionsDeserializer();
		Questions questions;
		Manual manual = new Manual ( new File(Config._FILE_MANUAL_PATH) );
		questions = questionsDeserializer.readQuestionsFromXml(new File(Config._FILE_XML_QUESTIONS_FILE));
		Serialize<Highscore> serHighscore = null;
		Player player = new Player();
		Game game = new Game( (Questions) questions.clone(), highscore, manual );
		
		int userChoice = 0;
		game.addPlayer(player);
		
		// Das Spiel zeigt solange das Menü wieder, bis der Spieler es beenden möchte.
		while(!game.player.getWantsToExit())
		{
			userChoice = game.menu.show();
			switch(userChoice)
			{
				case Config._MENU_NUMBER_ONE_INT: // Spiel starten
					game.askForName();
					System.out.println(Designer.createDelimiterLine(Config._FILL_SPACE_TITLES, Config._BORDER_DEFAULT));
					game.printStartMessage();
					game.startPlay();
					game.player.score.calculateResult();
					game.over(); 
					serHighscore = new Serialize<Highscore>(Config._FILE_NAME_HIGHSCORE, highscore); // Initialisieren des Highscore Objektes.
					serHighscore.serialize(); // Serialisierung des Highscore Objektes.
					game.player.score.show(); // Ergebnis printen.
					break;
					
				case Config._MENU_NUMBER_TWO_INT: // Anleitung
					System.out.println(Designer.createDelimiterLine(Config._FILL_SPACE_TITLES, Config._BORDER_DEFAULT));
					game.manual.show();
					break;
					
				case Config._MENU_NUMBER_THREE_INT: // Highscore
					System.out.println(Designer.createDelimiterLine(Config._FILL_SPACE_TITLES, Config._BORDER_DEFAULT));
					game.highscore.show(); // Highscore printen.
					break;
					
				case Config._MENU_NUMBER_FOUR_INT: // Spiel beenden
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
