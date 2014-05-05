import java.util.ArrayList;
import java.util.List;


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
	public void setQuestion(String question)
	{
		this.question = question;
		answers = new ArrayList<Answer>();
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public void addAnswers(List<Answer> answers)
	{
		for(Answer answer : answers )
		{
			this.answers.add(answer);
		}
	}
	
	public List<Answer> getAnswers()
	{
		return this.answers;
	}
	
	public void askQuestion()
	{
		// Frage printen
		System.out.println(UiDesigner.createQuestion(question));
	}
	
	public void showAnswers()
	{
		int tmpIndex = 0;
		
		for(Answer answer : answers)
		{
			if(tmpIndex == 0)
				tmpIndex = 1;
			answer.showAnswers(tmpIndex);
			tmpIndex++;
		}
	}
	
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
	
	

}
