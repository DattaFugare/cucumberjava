package StepDefinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Comparator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class SearchSteps {

	WebDriver driver=null;
	List<Entry<WebElement, Integer>> list=null;
	@Given("user on search functionality")
	public void user_on_search_functionality() throws InterruptedException {
		System.out.println("at when");

		String key="webdriver.chrome.driver";
		String value=System.getProperty("user.dir");

		System.setProperty(key, value+"/Drivers/chromedriver.exe");

		driver =new ChromeDriver();

		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/login");
		Thread.sleep(3000);
	}

	@When("user search for books")
	public void user_search_for_books() {

		driver.findElement(By.cssSelector("#small-searchterms")).click();
		driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("books");
		driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]")).click();
	}

	@Then("user list out all books")
	public void user_list_out_all_books() {
		
		List<WebElement> searchresult=driver.findElements(By.cssSelector(".price.actual-price"));
		
		Map< WebElement, Integer> map = new HashMap<WebElement,Integer>();
		
		for(int i=0;i<searchresult.size();i++)
		{


			if (searchresult.get(i).getText() != "" )
			//double amount	=  Double.parseDouble(searchresult.get(i).getText().replaceAll("[^0-9.]", ""));
			{
			map.put(searchresult.get(i),  (int) Double.parseDouble(searchresult.get(i).getText().replaceAll("[^0-9.]", "")));
            System.out.println(map.isEmpty());    
			}
			}
		
		List<Entry<WebElement, Integer>> list= new ArrayList<Entry<WebElement, Integer>>(map.entrySet());
		list.sort(Entry.comparingByValue());
		
		for(Entry<WebElement, Integer> e :list)
		{
			System.out.println(e.getValue());
		}
		
		// for high price
		System.out.println(list.get(list.size()-1).getKey());
		System.out.println(list.get(list.size()-1).getKey().isEnabled());
		
		list.get(list.size()-1).getKey().click();
		String obj=list.get(list.size()-1).getKey().getTagName();
		if(obj.equals("span"))
		{
			System.out.println("done with easy");
		}
		else
		{
			System.out.println("fail");
		}
		
		// for low price
		//list.get(0).getKey().click();
	}

	@Then("select book on high prize")
	public void select_book_on_high_prize() {
		
		System.out.println("done");
	}

}
