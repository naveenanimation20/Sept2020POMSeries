package com.qa.hubspot.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;

public class ProductInfoTest extends BaseTest {

	@BeforeClass
	public void productInfoSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void ProductInforPageTitleTest_iMac() {
		accountsPage.doSearch("iMac");
		productInfoPage = accountsPage.selectProductFromResults("iMac");	
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("iMac"), "iMac");
	}

	@Test
	public void verifyProductInfoTest_MacBook() {
		String productName = "Macbook";

		Assert.assertTrue(accountsPage.doSearch(productName));

		productInfoPage = accountsPage.selectProductFromResults("MacBook Pro");

		Assert.assertTrue(productInfoPage.getProductImages() == 4);

		Map<String, String> produtcInfoMap = productInfoPage.getProductInformation();
		System.out.println(produtcInfoMap);
		// {Brand=Apple, Availability=In Stock,
		// price=$2,000.00, name=MacBook Pro,
		// Product Code=Product 18, Reward Points=800,
		// exTaxPrice=$2,000.00}

		Assert.assertEquals(produtcInfoMap.get("name"), "MacBook Pro");
		Assert.assertEquals(produtcInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(produtcInfoMap.get("price"), "$2,000.00");
		Assert.assertEquals(produtcInfoMap.get("Product Code"), "Product 18");
		Assert.assertEquals(produtcInfoMap.get("Reward Points"), "800");

	}

	@Test
	public void verifyProductInfoTest_iMac() {
		String productName = "iMac";

		Assert.assertTrue(accountsPage.doSearch(productName));

		productInfoPage = accountsPage.selectProductFromResults("iMac");

		Assert.assertTrue(productInfoPage.getProductImages() == 3);

		Map<String, String> produtcInfoMap = productInfoPage.getProductInformation();
		System.out.println(produtcInfoMap);

		//{Brand=Apple, Availability=In Stock, 
//		price=$100.00, name=iMac, 
//				Product Code=Product 14, 
//				exTaxPrice=$100.00}

		Assert.assertEquals(produtcInfoMap.get("name"), "iMac");
		Assert.assertEquals(produtcInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(produtcInfoMap.get("price"), "$100.00");
		Assert.assertEquals(produtcInfoMap.get("Product Code"), "Product 14");

	}

}
