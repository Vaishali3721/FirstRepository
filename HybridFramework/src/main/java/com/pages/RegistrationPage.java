package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class RegistrationPage extends BaseClass{
	
	@FindBy(id="name")
	private WebElement nameCred;
	
	@FindBy(id="mobile")
	private WebElement mobCred;
	
	@FindBy(id="email")
	private WebElement emailCred;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(xpath="//button")
	private WebElement signBtn;
	
	@FindBy(xpath="//a[@class='text-center']")
	private WebElement hyperLink;
	
	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void registerWithValidCred(String name, String no, String email, String password) {
		nameCred.sendKeys(name);
		mobCred.sendKeys(no);
		emailCred.sendKeys(email);
		pass.sendKeys(password);
		signBtn.click();
		
	}
	
	public void registerWithInvalidCred(String name, String no, String email, String password) {
		nameCred.sendKeys(name);
		mobCred.sendKeys(no);
		emailCred.sendKeys(email);
		pass.sendKeys(password);
		signBtn.click();
	}
	
	public LoginPage hyperLink() {
		hyperLink.click();
		return new LoginPage(driver);
	}
	
	
	
	

}
