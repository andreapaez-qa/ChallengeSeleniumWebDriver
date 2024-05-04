package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "div.container div.row div.col-sm-9.padding-right div.features_items div.col-sm-4:nth-child(14) div.product-image-wrapper div.single-products > div.productinfo.text-center") // This a product in the middle of the page
    private WebElement scrollArea;

    @FindBy(xpath = "(//a[contains(text(),'View Product')])") 
    private WebElement viewProductButton;

    public HomePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    }
    public void scrollToProductSection() {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView(true);", scrollArea); 
    }

    public ProductPage clickOnViewProduct() {
    	wait.until(ExpectedConditions.elementToBeClickable(viewProductButton));
        viewProductButton.click();
        return new ProductPage(driver);
    }
}
