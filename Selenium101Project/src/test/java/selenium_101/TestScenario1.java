package selenium_101;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestScenario1 {
	
	public static void main(String[] args) throws MalformedURLException {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("119.0");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "saijahnavithummala");
		ltOptions.put("accesskey", "d9wR3G0utBwPB4Xqgmj75OlWJFICMZIQkmHv78UMT0v6TjEzRL");
		ltOptions.put ("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("network", true);
		ltOptions.put("project", "Selenium-101");
		ltOptions.put("name", "TestScenario1");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);

		browserOptions.setCapability("LT:Options", ltOptions);
	
		WebDriver driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions); 
		driver.manage().window().maximize();

		// step 1
		driver.get("https://www.lambdatest.com/selenium-playground");

		//step 2 
		driver.findElement(By.linkText("Simple Form Demo")).click();

		//step 3
		String url = driver.getCurrentUrl();
		System.out.println(url); 
		if (url.contains("simple-form-demo")) {
			System.out.println("Validating URL Successful");
		}
		else {
			System.out.println("Validating URL not Successful");
		}

		// step 4
		String enterMessage = "Welcome to LambdaTest";

		// step 5 & 6
		driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div[1]/div[2]/div/div[1]/input")).sendKeys(enterMessage); 
		driver.findElement(By.id("showInput")).click();

		// step 7
		String YourMessage = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText(); //*[@id="message"]
		if (YourMessage.contains("Welcome to LambdaTest")) { 
			System.out.println("Entered message is displayed");
		}
		else {
			System.out.println("Entered message is not displayed");
		}
		driver.close();
	}
}
