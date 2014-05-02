import java.util.Scanner;


public class Player 
{
	// Variablen.
	private String name;
	private Score score;
	private int correctAnswersAmount;
	private int wrongAnswersAmount;
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
		correctAnswersAmount = 0;
		wrongAnswersAmount = 0;
		lifes = 3;
		wantsToExit = false;
	}
	
	// Methoden.
	public String answerQuestion(Question question)
	{
		String givenAnswer = "";
		int givenAnswerId = 0;
		Scanner scanner = null;
		System.out.print("Antwort: ");
		try
		{
			scanner = new Scanner(System.in);
		}
		catch(Exception e)
		{
			System.out.println("Scanner fehler!");
		}
	    
		givenAnswer = scanner.nextLine();
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
	
	
	
}
