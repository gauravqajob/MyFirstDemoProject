package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.*;

public class DemoTest1 
{
	public static WebDriver driver;
	@Given("^user is hitting the url \"([^\"]*)\" for login$")
	public void user_is_hitting_the_url_for_login(String arg1) throws Throwable 
	{
		System.setProperty("webdriver.gecko.driver","D:\\eclipse-workspace\\Cucumber_Selenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(arg1);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
	    
	}

	@Given("^go to the main page$")
	public void go_to_the_main_page() throws Throwable {
		//driver.findElement(By.linkText("Sign in")).click();
		//WebElement ele = driver.findElement(By.xpath("//div[@class='user_before_login blp']"));

		//Creating object of an Actions class
		//Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		//driver.action.moveToElement(ele).perform();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='user_before_login blp']")).click();
		driver.findElement(By.xpath("//a[@title='Log In']")).click();
		//Thread.sleep(1000);
	}

	@When("^doing any specific action$")
	public void doing_any_specific_action() throws Throwable {
		WebElement element=driver.findElement(By.xpath("//iframe[@id='myframe']"));
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("//form[@id='login_form']//following::input[@id='email']")).sendKeys("blog");
		Thread.sleep(2000);
        driver.findElement(By.xpath("//form[@id='login_form']//following::input[@id='pwd']")).sendKeys("@blog");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='ACCT_LOGIN_SUBMIT']")).click();
		/*driver.findElement(By.id("email")).sendKeys("blog.cucumber@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Cucumber@blog");
        driver.findElement(By.id("SubmitLogin")).click();*/
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^validate the outcome$")
	public void validate_the_outcome() throws Throwable {
		//String exp_message = "Welcome to your account. Here you can manage all of your personal information and orders.";
    	//String actual = driver.findElement(By.cssSelector(".info-account")).getText();
    	String exp_message = "Invalid User Id/EmailID or Password. Please try again.";
    	Thread.sleep(2000);
    	String actual = driver.findElement(By.xpath("//button[@id='ACCT_LOGIN_SUBMIT']//following::div[@id='error_api']")).getText();
    	System.out.println("actual value is:" + actual);
        Assert.assertEquals(exp_message, actual);
        driver.quit();
	}

	@Then("^check more outcomes$")
	public void check_more_outcomes() throws Throwable {
	    
	}
}
