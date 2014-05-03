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
			showCurrentQuestionsNumber(currentQuestion);
			showLifes(player);
			givenAnswer = nextRound(); // Stellt dem Spieler eine zufällige Frage, zeigt ihm Antworten, fragt ihn nach einer Antwort, kontrolliert ob die Antworte richtig oder falsch ist und liefert das Ergebnis als booleschen Wert zurück.
			player.changeLifes(givenAnswer); // Verändert das Leben des Spieler je nach Antwort (richtig oder falsch).
			markAnswerAsRightOrWrong(givenAnswer);
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
		
		questions.get(randomQuestionId).askQuestion();
		questions.get(randomQuestionId).showAnswers();
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
			System.out.println("Antwort (Korrekt)" + "\n");
		}
		else
		{
			System.out.println("Antwort (Falsch)" + "\n");
		}
	}

	public void showLifes(Player player) 
	{
		System.out.print("[");
		System.out.print("Leben: ");
		System.out.print(player.getLifes() + "");
		System.out.println("]");
	}

	public void goodLuckWishes() 
	{
		System.out.println("###########[SPIEL BEGINNT]############");
		System.out.println("###########[GOOD LUCK!!!!]############");
	}						

	public void over() 
	{
		System.out.println("#############[GAME OVER]##############\n");
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
		System.out.print("Geben Sie Ihren Namen ein: ");
		try
		{
			scanner = new Scanner(System.in);
			name = scanner.nextLine();
		}
		catch(Exception e)
		{
			System.out.println("Scanner fehler!");
		}
		
		player.setName(name);
		player.score.setPlayerName(name);
		
		
	}
}
