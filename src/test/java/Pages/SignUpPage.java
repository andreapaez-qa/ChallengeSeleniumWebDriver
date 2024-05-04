package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    @FindBy(xpath = "(//u[normalize-space()='Register / Login'])[1]")
    private WebElement registerLoginLink;

    @FindBy(css = "input[placeholder='Name']")
    private WebElement nameField;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement emailField;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signUpButton;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void navigateToSignUp() {
        registerLoginLink.click(); 
    }

    public void signUp(String name, String email) {
        navigateToSignUp(); 
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        signUpButton.click();
    }
}
