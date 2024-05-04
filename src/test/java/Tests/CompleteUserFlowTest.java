package Tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.time.Instant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.AccountCreatedPage;
import Pages.AccountDetailsPage;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.ContactUsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PaymentPage;
import Pages.ProductPage;
import Pages.SignUpPage;


public class CompleteUserFlowTest {
    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private SignUpPage signUpPage;
    private AccountCreatedPage accountCreatedPage;
    private LoginPage loginPage;
    private ContactUsPage contactUsPage;

    @BeforeClass
    public void setUp() {
        // Setup WebDriver
        System.setProperty("webdriver.chrome.driver", "../clothingStoreWebAutomation/drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("../clothingStoreWebAutomation/extensions/AdBlock.crx")); 
        // Configuraciones adicionales de Chrome
        options.addArguments("--start-maximized"); // Inicia el navegador maximizado
        options.addArguments("--ignore-certificate-errors"); // Ignora los errores de certificado
        options.addArguments("--disable-popup-blocking"); // Deshabilita el bloqueo de pop-ups
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        
        // Initialize page objects
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        signUpPage = new SignUpPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        loginPage = new LoginPage(driver);
        contactUsPage = new ContactUsPage(driver);
    }
    
    private String generateUniqueEmail() {
        return "user" + Instant.now().toEpochMilli() + "@example.com";
    }

    @Test
    public void testCompleteUserFlow() throws InterruptedException {
    	
    	// Generate a unique email address at the beginning of the test
        String uniqueEmail = generateUniqueEmail();
        
        homePage.scrollToProductSection();
        productPage = homePage.clickOnViewProduct();
        productPage.enterQuantity("30");
        productPage.addToCart();  
        cartPage.viewCart();      
        cartPage.proceedToCheckout(); 
        signUpPage.signUp("Andrea", uniqueEmail);
        AccountDetailsPage accountDetailsPage = new AccountDetailsPage(driver);
        accountDetailsPage.fillAccountDetails("password123", "Andrea", "Paez", "1234 Elm St", "New York", "New York", "10001", "1234567890");
        accountDetailsPage.submitAccountDetails();
        String confirmationMessage = accountCreatedPage.getAccountCreatedMessageText();
        assertEquals(confirmationMessage, "ACCOUNT CREATED!", "Account creation message is not correct");
        accountCreatedPage.clickContinue();  
        cartPage.clickOnMenuCart();
        cartPage.proceedToCheckout(); 
        checkoutPage.addComment("This is a test order.");
        checkoutPage.placeOrder();
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.fillCreditCardInformation("1234567890123456", "Andrea", "123", "12", "2025");
        accountCreatedPage.clickContinue();
        loginPage.logout();
        loginPage.navigateLoginPage();
        loginPage.login(uniqueEmail, "password123");
        contactUsPage.navigateToContactUsPage();
        contactUsPage.submitContactForm(uniqueEmail);
        contactUsPage.acceptPopup();
        loginPage.logout();
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
