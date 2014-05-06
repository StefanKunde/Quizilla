package game;
import java.util.Scanner;

import config.Config;
import design.Designer;

//! Diese Klasse repräsentiert das Menu.
/*  
 * Diese Klasse ist serialisierbar!
 * Sie ist eine Liste aus Objekten vom Typ <Score>.
 * 
 * @author Stefan Kunde
 * @date 03.05.2014
 * @version 1.0
 * 
 */
public class Menu 
{
	// Methoden
	
	//! Gibt das Menü aus, erfragt die Menüauswahl des Users und gibt die Auswahl zurück.
	/*!
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * 
	 * @return Menüauswahl des Users
	 * 
    */
	public int show()
	{
		Scanner scanner = null;
		String userChoice = "";
		int userChoiceNumber = 0;
		boolean validUserChoice = false;
		scanner = new Scanner(System.in);
		
		
		System.out.println(Designer.createTitle(Config._TITLE_QUIZILLA));
		System.out.println(Designer.createDelimiterLine(Config._FILL_SPACE_DELIMITING, Config._BORDER_DELIMITER_LINE));
		System.out.println(Designer.createMenuLine(Config._MENU_NUMBER_ONE_TEXT + Config._MENU_PLAY_GAME));
		System.out.println(Designer.createMenuLine(Config._MENU_NUMBER_TWO_TEXT + Config._MENU_MANUAL));
		System.out.println(Designer.createMenuLine(Config._MENU_NUMBER_THREE_TEXT + Config._MENU_HIGH_SCORE));
		System.out.println(Designer.createMenuLine(Config._MENU_NUMBER_FOUR_TEXT + Config._MENU_EXIT_GAME));
		System.out.println(Designer.createDelimiterLine(Config._FILL_SPACE_DELIMITING, Config._BORDER_DELIMITER_LINE));
		
		
		while(!validUserChoice)
		{
			System.out.print(Designer.createUserRequest(Config._USER_REQUEST_MENU_CHOICE_TEXT));
			userChoice = scanner.next();
			validUserChoice = (userChoice.equals(String.valueOf(Config._MENU_NUMBER_ONE_INT)) || (userChoice.equals(String.valueOf(Config._MENU_NUMBER_TWO_INT)) || 
							  (userChoice.equals(String.valueOf(Config._MENU_NUMBER_THREE_INT)) || (userChoice.equals(String.valueOf(Config._MENU_NUMBER_FOUR_INT))))));
			
			if(!validUserChoice)
			{
				System.out.println(Designer.createInvalidInputMsg(Config._INVALID_MENU_CHOICE_MSG));
			}
		}
		userChoiceNumber = Integer.parseInt(userChoice);
		
		
		return userChoiceNumber;
 	}
}
