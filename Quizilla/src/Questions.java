import java.util.ArrayList;


public class Questions extends ArrayList<Question>
{


	// Konstruktor.
	public Questions() {}

	
	// Methoden.
	public boolean hasNext()
	{
		boolean hasNext = false;
		if(this != null && this.size() > 0)
		{
			hasNext = true;
		}
		
		return hasNext;
	}
	
	
	
	
	
}
