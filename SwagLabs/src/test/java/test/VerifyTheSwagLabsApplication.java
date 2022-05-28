package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browserSetting.Pojo;
import pomPack.CartPage;
import pomPack.HomePage;

import pomPack.LoginPage;




public class VerifyTheSwagLabsApplication extends Pojo {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browser) {
		if(browser.equals("ChromeBrowser"))
		{
			driver = openChromeBrowser();
		}
		if(browser.equals("FirefoxBrowser")) {
			driver = openFirefoxBrowser();
		}
		
		 driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}
	
	
	@BeforeClass
	public void launchBrowser() {
		loginPage = new LoginPage(driver);
		 homePage = new HomePage(driver);
		 cartPage = new CartPage(driver);
	}
	
	@BeforeMethod
	public void loginToApplication() throws InterruptedException {
	    driver.get("https://www.saucedemo.com/");
		 Thread.sleep(2000);

		
	    loginPage.sendToUsername();
	    loginPage.sendToPassword();
	    loginPage.clickOnLogIn();
	    
	   
	   
	
	}
	
	@Test
	public void verifyAddToCartTab() throws InterruptedException {
	    Thread.sleep(2000);

		 homePage.clickOnAddToCartBag();
		 Thread.sleep(2000);
		 homePage.clickOnAddToCartTshirt();
		 homePage.clickOnCartsymbol();
		
		    Thread.sleep(2000);
		    
		 
		 
		String url = driver.getCurrentUrl();
	    System.out.println(url);
	    
	   
       
	    
	    SoftAssert s =new SoftAssert();
	   
	    s.assertEquals(url, "https://www.saucedemo.com/cart.html");

	   // s.assertAll();
	    
	    homePage.clickOnCheckoutTab();
		Thread.sleep(2000);
		
		
		    s.assertEquals(url, "https://www.saucedemo.com/checkout-step-one.html");

		cartPage.sendToFirstName();
		
//		WebElement firstName;
//		String value = firstName.getAttribute("first-name");
//		boolean result = value.equals("First Name");
//		if(result == true) {
//	    	System.out.println("pass");
//	    }
//	    else {
//	    	System.out.println("fail");
//	    }
		
		cartPage.sendToLastName();
	    cartPage.sendToPostalCode();
	    cartPage.clickOnContinueTab();
	    Thread.sleep(2000);
        s.assertEquals(url, "https://www.saucedemo.com/checkout-step-two.html");

	    cartPage.clickOnFinishTab();
	    Thread.sleep(3000);

	    s.assertEquals(url, "https://www.saucedemo.com/checkout-complete.html");

	   
}
	
	
	
	
	
	    
	    
	    
	@AfterMethod
	public void logOutFromApplication() throws InterruptedException {
//		 homePage.clickOnCheckoutTab();
//		Thread.sleep(2000);
//		
//		 cartPage = new CartPage(driver);
//		 
//		cartPage.sendToFirstName();
//	    cartPage.sendToLastName();
//	    cartPage.sendToPostalCode();
//	    cartPage.clickOnContinueTab();
//	    Thread.sleep(2000);
//	    
//	    cartPage.clickOnFinishTab();
//	    Thread.sleep(3000);

	    cartPage.clickOnOpenMenu();
		cartPage.clickOnLogOut();
		
		
	}
	
	@AfterClass
	public void clearPOMObject() {
		loginPage =null;
		homePage = null;
		cartPage = null;
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver = null;
		System.gc();  //garbage collector
	}

	
	

}
