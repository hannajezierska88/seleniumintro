package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class FooterPage {

    private Logger logger = LogManager.getRootLogger();


    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerOnFooter;

    public FooterPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean isBannerDisplayed(){
        WaitForElement.waitUnitElementIsVisible(bannerOnFooter);
        boolean isDisplayed = bannerOnFooter.isDisplayed();
        logger.info("Returned status of banner after login:{}", isDisplayed);
        return isDisplayed;
    }

}
