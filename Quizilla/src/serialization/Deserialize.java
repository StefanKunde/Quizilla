package serialization;
import game.Highscore;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

//! Diese Klasse repräsentiert ein Deserialization-Object, welches übergebene Objekte persistent machen kann.
/*
 * Durch das Generic <T> muss der Typ des zu deserialisiernden Objekts beim Aufruf angegeben werden. 
 * 
 * @author Stefan Kunde
 * @date 01.05.2014
 * @version 1.0
 * 
 */
public class Deserialize<T> 
{
	// Variablen.
	private String fileName;
	private File file;

	// Konstruktor.
	public Deserialize(String fileName) 
	{
		this.fileName = fileName;
	}
	
	// Methoden.
	
	// GETTER fileName.
	public String getFileName() 
	{
		return fileName;
	}
	
	// SETTER fileName.
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}
	
	//! Deserialisiert ein Objekt.
	/*! Die zu deserialisierende Datei entnimmt diese Methode aus dieser Klasse. 
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @return Zurückgegeben wird eine deserialisierte Instanz des des aufrufenden Types..
	 * 
    */
	public T deserialize() 
	{
		file = new File(fileName);
		T data = null;
		try 
		{
			if(file.exists())
			{
				FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);
				data = (T) ois.readObject();
				ois.close();
				fis.close();
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return data;
	}

}
