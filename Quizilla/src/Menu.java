import java.util.Scanner;


public class Menu 
{
	final String PLAY_GAME_TEXT = "Spiel starten";
	final String HIGH_SCORE_TEXT = "Highscore";
	final String SETTINGS_TEXT = "Settings";
	final String EXIT_GAME_TEXT = "Spiel beenden";
	final String GAME_TITLE_TEXT = "QUIZILLA";
	
	
	public int show()
	{
		Scanner scanner = null;
		String userChoice = "";
		int userChoiceNumber = 0;
		try
		{
			scanner = new Scanner(System.in);
		}
		catch(Exception e)
		{
			System.out.println("Scanner fehler!");
		}
		
		System.out.println("##############" + "[" +  GAME_TITLE_TEXT + "]" + "##############");
		System.out.println("--------------------------------------");
		System.out.println("         1) " + PLAY_GAME_TEXT);
		System.out.println("         2) " + HIGH_SCORE_TEXT);
		System.out.println("         3) " + SETTINGS_TEXT);
		System.out.println("         4) " + EXIT_GAME_TEXT);
		System.out.println("--------------------------------------");
		System.out.print("Auswahl: ");
		userChoice = scanner.nextLine();
		userChoiceNumber = Integer.parseInt(userChoice);
		System.out.println();
		
		return userChoiceNumber;
 	}
}
