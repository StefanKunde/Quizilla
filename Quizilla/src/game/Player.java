package game;
import java.util.Scanner;

import config.Config;
import design.Designer;

//! Diese Klasse repräsentiert einen einzigen Spieler.
/*  
 * 
 * @author Stefan Kunde
 * @date 01.05.2014
 * @version 1.0
 * 
 */
public class Player 
{
	// Variablen.
	private String name;
	public Score score;
	private boolean isAlive;
	private boolean hasLifes;
	private boolean wantsToExit;
	private int lifes;
	
	// Konstruktor.
	public Player()
	{
		name = "";
		isAlive = true;
		hasLifes = true;
		score = new Score();
		lifes = 3;
		wantsToExit = false;
	}
	
	// Methoden.
	
	//! Fragt den Benutzer nach einer Antwort und gibt diese zurück.
	/*!
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @question Wird benötigt um die gewählte Antwort als String zurück zu geben.
	 * 
	 * 
	 * @return Gibt die Antwort, die der Spieler gewählt hat als String zurück.
	 * 
    */
	public String answerQuestion(Question question)
	{
		String givenAnswer = "";
		int givenAnswerId = 0;
		boolean validUserChoice = false;
		Scanner scanner = new Scanner(System.in);
		
		while(!validUserChoice)
		{
			System.out.print(Designer.createUserRequest(Config._USER_REQUEST_ANSWER_QUESTION_TEXT));
			givenAnswer = scanner.next();
			validUserChoice = (givenAnswer.equals(String.valueOf(Config._MENU_NUMBER_ONE_INT)) || (givenAnswer.equals(String.valueOf(Config._MENU_NUMBER_TWO_INT)) || 
							  (givenAnswer.equals(String.valueOf(Config._MENU_NUMBER_THREE_INT)) || (givenAnswer.equals(String.valueOf(Config._MENU_NUMBER_FOUR_INT))))));
			
			if(!validUserChoice)
			{
				System.out.println(Designer.createInvalidInputMsg(Config._INVALID_ANSWER_MSG));
			}
		}
		givenAnswerId = Integer.parseInt(givenAnswer);
		
	    return question.getAnswerById(givenAnswerId);
	}
	
	// SETTER name.
	public void setName(String name)
	{
		this.name = name;
	}
	
	// GETTER name.
	public String getName()
	{
		return name;
	}
	
	// SETTER isAlive.
	public void setIsAlive(boolean isAlive)
	{
		this.isAlive = isAlive;
	}
	
	// GETTER isAlive.
	public boolean getIsAlive()
	{
		return isAlive;
	}
	
	// GETTER lifes.
	public int getLifes() 
	{
		return lifes;
	}
	
	// GETTER hasLifes
	public boolean getHasLifes()
	{
		return hasLifes;
	}
	
	// SETTER wantsToExit
	public void setWantsToExit(boolean wantsToExit) 
	{
		this.wantsToExit = wantsToExit;
	}
	
	// GETTER wantsToExit
	public boolean getWantsToExit() 
	{
		return wantsToExit;
	}
	
	//! Verringert das Leben des Player um 1.
	/*!
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * 
    */
	private void decreaseLifes()
	{
		if(lifes == 1)
		{
			lifes -= Config._DECREASE_LIFE_VALUE;
			hasLifes = false;
		}
		else
		{
			lifes -= Config._DECREASE_LIFE_VALUE;
		}
	}
	
	//! Verändert das Leben des Spieler je nach Antwort (richtig oder falsch).
	/*!
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @givenAnswer Gibt an ob die Frage richtig oder falsch beantwortet wurde
	 * 
    */
	public void changeLifes(boolean givenAnswer)
	{
		if( givenAnswer )
		{
			//increaseLifes(); @TODO: Was dann?
		}
		else
		{
			 decreaseLifes();
		}
		
	}

	//! Setzt den Status des Spielers auf die Defaultwert zurück
	/*!
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
    */
	public void resetStatus() 
	{
		isAlive = true;
		hasLifes = true;
		score = new Score();
		lifes = Config._START_LIFES;
		wantsToExit = false;
	}
	
}
