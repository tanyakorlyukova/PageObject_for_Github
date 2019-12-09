package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    private WebDriver driver;
    @FindBy(xpath = "//div[@class='application-main ']//h1")
    private WebElement heading;
    @FindBy(xpath = "//input[@id='user_login']")
    private WebElement userNameField;
    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='user_password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@id='signup_button']")
    private WebElement signUpButton;
    @FindBy(xpath = "//div[@class='flash flash-error my-3']")
    private WebElement commonError;
    @FindBy(xpath = "//input[@id='user_login']/ancestor::dd/following-sibling::dd/div/div")
    private WebElement userNameError;
    @FindBy(xpath = "//input[@id='user_email']/ancestor::dd/following-sibling::dd")
    private WebElement emailError;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignUpPage typeUserName(String username) {
        userNameField.sendKeys(username);
        return this;
    }

    public SignUpPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public String getHeadingText() {
        return heading.getText();
    }

    public String getCommonErrorText() {
        return commonError.getText();
    }

    public String getUsernameErrorText() {
        return userNameError.getText();
    }

    public String getEmailErrorText() {
        return emailError.getText();
    }
}
