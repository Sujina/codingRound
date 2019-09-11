
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import CommonFunctions.GenericMethods;

public class HotelBooking extends GenericMethods {

	WebDriver driver;
	By hotels = By.linkText("Hotels");
	By tags = By.id("Tags");
	By travellerSelection = By.id("travellersOnhome");
	By searchHotelsButton = By.id("SearchHotelsButton");

	public HotelBooking(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Function to search for hotels
	 */
	public void shouldBeAbleToSearchForHotels() {
		try {
			waitFor(2000);
			clickHotels();
			searchLocation("Indiranagar, Bangalore");
			travellerSelection();

			driver.findElement(By.id("SearchHotelsButton")).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickHotels() {
		try {
			driver.findElement(hotels).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void searchLocation(String location) {
		try {
			driver.findElement(tags).sendKeys(location);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void travellerSelection() {
		try {
			new Select(driver.findElement(travellerSelection)).selectByVisibleText("1 room, 2 adults");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void clickSearchHotels() {
		try {
			driver.findElement(searchHotelsButton).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
