package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementActions;

import java.util.List;

import static utils.ConfigDataReader.getConfigValue;

public class Resource_Centre_Page {

    WebDriver driver;

    ElementActions perform;

    public static Logger log = LogManager.getLogger(Entrata_Home_Page.class);

    @FindBy(id = "guide")
    WebElement guidesElement;

    @FindBy(xpath = "//div[@data-w-tab='Guides']//div[@class='collection-list-wrapper w-dyn-list']/div/div[@role='listitem']/descendant::h2")
    List<WebElement> guideList;

    public Resource_Centre_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        perform = new ElementActions(driver);
    }
    public void clickOnGuidesTab(){
        //Move to Guide tab
        perform.clickOn(guidesElement);
        log.info("Moved to Guide tab");
    }

    public void printAllGuideName(){
        int noOfGuides = guideList.size();
        log.info("Total no of Guides present: "+noOfGuides);
        //Print list of guides present on Entrata.com
        for (WebElement guide:guideList) {
            log.info(guide.getText());
        }
    }

    public void validateGuideIsPresentOnEntrataWebsite(){
        String expectedGuideName = getConfigValue("guideName");
        String actualGuideName = "";
        try{
            //Iterate through guide name
            for (WebElement guide:guideList) {
                actualGuideName = guide.getText();
                //Validate if expected guide is present in list of Entrata
                if(expectedGuideName.equalsIgnoreCase(actualGuideName)){
                    log.info(expectedGuideName+" is present in guide list of Entrata");
                }
            }}catch (Exception e){
            log.error("Sorry "+expectedGuideName+"is present in guide list of Entrata");
        }
    }
}
