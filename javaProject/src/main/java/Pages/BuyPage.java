package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.packagefactory.Base.Setup;

public class BuyPage extends Setup {

	private WebDriver driver;
	
	public BuyPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By closewindow = By.xpath("//*[@id=\"R1MarketRedirect-close\"]");
	By buy = By.xpath("//*[@id=\"coreui-pivotheader-s3sdtmy\"]/div/div/header/a[1]");
	
		
	public void buypage() {
		WaitHelper(driver,closewindow,10);		
		if(isDisplayed(closewindow)) {
			click(closewindow);
			click(buy);	
			System.out.println("Click in buy button OK");
		}else {
			System.out.println("Buy Page was not found");
		}
	}

}
