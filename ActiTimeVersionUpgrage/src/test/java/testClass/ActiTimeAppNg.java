package testClass;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ActiTimeApp.ActiTimeLogin;
import ActiTimeApp.ActiTimeMainNavBar;
import ActiTimeApp.ActitimeCreateUser;
import Util.BrowserLunch;
import Util.Pojo;
import Util.ScreenShot;

public class ActiTimeAppNg extends BrowserLunch {
	WebDriver driverStart;
	Actions action;
	ActiTimeMainNavBar navBar;
	String TestID="" ;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	@Parameters("browser")
	@BeforeClass
	public void launchTheBrowser(String data) {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println(data);
		if(data.equals("firefox")) {
			driverStart = FireFoxDriver();
		}
		if(data.equals("chrome")) {
			driverStart = CheromeDriver();
		}
		action  = new Actions(driverStart);
		driverStart.get("http://localhost/login.do");
	}
	
	@BeforeMethod
	public void LoginIntoActiTime() throws IOException {
		ActiTimeLogin login = new ActiTimeLogin(driverStart);
		String Username = Pojo.GetSheetData("Data", 1, 0);
		String Password = Pojo.GetSheetData("Data", 1, 1);
		login.SetDataToUsername(Username);
		if(login.IsUsernameWrong()) {
			ScreenShot.TakeScreenShot(driverStart, TestID);
			Assert.fail();
		}
		else {
			login.SetDataToPassword(Password);
			login.EnableKeepMeLogin();
			login.ClickToLogin();
		}
	}
	
	@Test (priority = 1)
	public void AddUser() throws InterruptedException {
		TestID="Test234";
		navBar = new ActiTimeMainNavBar(driverStart);
		navBar.ClickOnNavTabs("Users");
		ActitimeCreateUser user = new ActitimeCreateUser(driverStart);
		user.AddUser();
		Thread.sleep(2000);
		user.setFnameLnameUsername("Rajat","Joshi","jnishhbhertrsdhsdhsjdh");
		user.setEmailAndMiddleLetter("jnishant526@gmail.com", "C.");
		user.setPassAndConfirmPass("Nishan@1998","Nishan@1998");
		user.SetReleaseDate();
		user.setPermissions();
		user.CreateUser();
	}
	
	@Test (priority = 2)
	public void CloseUserBtnValidation() throws InterruptedException {
		TestID="Test334";
		navBar = new ActiTimeMainNavBar(driverStart);
		navBar.ClickOnNavTabs("Users");
		ActitimeCreateUser user = new ActitimeCreateUser(driverStart);
		user.AddUser();
		Thread.sleep(2000);
		user.setFnameLnameUsername("Rajat","Joshi","jnishanteyrt");
		user.setEmailAndMiddleLetter("jnishant526@gmail.com", "C.");
		user.setPassAndConfirmPass("Nishan@1998","Nishan@1998");
		user.SetReleaseDate();
		user.setPermissions();
		user.CloseuserTab();
		Alert alt = driverStart.switchTo().alert();
		alt.accept();
	}
	
	@AfterMethod
	public void LogoutFromActiTime(ITestResult result) throws IOException {
		if(ITestResult.FAILURE == result.getStatus()) {
			System.out.println(result.getStatus());
			ScreenShot.TakeScreenShot(driverStart, TestID);
		}
		navBar.logoutFromActiTime();
	}
	
	@AfterClass
	public void ConnectionClosed() {
    	driverStart.close();
	}
}

