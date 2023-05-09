package Newmavenprj.Endtoend;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Newmavenprj.Endtoend.Base;
import package2.beta;
import pageObject.Landingpage;
import pageObject.Loginpage;

public class Homepage extends Base  {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void intialize() throws IOException
	{
		driver=intializeDriver();
		log.info("driver is intialized");
		
	}
	@Test(dataProvider="getdata")
	public void basepageNavigation(String username,String password,String text) throws IOException
	{
		driver.get(prop.getProperty("url"));
		log.info("navigated to home page");
		Landingpage l=new Landingpage(driver);
		l.Login().click();
		log.info("navigated to login page");
		Loginpage l2=new Loginpage(driver);
		l2.getemail().sendKeys(username);
		l2.getpassword().sendKeys(password);
		log.info(text);
		l2.getlogin().click();
		
		
	}
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data=new Object[2][3];
		data[0][0]="good";
		data[0][1]="143";
		data[0][2]="test";
		
		data[1][0]="sagar@almad";
		data[1][1]="0202";
		data[1][2]="hi";
		
		return data;
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

}
