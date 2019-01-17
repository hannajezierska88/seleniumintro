package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LandingPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#Content a")
    private WebElement storeLink;


    public LandingPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public TopMenuPage clickOnStoreLink(){
        WaitForElement.waitUntilElementIsClickable(storeLink);
        storeLink.click();
        logger.info("Clicked on Enter Store link");
        return  new TopMenuPage();
    }
}
