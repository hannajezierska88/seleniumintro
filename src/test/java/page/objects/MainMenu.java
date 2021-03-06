package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class MainMenu {

    private Logger logger = LogManager.getRootLogger();


    @FindBy(xpath = "//div[@id='MainImageContent']/map/area[2]")
    private WebElement fish;




    public MainMenu(){

        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }


    public FishPage selectFish(){

        WaitForElement.waitUnitElementIsVisible(fish);
        fish.click();
        logger.info("Select fish from the menu");
        return new FishPage();
    }
}
