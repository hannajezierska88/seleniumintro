package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShoppingCart {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css =  "a[href$='newOrderForm=']")
    private WebElement proceedButton;


    public  ShoppingCart(){

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }


    public void goToCheckout(){

        proceedButton.click();
        logger.info("Select button Proceed to checkuot");
    }
}
