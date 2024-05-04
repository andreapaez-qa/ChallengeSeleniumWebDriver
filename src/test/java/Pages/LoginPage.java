package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(css = "input[data-qa='login-email']")
    private WebElement emailField;

    @FindBy(css = "input[placeholder='Password']")
    private WebElement passwordField;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;
    
    @FindBy(css = "a[href='/logout']")
    private WebElement logoutButton;
    
    @FindBy(css = "a[href='/login']")
    private WebElement navigateLoginPage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }
    
    public void navigateLoginPage() {
    	navigateLoginPage.click();
    }
    
    public void logout() {
        logoutButton.click();
    }
}
