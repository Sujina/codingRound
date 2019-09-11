import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import CommonFunctions.GenericMethods; //import and extends


public class BookingTest extends GenericMethods{
	WebDriver driver ;//val set on before methd,so that value present for after and test methods
	
	@Before
	public void setUp() throws Exception {
			setDriverPath(); //extends
			driver = openApplication();
			
	}

	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}

	@Test
	public void flightBooking() {
		FlightBooking  flightBooking = new FlightBooking(driver);
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
