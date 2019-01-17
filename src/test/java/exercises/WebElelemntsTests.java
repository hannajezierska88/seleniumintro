package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class WebElelemntsTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
      //  driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }


    @Test
    public void typingIntoWebElementTest(){

        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("Selenium Start");

        String typeUserNameValue = userNameField.getAttribute("value");
        sleep();
        assertEquals(typeUserNameValue, "Selenium Start");
    }



    @Test
    public void fileUploadTest(){
        WebElement uploadFilePicker = driver.findElement(By.id("upload_file"));
        uploadFilePicker.sendKeys("C:\\test.jpg");
        sleep();
    }

    private void sleep(){
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void typingAndClearingValueTest() {
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("Selenium Start");

        String typeUserNameValue = userNameField.getAttribute("value");
        sleep();
        assertEquals(typeUserNameValue, "Selenium Start");
        userNameField.clear();
        sleep();
        String emptyUserNameField = userNameField.getAttribute("value");
        assertEquals(emptyUserNameField, "");
    }

    @Test
    public void checkRadioButtonTest(){

        WebElement maleButton = driver.findElement(By.cssSelector("input[value='male']"));
        WebElement femaleButton = driver.findElement(By.cssSelector("input[value='female']"));

        maleButton.click();
        sleep();
        assertTrue(maleButton.isSelected());
        femaleButton.click();
        assertTrue(femaleButton.isSelected());
        sleep();
        assertFalse(maleButton.isSelected());
    }


    @Test
    public void checkBoxTest(){

        WebElement pizzaButton = driver.findElement(By.cssSelector("input[value='pizza']"));
        WebElement spaghettiButton = driver.findElement(By.cssSelector("input[value='spaghetti']"));
        WebElement hamburgerButton = driver.findElement(By.cssSelector("input[value='hamburger']"));

        assertFalse(pizzaButton.isSelected());
        assertFalse(spaghettiButton.isSelected());
        assertFalse(hamburgerButton.isSelected());

        pizzaButton.click();
        spaghettiButton.click();
        hamburgerButton.click();

        sleep();
        assertTrue(pizzaButton.isSelected());
        assertTrue(spaghettiButton.isSelected());
        assertTrue(hamburgerButton.isSelected());

        pizzaButton.click();
        spaghettiButton.click();
        hamburgerButton.click();

        sleep();
        assertFalse(pizzaButton.isSelected());
        assertFalse(spaghettiButton.isSelected());
        assertFalse(hamburgerButton.isSelected());

    }



    @Test
    public void dropDownListTest(){

        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);
        List<WebElement> options = countryDropDown.getOptions();
        List<String>namesofOptions = new ArrayList<String>();

        for(WebElement option : options){
            namesofOptions.add(option.getText());
            System.out.println(option.getText());
        }

        List<String>expectedNamesDropDown = new ArrayList<String>();
        expectedNamesDropDown.add("Germany");
        expectedNamesDropDown.add("Poland");
        expectedNamesDropDown.add("UK");

        assertEquals(namesofOptions, expectedNamesDropDown);


    }


    @Test
    public void selectingOptionsFromDropDownTest(){
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);

        sleep();

        countryDropDown.selectByIndex(1);

        sleep();

        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Poland");

        countryDropDown.selectByValue("de_DE");

        sleep();

        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Germany");

        countryDropDown.selectByVisibleText("UK");

        sleep();

        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "UK");

    }

    @Test
    public void checkIfElementsOnPageTest(){
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement emailLabel = driver.findElement(By.cssSelector("span[class='help-block']"));

        System.out.println("Is usernameField displayed: "+ usernameField.isDisplayed());
        System.out.println("Is usernameField is enabled: "+usernameField.isEnabled());

        System.out.println("Is passwordField displayed : "+ passwordField.isDisplayed());
        System.out.println("Is passwordField enabled: "+ passwordField.isEnabled());

        System.out.println("Is emailLabel displaed: " +emailLabel.isDisplayed());
        System.out.println("Is emailLabel enabled: " + emailLabel.isEnabled());

        assertTrue(usernameField.isDisplayed());
        assertTrue(passwordField.isDisplayed());
        assertTrue(emailLabel.isDisplayed());

        assertTrue(usernameField.isEnabled());
        assertFalse(passwordField.isEnabled());


    }

    @Test
    public void actionsSmileyTest(){

        driver.navigate().to("http://przyklady.javastart.pl/test/hover_mouse.html");
        WebElement smileyIcon = driver.findElement(By.id("smiley"));
        WebElement smileyIcon2 = driver.findElement(By.id("smiley2"));

        Actions action = new Actions(driver);
        action.moveToElement(smileyIcon).moveToElement(smileyIcon2).build().perform();
        sleep();

    }


    @Test
    public void checkBoxesTest(){
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/checkboxes");
        WebElement checkbox = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));

        assertFalse(checkbox.isSelected());
        assertTrue(checkbox1.isSelected());
        checkbox.click();
        sleep();
        checkbox1.click();

        sleep();

        assertTrue(checkbox.isSelected());
        assertFalse(checkbox1.isSelected());
    }


    @Test
    public void dropdownTest(){

        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dropdown");

        WebElement dropDownWebElement = driver.findElement(By.id("dropdown"));
        Select dropDownList = new Select(dropDownWebElement);
      //  List<WebElement> options = dropDownList.getOptions();
       // List<String>namesOfList = new ArrayList<String>();
        assertEquals(dropDownList.getFirstSelectedOption().getText(), "Please select an option");

        dropDownList.selectByValue("1");
        sleep();
        assertEquals(dropDownList.getFirstSelectedOption().getText(),"Option 1");

        dropDownList.selectByValue("2");
        sleep();
        assertEquals(dropDownList.getFirstSelectedOption().getText(), "Option 2");

/*
WebElement dropdownWebElement = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownWebElement);

        String selectedOption = select.getFirstSelectedOption().getText();
        assertEquals(selectedOption, "Please select an option");

        select.selectByValue("1");
        selectedOption = select.getFirstSelectedOption().getText();

        assertEquals(selectedOption, "Option 1");

        select.selectByValue("2");
        selectedOption = select.getFirstSelectedOption().getText();

        assertEquals(selectedOption, "Option 2");
 */


    }



    @Test
    public void uploadTest(){
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");

        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        fileUpload.sendKeys("C:\\test.jpg");
        sleep();
        WebElement submit = driver.findElement(By.id("file-submit"));
        submit.click();

        WebElement text = driver.findElement(By.id("uploaded-files"));
        assertTrue(text.isDisplayed());
        //assertEquals(text.getText(), "test.jpg");

    }


    @Test
    public void hoverTest(){

        driver.navigate().to("http://theinternet.przyklady.javastart.pl/hovers");

        WebElement image = driver.findElement(By.xpath("//div[@id='content']/div/div[1]"));
        WebElement image1 = driver.findElement(By.xpath("//div[@id='content']/div/div[2]"));
        WebElement image2 = driver.findElement(By.xpath("//div[@id='content']/div/div[3]"));


        Actions actions = new Actions(driver);
        actions.moveToElement(image).perform();


        WebElement firstText = driver.findElement(By.xpath("//div/div[1]/h5"));
        WebElement secondText = driver.findElement(By.xpath("//div[2]/div/h5"));
        WebElement thirdText = driver.findElement(By.xpath("//div[3]/div/h5"));

        assertTrue(firstText.isDisplayed());
        assertEquals(firstText.getText(), "name: user1");
        assertFalse(secondText.isDisplayed());
        assertEquals(secondText.getText(), "");
        assertFalse(thirdText.isDisplayed());
        assertEquals(thirdText.getText(), "");


        actions.moveToElement(image1).perform();

        assertFalse(firstText.isDisplayed());
        assertEquals(firstText.getText(), "");
        assertTrue(secondText.isDisplayed());
        assertEquals(secondText.getText(), "name: user2");
        assertFalse(thirdText.isDisplayed());
        assertEquals(thirdText.getText(), "");


        actions.moveToElement(image2).perform();

        assertFalse(firstText.isDisplayed());
        assertEquals(firstText.getText(), "");
        assertFalse(secondText.isDisplayed());
        assertEquals(secondText.getText(), "");
        assertTrue(thirdText.isDisplayed());
        assertEquals(thirdText.getText(), "name: user3");

    }


@AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }




}
