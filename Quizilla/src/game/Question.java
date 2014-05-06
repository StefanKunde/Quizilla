package game;
import java.util.ArrayList;
import java.util.List;

import design.Designer;

//! Diese Klasse repräsentiert eine einzige Frage.
/*  
 * 
 * @author Stefan Kunde
 * @date 01.05.2014
 * @version 1.0
 * 
 */
public class Question
{
	// Variablen.
	String question;
	List<Answer> answers;
	
	
	// Konstruktoren.
	public Question(String question, List<Answer> answers)
	{
		this.question = question;
		this.answers = answers;
	}
	
	public Question()
	{
		question = "";
		answers = null;
	}
	
	// Methoden.
	
	// SETTER question.
	public void setQuestion(String question)
	{
		this.question = question;
		answers = new ArrayList<Answer>();
	}
	
	// GETTER question.
	public String getQuestion()
	{
		return question;
	}
	
	// GETTER correctAnswer
	public String getCorrectAnswer()
	{
		String correctAnswer = "";
		for(Answer answer : answers)
		{
			if(answer.getIsCorrect())
			{
				correctAnswer = answer.getAnswer();
			}
		}
		
		return correctAnswer;
	}
	
	// GETTER answerById
	public String getAnswerById(int id)
	{
		String answerTmp = "";
		int counter = 0;
		for(Answer answer : answers)
		{
			counter++;
			if( id == counter )
			{
				answerTmp = answer.getAnswer();
			}
		}
		
		return answerTmp;
	}
	
	// GETTER answers
	public List<Answer> getAnswers()
	{
		return this.answers;
	}
	
	//! Fügt der Frage eine Liste von Antworten hinzu.
	/*!
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @answer Liste von Antworten
	 * 
	 * 
    */
	public void addAnswers(List<Answer> answers)
	{
		for(Answer answer : answers )
		{
			this.answers.add(answer);
		}
	}
	
	//! Gibt die Frage dieser Instanz aus..
	/*!
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
    */
	public void askQuestion()
	{
		System.out.println(Designer.createQuestion(question));
	}
	
	//! Gibt alle Antworten für diese Frage aus.
	/*!
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
    */
	public void showAnswers()
	{
		int tmpIndex = 0;
		
		for(Answer answer : answers)
		{
			if(tmpIndex == 0)
				tmpIndex = 1;
			answer.showAnswer(tmpIndex);
			tmpIndex++;
		}
	}
	
}
