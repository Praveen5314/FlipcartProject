package com.flipcart.functionality;

import java.util.List;

import org.apache.bcel.generic.GETSTATIC;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import OnlineShopping.Flipcart.BaseClass;

public class FlipcartFunctionality extends BaseClass {
	public static void navMenuSubCategories(String category, String subCategory) throws InterruptedException
	{
		
		String categoryLocator="//span[text()='$']";
		String actualMenuCategory=categoryLocator.replace("$", category);
		Thread.sleep(3000);
		WebElement mainCategory=driver.findElement(By.xpath(actualMenuCategory));
		Actions mouseOverAcc=new Actions(driver);
		mouseOverAcc.moveToElement(mainCategory).build().perform();
		Thread.sleep(3000);
		String actualSubCategory=categoryLocator.replace("$", subCategory);
		WebElement subCategory_element = driver.findElement(By.xpath(actualSubCategory));
		mouseOverAcc.moveToElement(subCategory_element).build().perform();
		subCategory_element.click();
	}
	
	public static void main(String[] args) throws InterruptedException {
		/*launchBrowser("https://www.flipkart.com/");
		Actions action1=new Actions(driver);
		action1.sendKeys(Keys.ESCAPE).build().perform();
		navMenuSubCategories("Men", "Casual Shoes");*/
		//navToNextPage("2");
		navForYahooSearch("2");
	}
	public static void navToNextPage(String pageNumber) throws InterruptedException
	{
		launchBrowser("https://www.google.com/");
		WebElement txtSearch = driver.findElement(By.id("lst-ib"));
		txtSearch.sendKeys("Selenium", Keys.ENTER);
		WebElement parentElement=driver.findElement(By.id("nav"));
		List<WebElement> tableRows = parentElement.findElements(By.tagName("td"));
		int requiredPageIndex=0;
		Thread.sleep(3000);
		for(int i=0;i<tableRows.size();i++)
		{
			String text = tableRows.get(i).findElement(By.tagName("a")).findElement(By.tagName("span")).getText();
			boolean b = tableRows.get(i).findElement(By.tagName("a")).getText().equals(pageNumber);
			if(tableRows.get(i).findElement(By.tagName("a")).getText().equals(pageNumber))
			{
			requiredPageIndex=i;
			break;
			}
		}
	tableRows.get(requiredPageIndex);
	}
	public static void navForYahooSearch(String pageNumber)
	{
		launchBrowser("https://in.search.yahoo.com/");
		WebElement txtSearch = driver.findElement(By.id("yschsp"));
		txtSearch.sendKeys("Selenium", Keys.ENTER);
		WebElement parentElement=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/div/ol/li/div/div"));
		List<WebElement> tableRows = parentElement.findElements(By.tagName("a"));
		int requiredPageIndex=0;
		for(int i=0;i<tableRows.size();i++)
		{
			if(tableRows.get(i).getText().equals(pageNumber))
			{
			requiredPageIndex=i;
			break;
			}
		}
	tableRows.get(requiredPageIndex).click();;
	}

}
