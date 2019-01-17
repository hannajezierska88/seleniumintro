package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelfishPage {

    private Logger logger = LogManager.getRootLogger();


    @FindBy(css = "a.Button[href$='EST-2']")
    private WebElement smallAngelFish;

    public AngelfishPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void selectSmallAngelFish(){

        smallAngelFish.click();
        logger.info("Select small AngelFish to the cart");

    }
}
