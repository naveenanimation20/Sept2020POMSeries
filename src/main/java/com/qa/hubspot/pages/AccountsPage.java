package com.qa.hubspot.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;

public class AccountsPage extends BasePage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By header = By.cssSelector("div#logo a");
	private By accountSectionHeaders = By.cssSelector("div#content h2");
	private By searchText = By.cssSelector("div#search input[name='search']");
	private By searchButton = By.cssSelector("div#search button[type='button']");
	private By searchItemsResult = By.cssSelector(".product-layout .product-thumb");
	private By resultItems = By.cssSelector(".product-thumb h4 a");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	@Step("getting accounts page title.....")
	public String getAccountPagePagetitle() {
		return elementUtil.waitForTitlePresent(Constants.ACCOUNTS_PAGE_TITLE, 10);
	}

	@Step("getting the header value....")
	public String getHeaderValue() {
		if (elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}

	@Step("getting total number of account sections.....")
	public int getAccountSectionsCount() {
		return elementUtil.getElements(accountSectionHeaders).size();
	}

	@Step("getting account sections list from the my accounts page....")
	public List<String> getAccountSectionsList() {
		List<String> accountsList = new ArrayList<>();
		List<WebElement> accSectionList = elementUtil.getElements(accountSectionHeaders);

		for (WebElement e : accSectionList) {
			System.out.println(e.getText());
			accountsList.add(e.getText());
		}

		return accountsList;
	}

	@Step("searching a product with name : {0}")
	public boolean doSearch(String productName) {
		elementUtil.doSendKeys(searchText, productName);
		elementUtil.doClick(searchButton);
		if (elementUtil.getElements(searchItemsResult).size() > 0) {
			return true;
		}
		return false;
	}

	@Step("selecting a product with name from the results section : {0}")
	public ProductInfoPage selectProductFromResults(String productName) {
		List<WebElement> resultItemList = elementUtil.getElements(resultItems);
		System.out.println("total number of items displayed: " + resultItemList.size());

		for (WebElement e : resultItemList) {
			if (e.getText().equals(productName)) {
				e.click();
				break;
			}
		}

		return new ProductInfoPage(driver);
	}
	
	public void getAccountsPageDetails() {
		System.out.println("getAccountsPageDetails");
	}

}
