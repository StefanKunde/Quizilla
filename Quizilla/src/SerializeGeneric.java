import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeGeneric<T> 
{
	private String fileName;
	private T serializeData;

	public SerializeGeneric(String fileName, T serData) 
	{
		super();
		this.fileName = fileName;
		this.serializeData = serData;
	}

	public String getFileName() 
	{
		return fileName;
	}

	public void setFileName(String fileName) {
		
		this.fileName = fileName;
	}

	public T getSerData() 
	{
		return serializeData;
	}

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