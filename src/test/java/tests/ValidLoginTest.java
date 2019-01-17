package tests;

import org.testng.annotations.Test;
import page.objects.FooterPage;
import page.objects.LandingPage;
import page.objects.LogInPage;
import page.objects.TopMenuPage;

import static org.testng.Assert.assertTrue;

public class ValidLoginTest extends TestBase {


    @Test
        public void asUserLogInCorrectCredentials(){

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
