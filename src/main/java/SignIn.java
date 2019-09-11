
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import CommonFunctions.GenericMethods;

public class SignIn extends GenericMethods {
	WebDriver driver;
	By yourTrips = By.linkText("Your trips");
	By signIn = By.id("SignIn");
	By signInButton = By.id("signInButton");
	By errors = By.id("errors1");

	public SignIn(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Function to verify error if signIn details are missing
	 */
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		try {
			waitFor(2000);
			clickYourTrips();
			signIn();
			waitFor(4000);
			driver.switchTo().frame("modal_window");
			driver.findElement(signInButton).click();
			waitFor(1000);
			String errors1 = driver.findElement(errors).getText();
			Assert.assertTrue(errors1.contains("There were errors in your submission"));
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickYourTrips() {
		try {
			driver.findElement(yourTrips).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void signIn() {
		try {
			driver.findElement(signIn).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
