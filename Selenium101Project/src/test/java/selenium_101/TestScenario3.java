package selenium_101;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class TestScenario3 {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName ("Windows 10");
		browserOptions.setBrowserVersion ("119.0");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "saijahnavithummala");
		ltOptions.put("accesskey", "d9wR3G0utBwPB4Xqgmj75OlWJFICMZIQkmHv78UMT0v6TjEzRL");
		ltOptions.put ("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("network", true);
		ltOptions.put("project", "Selenium-101");
		ltOptions.put("name", "TestScenario3");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);

		browserOptions.setCapability ("LT:Options", ltOptions);
	
		WebDriver driver = new RemoteWebDriver (new URL("https://hub.lambdatest.com/wd/hub"), browserOptions); 
		driver.manage().window().maximize();
		
		// Step 1
		driver.get("https://www.lambdatest.com/selenium-playground"); 
		driver.findElement(By.linkText("Input Form Submit")).click();

		// step 2
		driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[6]/button")).click();

		// step 3
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		Js.executeScript ("window.scrollBy (0,450)");
		WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"seleniumform\"]/div[6]/button"));
		submitButton.click();
		//Assert "Please fill out this field."
		String errorMessage = driver.findElement(By.name("name")).getAttribute("validationMessage"); 
		System.out.println(errorMessage);
		Thread.sleep(3000);
		Assert.assertEquals(errorMessage, "Please fill out this field.");

		// step 4
		driver.findElement(By.id("name")).sendKeys("Jahnavi");
		Thread.sleep(3000);
		driver.findElement(By.id("inputEmail4")).sendKeys("saiJahnavi@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("inputPassword4")).sendKeys("123456789");
		Thread.sleep(3000);
		driver.findElement(By.id("company")).sendKeys("Virtusa");
		Thread.sleep (3000);
		driver.findElement(By.id("websitename")).sendKeys("https://www.virtusa.com/%22"); 
		Thread.sleep(3000);

		//step 5
		Select countryDropDown = new Select(driver.findElement(By.name ("country"))); 
		countryDropDown.selectByVisibleText("United States");
		Thread.sleep(3000);
		driver.findElement(By.id("inputCity")).sendKeys("Nandyal");
		Thread.sleep(3000);
		driver.findElement(By.id("inputAddress1")).sendKeys("Rythunagaram");
		Thread.sleep (3000);
		driver.findElement(By.id("inputAddress2")).sendKeys ("Koilakuntla");
		Thread.sleep(3000);
		driver.findElement(By.id("inputState")).sendKeys("Andhra Pradesh");
		Thread.sleep(3000);
		driver.findElement(By.name ("zip")).sendKeys("518501");
		Thread.sleep(3000);

		// step 6
		driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/form/div[6]/button")).click(); 
		Thread.sleep (3000);

		// step 7
		WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div/div/p")); 
		if (successMessage.getText().equals("Thanks for contacting us, we will get back to you shortly.")) { 
			System.out.println("Validation Passed: Success message displayed.");
		}
		else {
			System.out.println("Validation Failed: Success message not displayed.");
		}
		driver.close();
	}
}
