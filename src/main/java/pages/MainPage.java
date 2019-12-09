package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;
    @FindBy(xpath = "//input[@id='user[login]']")
    private WebElement userNameField;
    @FindBy(xpath = "//input[@id='user[email]']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='user[password]']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@class='btn-mktg btn-primary-mktg btn-large-mktg f4 btn-block my-3']")
    private WebElement signUpFormBtn;
    @FindBy(xpath = "//input[@id='user[login]']/ancestor::dd/following-sibling::dd/div/div")
    private WebElement userNameError;
    @FindBy(xpath = "//input[@id='user[email]']/ancestor::dd/following-sibling::dd")
    private WebElement emailError;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignUpPage clickSignUpFormBtn() {
        signUpFormBtn.click();
        return new SignUpPage(driver);
    }

    public MainPage setUserName(String value) {
        userNameField.clear();
        userNameField.sendKeys(value);
        return this;
    }

    public MainPage setPassword(String value) {
        userNameField.clear();
        passwordField.sendKeys(value);
        return this;
    }

    public MainPage setEmail(String value) {
        emailField.clear();
        emailField.sendKeys(value);
        return this;
    }

    public SignUpPage registerUser(String name, String email, String password) {
        this.setUserName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.clickSignUpFormBtn();
        return new SignUpPage(driver);
    }

    private void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForUsernameError() {
        waitForElement(userNameError);
    }

    public void waitForEmailError() {
        waitForElement(emailError);
    }

    public String getUsernameErrorText() {
        return userNameError.getText();
    }

    public String getEmailErrorText() {
        return emailError.getText();
    }
}
