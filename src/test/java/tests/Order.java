package tests;

import org.testng.annotations.Test;
import page.objects.*;

import static org.testng.Assert.assertEquals;

public class Order extends TestBase {

    @Test
    public void angelFishOrderTest(){

        LandingPage landingPage = new LandingPage();
        MainMenu mainMenu = new MainMenu();
        FishPage fishPage = new FishPage();
        AngelfishPage angelfishPage = new AngelfishPage();
        ShoppingCart shoppingCart = new ShoppingCart();
        LogInPage logInPage = new LogInPage();


        landingPage.clickOnStoreLink();
        mainMenu.selectFish();
        fishPage.selectAngelFish();
        angelfishPage.selectSmallAngelFish();
        shoppingCart.goToCheckout();
        String warningMessage = logInPage.checkWarningMsg();
        assertEquals(warningMessage, "You must sign on before attempting to check out. Please sign on and try checking out again.");


    }
}
