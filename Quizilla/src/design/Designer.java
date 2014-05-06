package design;

import game.Highscore;

import java.util.Scanner;

import config.Config;


//! Diese Klasse beinhaltet Methoden, um Consolenausgaben einheitlich zu gestalten.
/*  
 * Diese Klasse kann nicht instanziert werden. 
 * Mit Hilfe dieser Klasse lässt sich für alle aktuellen Situation eine einheitliche, individuell angepasste Zeile generien.
 * Die Designrelevanten Einstellungen werden in der Klaase Config als Konstanten konfiguriert.
 * 
 * @INFO: Leider NOCH sehr redundant.
 * @ TODO: siehe INFO.
 * 
 * @author Stefan Kunde
 * @date 01.05.2014
 * @version 1.0
 * 
 */
public final class Designer 
{
	// statische Variablen.
	private static StringBuilder text;
	private static int startTextPos;
	private static int endTextPos;
	private static int openCharPos;
	private static int closeCharPos;
	
	
	// Statische Methoden.
	
	//! Generiert eine einheitliche Zeile zur Ausgabe, entsprechend der Parameter, nach einem Muster.
	/*!
	 * Das Muster wird aus der Config "generiert".
	 *
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @fillText Dies ist der Text, der umhüllt werden soll .
	 * @freeSpaceChar Dieser char wird benutzt, um die Lücken (leere Zeichen) zu füllen.
	 * @openChar Dieser char wird dafür verwendet den fillText mit einem Zeichen zu eröffnen (Umrandung).
	 * @closeChar Dieser char wird dafür verwendet den fillText mit einem Zeichen zu verschließen (Umrandung).
	 * @border Dieser Char wird für den Rand der Zeile verwendet. Jeweils am Anfang und am Ende der Zeile.
	 * @puffer Dieser Integer gibt an auf welcher Position (vom linken Rand aus) der fillText stehen soll.
	 * @param isUserRequest Signalisiert, dass der Aurufende eine Userrequest generlert haben will. Wenn true, wird die Zeile nur bis zum Ende des fillTextes generiert. 
	 * 						Das ist so gelöst, damit eine Usereingabe in der selben Zeile stattfinden kann. 
	 * 
	 * 
	 * @return Zurückgegeben wird die generierte Zeile als String.
    */
	private static String createLine(String fillText, char freeSpaceChar, char openChar, char closeChar, char borderChar, int puffer, boolean isUserActionRequired)
	{
		text = new StringBuilder();
		int maxRowLengthTmp = Config._MAX_ROW_LENGTH;
		int fillTextLength = fillText.length();
		
		// Generiere die Zeile, wenn der Text nicht zu lang ist.
		if(fillTextLength < Config._MAX_TEXT_LENGTH_EACH_LINE)
		{
			
			// Setze den gegebenen Puffer, wenn dieser gültig ist.
			if( (puffer > Config._INVALID_PUFFER) && ( puffer < (Config._MAX_ROW_LENGTH - Config._MIN_PUFFER_EACH_LINE) ) )
				startTextPos = puffer + Config._BORDER_LENGTH;
			else
				startTextPos = ( (Config._MAX_ROW_LENGTH / 2) - (fillTextLength / 2) ); 
			
			// Bestimme Positionen der Elemente für diese Zeile.
			endTextPos = startTextPos + fillTextLength; 
			openCharPos = startTextPos - Config._OPEN_CHAR_LENGTH;
			closeCharPos = endTextPos + Config._CLOSE_CHAR_LENGTH;
			
			// Wenn der Aufruf von der Methode createUserRequest ist, dann begrenze das Zeilenende auf die Länge des Textes der Userrequest,
			// um die Usereingabe direkt hinter der Aufforderung schreiben zu können. Info: In Java wird nach jedem Userinput in der Konsole ein Zeilenumbruch generiert.
			if(isUserActionRequired)
				maxRowLengthTmp = puffer + fillText.length();
			
			// Durchläuft die als maximal eingestellte Zeilenlänge und beschreibt einen StringBuilder von der Größe damit.
			for(int i = 0; i <= maxRowLengthTmp; i++)
			{
				// Wenn i sich um eine Poistion vor dem fillText befindet, soll der zu eröffnende char dem StringBuilder hinzugefügt werden.
				if( i == openCharPos )
				{
					text.append( openChar );
					continue;
				}
				
				// Wenn i sich um eine Poistion nach dem fillText befindet, soll der zu schließende char dem StringBuilder hinzugefügt werden.
				if( i == closeCharPos )
				{
					text.append( closeChar);
					continue;
				}
				
				// Wenn i sich an der Startposition von fillText befindet, soll fillText dem StringBuilder hinzugefügt werden.
				if( i == startTextPos )
				{
					// Schreibt den fillText in den StringBuilder.
					for(int j = 0;j < fillTextLength; j++)
					{
						text.append(fillText.charAt(j));
					}
					i += fillTextLength; // Erhöht i um die Länge von fillText.
					continue;
				}
				
				// Wenn i sich an der erste oder letzten Position befindet, soll der Rand dem StringBuilder appendet werden.
				if( (i == Config._START_ROW) || (i == Config._MAX_ROW_LENGTH) )
				{
					text.append(borderChar);
					continue;
				}
					
				// Wenn keine Bedingung bis hierhin erfüllt wurde, muss es sich um eine Position mit Leerraum handeln 
				// und der dafür übergebende Char soll dem StringBuider appendet werden.
				text.append(freeSpaceChar);
			}
		}
		else
		{
			return null; // @ TODO: Eigene Exception schreiben.
		}
		
		return text.toString();
	}
	
	//! Ruft die createLine Methode auf, mit den für einen Titel vordefinierten Designeinstellungen aus Config.
	/*!
	 *
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @title Behinhandelt den gewünschten Text für eine Titelzeile.
	 * 
	 * 
	 * @return Zurückgegeben wird die generierte Titelzeile als String.
    */
	public static String createTitle(String title)
	{
		String titleLine = createLine(title, 
					Config._FILL_SPACE_TITLES, Config._OPEN_TITLE_CHAR, 
					Config._CLOSE_TITLE_CHAR, Config._BORDER_DEFAULT, 
					Config._PUFFER_TITLE, false);
		return titleLine;
	}
	
	//! Ruft die createLine Methode auf, mit den für eine Frage vordefinierten Designeinstellungen aus Config.
	/*!
	 *
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @question Behinhandelt die Frage. 
	 * 
	 * 
	 * @return Zurückgegeben wird die generierte Frage-Zeile als String.
    */
	public static String createQuestion(String question)
	{
		String questionLine = createLine(question, 
					Config._FILL_SPACE_QUESTIONS, Config._OPEN_QUESTION_CHAR, 
					Config._CLOSE_QUESTION_CHAR, Config._BORDER_QUESTION, 
					Config._PUFFER_QUESTION, false);
		return questionLine;
	}
	
	//! Ruft die createLine Methode auf, mit den für eine Antwort vordefinierten Designeinstellungen aus Config.
	/*!
	 *
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @answer Behinhandelt eine Antwort. 
	 * 
	 * 
	 * @return Zurückgegeben wird die generierte Antwort-Zeile als String.
    */
	public static String createAnswer(String answer)
	{
		String answerLine = createLine(answer, 
					Config._FILL_SPACE_ANSWERS, Config._OPEN_ANSWER_CHAR, 
					Config._CLOSE_ANSWER_CHAR, Config._BORDER_ANSWER, 
					Config._PUFFER_ANSWER, false);
		return answerLine;
	}
	
	//! Ruft die createLine Methode auf, mit den für eine UserRequest vordefinierten Designeinstellungen aus Config.
	/*!
	 *
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @request Behinhandelt den Text, den Benutzeraufforderungstext. 
	 * 
	 * 
	 * @return Zurückgegeben wird die generierte Benutzeraufforderungszeile als String.
    */
	public static String createUserRequest(String request)
	{
		String answerLine = createLine(request, 
					Config._FILL_SPACEREQUEST, Config._OPEN_REQUEST_CHAR, 
					Config._CLOSE_REQUEST_CHAR, Config._BORDER_REQUEST, 
					Config._PUFFER_USER_REQUEST, true);
		return answerLine;
	}
	
	//! Ruft die createLine Methode auf, mit den für eine Infozeile vordefinierten Designeinstellungen aus Config.
	/*!
	 *
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @info Behinhandelt den Text der informieren soll.
	 * 
	 * 
	 * @return Zurückgegeben wird die generierte Infozeile als String.
    */
	public static String createInfo(String info)
	{
		String answerLine = createLine(info, 
					Config._FILL_SPACE_INFO, Config._OPEN_INFO_CHAR, 
					Config._CLOSE_INFO_CHAR, Config._BORDER_INFO, 
					Config._PUFFER_USER_INFO, false);
		return answerLine;
	}
	
	//! Ruft die createLine Methode auf, mit den für eine Ergebniszeile vordefinierten Designeinstellungen aus Config.
	/*!
	 *
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @result Behinhandelt das Ergebnis.
	 * 
	 * 
	 * @return Zurückgegeben wird die generierte Ergebniszeile als String.
    */
	public static String createResultLine(String result)
	{
		String answerLine = createLine(result, 
					Config._FILL_SPACE_RESULT, Config._OPEN_RESULT_CHAR, 
					Config._CLOSE_RESULT_CHAR, Config._BORDER_RESULT, 
					Config._PUFFER_RESULT, false);
		return answerLine;
	}
	
	//! Ruft die createLine Methode auf, mit den für eine Menüzeile vordefinierten Designeinstellungen aus Config.
	/*!
	 *
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @request Behinhandelt die Menüauswahlmöglichkeit einer Zeile.
	 * 
	 * 
	 * @return Zurückgegeben wird die generierte Menüzeile als String.
    */
	public static String createMenuLine(String menuText)
	{
		String menuTextTmp = createLine(menuText, 
					Config._FILL_SPACE_MENU, Config._OPEN_MENU_CHAR, 
					Config._CLOSE_MENU_CHAR, Config._BORDER_MENU, 
					Config._PUFFER_MENU, false);
		return menuTextTmp;
	}
	
	//! Ruft die createLine Methode auf, mit den für eine falsche-Benutzereingabe-Zeile vordefinierten Designeinstellungen aus Config.
	/*!
	 *
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @invalidNameMsg Behinhandelt den Text, den Benutzeraufforderungstext. 
	 * 
	 * 
	 * @return Zurückgegeben wird die generierte falsche-Benutzereingabe-Zeile als String.
    */
	public static String createInvalidInputMsg(String invalidUserInputMsg) 
	{
		String invalidUserInputMsgTmp = createLine(invalidUserInputMsg, 
				Config._FILL_SPACE_INVALID_INPUTS, Config._OPEN_INVALID_INPUT_CHAR, 
				Config._CLOSE_INVALID_INPUT_CHAR, Config._BORDER_INVALID_INPUT, 
				Config._PUFFER_INVALID_INPUT, false);
		
		return invalidUserInputMsgTmp;
	}
	
	public static String createManualLine(String manualLine) 
	{
		String manualLineTmp = createLine(manualLine, 
				Config._FILL_SPACE_MANUAL, Config._OPEN_MANUAL_LINE_CHAR, 
				Config._CLOSE_MANUAL_LINE_CHAR, Config._BORDER_MANUAL, 
				Config._PUFFER__MANUAL_LINE, false);
		
		return manualLineTmp;
	}
	
	//! Ruft die createLine Methode auf, mit den für eine WaitForUserAction-Zeile vordefinierten Designeinstellungen aus Config.
	/*!
	 * Es wird daraufhin gewartet, dass der Benutzter mit Enter bestätigt.
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
    */
	public static void createWaitForUserLine()
	{
		Scanner scanner = new Scanner(System.in);
		
		String answerLine = createLine(Config._USER_REQUEST_ENTER_TEXT, 
				Config._FILL_SPACEREQUEST, Config._OPEN_REQUEST_CHAR, 
				Config._CLOSE_REQUEST_CHAR, Config._BORDER_REQUEST, 
				Config._PUFFER_USER_REQUEST, true);
		System.out.print(answerLine);
		scanner.nextLine();
		System.out.println(Designer.createEmptyLine());
	}
	
	//! Generiert eine Zeile der Highscoreliste.
	/*!
	 * @ TODO: Sehr ähnlich zur createLine Funktion. Sollte angepasst werden, um Redundanz zu vermeiden.
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @rank Der Rang des Scores. 
	 * @name Der Name des Spielers des Scores.
	 * @result Das Ergebnis als Prozent dargestellt. 
	 * 
	 * 
	 * @return Zurückgegeben wird die generierte Highscoreliste-Zeile als String.
    */
	private static String createHighscoreLine(int rank, String name, int result)
	{
		text = new StringBuilder();
		String highscoreLine = "";
		String rankTmp = "" + rank;
		String nameTmp = name;
		String resultTmp = "" + result;
		
		// Hier sollen die Zusatzzeichen (z.b. "." oder "%" bei den Ergebnissen nicht gespeichert werden, wenn es kein Ergebnis gibt.
		if(rank == Config._RESULT_IS_NOT_AVAILABLE_INT)
			rankTmp = Config._RESULT_EMPTY_TEXT;
		else
			rankTmp += Config._BORDER_RANK;
		if(result == Config._RESULT_IS_NOT_AVAILABLE_INT)
			resultTmp = Config._RESULT_EMPTY_TEXT;
		else
			resultTmp += Config._BORDER_RESULT;
		// Das Zusatzzeichenhandling ist hier abgeschlossen.
		
		for(int i = 0; i < Config._MAX_ROW_LENGTH; i++)
		{
			if(i == Config._PUFFER_HIGHSCORE_RANK)
			{
				text.append(rankTmp);
				i += rankTmp.length() - 1;
				continue;
			}
			if(i == Config._PUFFER_HIGHSCORE_NAME)
			{
				text.append(nameTmp);
				i += nameTmp.length() - 1;
				continue;
			}
			if(i == Config._PUFFER_HIGHSCORE_RESULT)
			{
				text.append( resultTmp );
				i += resultTmp.length() -1;
				continue;
			}
			
			if(i == 0 || i == Config._MAX_ROW_LENGTH - 1)
			{
				text.append(Config._BORDER_HIGHSCORE);
				continue;
			}
			
			text.append(Config._FILL_SPACE_HIGHSCORE);
			
		}
		highscoreLine = text.toString();
		
		return highscoreLine;
	}
	
	//! Generiert die komplette Highscoreliste.
	/*!
	 * Erstellt die Highscoreliste nach den in den Config vordefinierten Einstellungen.
	 *
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @highscore Behinhandelt den sortierten Highscore. 
	 * 
	 * 
	 * @return Zurückgegeben wird die generierte falsche-Benutzereingabe-Zeile als String.
    */
	public static String createHighscoreList(Highscore highscore)
	{
		StringBuilder textTmp = new StringBuilder(); // Neuer Stringbuilder, weil diese Methode eine andere Methode aufruft, die den StringBuilder "text" dieser Klasse verwendet.
		
		textTmp.append( createTitle(Config._TITLE_HIGHSCORE) );
		textTmp.append( Config._NEW_LINE );
		
		// Generiert so viele Highscorezeilen wie laut Config eingestellt sind.
		for(int i = 0; i < Config._MAX_PLAYER_ON_HIGHSCORE_LIST; i++)
		{
			// Wenn es beim aktuellen index des Highscores ein Ergebnis vorliegt, generiere eine Zeile mit den dazu passenden Informationen
			if(i < highscore.size())
			{
				textTmp.append( createHighscoreLine( (i+1), highscore.get(i).getPlayerName(), highscore.get(i).getResult()) );
			}
			else
			{
				textTmp.append( createHighscoreLine( Config._RESULT_IS_NOT_AVAILABLE_INT, Config._RESULT_EMPTY_TEXT, Config._RESULT_IS_NOT_AVAILABLE_INT) );
			}
			textTmp.append(Config._NEW_LINE);
		}
		textTmp.append( createTitle(Config._TITLE_HIGHSCORE) );
		
		return textTmp.toString();
	}

	
	//! Generiert eine Statuszeile.
	/*!
	 * Eine Statuszeile ist eine Zeile die vor jeder Frage die aktuelle Nummer der Frage und das aktuelle Leben enthält.
	 *
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @questionAmount Behinhandelt die aktuelle Anzahl der Frage.
	 * @lifes Behinhaltelt die aktuelle Anzahl an Leben des Spielers.
	 * 
	 * 
	 * @return Zurückgegeben wird die generierte Statuszeile als String.
    */
	public static String createStatus(int questionAmount, int lifes)
	{
		text = new StringBuilder();
		
		// Designeinstellungen für die aktuelle Statuszeile laden, anhand der Config und der Parameter.
		String questionsText = Config._STATUS_QUESTIONS_AMOUNT_TEXT + String.valueOf(questionAmount);
		String lifesText = Config._STATUS_LIFE_TEXT + String.valueOf(lifes);
		int questionStartPos = Config._PUFFER_QUESTION_AMOUNT;
		int endTextPosQuestion = questionStartPos + questionsText.length(); 
		int lifeStartPos = Config._PUFFER_LIFE_LEFT;
		int endTextPosLife = lifeStartPos + lifesText.length(); 
		int openCharPosQuestion = questionStartPos - Config._OPEN_CHAR_LENGTH;
		int closeCharPosQuestion = endTextPosQuestion;
		int openCharPosLife = lifeStartPos - Config._OPEN_CHAR_LENGTH;
		int closeCharPosLife = endTextPosLife;
		
		// Generiert die Zeile.
		for(int i = 0; i < Config._MAX_ROW_LENGTH; i++)
		{
			if(i == questionStartPos)
			{
				for(int j = 0;j < questionsText.length(); j++)
				{
					text.append(questionsText.charAt(j));
				}
				i += questionsText.length(); 
			}
			
			if(i == lifeStartPos)
			{
				for(int j = 0;j < lifesText.length(); j++)
				{
					text.append(lifesText.charAt(j));
				}
				i += lifesText.length(); 
			}
			
			if( i == openCharPosQuestion || i == openCharPosLife )     
				text.append(Config._OPEN_STATUS_CHAR);
			
			if ((i == closeCharPosQuestion || i == closeCharPosLife))
			{
				text.append(Config._CLOSE_STATUS_CHAR);
			}
							
			if ( (i != lifeStartPos) && (i != questionStartPos) && (i != openCharPosQuestion) && (i != closeCharPosQuestion) && (i != openCharPosLife) && (i != closeCharPosLife) ) 
				text.append(Config._FILL_SPACE_STATUS);
		}
		
		return text.toString();
	}
	
	//! Generiert eine Trennzeile.
	/*!
	 *
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @delimiterChar Ist das Zeichen, das zum Füllen der Zeile verwendet werden soll.
	 * @boarderChar Ist das Zeichen, das als Rand verwendet werden soll.
	 * 
	 * 
	 * @return Zurückgegeben wird die generierte Trennzeile als String.
    */
	public static String createDelimiterLine(char delimiterChar, char boarderChar)
	{
		text = new StringBuilder();
		for(int i = 0; i < Config._MAX_ROW_LENGTH; i++)
		{
			if( (i == Config._START_ROW) || (i == ( Config._MAX_ROW_LENGTH - 1 ) ) )
				text.append(boarderChar);
			else
				text.append(delimiterChar);
			
		}
		
		return text.toString();
	}
	
	//! Generiert eine Leere Zeile.
	/*!
	 *
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * 
	 * @return Zurückgegeben wird eine leere Zeile als String (Zeilenumbruch).
    */
	public static String createEmptyLine() 
	{
		return Config._NEW_LINE;
	}
	
}
