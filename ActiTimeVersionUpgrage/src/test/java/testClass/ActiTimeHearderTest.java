package testClass;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ActiTimeApp.ActiTimeLogin;
	import ActiTimeApp.ActiTimeMainNavBar;
	import ActiTimeApp.ActitimeCreateUser;
	import ActiTimeApp.TrackTimeAddTask;
import Util.BrowserLunch;
	public class ActiTimeHearderTest extends BrowserLunch {
		WebDriver driverStart;
		Actions action;
		ActiTimeMainNavBar navBar;
		SoftAssert asrt;
		@BeforeClass
		@Parameters("browser")
		public void launchTheBrowser(String data) {
			System.out.println(data);
			if(data.equals("firefox")) {
				driverStart = FireFoxDriver();
			}
			if(data.equals("chrome")) {
				driverStart = CheromeDriver();
			}
			asrt = new SoftAssert();
			action  = new Actions(driverStart);
			driverStart.get("http://localhost/login.do");
		}
		
		@BeforeMethod
		public void LoginIntoActiTime() {
			ActiTimeLogin login = new ActiTimeLogin(driverStart);
			login.SetDataToUsername("admin");
			login.SetDataToPassword("manager");
			login.EnableKeepMeLogin();
			login.ClickToLogin();
		}
		
		@Test (priority = 2)
		public void TestToCheckHeader1() throws InterruptedException {
			navBar = new ActiTimeMainNavBar(driverStart);
			navBar.ClickOnNavTabs("Users");
			Thread.sleep(500);
			String linkUrl="http://localhost/administration/userlist.do";
			Boolean url = linkUrl.equals("http://localhost/administration/userlist.do");
			System.out.println(url);
			asrt.assertEquals(driverStart.getCurrentUrl(), "http://localhost/administration/userlist.do");
			asrt.assertEquals(driverStart.getCurrentUrl(), "http://localhost/administration/userlist.do" , "Url does not match");
			asrt.assertTrue(url);
			asrt.assertNotEquals(driverStart.getCurrentUrl(), "http://desktop-3q09jmr/administration/userlist.do");
			asrt.assertAll();
		}
		
		@Test (priority = 1)
		public void TestToCheckHeader2() {
			navBar = new ActiTimeMainNavBar(driverStart);
			navBar.ClickOnNavTabs("Tasks");
		}
		
		@AfterMethod
		public void LogoutFromActiTime() {
			navBar.logoutFromActiTime();
		}
		
		@AfterClass
		public void ConnectionClosed() {
	    	driverStart.close();
		}
	}

