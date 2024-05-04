package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;

    @FindBy(id = "quantity") 
    private WebElement quantityBox;

    @FindBy(css = "button[type='button']") 
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterQuantity(String quantity) {
        quantityBox.clear();
        quantityBox.sendKeys(quantity);
    }

    public CartPage addToCart() {
        addToCartButton.click();
        return new CartPage(driver);
    }
}

