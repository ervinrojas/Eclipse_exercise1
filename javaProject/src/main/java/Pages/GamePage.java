package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.packagefactory.Base.Setup;

public class GamePage extends Setup {

	private WebDriver driver;
	
	public GamePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By actualtext = By.xpath("//div[@class='itemMessage--2sv1QR57']");
	By takeoff = By.xpath("//div[@id='store-cart-root']/div/div/div/section[1]/div/div/div/div[1]/div/div[2]/div[2]/div/button[1]");
	By emptyCart = By.xpath("//*[@id=\"store-cart-root\"]/div/div/div/section[1]/p");
	
	public void VerifyCart() {
		WaitHelper(driver,actualtext,10);
		isDisplayed(actualtext);
		System.out.println("Find element in Cart OK");
		WaitHelper(driver,takeoff,10);
		click(takeoff);
		WaitHelper(driver,emptyCart,10);
		isDisplayed(emptyCart);
		System.out.println("Take off element in Cart OK");
	}

}
