package CommonFunctions;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericMethods {
	WebDriver driver ;
	protected void waitFor(int durationInMilliSeconds) { // protected visiblitiy,static
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File | Settings | File Templates.
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
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		/*
		 * if (PlatformUtil.isMac()) { System.setProperty("webdriver.chrome.driver",
		 * "chromedriver"); } if (PlatformUtil.isWindows()) {
		 * System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); } if
		 * (PlatformUtil.isLinux()) { System.setProperty("webdriver.chrome.driver",
		 * "chromedriver_linux"); }
		 */
		}

	public WebDriver openApplication() throws InterruptedException { // datatpe
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		return driver;
	}
}
