
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
		String answerTmp = "";
		switch(id)
		{
			case DesignConfig.MENU_NUMBER_ONE:
				answerTmp += DesignConfig.MENU_ANSWER_TEXT;
				answerTmp += DesignConfig.MENU_NUMBER_ONE_TEXT;
				answerTmp += answer;
				System.out.println(UiDesigner.createAnswer(answerTmp));
				break;
			case DesignConfig.MENU_NUMBER_TWO:
				answerTmp += DesignConfig.MENU_ANSWER_TEXT;
				answerTmp += DesignConfig.MENU_NUMBER_TWO_TEXT;
				answerTmp += answer;
				System.out.println(UiDesigner.createAnswer(answerTmp));
				break;
			case DesignConfig.MENU_NUMBER_THREE:
				answerTmp += DesignConfig.MENU_ANSWER_TEXT;
				answerTmp += DesignConfig.MENU_NUMBER_THREE_TEXT;
				answerTmp += answer;
				System.out.println(UiDesigner.createAnswer(answerTmp));
				break;
			case DesignConfig.MENU_NUMBER_FOUR:
				answerTmp += DesignConfig.MENU_ANSWER_TEXT;
				answerTmp += DesignConfig.MENU_NUMBER_FOUR_TEXT;
				answerTmp += answer;
				System.out.println(UiDesigner.createAnswer(answerTmp));
				break;
			default:
				break;
		}
		//System.out.print(id + ". ");
		//System.out.println(answer);
	}
	
	

}
