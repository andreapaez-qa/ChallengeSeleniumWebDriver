package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    private WebDriver driver;
    
    @FindBy(css = "a[href='/contact_us']")
    private WebElement navigateToContactUsPage;

    @FindBy(css = "input[name='email']")
    private WebElement contactEmailField;

    @FindBy(css = "input[name='submit']")
    private WebElement submitMessageButton;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void navigateToContactUsPage() {
    	navigateToContactUsPage.click();
    }

    public void submitContactForm(String email) {
        contactEmailField.sendKeys(email);
        submitMessageButton.click();
    }
    
    public void acceptPopup() {
        
        Alert alert = driver.switchTo().alert(); 
        alert.accept(); 
        driver.switchTo().defaultContent(); 
    }
}
