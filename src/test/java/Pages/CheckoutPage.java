package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    @FindBy(css = "textarea[name='message']")
    private WebElement commentBox;

    @FindBy(xpath = "//a[contains(text(),'Place Order')]") 
    private WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addComment(String comment) {
        commentBox.sendKeys(comment);
    }

    public void placeOrder() {
        placeOrderButton.click();
    }
}

