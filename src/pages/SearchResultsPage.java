package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;


public class SearchResultsPage extends BasePage{

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * locators
	 * **/
	
	static String itemsTitlesXpath = "//ul[@class='product_list grid row']//a[@class='product-name']";
	String searchButtonXpath = "//form[@id='searchbox']/button";
	
	@FindBy(xpath="searchButtonXpath")
	private static WebElement searchButtonLocator;
	
	/**
	 * methods
	 * **/
	
	public void clickSearchButton(WebDriver driver){
		driver.findElement(By.xpath(searchButtonXpath));
		}

	public static void getTitlesOfItems(WebDriver driver) {
		List<WebElement> listOfItemNames = driver.findElements(By.xpath(itemsTitlesXpath));
		int size = listOfItemNames.size();
		System.out.println("size "+size);
		
		for (int i=0; i<size; i++) {
			WebElement elem = listOfItemNames.get(i);
			String textOfElem = elem.getText();
			System.out.println(textOfElem);
		}
	}
	
	public static void sendEnter() {
		searchButtonLocator.sendKeys(Keys.RETURN);
	}
}
