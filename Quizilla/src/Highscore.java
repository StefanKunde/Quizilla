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
public class Highscore extends ArrayList<Score> implements Serializable
{
	private static final long serialVersionUID = -8405218090412486870L;
	
	
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
		System.out.println(UiDesigner.createEmptyLine());
		System.out.println(UiDesigner.createHighscoreList(this));
		UiDesigner.createWaitForUserLine();
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
