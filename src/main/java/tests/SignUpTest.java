package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {

    MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
    SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

    @Test
    public void registerWithEmptyUsernameAndEmail() {
        mainPage.registerUser("", "", "Pass123word456");
        String expectedError = "There were problems creating your account.";
        Assert.assertEquals(expectedError, signUpPage.getCommonErrorText());
    }
}
