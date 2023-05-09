package Newmavenprj.Endtoend;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Newmavenprj.Endtoend.Base;
import pageObject.Landingpage;
import pageObject.Loginpage;

public class validationtitle extends Base {
	public WebDriver driver;
	
	public static Logger log=LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void intialize() throws IOException
	{
		driver=intializeDriver();
		log.info("driver is intialized");
		
	}

	@Test
	public void basepageNavigation() throws IOException
	{
		driver.get(prop.getProperty("url"));
		log.info("navigated to home page");

				Landingpage l=new Landingpage(driver);
		String actual = l.gettitle().getText();
		Assert.assertEquals(actual, "FEATURED COOURSE123");
		log.info("successfuly valitated");
		
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}


}
