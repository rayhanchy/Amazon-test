package amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Amazonlogincheck {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\rhcho\\eclipse-workspace\\Amazontesting\\driver\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.co.uk/");
		
		driver.findElementByXPath("//span[text()='Hello, Sign in']").click();
		driver.findElementById("ap_email").sendKeys("rhchowdhury73@gmail.com");
		driver.findElementById("continue").click();
		
	 
		String errmsge = driver.findElementByXPath("//h4[text()='There was a problem']").getText();
	 System.out.println(errmsge);
	 
	 Assert.assertEquals(errmsge, "There was a problem");
		Thread.sleep(1000);
		
		
		
		
	String title = driver.getTitle();
	System.out.println(title);
		if (title.contains("Amazon")) {
			System.out.println("title matched");
			
		} else {

			System.out.println("title not matched");
		}
		
		//driver.findElementById("ap_password").sendKeys("afdfsdf");
		//driver.findElementById("signInSubmit").click();

	}

}
