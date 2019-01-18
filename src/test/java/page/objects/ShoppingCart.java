package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;


public class ShoppingCart {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css =  "a[href$='newOrderForm=']")
    private WebElement proceedButton;


    public  ShoppingCart(){

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }


    public CheckoutPage goToCheckout(){

        WaitForElement.waitUnitElementIsVisible(proceedButton);
        proceedButton.click();
        logger.info("Select button Proceed to checkuot");
        return new CheckoutPage();
    }
}
