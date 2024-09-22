package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ConfigDataReader;
import utils.ElementActions;
import utils.TestBase;

import static utils.ConfigDataReader.*;

public class Schedule_Demo_Page {

    WebDriver driver;
    ElementActions perform;

    public static Logger log = LogManager.getLogger(Schedule_Demo_Page.class);

    @FindBy(id = "FirstName")
    WebElement firstNamePlaceholderElement;

    @FindBy(id = "LastName")
    WebElement lastNamePlaceholderElement;

    @FindBy(id = "Email")
    WebElement emailPlaceholderElement;

    @FindBy(id = "Company")
    WebElement companyNamePlaceholderElement;

    @FindBy(id = "Phone")
    WebElement phonePlaceholderElement;

    @FindBy(id = "Unit_Count__c")
    WebElement unitCountDropDownElement;

    @FindBy(id = "Title")
    WebElement jobTitlePlaceholderElement;

    @FindBy(id = "demoRequest")
    WebElement iAmDropDownElement;

    public Schedule_Demo_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        perform = new ElementActions(driver);
    }

    public void fillScheduleDemoForm(){
        //Validate Schedule Demo form is correctly opened or not
        validateScheduleDemoPage();

        //Enter First Name
        perform.enterText(firstNamePlaceholderElement, FirstName);
        log.info("Entered First Name: "+FirstName);
        //Enter Last Name
        perform.enterText(lastNamePlaceholderElement,LastName);
        log.info("Entered Last Name: "+LastName);
        //Enter Email
        perform.enterText(emailPlaceholderElement,Email);
        log.info("Entered Email: "+Email);
        //Enter Company Name
        perform.enterText(companyNamePlaceholderElement,CompanyName);
        log.info("Entered Company Name: "+CompanyName);
        //Enter Phone Number
        perform.enterText(phonePlaceholderElement,PhoneNumber);
        log.info("Entered Phone Number: "+PhoneNumber);
        //Select unit count option from dropdown
        perform.selectOptionFromDropdown(unitCountDropDownElement,UnitCount);
        log.info("Selected Unit count from dropdown: "+UnitCount);
        //Enter Job Title
        perform.enterText(jobTitlePlaceholderElement,JobTitle);
        log.info("Entered Job Title: "+JobTitle);
        //Select I am option from dropdown
        perform.selectOptionFromDropdown(iAmDropDownElement,IAm);
        log.info("Selected I am from dropdown: "+IAm);
        //Not submitting form as per instruction in mail
    }

    public void switchToMainWindow(){
        perform.switchBackToMainWindow();
    }

    public void validateScheduleDemoPage(){
        String expectedTitle = "Entrata | Property Management the Way It Should Be";
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            log.info("Schedule demo form opened successfully");
        }else{
            Assert.fail("Failed to open Schedule demo form page");
        }
    }
}
