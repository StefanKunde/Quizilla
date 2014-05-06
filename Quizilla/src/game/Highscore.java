package game;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import serialization.Deserialize;
import design.Designer;


//! Diese Klasse repräsentiert die Highscoreliste.
/*  
 * Diese Klasse ist serialisierbar!
 * Sie ist eine Liste aus Objekten vom Typ <Score>.
 * 
 * @author Stefan Kunde
 * @date 03.05.2014
 * @version 1.0
 * 
 */
public class Highscore extends ArrayList<Score> implements Serializable
{
	// Eindeutige serial erstellen, um unnötige Problem, beim Serialisieren zu vermeiden.
	private static final long serialVersionUID = -8405218090412486870L;
	
	// Konstruktor.
	public Highscore() 
	{ 
		this.add(new Score("Stefan", 101));
	}
	
	// Methoden.
	
	//! Fügt dem Highscore ein Score-Objekt hinzu.
	/*!
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
    */
	public void addScoreToList(Score score)
	{
		this.add(score);
	}
	
	//! Ruft eine Sortierfunktion für die Highscoreliste auf, die Anhand der Ergebnisse sortiert.
	/*!
	 * Ruft die statische Collections.sort Methode mit dem Comparator ScoreComparator auf, der extra dafür erstellt wurde.
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
    */
	public void sort()
	{
		Collections.sort(this, new ScoreComparator()); 
	}

	//! Sortiert die Highscoreliste und gibt sie aus.
	/*!
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
    */
	public void show() 
	{
		sort();
		System.out.println(Designer.createEmptyLine());
		System.out.println(Designer.createHighscoreList(this));
		Designer.createWaitForUserLine();
	}

	//! Versucht ein deserialisierte Object von dieser Klasse zu laden.
	/*!
	 * Wenn das übergebene Object null ist, wird ein leeres neues Highscore Objekt zurück gegeben.
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014
	 * 
	 * @deSerializedHighscoreObject Das Deserialisierte Object.
	 * 
	 * 
	 * @return entweder das deserialisierte Highscore object oder eine neue Instanz von Highscore.
	 * 
    */
	public static Highscore create(Deserialize<Highscore> deSerializedHighscoreObject) 
	{
		Highscore tmpHighscore = null;
		if(deSerializedHighscoreObject != null)
		{
			tmpHighscore = deSerializedHighscoreObject.deserialize();
		}
		
		if(tmpHighscore == null)
		{
			tmpHighscore = new Highscore();
		}
		return tmpHighscore;
	}
	
}
