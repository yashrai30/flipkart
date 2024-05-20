package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties properties;

    public ReadConfig() {
        properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("C:\\Users\\yashrai\\OneDrive - Nagarro\\Desktop\\QA exit assign\\Flipkart\\Configuration\\config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseUrl() 
    {
    	String url = properties.getProperty("baseUrl");
    	if(url!=null)
    		return url;
    	else 
    		throw new RuntimeException("no url found");
    }
    
    public String getBrowser() 
    {
    	String browser = properties.getProperty("browser");
    	if(browser!=null)
    		return browser;
    	else 
    		throw new RuntimeException("no parameter found");
    }
    
    public boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }
}
