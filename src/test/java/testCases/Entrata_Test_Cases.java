package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Broken_Link_Page;
import pages.Entrata_Home_Page;
import pages.Resource_Centre_Page;
import pages.Schedule_Demo_Page;
import utils.TestBase;

@Listeners(utils.Listeners.class)
public class Entrata_Test_Cases extends TestBase {

    Entrata_Home_Page entrataHomePage;
    Schedule_Demo_Page scheduleDemoPage;
    Broken_Link_Page brokenLinkPage;
    Resource_Centre_Page resourceCentrePage;

    @BeforeClass
    public void initializeDriver(){
        entrataHomePage = new Entrata_Home_Page(driver);
        scheduleDemoPage = new Schedule_Demo_Page(driver);
        brokenLinkPage = new Broken_Link_Page(driver);
        resourceCentrePage = new Resource_Centre_Page(driver);
    }

    @Test(priority = 0,description = "Validate user can schedule a demo")
    public void validate_user_can_schedule_a_demo(){
        entrataHomePage.clickOnScheduleYourDemo();
        entrataHomePage.switchToScheduleDemoFormWindow();
        scheduleDemoPage.fillScheduleDemoForm();
        scheduleDemoPage.switchToMainWindow();
    }

    @Test(priority = 1,description = "Validate particular guide is present on Entrata website")
    public void validate_particular_guide_is_present_on_Entrata_website(){
        entrataHomePage.selectGuidesFromResources();
        resourceCentrePage.clickOnGuidesTab();
        resourceCentrePage.printAllGuideName();
        resourceCentrePage.validateGuideIsPresentOnEntrataWebsite();
    }

    @Test(priority = 2,description = "Validate there are no broken links are present on the website")
    public void validate_there_are_no_broken_links_are_present_on_the_website(){
        brokenLinkPage.verifyAllLinks();
    }
}
