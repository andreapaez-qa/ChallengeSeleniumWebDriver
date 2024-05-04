package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountDetailsPage {
    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement submitButton;

    public AccountDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillAccountDetails(String password, String firstName, String lastName, String address, String state, String city, String zipcode, String mobileNumber) {
        passwordInput.sendKeys(password);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        addressInput.sendKeys(address);
        
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText("United States");
        
        stateInput.sendKeys(state);
        cityInput.sendKeys(city);
        zipcodeInput.sendKeys(zipcode);
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public void submitAccountDetails() {
        submitButton.click();
    }
}
