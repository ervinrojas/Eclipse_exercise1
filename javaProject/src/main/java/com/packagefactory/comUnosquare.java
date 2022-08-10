package com.packagefactory;
import Pages.LandingPage;
import Pages.WindowsPage;
import dev.failsafe.internal.util.Assert;
import Pages.BuyPage;
import Pages.ResultsPage;
import Pages.ComparePage;
import Pages.GamePage;
import DataProvider.DataUtil;

import org.testng.annotations.Test;

import DataProvider.DataUtil;

import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;


public class comUnosquare 
{
	private WebDriver driver;
	LandingPage landingpage;
	WindowsPage windowspage;
	BuyPage buypage;
	ResultsPage resultspage;
	ComparePage comparepage;
	GamePage gamepage;
	DataUtil datautil;
	
	By closewindow = By.xpath("//*[@id=\"R1MarketRedirect-close\"]");
	By search = By.id("search");
	By aplicaciones = By.xpath("//a[@aria-label='Refine by Aplicaciones']/span");
	By secondpage = By.xpath("//*[@id=\"coreui-productplacementlist-1g76zxk\"]/div[3]/ul/li[3]/a");
	By thirdpage = By.xpath("//*[@id=\"coreui-productplacementlist-1g76zxk\"]/div[3]/ul/li[4]/a");
	By games = By.xpath("//*[@id=\"refine-by-menu-title-Categorías\"]/div/ul/li[3]/a");
	By takeoff = By.xpath("//div[@id='store-cart-root']/div/div/div/section[1]/div/div/div/div[1]/div/div[2]/div[2]/div/button[1]");
	By windows = By.id("shellmenu_2");
	
	@BeforeClass
	public void beforeClass() throws Exception	{
		
		landingpage = new LandingPage(driver);
		driver = landingpage.CreateDriver();
		landingpage.visit("https://www.microsoft.com/es-mx");
		
		windowspage = new WindowsPage(driver);
		buypage = new BuyPage(driver);
		resultspage = new ResultsPage(driver);
		comparepage = new ComparePage(driver);
		gamepage = new GamePage(driver);
		datautil = new DataUtil(driver);
				
	}
	
	@Test
	public void Test() throws InterruptedException, FileNotFoundException	{
		WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		ewait.until(ExpectedConditions.elementToBeClickable(windows));
		landingpage.HomePage();
		ewait.until(ExpectedConditions.elementToBeClickable(search));
		windowspage.searchPage();
		ewait.until(ExpectedConditions.elementToBeClickable(closewindow));
		buypage.buypage();
		ewait.until(ExpectedConditions.elementToBeClickable(aplicaciones));
		resultspage.CountApps();
		ewait.until(ExpectedConditions.elementToBeClickable(secondpage));
		resultspage.CountSndPage();
		ewait.until(ExpectedConditions.elementToBeClickable(thirdpage));
		resultspage.CountThdPage();					
		ewait.until(ExpectedConditions.elementToBeClickable(games));
		comparepage.PriceGame();
		ewait.until(ExpectedConditions.elementToBeClickable(takeoff));
		gamepage.VerifyCart();
		
	}
	
	@After
	public void TearDown()
	{
		driver.quit();
	}
	
}
