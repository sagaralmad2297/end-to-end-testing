package pageObject;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;

public class Landingpage {
	
	 public WebDriver driver;
	By signin=By.xpath("//span[contains(text(),'Login')]");
	  By title=By.xpath("//h2[contains(text(),'Featured Courses')]");
	
	public Landingpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement Login()
	{
		return driver.findElement(signin);
	}
	
	public WebElement gettitle()
	{
		return driver.findElement(title);
	}


}
