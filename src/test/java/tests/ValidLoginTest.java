package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.FooterPage;
import page.objects.LandingPage;
import page.objects.LogInPage;
import page.objects.TopMenuPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class ValidLoginTest extends TestBase {


    @Test
        public void asUserLogInCorrectCredentials(){

        DriverUtils.navigateToPage(LOGIN_URL);
        LandingPage landingPage = new LandingPage();
        boolean isBannerDsiaplyed = landingPage
                .clickOnStoreLink()
                .clickOnSignIn()
                .typeIntoUsername("j2ee")
                .typeInPassword("j2ee")
                .clickLogIn()
                .isBannerDisplayed();


        assertTrue(isBannerDsiaplyed);


    }

}
