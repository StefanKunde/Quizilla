package game;
import java.util.Random;
import java.util.Scanner;

import config.Config;
import design.Designer;

//! Diese Klasse repräsentiert das komplette Spiel.
/*
 * Alle spielrelevanten Funktionen und Objekte treffen in einer Instanz dieser Klasse aufeinander.
 * 
 * @author Stefan Kunde
 * @date 01.05.2014
 * @version 1.0
 * 
 */
public class Game 
{
	// Variablen.
	private Questions questions;
	private int currentQuestion;
	public Player player;
	public Menu menu;
	public Highscore highscore;
	public Manual manual;
	
	
	// Konstrukoren.
	public Game()
	{
		questions = null;
		player = null;
		menu = new Menu();
		highscore = new Highscore();;
		currentQuestion = 0;
		manual = null;
	}
	
	public Game(Questions questions, Highscore highscore, Manual manual)
	{
		this.questions = questions;
		this.highscore = highscore;

		this.manual = manual;
		player = null;
		menu = new Menu();
		currentQuestion = 0;		
	}
	
	// Methoden.
	
	//! Fügt dem Spiel das Objekt zu, das die Fragen beinhalten und verwalten soll.
	/*!
	 *
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @questions questions-Objekt das hinzugefügt werden soll. 
	 * 
    */
	public void addQuestions(Questions questions)
	{
		this.questions = questions;
	}
	
	//! Startet das Spiel.
	/*!
	 * Fragt den Spieler Fragen, zeigt ihm Antworten und erwartet eine Antwort.
	 * Das Spiel läuft solange, bis der Spieler keine Leben mehr hat oder es keine Fragen mehr gibt.
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
    */
	public void startPlay() 
	{
		boolean givenAnswer = false;
		if(questions.size() > Config._MAX_QUESTIONS_EACH_GAME)
		{
			player.score.setMaxQuestions(Config._MAX_QUESTIONS_EACH_GAME);
		}
		else
		{
			player.score.setMaxQuestions(questions.size());
		}
		
		
		// Wenn der Spieler noch Leben hat, es überhaupt noch Fragen gibt UND der Spieler noch nicht die maximal eingestellte Fragenanzahl erreicht hat,
		// wird eine neue Frage gestellt.
		while( player.getHasLifes() && !questions.isEmpty() && (currentQuestion < Config._MAX_QUESTIONS_EACH_GAME) )
		{
			currentQuestion++;
			System.out.println(Designer.createStatus(currentQuestion, player.getLifes()));
			givenAnswer = nextRound(); // Stellt dem Spieler eine zufällige Frage, zeigt ihm Antworten, fragt ihn nach einer Antwort, kontrolliert ob die Antworte richtig oder falsch ist und liefert das Ergebnis als booleschen Wert zurück.
			player.changeLifes(givenAnswer); // Verändert das Leben des Spieler je nach Antwort (richtig oder falsch).
			markAnswerAsRightOrWrong(givenAnswer);
			System.out.println(Designer.createDelimiterLine(Config._FILL_SPACE_DEFAULT, Config._BORDER_DEFAULT));
			System.out.println(Designer.createEmptyLine());
			player.score.changeCorrectAnswersAmount(givenAnswer);
		}
	}
	
	//! Stellt dem Spieler eine zufällige Frage, erwartet eine Antwort und liefer zurück ob sie richtig oder falsch beantwortet wurde.
	/*!
	 * !!! Nachdem die Frage geestellt wurde, wird sie aus dem Questions-Objekt gelöscht.
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @return Zurückgegeben wird ein boolescher Wert der angibt, ob der User die Frage richtig oder falsch beantwortet hat.
	 * 
    */
	private boolean nextRound()
		{
			String givenAnswer = "";
			String correctAnswer = "";
			Random random = new Random();
			
			int questionsAmount = questions.size();
			int randomQuestionId = random.nextInt( questionsAmount );
			
			System.out.println(Designer.createDelimiterLine(Config._FILL_SPACE_DELIMITING, Config._BORDER_DEFAULT));
			questions.get(randomQuestionId).askQuestion();
			System.out.println(Designer.createDelimiterLine(Config._FILL_SPACE_DELIMITING, Config._BORDER_DEFAULT));
			questions.get(randomQuestionId).showAnswers();
			System.out.println(Designer.createDelimiterLine(Config._FILL_SPACE_DELIMITING, Config._BORDER_DEFAULT));
			givenAnswer = player.answerQuestion(questions.get(randomQuestionId));
			correctAnswer = questions.get(randomQuestionId).getCorrectAnswer();
			questions.remove(randomQuestionId);

			questionsAmount = 0;
			randomQuestionId = 0;
					
			return givenAnswer.equals(correctAnswer);
		}

	//! Fügt dem Spiel ein Player-Objekt hinzu.
	/*!
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
    */
	public void addPlayer(Player player)
	{
		this.player = player;
	}

	//! Markierte diese Frage als richtig oder falsch.
	/*! 
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @isAnswerCorrect Beinhaltet die Information ob die Antwort richtig oder falsch ist.
	 * 
    */
	public void markAnswerAsRightOrWrong(boolean isAnswerCorrect)
	{
		if(isAnswerCorrect)
		{
			System.out.println(Designer.createInfo(Config._INFO_ANSWER_CORRECT_TEXT));
		}
		else
		{
			System.out.println(Designer.createInfo(Config._INFO_ANSWER_WRONG_TEXT));
		}
	}

	//! Ausgabe einiger Zeilen, die den Benutzer darauf hinweisen, dass das Spiel beginnt.
	/*! 
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
    */
	public void printStartMessage() 
	{
		System.out.println(Designer.createEmptyLine());
		System.out.println(Designer.createTitle(Config._TITLE_GAME_START));
		System.out.println(Designer.createEmptyLine());
	}						

	//! Ausgabe einiger Zeilen, die den Benutzer darauf hinweisen, dass das Spiel vorbei ist.
	/*! 
	 * Wenn der Benutzer noch volles Leben hat und alle Fragen richtig beantwortet hat, wird eine Glückwunschzeile ausgegeben
	 * Ansonsten eine "Leider verloren"-Zeile.
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
    */
	public void over() 
	{
		if(player.score.getResult() == Config._MAX_RESULT || player.getHasLifes())
		{
			System.out.println(Designer.createTitle(Config._TITLE_CONGRATULATIONS));
			System.out.println(Designer.createTitle(Config._TITLE_WON));
		}
		else
		{
			System.out.println(Designer.createTitle(Config._TITLE_LOST));
		}
		highscore.add(player.score);
	}
	
	//! Setzt die Spielrelevanten Einstellung wieder auf den Startzustand zurück.
	/*! 
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @questions Ein "frisches" Object mit allen Fragen.
	 * 
    */
	public void resetGameStatus(Questions questions)
	{
		currentQuestion = Config._RESET_CURRENT_QUESTION_VALUE;
		player.resetStatus();
		this.questions = questions;
	}
	
	//! Fragt den Spieler nach seinem Namen und speichert ihn.
	/*! 
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
    */
	public void askForName()
	{
		Scanner scanner = null;
		String name = "";
		boolean vaildName = false;
		System.out.print(Designer.createUserRequest(Config._USER_REQUEST_NAME_TEXT));
		scanner = new Scanner(System.in);
		
		while(!vaildName)
		{
			name = scanner.nextLine();
			vaildName = (name.length() >= 1) && (name.length() <= 15);
			if(!vaildName)
			{
				System.out.println(Designer.createInvalidInputMsg(Config._INVALID_NAME_MSG));
				System.out.print(Designer.createUserRequest(Config._USER_REQUEST_NAME_TEXT));
			}
		}
		player.setName(name);
		player.score.setPlayerName(name);
	}

	//! Gibt eine Zeile aus, in der sich vom Benutzer verabschiedet wird.
	/*! 
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
    */
	public void showGoodByeMsg() 
	{
		System.out.println(Designer.createTitle(Config._TITLE_GOOD_BYE));		
	}
}
