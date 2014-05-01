import java.util.ArrayList;


public class Questions extends ArrayList<Question>
{
	// Konstruktor.
	public Questions() {}
	
	public void printAllQuestions()
	{
		for(Question question : this )
		{
			System.out.println(question.question);
		}
	}
	
	public void printAllAnswersFromAllQuestions()
	{
		for(Question question : this )
		{
			for(Answer answer : question.answers)
			{
				System.out.println(answer.getAnswer());
			}
			
		}
	}
	
	
	
}
