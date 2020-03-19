package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleHomepageTest {

	WebDriver driver;
	@BeforeMethod
	public void setBrowser(){
		System.setProperty("webdriver.chrome.driver", "E:\\Jarfiles\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Start the application");
	}
	
	@Test(priority=1)
	public void checkURL(){
		String acturl=driver.getCurrentUrl();
		String expurl="www.google.com";
		Assert.assertEquals(acturl, expurl); 
		System.out.println("URL verified");
	}
	
	@Test(priority=2)
	public void checkLogo(){
		WebElement logo=driver.findElement(By.xpath("//img[@id='hplogo']"));
		boolean islogoDisplayed=logo.isDisplayed();
		Assert.assertTrue(islogoDisplayed);
		System.out.println("logo status: "+islogoDisplayed);
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser(){
		driver.close();
	}
}
