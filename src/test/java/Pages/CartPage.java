package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = "//u[contains(text(),'View Cart')]")
    private WebElement viewCartLink;

    @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
    private WebElement proceedToCheckoutButton;
    
    @FindBy(css = "a[href='/view_cart']")
    private WebElement menuCartLink;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void viewCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//u[contains(text(),'View Cart')]")));
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
        viewCartButton.click();
    }


    public CheckoutPage proceedToCheckout() {
        proceedToCheckoutButton.click(); 
        return new CheckoutPage(driver);
    }
    
    public void clickOnMenuCart() {
        menuCartLink.click();
    }
    
}
