
public class Answer 
{
	// Variablen.
	private String answer = "";
	private boolean isCorrect = false;
	
	
	// Konstruktor.
	public Answer(String answer, boolean isCorrect)
	{
		this.answer = answer;
		this.isCorrect = isCorrect;
	}
	
	public Answer(String answer)
	{
		this.answer = answer;
	}
	
	public Answer() {}
	
	
	// Methoden.
	public void setIsCorrect(boolean isCorrect)
	{
		this.isCorrect = isCorrect;
	}
	
	public boolean getIsCorrect()
	{
		return isCorrect;
	}
	
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
	
	public String getAnswer()
	{
		return answer;
	}
	
	public void showAnswers(int id)
	{
		System.out.print(id + ". ");
		System.out.println(answer);
	}
	
	

}
