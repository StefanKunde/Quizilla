package game;
import java.io.Serializable;

import config.Config;
import design.Designer;

//! Diese Klasse repräsentiert ein Ergebnis eines Spielers.
/*  
 * 
 * @author Stefan Kunde
 * @date 01.05.2014
 * @version 1.0
 * 
 */
public class Score implements Comparable<Score>, Serializable
{
	private static final long serialVersionUID = 1805062062981874534L;
	
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
	
	// SETTER result
	public void setResult(int result)
	{
		this.result = result;
	}
	// SETTER player
	public String getPlayerName()
	{
		return playerName;
	}
	
	// GETTER playerName
	public void setPlayerName(String name)
	{
		playerName = name;
	}
	
	// GETTER result
	public int getResult()
	{
		return result;
	}
	
	// GETTER correctAnswersAmount
	public int getCorrectAnswersAmount()
	{
		return correctAnswersAmount;
	}
	
	// SETTER corretAnswersAmount
	public void setCorrectAnswersAmount(int correctAnswersAmount)
	{
		this.correctAnswersAmount = correctAnswersAmount;
	}
	
	// GETTER answersQuestionsAmount
	public int getAnsweredQuestionsAmount()
	{
		return answeredQuestionsAmount;
	}
	
	// SETTER answersQuestionsAmount
	public void setAnsweredQuestionsAmount(int answeredQuestionsAmount)
	{
		this.answeredQuestionsAmount = answeredQuestionsAmount;
	}

	// SETTER maxQuestions
	public void setMaxQuestions(int maxQuestions) 
	{
		this.maxQuestions = maxQuestions;
	}
	
	//! Gibt das Ergebnis nach dem Ende eines Spiels aus.
	/*!
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
    */
	public void show()
	{
		System.out.println(Designer.createEmptyLine());
		System.out.println(Designer.createTitle(Config._TITLE_RESULT));
		System.out.println(Designer.createResultLine(Config._INFO_QUESTIONS_OVERALL_TEXT + (maxQuestions + 1))); // + 1, weil maxQuestions die size der Liste als int dargestellt ist.
		System.out.println(Designer.createResultLine(Config._INFO_ANSWERED_QUESTIONS_TEXT + answeredQuestionsAmount));
		System.out.println(Designer.createResultLine(Config._INFO_CORRECT_ANSWERED_QUESTIONS_TEXT + correctAnswersAmount));
		System.out.println(Designer.createResultLine(Config._INFO_RESULT_TEXT + result + Config._SIGN_FOR_RESULT));
		System.out.println(Designer.createTitle(Config._TITLE_RESULT));
		Designer.createWaitForUserLine();
	}

	//! Erhöht ggf. die Anzahl der richtig beantworteten Fragen um 1.
	/*!
	 * Die variable wird nur erhöht, wenn der Parameter givenAnswer true ist.
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @givenAnswer Gibt an ob eine Frage richtig oder falsch beantwortet wurde.
	 * 
    */
	public void changeCorrectAnswersAmount( boolean givenAnswer) 
	{
		if(givenAnswer)
		{
			increaseCorrectAnswersAmount();
		}
		answeredQuestionsAmount += 1;
	}

	//! Erhöht die Anzahl der richtig beantworteten Fragen um 1.
	/*!
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
    */
	public void increaseCorrectAnswersAmount()
	{
		correctAnswersAmount += 1;
	}
	
	//! Initialisiert wonach diese Klasse sortiert wird.
	/*!
	 * Sortiert wird nach dem Ergebnis.
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @score Instanz dieser Klasse mit der die aufrufende Instanz verglichen werden soll
	 * 
    */
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

	//! Berechnet das Ergebnis.
	/*!
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @maxQuestions Wird zum Berechnen des Ergebnises benötigt.
	 * @correctAnswersAmount Wird zum Berechnen des Ergebnises benötigt.
	 * 
    */
	public void calculateResult() 
	{
		double maxQuestionsDouble = (double) maxQuestions;
		double correctAnswersAmountDouble = (double) correctAnswersAmount;
		
		double result = ( correctAnswersAmountDouble / maxQuestionsDouble ) * 100.0; 
		setResult((int)result);
	}
	
}
