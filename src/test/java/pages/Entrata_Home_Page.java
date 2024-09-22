package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementActions;

import java.util.List;

public class Entrata_Home_Page {

    WebDriver driver;

    ElementActions perform;

    public static Logger log = LogManager.getLogger(Entrata_Home_Page.class);

    @FindBy(id = "cookie-policy")
    WebElement cookiePolicyElement;

    @FindBy(id = "cookie-close")
    WebElement cookieCloseElement;

    @FindBy(xpath = "//p[contains(text(),'With AI')]")
    WebElement scrollTillDemoButtonIsVisibleElement;

    @FindBy(xpath = "//div[text()='Schedule Your Demo']")
    WebElement scheduleYourDemoButtonElement;

    @FindBy(xpath = "//div[text()='Resources']")
    WebElement resourcesDropdownElement;

    @FindBy(xpath = "//a[text()='Guides']")
    WebElement guidesElementUnderResourcesDropdown;

    public Entrata_Home_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        perform = new ElementActions(driver);
    }

    public void closeCookiePolicy(){
        //Cancel cookie policy if displayed
        if(cookiePolicyElement.isDisplayed()) {
            perform.clickOn(cookieCloseElement);
        }
    }

    public void clickOnScheduleYourDemo(){
        //Close cookie policy if displayed
        closeCookiePolicy();

        //Scroll page until "Schedule Your Demo" button is visible
        perform.scrollToElement(scrollTillDemoButtonIsVisibleElement);

        //Click on "Schedule Your Demo" button which open new window to fill the form
        perform.clickOn(scheduleYourDemoButtonElement);
        log.info("Clicked on Schedule Your Demo button");
    }

    public void switchToScheduleDemoFormWindow(){
        //Switch to new window to fill the form
        perform.switchToNewWindow();
        log.info("Switched to new window to fill the form");
    }

    public void selectGuidesFromResources(){
        //Wait till element is visible
        perform.waitTillElementIsVisible(10,resourcesDropdownElement);

        //Click on Resources
        perform.clickOn(resourcesDropdownElement);
        log.info("Clicked on Resources dropdown");

        //select Guides option from Resources dropdown
        perform.clickOn(guidesElementUnderResourcesDropdown);
        log.info("Clicked on Guide under Resources");
    }
}
