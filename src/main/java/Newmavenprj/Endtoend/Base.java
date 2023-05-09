package Newmavenprj.Endtoend;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	WebDriver driver;
	public Properties prop;
	
	public WebDriver intializeDriver() throws IOException
	{
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\sagar\\OneDrive\\Documents\\eclipse-workspace\\Endtoend\\src\\main\\java\\resourse\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./javam/chromedriver1.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./javam/geckodriver.exe");
			driver =new FirefoxDriver();

		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
		
	}
	public void getScreenShotPath(String TestCaseName,WebDriver driver) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports"+TestCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
	}

	
}
