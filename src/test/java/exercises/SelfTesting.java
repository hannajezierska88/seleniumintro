package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class SelfTesting {


    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test

    public void repeatTest(){

        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/actions/Account.action?newAccountForm=");

        WebElement userID = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement pass = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement repPass = driver.findElement(By.cssSelector("input[name='repeatedPassword']"));

        assertTrue(userID.isEnabled());
        assertTrue(pass.isEnabled());
        assertTrue(repPass.isEnabled());

        userID.sendKeys("hanna");
        pass.sendKeys("password123");
        repPass.sendKeys("password123");

        WebElement langList = driver.findElement(By.cssSelector("select[name='account.languagePreference']"));
        Select langPref = new Select(langList);
        assertEquals(langPref.getFirstSelectedOption().getText(), "english");

        langPref.selectByValue("japanese");
        sleep();

        WebElement catList = driver.findElement(By.cssSelector("select[name='account.favouriteCategoryId']"));
        Select favCategory = new Select(catList);
        assertEquals(favCategory.getFirstSelectedOption().getText(), "FISH");

        favCategory.selectByValue("CATS");
        sleep();

        WebElement myList = driver.findElement(By.cssSelector("input[name='account.listOption']"));
        WebElement myBanner = driver.findElement(By.cssSelector("input[name='account.bannerOption']"));

        assertFalse(myList.isSelected());
        assertFalse(myBanner.isSelected());


        myList.click();
        myBanner.click();

        sleep();

        assertTrue(myBanner.isSelected());
        assertTrue(myList.isSelected());


    }


    @Test
    public void waitForDisappearingElement(){

        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");

        WebElement aCheckbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        assertTrue(aCheckbox.isDisplayed());
        assertFalse(aCheckbox.isSelected());

        WebElement buttonRemove = driver.findElement(By.id("btn"));

        buttonRemove.click();
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.invisibilityOf(aCheckbox));

        WebElement msg = driver.findElement(By.id("message"));
        assertEquals(msg.getText(), "It's gone!");
        //WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        //webDriverWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("p[id='message']")), "It's gone!"));
    }

    @Test
    public void waitForPresenceOfElement(){

        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
        WebElement checkBox = driver.findElement(By.id("checkbox"));
        assertTrue(checkBox.isDisplayed());
        assertFalse(checkBox.isSelected());

        WebElement btnRemove = driver.findElement(By.id("btn"));
        btnRemove.click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkBox));

        WebElement msg = driver.findElement(By.id("message"));
        assertEquals(msg.getText(), "It's gone!");

        btnRemove.click();
        WebDriverWait webDriverWait1 = new WebDriverWait(driver, 10);
        webDriverWait1.until(ExpectedConditions.presenceOfElementLocated(By.id("checkbox")));
        WebElement checkBoxReturn= driver.findElement(By.id("checkbox"));
        assertTrue(checkBoxReturn.isDisplayed());
        assertFalse(checkBoxReturn.isSelected());
    }

    @Test
    public void fluentWaitTest(){

        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/1");

        WebElement textHello = driver.findElement(By.id("finish"));
        assertFalse(textHello.isDisplayed());

        WebElement btnStart = driver.findElement(By.cssSelector("#start>button"));
        btnStart.click();

        FluentWait<WebDriver> fluentWait = new FluentWait(driver);
        fluentWait.withTimeout(Duration.ofSeconds(10));
        fluentWait.pollingEvery(Duration.ofMillis(250));
        fluentWait.ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(textHello));

        assertTrue(textHello.isDisplayed());


    }




    private void sleep(){
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
