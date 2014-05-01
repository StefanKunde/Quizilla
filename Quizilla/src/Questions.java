import java.util.ArrayList;


public class Questions extends ArrayList<Question>
{
	// Konstruktor.
	public Questions() {}

	
	// Methoden.
	public void printAllQuestionsAndAnswers()
	{
		String tmpAnswer = "";
		for(Question question : this )
		{
			System.out.println(question.getQuestion());
			for(Answer answer : question.answers)
			{
				tmpAnswer = answer.getAnswer();
				if(answer.getIsCorrect())
				{
					tmpAnswer += " (Korrekt)";
				}
				System.out.println(tmpAnswer);
				tmpAnswer = "";
			}
			System.out.println(tmpAnswer);
			
		}
	}
	
	
	
	
	
}
