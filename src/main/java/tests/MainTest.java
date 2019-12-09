package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;

public class MainTest extends BaseTest {

    MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

    @Test
    public void enterIncorrectUsername() {
        mainPage.setUserName("*&^&%^%*");
        mainPage.sleep();
        mainPage.waitForUsernameError();
        String expectedUsernameError = "Username may only contain alphanumeric characters or single hyphens, and cannot begin or end with a hyphen.";
        Assert.assertEquals(expectedUsernameError, mainPage.getUsernameErrorText());
    }

    @Test
    public void enterUnavailableUsername() {
        String unavailableUsername = "Username";
        mainPage.setUserName(unavailableUsername);
        mainPage.sleep();
        mainPage.waitForUsernameError();
        String expectedUsernameError = "Username '" + unavailableUsername + "' is unavailable.";
        Assert.assertEquals(expectedUsernameError, mainPage.getUsernameErrorText());
    }

    @Test
    public void enterInvalidEmail() {
        mainPage.setEmail("invalid@email@com");
        mainPage.waitForEmailError();
        String expectedEmailError = "Email is invalid or already taken";
        Assert.assertEquals(expectedEmailError, mainPage.getEmailErrorText());
    }
}
