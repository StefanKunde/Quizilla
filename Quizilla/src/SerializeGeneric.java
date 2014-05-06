import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeGeneric<T> 
{
	// Variablen.
	private String fileName;
	private T serializeData;
	
	// Konstruktor.
	public SerializeGeneric(String fileName, T serData) 
	{
		this.fileName = fileName;
		this.serializeData = serData;
	}
	
	// GETTER fileName.
	public String getFileName() 
	{
		return fileName;
	}
	
	// SETTER fileName
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
