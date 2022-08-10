package com.packagefactory.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import bsh.ParseException;
import io.netty.handler.codec.json.JsonObjectDecoder;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.json.simple.parser.*;

public class Setup {
	
	private WebDriver driver;
	
	
	public Setup(WebDriver driver)	{
		this.driver= driver;
	}
	
	public WebDriver CreateDriver()	{ 
	  	System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebElement findElement(By locator)	{
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator)	{
		return driver.findElements(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	  
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}	catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public int countElements() {
		List<WebElement> link = driver.findElements(By.xpath("//h3"));
		for(WebElement objCurrentLink : link) {
			String strLinkText = objCurrentLink.getText();
			System.out.println(strLinkText);
		}
		System.out.println("Total Web Elements are: "+link.size());
		return link.size();
	}
	
	public static boolean WaitHelper(WebDriver diver, By locator, int timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(diver, Duration.ofSeconds(timeOutInSeconds));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public void ClosePopup(By locator) throws InterruptedException {
		WaitHelper(driver,locator,30);
		driver.findElement(locator).click();		
	}
	
	
	public void verifyApp(By locator) {
		WaitHelper(driver,locator,20);
		//Boolean verifyText = getText(locator).equalsIgnoreCase("Contiene compras desde la aplicación");
		assertEquals("Contiene compras desde la aplicación",getText(locator));
		//assertTrue(verifyText);
	}
	
	public void verifyEmpty(By locator) {
		WaitHelper(driver,locator,20);
		Boolean verifyEmptyCart = getText(locator).equalsIgnoreCase("Tu carro está vacío.");
		assertTrue(verifyEmptyCart);
	}
	
	@DataProvider (name="dp")
	public String readJson() throws FileNotFoundException 
	{
		JSONParser jsonParser=new JSONParser();
		//FileReader reader=new FileReader("/data.json"); 
		
		JSONObject json = new JSONObject();
		
		Object obj = null;
		try {
			Object obj1 = jsonParser.parse(new FileReader(".\\Json\\data.json")); 
		    json = (JSONObject)obj1;
			//obj = jsonParser.parse(reader);
		} catch (IOException | org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		
		JSONObject search=(JSONObject) obj;
		String fileToSearch = json.get("Search").toString();
		
		return fileToSearch;
		
	//JSONArray searchArray =(JSONArray) search.get("searchfile");
		
		/*String arr[]=new String[searchArray.size()];
		
		for(int i=0;i<searchArray.size();i++)
		{
			JSONObject text=(JSONObject) search.get(i);
			String file=(String) text.get("Search");
			
			arr[i]=file;
		}
		return arr;*/		
	}
	
	 /* public void Click(WebElement element){}
	 * 
	 * 
	 * public void SendKeys(WebElement element, String vaue){}
	 * 
	 * 
	 * public WebElement FindElement(String locator, enum locatorType){
	 * 
	 * switch (locatorType)
	 *     case locatorType.Xpath:
	 *     
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * enum LocatorTye{
	 * Xpath,
	 * CSS,
	 * Tag,
	 * Id
	 * 
	 * }
	 */

}
