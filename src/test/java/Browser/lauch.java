package Browser;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class lauch {
	
	  ExtentReports extent;

	@Test
	public void lauchbrowser() throws IOException {
		extent.createTest("Lauch browser");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		System.setProperty("Webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bstackdemo.com/");
		driver.close();
		extent.flush();
	}
	
	@BeforeTest
	@Test
	public void Config() {
		String file = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(file);
		report.config().setReportName("Test Automation");
		report.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		  extent.attachReporter(report);
		  extent.setSystemInfo("Tester", "Sagar Raipurkar");
	}

}
