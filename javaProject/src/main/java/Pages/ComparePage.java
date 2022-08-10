package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.packagefactory.Base.Setup;

public class ComparePage extends Setup{

	private WebDriver driver;
	
	public ComparePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By games = By.xpath("//a[@aria-label='Refine by Juegos']");
	By callofduty = By.xpath("//div[@data-id='9xbl7svv7x33']");
	By firstprice = By.xpath("//div[@data-id='9xbl7svv7x33']/a/div[2]/div/div/span");
	By closeregister = By.xpath("//div[@class='c-dialog f-flow']/div[3]/div[1]");
	By secondprice = By.xpath("//div[@id='productPrice']/div/div/div/span[1]");
	By threedots = By.id("ButtonPanel_buttonPanel_OverflowMenuTrigger");
	By addtocart = By.id("buttonPanel_AddToCartButton");
	
	
	public void PriceGame() throws InterruptedException {
		//WaitHelper(driver,games,20);
		Thread.sleep(2000);
		click(games);
		WaitHelper(driver,firstprice,10);
		String frtprice = getText(firstprice);
		System.out.println("Price: "+frtprice);
		WaitHelper(driver,callofduty,10);
		click(callofduty);
		WaitHelper(driver,closeregister,10);
		ClosePopup(closeregister);
		WaitHelper(driver,secondprice,10);
		String sndprice = getText(secondprice);
		System.out.println("Price: "+sndprice);
		if(frtprice.equals(sndprice)) {
			System.out.println("Results Matched "+frtprice+" = "+sndprice);
		}else {
			System.out.println("Results did not Match");
		}
		WaitHelper(driver,threedots,10);
		click(threedots);
		WaitHelper(driver,addtocart,10);
		click(addtocart);
		
		
	}
}
