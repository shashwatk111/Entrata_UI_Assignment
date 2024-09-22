package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ElementActions extends TestBase {

    private static Logger log = LogManager.getLogger(TestBase.class);
    WebDriver driver;
    public static Set<String> windows;
    public static String mainWindow;

    public ElementActions(WebDriver driver){
        this.driver = driver;
    }

    public void clickOn(WebElement element){
        try{
            element.click();
        }catch (NoSuchElementException e){
            log.error("Unable to find the element !! ", element);
        }
    }

    public void enterText(WebElement element, String text){
        try{
            element.sendKeys(text);
        }catch (NoSuchElementException e){
            log.error("Unable to find the element !! ", element);
        }
    }

    public String getText(WebElement element){
        String text = "";
        try{
            text = element.getText();
        }catch (NoSuchElementException e){
            log.error("Unable to find the element !! ", element);
        }
        return text;
    }

    public void scrollToElement(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void switchToNewWindow()
    {
        //Multiple window handle
        windows = driver.getWindowHandles();
        mainWindow = driver.getWindowHandle();

        Set<String> windows = driver.getWindowHandles();
        String mainWindow = driver.getWindowHandle();

        for (String childWindow:windows)
        {
            if(!(childWindow == mainWindow))
            {
                //Switch to child window
                driver.switchTo().window(childWindow);
            }
        }

    }

    public void switchBackToMainWindow(){
        driver.switchTo().window(mainWindow);
    }

    public void selectOptionFromDropdown(WebElement element,String option){
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }

    public void mouseHoverOnElement(WebElement element){
        Actions ac = new Actions(driver);
        ac.moveToElement(element);
    }

    public void waitTillElementIsVisible(int duration, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitTillElementIsClickable(int duration, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void sleep(int duration)
    {
        try{
            Thread.sleep(duration);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
