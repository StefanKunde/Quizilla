import java.util.ArrayList;
import java.util.List;


public class Question
{
	// Variablen.
	String question = "";
	List<Answer> answers = null;
	
	
	// Konstruktoren.
	public Question(String question, List<Answer> answers)
	{
		this.question = question;
		this.answers = answers;
	}
	
	public Question()
	{
	}
	
	
	// Methoden.
	public void setQuestion(String question)
	{
		this.question = question;
		answers = new ArrayList<Answer>();
	}
	
	public void addAnswers(List<Answer> answers)
	{
		for(Answer answer : answers )
		{
			this.answers.add(answer);
		}
	}
}
