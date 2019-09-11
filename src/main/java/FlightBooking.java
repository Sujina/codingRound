
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import CommonFunctions.GenericMethods; 
import java.util.List;

public class FlightBooking extends GenericMethods {
	WebDriver driver;
	
	public FlightBooking(WebDriver driver) { 
		this.driver=driver;
	}
   
    public void testThatResultsAppearForAOneWayJourney(){

     waitFor(2000);
     driver.findElement(By.id("OneWay")).click();
        driver.findElement(By.id("FromTag")).clear(); 
        driver.findElement(By.id("FromTag")).sendKeys("Bangalore");
        //wait for the auto complete options to appear for the origin

        waitFor(2000);
        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        originOptions.get(0).click();
        waitFor(2000);
        driver.findElement(By.id("ToTag")).clear();
        driver.findElement(By.id("ToTag")).sendKeys("Delhi");

        //wait for the auto complete options to appear for the destination

        waitFor(2000);
        //select the first item from the destination auto complete list
        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        destinationOptions.get(0).click();

        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();

        //all fields filled in. Now click on search
        driver.findElement(By.id("SearchBtn")).click();

        waitFor(5000);
        //verify that result appears for the provided journey search
        WebElement searchSummary=driver.findElement(By.className("searchSummary"));
        Assert.assertTrue(isElementPresent(searchSummary));

        

    }
    



   
}
