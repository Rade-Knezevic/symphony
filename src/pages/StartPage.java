package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.SearchResultsPage;
	public class StartPage extends BasePage{
		 
		
		public StartPage(WebDriver driver) {
			super(driver);
		}
		
		/**
		 * locators
		 * */
		
		String signInLinkXpath = "//a[@class='login']";
		String signOutButtonXpath = "//a[@class='logout']";
		String popularItemsXpath = "//ul[@id='homefeatured']//img[@itemprop]";
		String bestSellersTabXpath = "//a[@class='blockbestsellers']";
		
		@FindBy(xpath="signInLinkXpath")
		private WebElement signInLinkLocator;
		
		@FindBy(id="email")
		private WebElement emailFieldLocator;
		
		@FindBy(id="passwd")
		private WebElement passwordFieldLocator;
		
		@FindBy(id="SubmitLogin")
		public WebElement submitButtonLocator;
		
		@FindBy(xpath="signOutButtonXpath")
		public WebElement signOutButtonLocator;
		/*************************************************/
		
		/**
		 * Methods
		 * 
		 * */
		
		public void waitUntilStartPageLoads() {
			
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.xpath(signInLinkXpath))
			);
			
			
		}
		
		public void clickSignInButton(WebDriver driver) {
			driver.findElement(By.xpath(signInLinkXpath)).click();
			//signInLinkLocator.click();
		}
		
		
		public void waitForEmailFieldToBeDisplayed(WebDriver driver) {
			
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.id("email") )
			);
			
			
		}

		public StartPage populateEmailField(WebDriver driver, String email) {
			
			driver.findElement(By.id("email")).sendKeys(email);
			return this;
		}
		
		public StartPage populatePasswordField(WebDriver driver, String password) {
			driver.findElement(By.id("passwd")).sendKeys(password);
			//passwordFieldLocator.sendKeys(password);
			return this;
		}

		public StartPage clickSubmitButton(WebDriver driver){
			driver.findElement(By.id("SubmitLogin")).click();
			//submitButtonLocator.click();
			return this;
		}		
		  
		public boolean isSignOutButtonPresent(WebDriver driver) {
			boolean isSignOutButtonPresent = driver.findElement(By.xpath(signOutButtonXpath)).isDisplayed();
			return isSignOutButtonPresent;
		}
		
		public int countNumberOfItems() {
			int numberOfelements = driver.findElements(By.xpath(popularItemsXpath)).size();
			return numberOfelements;
		}
		
		public void clickBestSellersTab(WebDriver driver){
			driver.findElement(By.xpath(bestSellersTabXpath)).click();
		}		
	/*	
		public boolean isElementPresent(WebDriver driver,WebElement locator) {
			Boolean isPresent = locator.isDisplayed();
			return isPresent;
		}*/
		
		public void insertSearchString(WebDriver driver, String searchInput) {
			driver.findElement(By.id("search_query_top")).sendKeys(searchInput);
		}
		
		public SearchResultsPage clickSearchButton(WebDriver driver){
			driver.findElement(By.name("submit_search"));
			return SearchResultsPage(driver);
			}

		private SearchResultsPage SearchResultsPage(WebDriver driver) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	