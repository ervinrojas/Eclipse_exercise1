package Pages;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.packagefactory.Base.Setup;

public class WindowsPage extends Setup {

	public WindowsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String Arr2;
	
	By search = By.id("search");
	By linksearch = By.xpath("//*[@id=\"cli_shellHeaderSearchInput\"]");
	By searchBtnlocator = By.xpath("//*[@id=\"search\"]");
	
	public void searchPage() throws FileNotFoundException {
		click(search);
		if(isDisplayed(linksearch)) {
			Arr2 = readJson();
			type(Arr2,linksearch);
			click(searchBtnlocator);
			System.out.println("Search Xbox page OK");
		}else {
			System.out.println("Windows Page was not found");
		}
	}
	
}
