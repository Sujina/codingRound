package CommonFunctions;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.jna.Platform;


public class GenericMethods {
	WebDriver driver ;
	protected void waitFor(int durationInMilliSeconds) { 
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
	}

	protected boolean isElementPresent(WebElement element) {
		try {
			 
			if(element.isDisplayed())
			return true;
			 else return false;
			 
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void setDriverPath() {
		
		if (Platform.isMac()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
		}
		if (Platform.isWindows()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		}
		if (Platform.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}

		}

	public WebDriver openApplication() throws InterruptedException { 
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		return driver;
	}
}
