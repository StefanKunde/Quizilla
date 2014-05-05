import java.util.Scanner;


public class Menu 
{
	// Methoden
	
	public int show()
	{
		Scanner scanner = null;
		String userChoice = "";
		int userChoiceNumber = 0;
		boolean validUserChoice = false;
		scanner = new Scanner(System.in);
		
		
		System.out.println(UiDesigner.createTitle(DesignConfig.TITLE_QUIZILLA));
		System.out.println(UiDesigner.createDelimiterLine(DesignConfig.FILL_CHAR_FOR_DELIMITING, DesignConfig.BORDER_CHAR_DELIMITER_LINE));
		System.out.println(UiDesigner.createMenuLine(DesignConfig.MENU_NUMBER_ONE_TEXT + DesignConfig.MENU_PLAY_GAME));
		System.out.println(UiDesigner.createMenuLine(DesignConfig.MENU_NUMBER_TWO_TEXT + DesignConfig.MENU_MANUAL));
		System.out.println(UiDesigner.createMenuLine(DesignConfig.MENU_NUMBER_THREE_TEXT + DesignConfig.MENU_HIGH_SCORE));
		System.out.println(UiDesigner.createMenuLine(DesignConfig.MENU_NUMBER_FOUR_TEXT + DesignConfig.MENU_EXIT_GAME));
		System.out.println(UiDesigner.createDelimiterLine(DesignConfig.FILL_CHAR_FOR_DELIMITING, DesignConfig.BORDER_CHAR_DELIMITER_LINE));
		
		
		while(!validUserChoice)
		{
			System.out.print(UiDesigner.createUserRequest(DesignConfig.USER_REQUEST_ANSWER_MENU));
			userChoice = scanner.next();
			validUserChoice = (userChoice.equals(String.valueOf(DesignConfig.MENU_NUMBER_ONE)) || (userChoice.equals(String.valueOf(DesignConfig.MENU_NUMBER_TWO)) || 
							  (userChoice.equals(String.valueOf(DesignConfig.MENU_NUMBER_THREE)) || (userChoice.equals(String.valueOf(DesignConfig.MENU_NUMBER_FOUR))))));
			
			if(!validUserChoice)
			{
				System.out.println(UiDesigner.createInvalidInputMsg(DesignConfig.INVALID_MENU_CHOICE));
			}
		}
		userChoiceNumber = Integer.parseInt(userChoice);
		
		
		return userChoiceNumber;
 	}
}
