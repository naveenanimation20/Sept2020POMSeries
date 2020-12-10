package com.qa.hubspot.pages;

import org.openqa.selenium.By;

public class SignUpPage {
	
	By signup = By.id("sign up");
	
	
	public SignUpPage() {
		System.out.println("SignUpPage");
	}
	
	
	public void clickSignup() {
		System.out.println("click on sign up");
	}
	

}
