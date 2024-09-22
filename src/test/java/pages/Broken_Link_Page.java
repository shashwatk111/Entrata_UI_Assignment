package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementActions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Broken_Link_Page {

    WebDriver driver;
    ElementActions perform;
    public static Logger log = LogManager.getLogger(Broken_Link_Page.class);

    @FindBy(tagName = "a")
    List<WebElement> allLinks;

    public Broken_Link_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        perform = new ElementActions(driver);
    }

    public void verifyAllLinks(){

        // Fetch all the links from the page
        List<WebElement> links = allLinks;
        log.info("Total links found on webpage: "+links.size());

        // Iterate each link and verify its status
        for (WebElement link:links) {
            String url = link.getAttribute("href");

            if(url != null && !url.isEmpty()){
                verifyLink(url);
            }else {
                log.info("Empty or null href found for element: " + link.getText());
            }
        }
    }

    public void verifyLink(String link){
        try {
            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("HEAD");
            //httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.connect();

            int responseCode = httpURLConnection.getResponseCode();
            if(responseCode >= 400){
                log.info(url+" link is broken and response code is "+responseCode);
            }else {
                log.info(url+" link is valid and response code is "+responseCode);
            }
        }catch (Exception e){
            System.out.println("Exception occurred while verifying link: " + link + " - " + e.getMessage());
        }

    }

}
