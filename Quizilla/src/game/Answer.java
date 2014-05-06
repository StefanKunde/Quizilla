package game;
import config.Config;
import design.Designer;

//! Diese Klasse repräsentiert eine einzige Antwort.
/*
 * @author Stefan
 * @date 01.05.2014
 * @version 1.0
 * 
 */
public class Answer 
{
	// Variablen.
	private String answer;
	private boolean isCorrect;
	
	
	// Konstruktoren.
	public Answer(String answer, boolean isCorrect)
	{
		this.answer = answer;
		this.isCorrect = isCorrect;
	}
	
	public Answer(String answer)
	{
		this.answer = answer;
	}
	
	
	// Methoden.
	
	// SETTER isCorrect.
	public void setIsCorrect(boolean isCorrect)
	{
		this.isCorrect = isCorrect;
	}
	
	// GETTER isCorrect.
	public boolean getIsCorrect()
	{
		return isCorrect;
	}
	
	// SETTER answer.
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
	
	// GETTER answer.
	public String getAnswer()
	{
		return answer;
	}
	
	//! Gibt eine Antwortzeile anhand ihrer ID in der List<Answer> vom Questions-Object aus.
	/*!
	 *
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @id Ist die ID in der List<Answer> vom Questions-Object. Die ID Ist wichtig zur Bestimmung der korreten Antwort. 
	 * 
	 * 
	 * @return Gibt eine Antwortzeile aus.
    */
	public void showAnswer(int id)
	{
		String answerTmp = "";
		switch(id)
		{
			case Config._MENU_NUMBER_ONE_INT:
				answerTmp += Config._MENU_ANSWER_TEXT;
				answerTmp += Config._MENU_NUMBER_ONE_TEXT;
				answerTmp += answer;
				System.out.println(Designer.createAnswer(answerTmp));
				break;
			case Config._MENU_NUMBER_TWO_INT:
				answerTmp += Config._MENU_ANSWER_TEXT;
				answerTmp += Config._MENU_NUMBER_TWO_TEXT;
				answerTmp += answer;
				System.out.println(Designer.createAnswer(answerTmp));
				break;
			case Config._MENU_NUMBER_THREE_INT:
				answerTmp += Config._MENU_ANSWER_TEXT;
				answerTmp += Config._MENU_NUMBER_THREE_TEXT;
				answerTmp += answer;
				System.out.println(Designer.createAnswer(answerTmp));
				break;
			case Config._MENU_NUMBER_FOUR_INT:
				answerTmp += Config._MENU_ANSWER_TEXT;
				answerTmp += Config._MENU_NUMBER_FOUR_TEXT;
				answerTmp += answer;
				System.out.println(Designer.createAnswer(answerTmp));
				break;
			default:
				break;
		}
	}

}
