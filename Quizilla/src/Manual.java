import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class Manual 
{
	File manualFile;
	ArrayList<String> lines;
	String manual;
	// Konstruktor.
	public Manual()
	{
		manualFile = new File( DesignConfig._FILE_MANUAL );
		lines = null;
		manual = "";
	}
	
	// Methoden.
	public void show()
	{
		System.out.println("Anleitung...");
	}
	
	// Formatiert die übergebene Anleitung als Textdatei und speichert diese zeilenweise in die Liste lines.
	public void formatManual()
	{
		if( manualFile.exists() )
		{
			// Lese den Inhalt der manualFile zeilenweise aus und schreibe den kompletten Text in einen String.
			BufferedReader in = new BufferedReader(new FileReader(manualFile.getPath()));
			String line = "";
			while((line = in.readLine()) != null)
			{
				manual += line;
			}
		}
		else
		{
			System.out.println("Folgende Datei konnte nicht gefunden werden: " + DesignConfig._FILE_MANUAL);
		}
	}
	
	
	// GETTER manual.
	public ArrayList<String> getManualAsList()
	{
		return lines;
	}
	
	// Formatiert die Anleitung je nach Congigeinstellungen im gewünschten Format.
	public void format()
	{
		
		// Fügt der Liste lines eine Zeile mit einer gültigen Länge hinzu.
		lines.add( getLineUntilLastWordToMaxLength(Config._MAX_LINE_TEXT_LENGTH) )
	}
	
	private int[] getStartAndEndPosOfNextValidLine()
	{
		
		return null;
	}
	
	// Liefert einen String bis zum letzt enmöglichen Wort einer Maximallänge zurück.
	private String getLineUntilLastWordToMaxLength(int maxLineLength)
	{
		int posLastWordEnd;
		return "";
	}
	
}
