package cz.cvut.fel.ts1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignUpLoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='login-box-email']")
    WebElement inputLoginEmail;

    @FindBy(xpath = "//*[@id='login-box-pw']")
    WebElement inputLoginPass;

    @FindBy(xpath = "//*[@id='login-box']/div/div[3]/button")
    WebElement btnLogIn;

    @FindBy(xpath = "//*[@id='login-box']/div/a")
    WebElement linkForgotPass;

    @FindBy(xpath = "//*[@id='login-box']/div/div[4]/a")
    WebElement linkLogInUsingCorporateAccount;

    @FindBy(xpath = "//*[@id='athens-shibboleth-link']")
    WebElement linkToAccessViaInstitution;

    @FindBy(xpath = "//*[@id='problems-logging-in-link']")
    WebElement linkToSupportAboutLogInProblem;

    @FindBy(xpath = "//*[@id='first-name']")
    WebElement inputNewFirstName;

    @FindBy(xpath = "//*[@id='last-name']")
    WebElement inputNewLastName;

    @FindBy(xpath = "//*[@id='email-address']")
    WebElement inputNewEmailAddress;

    @FindBy(xpath = "//*[@id='password']")
    WebElement inputNewPassword;

    @FindBy(xpath = "//*[@id='password-confirm']")
    WebElement inputPasswordConfirmation;

    @FindBy(xpath = "//*[@id='registration-form']/div[2]/button")
    WebElement btnCreateAccount;

    public SignUpLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
