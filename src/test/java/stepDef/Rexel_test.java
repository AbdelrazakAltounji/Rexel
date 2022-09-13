package stepDef;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;



import org.openqa.selenium.Platform;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;



import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.Duration;

import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class Rexel_test {
	
private HermesMethods RexelMethods;
	
	WebDriver driver;
	WebDriver driver1;
	
	@Before
	public void SecondSD() throws MalformedURLException {
		String string = "edge";	
		
			if(string =="firefox")
			{
			 FirefoxOptions firefoxOptions = new FirefoxOptions();
			 firefoxOptions.setCapability("browserName","firefox");
			 firefoxOptions.setCapability("platform", Platform.ANY);
			 driver = new RemoteWebDriver(new URL("https://selenium.wap-test-platform-iks-086d0feb796ce72f6b820703a879a158-0000.eu-de.containers.appdomain.cloud"),firefoxOptions);
			}
		else if (string =="chrome")
			{
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setCapability("browserName","chrome");
				chromeOptions.setCapability("platform", Platform.ANY);
				driver = new RemoteWebDriver(new URL("https://selenium.wap-test-platform-iks-086d0feb796ce72f6b820703a879a158-0000.eu-de.containers.appdomain.cloud"), chromeOptions);	
			}
		else if (string == "edge")
		{
			EdgeOptions edgeoptions = new EdgeOptions();
			edgeoptions.setCapability("browserName","edge");
			edgeoptions.setCapability("platform", Platform.ANY);
			driver = new RemoteWebDriver(new URL("https://selenium.wap-test-platform-iks-086d0feb796ce72f6b820703a879a158-0000.eu-de.containers.appdomain.cloud"), edgeoptions);
			
		}
		else if (string =="local")
		{
			System.setProperty("webdriver.chrome.driver","C:\\Abdelrazak\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	}
	
	
	
	@Given("Je navigue sur le site Rexel boutique") 
	public void naviguation_site_Rexel() {
		RexelMethods = new HermesMethods();
		//WebDriver driver = RexelMethods.Naviguation_Site_Rexel();
		driver.get("https://www.rexel.fr/frx/?gclid=EAIaIQobChMI1oOx97jL-QIVyRoGAB1l5AaJEAAYASAAEgKV5PD_BwE");
		RexelMethods.setDriver(driver);
		driver1 = RexelMethods.getDriver();
		driver1.manage().window().maximize();
		
	}
	

	@And("Accept cookies")
	public void cookies() {
		EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver1);
		WebElement event = eventHandler.findElement(By.id("acceptAllConsentSummary"));
		event.click();
	}
	
	@And("appuie sur selection produits")
	public void appuyer_selection(){
		EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver1);
		//WebElement produit = driver1.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[1]/div[1]/ul/li[3]/a"));
		//produit.click();
		
		WebElement event = eventHandler.findElement(By.partialLinkText("Sélection produits"));
		JavascriptExecutor executor = (JavascriptExecutor)driver1;
		executor.executeScript("arguments[0].click();",event);
		
	}
	
	@And("choisir Chauffage electrique climatisation ventilation")
	public void appuyer_produit() {
		//WebElement produit = driver1.findElement(By.linkText("Chauffage électrique climatisation ventilation"));
		//JavascriptExecutor executor1 = (JavascriptExecutor)driver1;
		//executor1.executeScript("arguments[0].click();",produit);
		for(int i=0; i<=2;i++){
			  try{
			     driver1.findElement(By.linkText("Chauffage électrique climatisation ventilation")).click();
			     break;
			  }
			  catch(Exception e){
				  System.out.println(e.getMessage());
			  }
			}
		
		//WebDriverWait wait = new WebDriverWait(driver1,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Chauffage électrique climatisation ventilation")));
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(produit)));
		
	}
	
	@And("choisir Chauffage domestique depuis la liste")
	public void choisir_element() {
		
		EventFiringWebDriver eventHandler1 = new EventFiringWebDriver(driver1);
		for(int i=0; i<=2;i++){
			  try{
			     eventHandler1.findElement(By.linkText("Chauffage domestique")).click();
			     break;
			  }
			  catch(Exception e){
				  System.out.println(e.getMessage());
			  }
			}
		//WebElement event1 = eventHandler1.findElement(By.linkText("Chauffage domestique"));
		//JavascriptExecutor executor = (JavascriptExecutor)driver1;
		//executor.executeScript("arguments[0].click();",event1);
	
	}
	
	/*@And("choisir Chauffage domestique")
	public void choisir_chauffage() {
		EventFiringWebDriver eventHandler1 = new EventFiringWebDriver(driver1);
		WebElement event2 = eventHandler1.findElement(By.linkText("Convecteur"));
		JavascriptExecutor executor = (JavascriptExecutor)driver1;
		executor.executeScript("arguments[0].click();",event2);
	}*/
	
	@And("choisir Radiateur connecte pour rajouter dans le panier")
	public void choisir_radiateur() {
		EventFiringWebDriver eventHandler2 = new EventFiringWebDriver(driver1);
		WebElement event3 = driver1.findElement(By.id("btnAddToCart_71294080"));
		JavascriptExecutor executor = (JavascriptExecutor)driver1;
		executor.executeScript("arguments[0].click();",event3);
		//Actions actions = new Actions(driver1);
		//actions.moveToElement(event3).click().build().perform();
		
	}
	
	@And("voir mon panier")
	public void panier() {
		EventFiringWebDriver eventHandler2 = new EventFiringWebDriver(driver1);
		WebElement event4 = driver1.findElement(By.id("my-cart-dropdown"));
		JavascriptExecutor executor = (JavascriptExecutor)driver1;
		executor.executeScript("arguments[0].click();",event4);
		
	}
	
}
