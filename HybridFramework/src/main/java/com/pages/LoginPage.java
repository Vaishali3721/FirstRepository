package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.pages.DashboardPage;

public class LoginPage extends BaseClass {
	
	//WebElements and its methods 
	
	@FindBy(id="email")
	private WebElement uname;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(xpath="//button")
	private WebElement loginBtn;
	
	@FindBy(xpath="//b[text()='Java By Kiran']")
	private WebElement heading;
	
	@FindBy(xpath="//h4[text()='JAVA | SELENIUM | PYTHON']")
	private WebElement subHeading;
	
	@FindBy(partialLinkText="Register a")
	private WebElement hyperLink;
	
	@FindBy(xpath="//p[@class='login-box-msg']")
	private WebElement registrationPage;

	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public DashboardPage loginToApplication(String username, String password) {
		uname.sendKeys(username);
		pass.sendKeys(password);
		loginBtn.click();
		if(driver.getTitle().equals("JavaByKiran | Dashboard"))
			return new DashboardPage(driver);
		return null;
	}

	public void loginWithValidCred(String username, String password) {
		uname.sendKeys(username);
		pass.sendKeys(password);
		loginBtn.click();
	}
	
	public String headingCheck() {
		return heading.getText();
	}
	
	public String subHeadindCheck() {
		return subHeading.getText();
	}
	
	public RegistrationPage hyperLinkisClickable() {
		hyperLink.click();
		return new RegistrationPage(driver);
		
	}
}
