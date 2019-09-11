
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import CommonFunctions.GenericMethods;
import java.util.List;

public class FlightBooking extends GenericMethods {
	WebDriver driver = null;
	By oneWay = By.id("OneWay");
	By fromTag = By.id("FromTag");
	By fromOption = By.xpath("//*[@id='ui-id-1']");
	By toTag = By.id("ToTag");
	By toOption = By.xpath("//*[@id='ui-id-2']");
	By datePicker = By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a");
	By searchBtn = By.id("SearchBtn");
	By searchSummary = By.className("searchSummary");

	public FlightBooking(WebDriver driver) {

		this.driver = driver;

	}

	/*
	 * Function to test results displayed for one way journey
	 */
	public void testThatResultsAppearForAOneWayJourney() {// parameter, change to static for src/test
		try {
			waitFor(2000);
			clickOneWay();
			selectSourceCity("Bangalore");
			waitFor(2000);
			selectDestinationCity("Delhi");
			waitFor(2000);
			driver.findElement(datePicker).click();
			// all fields filled in. Now click on search
			clickSearch();
			waitFor(5000);
			// verify that result appears for the provided journey search
			WebElement searchSummary = driver.findElement(By.className("searchSummary"));
			Assert.assertTrue(isElementPresent(searchSummary));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickOneWay() {
		try {
			driver.findElement(oneWay).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectSourceCity(String origin) {
		try {
		driver.findElement(fromTag).clear();
		driver.findElement(fromTag).sendKeys(origin);

		// wait for the auto complete options to appear for the origin
		List<WebElement> originOptions = driver.findElement(fromOption).findElements(By.tagName("li"));
		originOptions.get(0).click();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectDestinationCity(String origin) {
		try {

			driver.findElement(toTag).clear();
			driver.findElement(toTag).sendKeys(origin);

			// wait for the auto complete options to appear for the destination
			waitFor(2000);
			// select the first item from the destination auto complete list
			List<WebElement> destinationOptions = driver.findElement(toOption).findElements(By.tagName("li"));
			destinationOptions.get(0).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickSearch() {
		try {

			driver.findElement(searchBtn).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickDatePicker() {
		try {
	
		driver.findElement(datePicker).click();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
