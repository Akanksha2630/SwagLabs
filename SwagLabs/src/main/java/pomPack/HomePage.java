package pomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy (xpath = "//button[@name='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartBag ;
	
	@FindBy (xpath = "//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement addToCartTshirt ;
    
    @FindBy (xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartSymbol ;
    
    @FindBy (xpath = "//button[@id='checkout']")
    private WebElement checkoutTab  ;
    
    public HomePage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    public void clickOnAddToCartBag() {
    	addToCartBag.click();
    }
    public void clickOnAddToCartTshirt() {
    	addToCartTshirt.click();
    }
    public void clickOnCartsymbol() {
    	cartSymbol.click();
    }
    public void clickOnCheckoutTab() {
    	checkoutTab.click();
    }

}
