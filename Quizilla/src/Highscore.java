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


// @TODO Se- und Deserilisation
public class Highscore<T> extends ArrayList<Score> implements Serializable
{
	private static final long serialVersionUID = -8405218090412486870L;
	private final int MAX_PLAYER_ON_LIST = 10;
	
	
	
	
	public Highscore()
	{
	}
	
	public void addScoreToList(Score score)
	{
		this.add(score);
	}
	
	public void sort()
	{
		Collections.sort(this, new ScoreComparator());
	}

	public void show() 
	{
		sort();
		
		System.out.println("#############[HIGHSCORE]##############");
		System.out.println("-----" + "Platz" + "-----" + "Name" + "-----" + "Ergebnis" + "-----");
		for(int i = 0; i < MAX_PLAYER_ON_LIST; i++)
		{
			if( i < this.size() )
			{
				System.out.println("-----" + (i+1) + ".   " + "-----" + this.get(i).getPlayerName() + "-----" + this.get(i).getResult() + "%" + "-----");		     
			}
			else
			{
				System.out.println("-----" + (i+1) + ".----" + "LEER" + "-----" + "LEER" + "-----");
			}
		}
		System.out.println("#############[HIGHSCORE]##############");
		
	}

	public static Highscore create(DeserializeGeneric<Highscore> deser_gen, String fILE_NAME_HIGHSCORE) 
	{
		Highscore tmpHighscore = null;
		File fileHighscore = new File(fILE_NAME_HIGHSCORE);
		if(fileHighscore.exists())
		{
			tmpHighscore = deser_gen.deserialize();
		}
		else
		{
			tmpHighscore = new Highscore();
		}
		return tmpHighscore;
	}
	
	
	
	
}
