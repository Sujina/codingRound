
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import CommonFunctions.GenericMethods;

public class HotelBooking extends GenericMethods{

	WebDriver driver;
   
    public HotelBooking(WebDriver driver) {
		this.driver=driver;
	}


	public void shouldBeAbleToSearchForHotels() {
    	 waitFor(2000);
    	 driver.findElement(By.linkText("Hotels")).click();
    	 driver.findElement(By.id("Tags")).sendKeys("Indiranagar, Bangalore");
    	 WebElement travellerSelection= driver.findElement(By.id("travellersOnhome"));
        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        driver.findElement(By.id("SearchHotelsButton")).click();

      

    }

   

}
