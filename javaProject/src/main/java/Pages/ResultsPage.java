package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.packagefactory.Base.Setup;

public class ResultsPage extends Setup {

	private WebDriver driver;
	int totalElements = 0;
	public ResultsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By aplicaciones = By.xpath("//a[@aria-label='Refine by Aplicaciones']/span");
	By secondpage = By.xpath("//ul[@class='m-pagination']/li[3]/a");
	By thirdpage = By.xpath("//ul[@class='m-pagination']/li[4]/a");
	
	public void CountApps() {
		WaitHelper(driver,aplicaciones,20);
		click(aplicaciones);
		totalElements = countElements();
		System.out.println("Total elements are: "+totalElements);
	}
	
	public void CountSndPage() {
		WaitHelper(driver,secondpage,20);
		click(secondpage);
		totalElements += countElements();
		System.out.println("Total elements are: "+totalElements);
	}
	
	public void CountThdPage() {
		WaitHelper(driver,thirdpage,20);
		click(thirdpage);
		totalElements += countElements();
		System.out.println("Total elements are: "+totalElements);
		
	}
	
	
}
	


