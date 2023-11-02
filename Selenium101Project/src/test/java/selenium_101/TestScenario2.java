package selenium_101;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestScenario2 {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException {
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
		ltOptions.put("name", "TestScenario2");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);

		browserOptions.setCapability ("LT:Options", ltOptions);
	
		WebDriver driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		// step 1
		driver.get("https://www.lambdatest.com/selenium-playground");
		
		// step 2
		// Default value 15
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement progressBarsSlidersLink  = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Drag & Drop Sliders")));
		progressBarsSlidersLink.click();
		WebElement slider = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='15']"))); 
		Actions actions = new Actions(driver);
		actions.clickAndHold (slider).moveByOffset (216, 0).release().perform();
		WebElement rangeValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//output[contains(@Id, 'rangeSuccess')]")));
		String actualValue = rangeValue.getText();
		if (actualValue.equals("95")) {
				System.out.println("Test Passed: Range value is 95.");
		} 
	    else {
		System.out.println("Test Failed: Expected 95, but got " +actualValue);
	    }
		driver.quit();
	}
}
