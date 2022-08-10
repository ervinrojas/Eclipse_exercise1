package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.packagefactory.Base.Setup;

public class LandingPage extends Setup {
	
	By windows = By.id("shellmenu_2");
	By linkWindows = By.xpath("//*[@id=\"shellmenu_2\"]");
	
	public LandingPage(WebDriver driver) {
		super(driver);
	}
	
	public void HomePage(){
		if(isDisplayed(linkWindows)) {
			click(windows);
			System.out.println("Click on Windows OK");
		}else {
			System.out.println("Home Page was not found");
		}
	}

}
