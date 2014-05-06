import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeGeneric<T> 
{
	// Variablen.
	private String fileName;
	
	// Konstruktor.
	public DeserializeGeneric(String fileName) 
	{
		super();
		this.fileName = fileName;
	}
	
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
	
	// Serialisiert ein Objekt von einem generischen Typ in der Datei, die im Konstruktor angegeben wird.
	public T deserialize() 
	{
		T data = null;
		try 
		{
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			data = (T) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return data;
	}

}
