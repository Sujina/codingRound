import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import CommonFunctions.GenericMethods;

public class BookingTest extends GenericMethods {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		setDriverPath();
		driver = openApplication();

	}

	@After
	public void tearDown() throws Exception {

		driver.quit();
	}

	@Test
	public void flightBooking() {
		FlightBooking flightBooking = new FlightBooking(driver);
		flightBooking.testThatResultsAppearForAOneWayJourney();

	}

		@Test
	public void hotelBooking() {
		HotelBooking hotelBooking = new HotelBooking(driver);
		hotelBooking.shouldBeAbleToSearchForHotels();

	}

	@Test
	public void login() {
		SignIn login = new SignIn(driver);
		login.shouldThrowAnErrorIfSignInDetailsAreMissing();

	}

}
