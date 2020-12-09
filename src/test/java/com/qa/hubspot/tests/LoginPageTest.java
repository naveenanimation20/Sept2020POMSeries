package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Listeners(ExtentReportListener.class)

@Epic("Epic 100: define loing page features....")
@Story("US 101: define the login page class features with title, forgot pwd link and login functionality")
public class LoginPageTest extends BaseTest {

	@Description("verify LoginPage Title Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("verify forgot pwd Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 2)
	public void verifyForgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Description("Login page test with username and password")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
