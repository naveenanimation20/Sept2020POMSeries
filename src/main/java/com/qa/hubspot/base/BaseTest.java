package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.hubspot.pages.AccountsPage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.ProductInfoPage;
import com.qa.hubspot.pages.RegisterPage;

public class BaseTest {

	public BasePage basePage;
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	public ProductInfoPage productInfoPage;
	public RegisterPage registerPage;

	public Properties prop;
	public WebDriver driver;

	@Parameters({"browser", "version"})
	@BeforeTest
	public void setUp(String browserName, String browserVersion) {

		basePage = new BasePage();
		prop = basePage.init_prop();
		String browser = prop.getProperty("browser");

		if (browserName != null) {
			browser = browserName;
		}
		driver = basePage.init_driver(browser, browserVersion);
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
