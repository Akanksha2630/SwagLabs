package pomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy (xpath = "//input[@placeholder='Username']")
    private WebElement userName ;
    
    @FindBy (xpath = "//input[@placeholder='Password']")
    private WebElement password;
    
    @FindBy (xpath = "//input[@type='submit']")
    private WebElement logIn ;
    
    
    public LoginPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    public void sendToUsername() {
    	userName.sendKeys("standard_user");
    }
    
    public void sendToPassword() {
    	password.sendKeys("secret_sauce");
    }
    
    public void clickOnLogIn() {
    	logIn.click();
    }
    
    
   
    }


