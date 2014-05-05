import java.util.Scanner;


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
	public String answerQuestion(Question question)
	{
		String givenAnswer = "";
		int givenAnswerId = 0;
		Scanner scanner = null;
		boolean validUserChoice = false;
		
		try
		{
			scanner = new Scanner(System.in);
		}
		catch(Exception e)
		{
			System.out.println("Scanner fehler!");
		}
	    
		
		while(!validUserChoice)
		{
			System.out.print(UiDesigner.createUserRequest(DesignConfig.USER_REQUEST_ANSWER_QUESTION));
			givenAnswer = scanner.next();
			validUserChoice = (givenAnswer.equals(String.valueOf(DesignConfig.MENU_NUMBER_ONE)) || (givenAnswer.equals(String.valueOf(DesignConfig.MENU_NUMBER_TWO)) || 
							  (givenAnswer.equals(String.valueOf(DesignConfig.MENU_NUMBER_THREE)) || (givenAnswer.equals(String.valueOf(DesignConfig.MENU_NUMBER_FOUR))))));
			
			if(!validUserChoice)
			{
				System.out.println(UiDesigner.createInvalidInputMsg(DesignConfig.INVALID_ANSWER));
			}
		}
		
		givenAnswerId = Integer.parseInt(givenAnswer);
		
	    return question.getAnswerById(givenAnswerId);
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean getIsAlive()
	{
		return isAlive;
	}
	
	public void setIsAlive(boolean isAlive)
	{
		this.isAlive = isAlive;
	}

	public int getLifes() 
	{
		return lifes;
	}
	
	private void decreaseLifes()
	{
		if(lifes == 1)
		{
			lifes -= 1;
			hasLifes = false;
		}
		else
		{
			lifes -= 1;
		}
	}
	
	public boolean getHasLifes()
	{
		return hasLifes;
	}
	
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

	public void setWantsToExit(boolean wantsToExit) 
	{
		this.wantsToExit = wantsToExit;
	}

	public boolean getWantsToExit() 
	{
		return wantsToExit;
	}

	public void resetStatus() 
	{
		isAlive = true;
		hasLifes = true;
		score = new Score();
		lifes = 3;
		wantsToExit = false;
	}
	
	
	
}
