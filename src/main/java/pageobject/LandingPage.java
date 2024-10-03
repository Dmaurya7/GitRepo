package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AsbstractComponents;

public class LandingPage extends AsbstractComponents {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//PageFactory
	
	
	@FindBy (id="userEmail") WebElement userEmail;
	@FindBy (id="userPassword") WebElement pwd;
	@FindBy (id="login") WebElement submit;
	
	
	
	
	public void loginApplication(String email, String Password)
	{
		userEmail.sendKeys(email);
		pwd.sendKeys(Password);
		submit.click();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	

}
