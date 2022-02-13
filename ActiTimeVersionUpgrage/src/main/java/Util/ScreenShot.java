package Util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	
	public static void TakeScreenShot(WebDriver driver , String testID) throws IOException {
		DateFormat date = new SimpleDateFormat("MM dd yyyy HH mm ss");
		Date SystemDate = new Date();
		String CurrentDate = date.format(SystemDate);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\Users\\User\\Desktop\\TestProof\\"+testID+"-"+CurrentDate+".jpeg");
		FileHandler.copy(src,dest);
	}
}
