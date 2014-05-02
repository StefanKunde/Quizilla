import java.util.Random;


public class Game 
{
	// Variablen.
	private Questions questions;
	public Player player;
	public Menu menu;
	public Highscore highscore;
	private int currentQuestion;
	
	// Konstrukoren.
	public Game()
	{
		questions = null;
		player = null;
		menu = new Menu();
		highscore = null;
		currentQuestion = 0;
	}
	
	public Game(Questions questions)
	{
		this.questions = questions;
		this.player = null;
		menu = new Menu();
		highscore = null;
		currentQuestion = 0;
	}
	
	// Methoden.
	
	// Delegatefuntkion
	public void startPlay() 
	{
		boolean givenAnswer = false;
		while( player.getHasLifes() && !questions.isEmpty())
		{
			currentQuestion++;
			showCurrentQuestionsNumber(currentQuestion);
			showLifes(player);
			givenAnswer = nextRound(); // Stellt dem Spieler eine zufällige Frage, zeigt ihm Antworten, fragt ihn nach einer Antwort, kontrolliert ob die Antworte richtig oder falsch ist und liefert das Ergebnis als booleschen Wert zurück.
			player.changeLifes(givenAnswer); // Verändert das Leben des Spieler je nach Antwort (richtig oder falsch).
			markAnswerAsRightOrWrong(givenAnswer);
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
		randomQuestionId = 9;
				
		return givenAnswer.equals(correctAnswer);
	}
	
	public void markAnswerAsRightOrWrong(boolean givenAnswer)
	{
		if(givenAnswer)
		{
			System.out.println("Antwort ist (Korrekt)" + "\n");
		}
		else
		{
			System.out.println("Antwort ist (Falsch)" + "\n");
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
		System.out.println("###########[SPIEL BEGINNT]###########");
		System.out.println("###########[GOOD LUCK!!!!]###########");
	}						

	public void over() 
	{
		System.out.println("#############[GAME OVER]#############\n");
	}
}
