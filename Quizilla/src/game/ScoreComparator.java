package game;
import java.util.Comparator;

//! Diese Klasse repräsentiert einen Comparator, der beim Überschreiben der sort Funktion angibt, wonach sortiert werden soll.
/*  
 * Wird zum Überschreiben der sort Funktion der Klasse Highscore als Parameter verwendet.
 * 
 * @author Stefan Kunde
 * @date 01.05.2014
 * @version 1.0
 * 
 */
public class ScoreComparator implements Comparator<Score> 
{
	//! Weißt der Sortierfunktion des Comparator eigene Suchkriterien zu.
	/*!
	 * Dies geschieht mit dem Aufruf der in der Klasse Score erstellten compareTo Methode.
	 * 
	 * @author Stefan Kunde
	 * @version 1.0
	 * @date 03.05.2014,
	 * 
	 * 
	 * @return Zurückgeliefert wird, ob o1 größer o2, kleiner o2 oder gleich o2 ist.
	 * 
    */
    public int compare(Score o1, Score o2) 
    {
        return o1.compareTo(o2);
    }
}