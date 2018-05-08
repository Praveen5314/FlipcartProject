package OnlineShopping.Flipcart;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass {
	String mobilepBrand;
	String parentWindowId;
	Set<String> allWindowsId;
	String cartItem;
	int itemCount=0;

	@Given("^The user is on amazon search page$")
	public void the_user_is_on_amazon_search_page() {
		launchBrowser("https://www.flipkart.com/");
		try
		{
			WebElement loginSection = driver.findElement(By.xpath("/html/body/div[2]/div/div"));
			if(loginSection.isDisplayed())
			{
			WebElement loginClosebtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
			loginClosebtn.click();
			}
		}
		catch(Exception e)
		{
			
		}
		
	}

	@When("^The user search \"([^\"]*)\"$")
	public void the_user_search(String mobile) throws Throwable{
		
		//WebElement txtSearch = driver.findElement(By.name("q"));
		//searchMobile(txtSearch,mobile);
		
		WebElement showCategory=driver.findElement(By.xpath("/html/body/div[1]/div/header/div[3]/div/ul/li[1]/a"));
		WebElement mobile_element;
		Actions mouseOverAcc=new Actions(driver);
		mouseOverAcc.moveToElement(showCategory).build().perform();
		if(mobile.equalsIgnoreCase("Samsung"))
		{
			mobile_element = driver.findElement(By.xpath("/html/body/div[1]/div/header/div[3]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[2]/a"));
			mouseOverAcc.moveToElement(mobile_element).build().perform();
			mobile_element.click();
		}
		else if(mobile.equalsIgnoreCase("Lenovo"))  
				{
			mobile_element = driver.findElement(By.xpath("/html/body/div[1]/div/header/div[3]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[3]/a"));
			mouseOverAcc.moveToElement(mobile_element).build().perform();
			mobile_element.click();
				}
		else if(mobile.equalsIgnoreCase("Motorola"))  
				{
			mobile_element = driver.findElement(By.xpath("/html/body/div[1]/div/header/div[3]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[5]/a"));
			mouseOverAcc.moveToElement(mobile_element).build().perform();
			mobile_element.click();
				}
		else if(mobile.equalsIgnoreCase("Vivo"))  
				{
			mobile_element = driver.findElement(By.xpath("/html/body/div[1]/div/header/div[3]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[8]/a"));
			mouseOverAcc.moveToElement(mobile_element).build().perform();
			mobile_element.click();
				}
		
		mobilepBrand=mobile;
	}

	@When("^The user add to cart$")
	public void the_user_add_to_cart() throws InterruptedException {
		
		WebElement mobileLink = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[3]/div/div/div[1]/div[2]/div/div[1]/div/div[1]/div/div/div/a"));
		 mobileDetails(mobileLink);
		 parentWindowId=driver.getWindowHandle();
		 allWindowsId=driver.getWindowHandles();
		 if(allWindowsId.size()>1)
		 {
			 for(String currentWindow : allWindowsId)
			 {
				 if(currentWindow != parentWindowId)
					 driver.switchTo().window(currentWindow);
			 }
			 WebElement btnAddToCart = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div[1]/div/div[1]/div[2]/ul/li[1]/button"));
			 addToCart(btnAddToCart);
			 itemCount++;
			 try
			 {
				 WebElement itemInCart = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/div[1]/a"));
				 cartItem=itemInCart.getText();
			 }
			 catch(Exception e)
			 {
				 System.out.println(e);
			 }
			 
		 }
	}

	@Then("^The user verifies the mobile in cart$")
	public void the_user_verifies_the_mobile_in_cart() {
		switch(itemCount)
	      {
		 case 1:
			 Assert.assertTrue(cartItem.contains("samsung"));
		 case 2:
			 Assert.assertTrue(cartItem.contains("Apple"));
		 default:
			 Assert.assertTrue(cartItem.isEmpty());
	      }

  }
}
	
	



