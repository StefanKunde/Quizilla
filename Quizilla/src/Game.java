import java.util.Random;
import java.util.Scanner;


public class Game 
{
	// Variablen.
	private Questions questions;
	public Player player;
	public Menu menu;
	public Highscore highscore;
	private int currentQuestion;
	public Manual manual;
	
	
	// Konstrukoren.
	public Game()
	{
		questions = null;
		player = null;
		menu = new Menu();
		highscore = new Highscore();;
		currentQuestion = 0;
		manual = new Manual();
	}
	
	public Game(Questions questions, Highscore highscore)
	{
		this.questions = questions;
		this.highscore = highscore;
		player = null;
		menu = new Menu();
		currentQuestion = 0;
		manual = new Manual();		
	}
	
	// Methoden.
	public void addQuestions(Questions questions)
	{
		this.questions = questions;
	}
	
	public void startPlay() 
	{
		boolean givenAnswer = false;
		player.score.setMaxQuestions(questions.size());
		while( player.getHasLifes() && !questions.isEmpty())
		{
			currentQuestion++;
			System.out.println(UiDesigner.createStatus(currentQuestion, player.getLifes()));
			givenAnswer = nextRound(); // Stellt dem Spieler eine zufällige Frage, zeigt ihm Antworten, fragt ihn nach einer Antwort, kontrolliert ob die Antworte richtig oder falsch ist und liefert das Ergebnis als booleschen Wert zurück.
			player.changeLifes(givenAnswer); // Verändert das Leben des Spieler je nach Antwort (richtig oder falsch).
			markAnswerAsRightOrWrong(givenAnswer);
			System.out.println(UiDesigner.createDelimiterLine(DesignConfig.FILL_CHAR_DEFAULT, DesignConfig.BORDER_CHAR_DEFAULT));
			System.out.println(UiDesigner.createEmptyLine());
			player.score.addRound(currentQuestion, givenAnswer);
		}
		
	}
	
	private void showCurrentQuestionsNumber(int currentQuestion) 
	{
		System.out.println("Frage: " + currentQuestion);
	}

	public void addPlayer(Player player)
	{
		this.player = player;
	}
	
	private boolean nextRound()
	{
		String givenAnswer = "";
		String correctAnswer = "";
		Random random = new Random();
		
		int questionsAmount = questions.size();
		int randomQuestionId = random.nextInt( questionsAmount );
		
		System.out.println(UiDesigner.createDelimiterLine(DesignConfig.FILL_CHAR_FOR_DELIMITING, DesignConfig.BORDER_CHAR_DEFAULT));
		questions.get(randomQuestionId).askQuestion();
		System.out.println(UiDesigner.createDelimiterLine(DesignConfig.FILL_CHAR_FOR_DELIMITING, DesignConfig.BORDER_CHAR_DEFAULT));
		questions.get(randomQuestionId).showAnswers();
		System.out.println(UiDesigner.createDelimiterLine(DesignConfig.FILL_CHAR_FOR_DELIMITING, DesignConfig.BORDER_CHAR_DEFAULT));
		givenAnswer = player.answerQuestion(questions.get(randomQuestionId));
		correctAnswer = questions.get(randomQuestionId).getCorrectAnswer();
		questions.remove(randomQuestionId);

		questionsAmount = 0;
		randomQuestionId = 0;
				
		return givenAnswer.equals(correctAnswer);
	}
	
	public void markAnswerAsRightOrWrong(boolean givenAnswer)
	{
		if(givenAnswer)
		{
			System.out.println(UiDesigner.createInfo(DesignConfig.INFO_ANSWER_CORRECT));
		}
		else
		{
			System.out.println(UiDesigner.createInfo(DesignConfig.INFO_ANSWER_WRONG));
		}
	}

	public void printStartMessage() 
	{
		System.out.println(UiDesigner.createEmptyLine());
		System.out.println(UiDesigner.createTitle(DesignConfig.TITLE_GAME_START));
		System.out.println(UiDesigner.createEmptyLine());
	}						

	public void over() 
	{
		if(player.score.getResult() == 100)
		{
			System.out.println(UiDesigner.createTitle(DesignConfig.TITLE_CONGRATULATIONS));
			System.out.println(UiDesigner.createTitle(DesignConfig.TITLE_WON));
		}
		else
		{
			System.out.println(UiDesigner.createTitle(DesignConfig.TITLE_LOST));
		}
		highscore.add(player.score);
	}
	
	public void resetGameStatus(Questions questions)
	{
		currentQuestion = 0;
		player.resetStatus();
		this.questions = questions;
	}
	
	public void askForName()
	{
		Scanner scanner = null;
		String name = "";
		boolean vaildName = false;
		System.out.print(UiDesigner.createUserRequest(DesignConfig.USER_REQUEST_TEXT_NAME));
		
		scanner = new Scanner(System.in);
		while(!vaildName)
		{
			name = scanner.next();
			vaildName = (name.length() >= 1) && (name.length() <= 15);
			if(!vaildName)
			{
				System.out.println(UiDesigner.createInvalidInputMsg(DesignConfig.INVALID_NAME_MSG));
				System.out.print(UiDesigner.createUserRequest(DesignConfig.USER_REQUEST_TEXT_NAME));
			}
		}

		player.setName(name);
		player.score.setPlayerName(name);
		
		
	}

	public void showGoodByeMsg() 
	{
		System.out.println(UiDesigner.createTitle(DesignConfig.TITLE_GOOD_BYE));		
	}
}
