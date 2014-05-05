import java.io.Serializable;


public class Score implements Comparable<Score>, Serializable
{
	transient private int correctAnswersAmount;
	transient private int answeredQuestionsAmount;
	transient private int maxQuestions;
	private int result;
	private String playerName;
	
	// Konstruktor.
	public Score()
	{
		correctAnswersAmount = 0;
		answeredQuestionsAmount = 0;
		maxQuestions = 0;
		result = 0;
		playerName = "";
	}
	
	// Methoden.
	public void show()
	{
		System.out.println(UiDesigner.createEmptyLine());
		System.out.println(UiDesigner.createTitle(DesignConfig.TITLE_RESULT));
		System.out.println(UiDesigner.createResultLine(DesignConfig.INFO_QUESTIONS_OVERALL + maxQuestions));
		System.out.println(UiDesigner.createResultLine(DesignConfig.INFO_ANSWERED_QUESTIONS + answeredQuestionsAmount));
		System.out.println(UiDesigner.createResultLine(DesignConfig.INFO_CORRECT_ANSWERED_QUESTIONS + correctAnswersAmount));
		System.out.println(UiDesigner.createResultLine(DesignConfig.INFO_RESULT + result + DesignConfig.SIGN_FOR_RESULT));
		System.out.println(UiDesigner.createTitle(DesignConfig.TITLE_RESULT));
		UiDesigner.createWaitForUserLine();
	}

	public void addRound(int currentQuestion, boolean givenAnswer) 
	{
		if(givenAnswer)
		{
			increaseCorrectAnswersAmount();
		}
		answeredQuestionsAmount += 1;
	}
	
	public int getCorrectAnswersAmount()
	{
		return correctAnswersAmount;
	}
	
	public void setCorrectAnswersAmount(int correctAnswersAmount)
	{
		this.correctAnswersAmount = correctAnswersAmount;
	}
	
	public void increaseCorrectAnswersAmount()
	{
		correctAnswersAmount += 1;
	}
	
	public int getAnsweredQuestionsAmount()
	{
		return answeredQuestionsAmount;
	}
	
	public void setAnsweredQuestionsAmount(int answeredQuestionsAmount)
	{
		this.answeredQuestionsAmount = answeredQuestionsAmount;
	}

	public void setMaxQuestions(int maxQuestions) 
	{
		this.maxQuestions = maxQuestions;
	}

	@Override
	public int compareTo(Score score) 
	{
		int returnTmp = -99;
		
		if(this.result < score.result)
			returnTmp = 1;
		
		if(this.result > score.result)
			returnTmp = -1;
		
		if(this.result == score.result)
			returnTmp =  0;
		
		return returnTmp;
	}

	public void save() 
	{
		result = calculatePoints(maxQuestions, correctAnswersAmount);
	}

	private int calculatePoints(int maxQuestions, int correctAnswersAmount) 
	{
		double maxQuestionsDouble = (double) maxQuestions;
		double correctAnswersAmountDouble = (double) correctAnswersAmount;
		
		double result = ( correctAnswersAmountDouble / maxQuestionsDouble ) * 100.0; 
		return (int)result;
	}
	
	public String getPlayerName()
	{
		return playerName;
	}
	
	public void setPlayerName(String name)
	{
		playerName = name;
	}
	
	public int getResult()
	{
		return result;
	}
}
