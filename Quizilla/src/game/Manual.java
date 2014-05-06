package game;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import config.Config;
import design.Designer;

//! Diese Klasse repräsentiert die Anleitung.
/*  
 * Sie dient dazu die Anleitung in einen besser lesbaren Context zu bringen.
 * 
 * @author Stefan Kunde
 * @date 03.05.2014
 * @version 1.0
 * 
 */
public class Manual 
{
	// Varlablen.
	String text;
	File file;
	ArrayList<String> formatedLines;
	
	// Konstruktor.
	public Manual( File manualFile )
	{
		file = manualFile;
	}
	

	// Methoden.
	
	//! Gibt das Menü, formatiert, in der Konsole aus.
	/*!
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 05.05.2014
	 * 
    */
	public void show()
	{
		System.out.println(Designer.createEmptyLine());
		System.out.println(Designer.createTitle(Config._MENU_MANUAL));
		
		text = readManualFromFile( file );
		formatedLines = createFormatedLine( text );
		
		for(String formatedLine : formatedLines)
		{
			System.out.println(Designer.createManualLine(formatedLine));
		}
		
		System.out.println(Designer.createTitle(Config._MENU_MANUAL));
		System.out.println(Designer.createEmptyLine());
	}




	//! Liest den Text einer Datei aus und gibt diesen als String zurück.
	/*!
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 05.05.2014
	 * 
	 * @file Ein File-Objekt das ausgelesen werden soll.
	 * 
	 * @return Der aus der Datei ausgelesene Text als String.
	 * 
	 * 
    */
	private String readManualFromFile(File file) 
	{
		String line;
		BufferedReader br;
		StringBuilder sb = null;
		
		try {
			br = new BufferedReader( new FileReader( file.getName() ) );
			sb = new StringBuilder();
			
			while( ( line = br.readLine() ) != null)
			{
				sb.append(line);
			}
				
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return sb.toString();
	}
	
	//! Formatiert den übergebenen String, speichert jede formatierte Zeile in einer Liste und gibt diese zurück.
	/*! Trennt das letzte Wort einer Zeile ab und gibt diese zurück.
	 *  Das letzte Wort hängt davon ab, wie lang eine Zeile sein soll.
	 *  Wie lang eine Zeile sein soll, wird in der Config festgelegt.
	 *  Zweck dieser Methode ist es, eine einheitlich Ausgabe, anhand der maximalen Länge für eine Zeile, der Anleitung zu generieren.
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 05.05.2014
	 * 
	 * @ TODO: Bugt beim '.' (Satzende) noch rum.
	 * 
	 * @text Die komplette Anleitung als String.
	 * 
	 * @return Eine Liste von Strings mit den formatierten Zeilen.
	 * 
    */
	private ArrayList<String> createFormatedLine(String text) 
	{
		ArrayList<String> formatedManualList = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		String currentLine = "";
		int spacePos = -1;
		boolean foundLastPossibleWord;
		boolean lastLineAlreadyHandled = false;;
		
		while(!text.isEmpty())
		{
			foundLastPossibleWord = false;
			
			if(text.length() >= Config._MAX_MANUAL_TEXT_LENGTH_EACH_ROW - 1)
			{
				currentLine = text.substring(0, (Config._MAX_MANUAL_TEXT_LENGTH_EACH_ROW - 1) ) ; // -1, weil bei 0 angefangen wird.
			}
			else
			{
				currentLine = text.substring(0, (text.length() - 1) )  ;
				lastLineAlreadyHandled = true;
				formatedManualList.add(currentLine); // Letzte Zeile adden.
			}
			
			if(!lastLineAlreadyHandled)
			{
				for( int i = (currentLine.length() - 1); !foundLastPossibleWord; i--) // Rückwerts durchlaufen, weil bis zum letzten Wort der Zeile abgeschnitten werden soll.
				{
					if(currentLine.charAt(i) == ' ')
					{
						spacePos = i + 1; // + 1, weil von 0 bis ...
						foundLastPossibleWord = true;
					}
					
					if( (i == 0) && !foundLastPossibleWord)
					{
						spacePos = (currentLine.length());
						foundLastPossibleWord = true;
					}
				}
				currentLine = currentLine.substring(0 , (spacePos - 1)); // -1, um das Leerzeichen nicht mitzunehmen.
				text = text.substring( (currentLine.length() + 1), text.length() ); // + 1, um das Leerzeichen nicht mitzunehmen
				formatedManualList.add(currentLine);
			}
			else
			{
				text = "";
			}
		}
		
		
		return formatedManualList;
	}
}
