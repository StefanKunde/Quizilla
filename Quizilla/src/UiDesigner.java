

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class UiDesigner 
{
	private static StringBuilder text = new StringBuilder();
	private static int freeSpaceSize;
	private static int startTextPos;
	private static int endTextPos;
	private static int openCharPos;
	private static int closeCharPos;
	
	// Statische Methoden.
	private static String createLine(String fillText, char freeSpaceChar, char openChar, char closeChar, char border, int puffer, boolean userRequest)
	{
		text.delete(0, DesignConfig.MAX_ROW_LENGTH);
		int maxRowLength = DesignConfig.MAX_ROW_LENGTH;
		int fillTextLength = fillText.length();
		String result = "";
		if(fillTextLength < DesignConfig.MAX_LENGTH_FOR_QUESTIONS_EACH_LINE)
		{
			freeSpaceSize = DesignConfig.MAX_ROW_LENGTH - fillTextLength - 
							DesignConfig.OPEN_CHAR_LENGTH - DesignConfig.CLOSE_CHAR_LENGTH;
			
			// Setze den gegebenen Buffer, wenn dieser gültig ist.
			if( (puffer > 0) && (puffer < (DesignConfig.MAX_ROW_LENGTH - DesignConfig.MIN_PUFFER_EACH_LINE)) )
				startTextPos = puffer + DesignConfig.BORDER_LENGTH;
			else
				startTextPos = (DesignConfig.MAX_ROW_LENGTH / 2) - (fillTextLength / 2); 
			
			endTextPos = startTextPos + fillTextLength; 
			openCharPos = startTextPos - DesignConfig.OPEN_CHAR_LENGTH;
			closeCharPos = endTextPos + DesignConfig.CLOSE_CHAR_LENGTH;
			
			// Wenn der Aufruf von der Methode createUserRequest ist, dann begrenze das Zeilenende auf die Länge des Textes der Userrequest,
			// um die Usereingabe direkt hinter der Aufforderung schreiben zu können. Info: In Java wird nach jedem Userinput in der Konsole ein Zeilenumbruch geprintet.
			if(userRequest)
				maxRowLength = puffer + fillText.length();
				
			for(int i = 0; i <= maxRowLength; i++)
			{
				if( i == openCharPos )
					text.append(openChar);
				
				if( i == closeCharPos )
					text.append(closeChar);
				
				if( i == startTextPos )
				{
					for(int j = 0;j < fillTextLength; j++)
					{
						text.append(fillText.charAt(j));
					}
					i += fillTextLength; 
				}
				
				if( (i != openCharPos) &&  (i != closeCharPos) 
						&& ((i < startTextPos) || (i > endTextPos)) 
							&& (freeSpaceSize > 0) && (i != 0) 
								&& (i != DesignConfig.MAX_ROW_LENGTH) )
				{
					text.append(freeSpaceChar);
				}
				
				if( (i == 0) || (i == DesignConfig.MAX_ROW_LENGTH) )
					text.append(border);
			}
		}
		else
		{
			return null; // @ TODO: Eigene Exception schreiben.
		}
		
		result = text.toString();
		text.delete(0, DesignConfig.MAX_ROW_LENGTH);
		
		return result;
	}
	
	public static String createTitle(String title)
	{
		String titleLine = createLine(title, 
					DesignConfig.FILL_CHAR_FOR_TITLES, DesignConfig.OPEN_TITLE_CHAR, 
					DesignConfig.CLOSE_TITLE_CHAR, DesignConfig.BORDER_CHAR_DEFAULT, 
					DesignConfig.PUFFER_TITLE, false);
		return titleLine;
	}
	
	public static String createQuestion(String question)
	{
		String questionLine = createLine(question, 
					DesignConfig.FILL_CHAR_FOR_QUESTIONS, DesignConfig.OPEN_QUESTION_CHAR, 
					DesignConfig.CLOSE_QUESTION_CHAR, DesignConfig.BOARDER_CHAR_QUESTION, 
					DesignConfig.PUFFER_QUESTION, false);
		return questionLine;
	}
	
	public static String createAnswer(String answer)
	{
		String answerLine = createLine(answer, 
					DesignConfig.FILL_CHAR_FOR_ANSWERS, DesignConfig.OPEN_ANSWER_CHAR, 
					DesignConfig.CLOSE_ANSWER_CHAR, DesignConfig.BORDER_CHAR_ANSWER, 
					DesignConfig.PUFFER_ANSWER, false);
		return answerLine;
	}
	
	public static String createUserRequest(String request)
	{
		String answerLine = createLine(request, 
					DesignConfig.FILL_CHAR_FOR_REQUEST, DesignConfig.OPEN_REQUEST_CHAR, 
					DesignConfig.CLOSE_REQUEST_CHAR, DesignConfig.BORDER_CHAR_REQUEST, 
					DesignConfig.PUFFER_USER_REQUEST, true);
		return answerLine;
	}
	
	public static String createInfo(String info)
	{
		String answerLine = createLine(info, 
					DesignConfig.FILL_CHAR_FOR_INFO, DesignConfig.OPEN_INFO_CHAR, 
					DesignConfig.CLOSE_INFO_CHAR, DesignConfig.BORDER_CHAR_INFO, 
					DesignConfig.PUFFER_USER_INFO, false);
		return answerLine;
	}
	
	public static String createResultLine(String result)
	{
		String answerLine = createLine(result, 
					DesignConfig.FILL_CHAR_FOR_RESULT, DesignConfig.OPEN_RESULT_CHAR, 
					DesignConfig.CLOSE_RESULT_CHAR, DesignConfig.BORDER_CHAR_RESULT, 
					DesignConfig.PUFFER_RESULT, false);
		return answerLine;
	}
	
	public static String createMenuLine(String menuText)
	{
		String menuTextTmp = createLine(menuText, 
					DesignConfig.FILL_CHAR_FOR_MENU, DesignConfig.OPEN_MENU_CHAR, 
					DesignConfig.CLOSE_MENU_CHAR, DesignConfig.BORDER_CHAR_MENU, 
					DesignConfig.PUFFER_MENU, false);
		return menuTextTmp;
	}
	
	private static String createHighscoreLine(int rank, String name, int result)
	{
		text.delete(0, DesignConfig.MAX_ROW_LENGTH);
		String highscoreLine = "";
		String rankTmp = "" + rank;
		String nameTmp = name;
		String resultTmp = "" + result;
		
		// Hier sollen die Zusatzzeichen (z.b. "." oder "%" bei den Ergebnissen nicht gespeichert werden, wenn es kein Ergebnis gibt.
		if(rank == DesignConfig.RESULT_IS_NOT_AVAILABLE_INT)
			rankTmp = DesignConfig.RESULT_EMPTY;
		else
			rankTmp += DesignConfig.BORDER_CHAR__RANK;
		if(result == DesignConfig.RESULT_IS_NOT_AVAILABLE_INT)
			resultTmp = DesignConfig.RESULT_EMPTY;
		else
			resultTmp += DesignConfig.BORDER_CHAR_RESULT;
		// Das Zusatzzeichenhandling ist hier abgeschlossen.
		
		for(int i = 0; i < DesignConfig.MAX_ROW_LENGTH; i++)
		{
			if(i == DesignConfig.PUFFER_HIGHSCORE_RANK)
			{
				text.append(rankTmp);
				i += rankTmp.length() - 1;
				continue;
			}
			if(i == DesignConfig.PUFFER_HIGHSCORE_NAME)
			{
				text.append(nameTmp);
				i += nameTmp.length() - 1;
				continue;
			}
			if(i == DesignConfig.PUFFER_HIGHSCORE_RESULT)
			{
				text.append( resultTmp );
				i += resultTmp.length() -1;
				continue;
			}
			
			if(i == 0 || i == DesignConfig.MAX_ROW_LENGTH - 1)
			{
				text.append(DesignConfig.BORDER_CHAR_HIGHSCORE);
				continue;
			}
			
			text.append(DesignConfig.FILL_CHAR_FOR_HIGHSCORE);
			
		}
		highscoreLine = text.toString();
		text.delete(0, DesignConfig.MAX_ROW_LENGTH);
		
		return highscoreLine;
	}
	
	public static String createHighscoreList(Highscore highscore)
	{
		String highScoreLines = "";
		highScoreLines += createTitle(DesignConfig.TITLE_HIGHSCORE);
		highScoreLines += DesignConfig.NEW_LINE;
		
		for(int i = 0; i < DesignConfig.MAX_PLAYER_ON_HIGHSCORE_LIST; i++)
		{
			if(i < highscore.size())
			{
				highScoreLines += createHighscoreLine( (i+1), highscore.get(i).getPlayerName(), highscore.get(i).getResult());
			}
			else
			{
				highScoreLines += createHighscoreLine( DesignConfig.RESULT_IS_NOT_AVAILABLE_INT, DesignConfig.RESULT_EMPTY, DesignConfig.RESULT_IS_NOT_AVAILABLE_INT);
			}
			highScoreLines += DesignConfig.NEW_LINE;
		}
		highScoreLines += createTitle(DesignConfig.TITLE_HIGHSCORE);
		return highScoreLines;
	}
	
	public static String createManual(File manual)
	{
		
		return text.toString();
	}
	
	public static String createStatus(int questionAmount, int lifes)
	{
		text.delete(0, DesignConfig.MAX_ROW_LENGTH);
		String answerLine = "";
		String questionsText = DesignConfig.STATUS_QUESTIONS_AMOUNT_TEXT + String.valueOf(questionAmount);
		String lifesText = DesignConfig.STATUS_LIFE_TEXT + String.valueOf(lifes);
		int questionStartPos = DesignConfig.PUFFER_QUESTION_AMOUNT;
		int endTextPosQuestion = questionStartPos + questionsText.length(); 
		
		int lifeStartPos = DesignConfig.PUFFER_LIFE_LEFT;
		int endTextPosLife = lifeStartPos + lifesText.length(); 
		
		int openCharPosQuestion = questionStartPos - DesignConfig.OPEN_CHAR_LENGTH;
		int closeCharPosQuestion = endTextPosQuestion;
		
		int openCharPosLife = lifeStartPos - DesignConfig.OPEN_CHAR_LENGTH;
		int closeCharPosLife = endTextPosLife;
		
		for(int i = 0; i < DesignConfig.MAX_ROW_LENGTH; i++)
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
				text.append(DesignConfig.OPEN_STATUS_CHAR);
			
			if ((i == closeCharPosQuestion || i == closeCharPosLife))
			{
				text.append(DesignConfig.CLOSE_STATUS_CHAR);
			}
							
			if ( (i != lifeStartPos) && (i != questionStartPos) && (i != openCharPosQuestion) && (i != closeCharPosQuestion) && (i != openCharPosLife) && (i != closeCharPosLife) ) 
				text.append(DesignConfig.FILL_CHAR_FOR_STATUS);
		}
		answerLine = text.toString();
		text.delete(0, DesignConfig.MAX_ROW_LENGTH);
		
		return answerLine;
	}
	
	public static String createDelimiterLine(char delimiter, char boarder)
	{
		String result = "";
		for(int i = 0; i < DesignConfig.MAX_ROW_LENGTH; i++)
		{
			if( (i == 0) || (i == (DesignConfig.MAX_ROW_LENGTH - 1)) )
				text.append(boarder);
			else
				text.append(delimiter);
			
		}
		result = text.toString();
		text.delete(0, DesignConfig.MAX_ROW_LENGTH);
		return result;
	}
	
	public static void createWaitForUserLine()
	{
		Scanner scanner = new Scanner(System.in);
		
		String answerLine = createLine(DesignConfig.USER_REQUEST_ENTER, 
				DesignConfig.FILL_CHAR_FOR_REQUEST, DesignConfig.OPEN_REQUEST_CHAR, 
				DesignConfig.CLOSE_REQUEST_CHAR, DesignConfig.BORDER_CHAR_REQUEST, 
				DesignConfig.PUFFER_USER_REQUEST, true); // True, um createLine zu signaliseren, dass es sich um eine UserRequest handelt.
		System.out.print(answerLine);
		scanner.nextLine();
		System.out.println(UiDesigner.createEmptyLine());
	}

	public static String createEmptyLine() 
	{
		return DesignConfig.NEW_LINE;
	}

	public static String createInvalidInputMsg(String invalidNameMsg) 
	{
		String invalidMsgLine = createLine(invalidNameMsg, 
				DesignConfig.FILL_CHAR_FOR_INVALID_INPUTS, DesignConfig.OPEN_INVALID_INPUT_CHAR, 
				DesignConfig.CLOSE_INVALID_INPUT_CHAR, DesignConfig.BORDER_CHAR_INVALID_INPUT, 
				DesignConfig.PUFFER_INVALID_INPUT, false);
		
		return invalidMsgLine;
	}

	
	
}
