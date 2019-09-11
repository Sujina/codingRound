//import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import CommonFunctions.GenericMethods;

public class SignIn extends GenericMethods{
	WebDriver driver;
	   
    public SignIn(WebDriver driver) {
		this.driver=driver;
	}
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        
        waitFor(2000);

        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();
        waitFor(4000);
        driver.switchTo().frame("modal_window");
        driver.findElement(By.id("signInButton")).click(); //failed
        waitFor(1000);
        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }

 
}
