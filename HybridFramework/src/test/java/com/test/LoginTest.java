package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.RegistrationPage;

public class LoginTest extends BaseClass {
	LoginPage lp = null;
	public static DashboardPage dp = null;
	public static RegistrationPage rp = null;

	@BeforeSuite
	public void setUp() throws Exception {
		initialization();
		lp = new LoginPage(driver);
	}

	@Test(priority = 5)
	public void loginToApplication() {
		dp = lp.loginToApplication("kiran@gmail.com", "123456");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}

	/*
	 * @Test(priority=0) public void loginWithDiffCred(String uname,String pass) {
	 * lp.loginWithValidCred(uname, pass); Assert.assertEquals(driver.getTitle(),
	 * "JavaByKiran | Dashboard"); }
	 */

	/*
	 * @DataProvider public Object[][] loginData() throws Exception{
	 * 
	 * DataFormatter df=new DataFormatter(); String
	 * path=System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx";
	 * FileInputStream fis=new FileInputStream(path); Workbook
	 * wb=WorkbookFactory.create(fis); Sheet sh= wb.getSheet("Login"); int
	 * rows=sh.getLastRowNum(); String[][] data=new String[rows][2];
	 * 
	 * for(int i=0; i<=rows;i++) { Cell c1=sh.getRow(i).getCell(0); Cell
	 * c2=sh.getRow(i).getCell(1); data[i][0]=df.formatCellValue(c1);
	 * data[i][1]=df.formatCellValue(c2);
	 * 
	 * } return data; }
	 */
	@Test(priority = 1)
	public void checkHeading() {
		String exp = "Java By Kiran";
		Assert.assertEquals(lp.headingCheck(), exp);
	}

	@Test(priority = 2)
	public void checkSubheading() {
		String exp = "JAVA | SELENIUM | PYTHON";
		Assert.assertEquals(lp.subHeadindCheck(), exp);
	}

	
	/*
	 * @Test(priority=4) public void hyperLinkClicable() {
	 * rp=lp.hyperLinkisClickable(); Assert.assertEquals(driver.getTitle(),
	 * "JavaByKiran | Registration Page"); }
	 */
	 
}
