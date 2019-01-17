package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(linkText = "FI-SW-01")
    private WebElement angelFish;




    public FishPage(){

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void selectAngelFish(){

        angelFish.click();
        logger.info("Select AngelFish");
    }
}
