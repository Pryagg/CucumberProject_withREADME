package context;


import java.util.HashMap;

import managers.PageObjectManager;
import managers.TestDriver;
import configuration.Configuration;
 
public class TestContext {
	
	 private final HashMap<Object, Object> sharedData;
	 private TestDriver testDriver;
	 private PageObjectManager pageObjectManager;
	 private Configuration configuration;
 
	 public TestContext()
	 {

		 
		 sharedData = new HashMap<>();
		 testDriver = new TestDriver(this);
		 pageObjectManager = new PageObjectManager(this);
	 }
	 
	 public TestDriver getTestDriver() {
	 return testDriver;
	 }
	 
	 public PageObjectManager getPageObjectManager() {
	 return pageObjectManager;
	 }
	 
	 public Configuration getConfiguration() {
		 return configuration;
	 }
	 
	 public HashMap<Object, Object> getSharedData()
	    {
	        return sharedData;
	    }

	 public void addSharedData(Object key, Object value)
	 
	 {
	        sharedData.put(key, value);
	    }
	 
	 public Boolean isContains(Object key){
         return sharedData.containsKey(key.toString());
     }
 
}

