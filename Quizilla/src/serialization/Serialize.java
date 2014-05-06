package serialization;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

//! Diese Klasse repräsentiert ein Serialization-Object, welches übergebene serialisierte Objekte serialisiert..
/*
 * Durch das Generic <T> muss der Typ des zu serialisiernden Objekts beim Aufruf angegeben werden. 
 * 
 * @author Stefan Kunde
 * @date 01.05.2014
 * @version 1.0
 * 
 */
public class Serialize<T> 
{
	// Variablen.
	private String fileName;
	private T serializeData;

	// Konstruktor.
	public Serialize(String fileName, T serData) 
	{
		this.fileName = fileName;
		this.serializeData = serData;
	}

	// Methoden.
	
	// GETTER fileName.
	public String getFileName() 
	{
		return fileName;
	}

	// SETTER fileName.
	public void setFileName(String fileName) {
		
		this.fileName = fileName;
	}
	
	// GETTER serData
	public T getSerData() 
	{
		return serializeData;
	}

	// SETTER serData
	public void setSerData(T serData) 
	{
		this.serializeData = serData;
	}

	//! Serialisiert ein Objekt.
	/*! Das zu Serialisierende Objekt wird speichert die Datei unter dem Namen von fileName dieser Klasse. 
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
    */
	public void serialize() 
	{
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try 
		{
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(serializeData);
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}