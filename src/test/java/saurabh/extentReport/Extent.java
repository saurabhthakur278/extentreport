package saurabh.extentReport;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extent {
	WebDriver driver;
  static ExtentReports extent;
	
	@BeforeMethod
	public static ExtentReports config() {
		
		
		String path=System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter report =new ExtentSparkReporter(path);
		report.config().setReportName("Web Automation report");
		
		report.config().setDocumentTitle("report extent");
		
		 extent = new ExtentReports();
		
		extent.attachReporter(report);
		extent.setSystemInfo("tester", "Saurabh thakur");
		return extent;
	}
	
	
	
	
	@Test
	public void test1() {
		extent.createTest("test1");
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://rahulshettyacademy.com/client/");
	 System.out.println(driver.getTitle());
	 extent.flush();
}
}