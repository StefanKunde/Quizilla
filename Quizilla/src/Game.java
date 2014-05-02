import java.util.Random;


public class Game 
{
	// Variablen.
	private Questions questions;
	private Player player;
	private int maxQuestions;
	
	// Konstrukoren.
	public Game()
	{
		questions = null;
		player = null;
	}
	
	public Game(Questions questions)
	{
		this.questions = questions;
		this.player = null;
	}
	
	// Methoden.
	
	// Delegatefuntkion
	public void start() 
	{
		boolean givenAnswer = false;
		while( player.getHasLifes() && !questions.isEmpty())
		{
			showLifes(player);
			givenAnswer = nextRound(); // Stellt dem Spieler eine zufällige Frage, zeigt ihm Antworten, fragt ihn nach einer Antwort, kontrolliert ob die Antworte richtig oder falsch ist und liefert das Ergebnis als booleschen Wert zurück.
			player.changeLifes(givenAnswer); // Verändert das Leben des Spieler je nach Antwort (richtig oder falsch).
			markAnswerAsRightOrWrong(givenAnswer);
			
		}
	}
	
	public void addPlayer(Player player)
	{
		this.player = player;
	}
	
	public boolean nextRound()
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
			System.out.println("Antwort ist: (Korrekt)" + "\n");
		}
		else
		{
			System.out.println("Antwort ist: (Falsch)" + "\n");
		}
	}

	public void showLifes(Player player) 
	{
		System.out.print("[");
		System.out.print("Leben: ");
		System.out.print(player.getLifes() + "");
		System.out.println("]");
	} 
	
	
}
