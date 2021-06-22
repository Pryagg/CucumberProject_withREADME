package helpers;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import configuration.Configuration;
import context.TestContext;

public class Props {
	 
	 
	 private TestContext context;

	    public Props(TestContext context)
	    {
	        this.context = context;
	    }
	    
	    public String getProperty(String key)
	    {
	        String filePath = setupDataFile();

	        Properties props = new Properties();
	        try
	        {
	            props.load(new FileInputStream(filePath));
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }

	        return props.getProperty(key);
	    }

	    
	    private String setupDataFile()
	    {
	        String env = Configuration.getBranch();
	        String filePath = HelperMethods.getAbsoluteFromRelativePath("configs\\data-" + env + ".properties");

	        if (!System.getProperty("os.name").contains("Windows"))
	        {
	            filePath = filePath.replace("\\", "/");
	        }
	        return filePath;
	    }

	/*public String getShippingAttribute(String key)
	{

		String filePath = HelperMethods.getAbsoluteFromRelativePath("configs\\Shipping-Information.properties");

		Properties props = new Properties();
		try
		{
			props.load(new FileInputStream(filePath));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return props.getProperty(key);
	}*/
	
}