package pomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
    
    @FindBy (xpath = "//input[@id='first-name']")
    private WebElement firstName;
    
    @FindBy (xpath = "//input[@id='last-name']")
    private WebElement lastName ;
    
    @FindBy (xpath = "//input[@id='postal-code']")
    private WebElement postalCode ;
    
    @FindBy (xpath = "//input[@id='continue']")
    private WebElement continueTab ;
    

	@FindBy(xpath = "//button[@id='finish']")
	private WebElement finishTab;
	
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	private WebElement openMenu ;
    

	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	private WebElement logOut;
    
    public CartPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    public void sendToFirstName() {
    	firstName.sendKeys("abc");
    }
    
    public void sendToLastName() {
    	lastName.sendKeys("xyz");
    }
    
    public void sendToPostalCode() {
    	postalCode.sendKeys("1234");
    	
    }
    
    public void clickOnContinueTab() {
    	continueTab.click();
    }
    
    public void clickOnFinishTab() {
    	finishTab.click();
    }
    
    public void clickOnOpenMenu() {
    	openMenu.click();
    }
    
    public void clickOnLogOut() {
    	logOut.click();	
    

}
}