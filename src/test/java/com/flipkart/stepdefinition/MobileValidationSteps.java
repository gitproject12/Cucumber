package com.flipkart.stepdefinition;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileValidationSteps {
	static WebDriver driver;
	
	@Given("user launches flipkart application")
	public void user_launches_flipkart_application() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	    
	}

	@Given("user login by entering valid crendentials")
	public void user_login_by_entering_valid_crendentials() {
		WebElement close= driver.findElement(By.xpath("//button[text()='✕']"));
		 close.click();
	   
	}

	@When("user search mobile")
	public void user_search_mobile() {
		WebElement search= driver.findElement(By.xpath("//input[@type='text']"));
		 search.sendKeys("Iphone 13 ",Keys.ENTER);
	   
	}

	@When("user click on the mobile name")
	public void user_click_on_the_mobile_name() {
	try
	{
		WebElement mobile =driver.findElement(By.xpath("//div[text()='APPLE iPhone 13 (Blue, 128 GB)']"));
		mobile.click();
	}
	catch(Exception e) {
		
	}
	}

	@Then("user validate the mobile names")
	public void user_validate_the_mobile_names() {
		String parent = driver.getWindowHandle();
		Set<String> children = driver.getWindowHandles();
		for (String x : children) {
			if (!parent.equals(x)) {
				driver.switchTo().window(x);
				driver.switchTo().window(parent);
				WebElement buy = driver.findElement(By.xpath("//button[text()='BUY NOW']"));
				buy.click();
			}
				}
		
	
			
		}		
		
		
	
	}

	

}
