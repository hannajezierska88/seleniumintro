package tests;

import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LogInPage;
import page.objects.TopMenuPage;

import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTests extends TestBase{


    @Test
    public void asUserLogInIncorrectCredentials(){

        LandingPage landingPage = new LandingPage();
        landingPage.clickOnStoreLink()
                .clickOnSignIn()
                .typeIntoUsername("NotExisting")
                .typeInPassword("NotExisting")
                .clickLogIn();
        LogInPage logInPage = new LogInPage();
        String warningMsg = logInPage.checkWarningMsg();

        assertEquals(warningMsg, "Invalid username or password. Signon failed.");

    }


}
