package Selenium.MavenFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.LandingPage;
import pageobject.ProductCatalogue;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LandingPage mainPage= new LandingPage(driver);
		mainPage.goTo();
		mainPage.loginApplication("dmaurya@gmail.com", "F121@Dusr");
		
		ProductCatalogue proCat = new ProductCatalogue(driver);
		List<WebElement> products= proCat.getProductList();
		proCat.addProductToCart(productName);
		proCat.goToCartPage();
		
		
			
		
		
				
		
	
		List <WebElement> cartProducts= driver.findElements(By.cssSelector(".cartSection h3"));
	Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	//Assert.asserttrue(match);
	System.out.println(match);
	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	Actions a = new Actions(driver);
	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	Thread.sleep(2000);
//	//.ta-item:nth-of-type(1)
	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	driver.findElement(By.cssSelector(".action__submit")).click();
	String confirm = driver.findElement(By.cssSelector(".hero-primary")).getText();
	System.out.println(confirm);
	//ta-item:nth-of-type(1)
	
	
	
	
	}

}
