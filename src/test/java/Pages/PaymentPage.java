package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    @FindBy(css = "input[name='card_number']")
    private WebElement creditCardInput;

    @FindBy(css = "input[name='name_on_card']")
    private WebElement nameOnCardInput;

    @FindBy(css = "input[name='cvc']")
    private WebElement cvcInput;

    @FindBy(css = "input[name='expiry_month']")
    private WebElement expiryMonthInput;

    @FindBy(css = "input[name='expiry_year']")
    private WebElement expiryYearInput;

    @FindBy(id = "submit")
    private WebElement payAndConfirmButton;
    

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillCreditCardInformation(String cardNumber, String nameOnCard, String cvc, String expiryMonth, String expiryYear) {
        creditCardInput.sendKeys(cardNumber);  
        nameOnCardInput.sendKeys(nameOnCard);  
        cvcInput.sendKeys(cvc); 
        expiryMonthInput.sendKeys(expiryMonth);
        expiryYearInput.sendKeys(expiryYear);

        payAndConfirmButton.click();  
    }
}

