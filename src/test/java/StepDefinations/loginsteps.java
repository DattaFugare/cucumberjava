package StepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class loginsteps {

	WebDriver driver=null;
	@Given("user on login page")
	public void user_on_login_page() {
	    System.out.println("at when");
	    
	    String key="webdriver.chrome.driver";
	    String value=System.getProperty("user.dir");
	    
	    System.setProperty(key, value+"/Drivers/chromedriver.exe");
	    
	     driver =new ChromeDriver();
	    
	    driver.manage().window().maximize();
	    driver.navigate().to("https://demo.nopcommerce.com/login");
	}

	@When("user enter valid username and password")
	public void user_enter_valid_username_and_password() {
	    System.out.println("at when");
	    driver.findElement(By.cssSelector(".email")).sendKeys("dattatrayfugare18@gmail.com");
	    driver.findElement(By.cssSelector(".password")).sendKeys("Datta123sujay");
	}

	@And("click on sign button")
	public void click_on_sign_button() {
	    System.out.println("at when");
	    driver.findElement(By.cssSelector("button[class='button-1 login-button']")).click();
	}

	@Then("user should be login sccessfully")
	public void user_should_be_login_sccessfully() {
	    System.out.println("at when");
	   driver.findElement(By.cssSelector(".ico-logout")).isDisplayed();



}
}