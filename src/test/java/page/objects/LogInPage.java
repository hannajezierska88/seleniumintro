package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LogInPage {


    private Logger logger = LogManager.getRootLogger();


    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private  WebElement passField;

    @FindBy (name = "signon")
    private  WebElement logIn;

    @FindBy(css ="#Content ul[class='messages'] li" )
    private WebElement msgLabel;



    public LogInPage(){

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public  LogInPage typeIntoUsername(String username){
        WaitForElement.waitUnitElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        logger.info("Enter  username");
        return this;
    }

    public LogInPage typeInPassword(String password){
        passField.clear();
        passField.sendKeys(password);
        logger.info("Enter Password");
        return this;

    }

    public FooterPage  clickLogIn(){

        logIn.click();
        logger.info("Log in to the portal");
        return new FooterPage();

    }

    public String checkWarningMsg(){

        WaitForElement.waitUnitElementIsVisible(msgLabel);
        String warningText = msgLabel.getText();
        logger.info("Returned warning message was:{}", warningText);
        return warningText;

    }


}
