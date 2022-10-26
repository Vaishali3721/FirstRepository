package com.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utils.PropertyUtils;

public class BaseClass {
	
	public static WebDriver driver=null;
	public static ExtentReports report=null;
	public static ExtentSparkReporter sparc=null;
	public static ExtentTest test=null;
	public static Logger log=Logger.getLogger(BaseClass.class);//import this logger by apache.log4j
	
	public void initialization() throws Exception {
		System.out.println("Initializing browser");//this will print only on consol
		log.info("reading a browser name from config file");//file as well as on consol
		String br_name=PropertyUtils.readProperty("browser");
		
		if(br_name.equals("chrome")) {
			log.info("initializing chrome browser");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
		}
		if(br_name.equals("firefox")) {
			log.info("initializing firefox browser");
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}
		log.info("browser initialized successfully");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(PropertyUtils.readProperty("url"));
	}
	
	public void reportInit() {
		report = new ExtentReports();
		sparc=new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReopt.html");
		//to make connection between report and sparc
		report.attachReporter(sparc);
		//to initialize the ExtentReport we will take a help of Listerners
		
	}

}
