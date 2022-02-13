package ActiTimeApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackTimeView {

	@FindBy (xpath = "//a[text() = 'View Time-Track']")
	private WebElement ViewTrackTime;
	
	public TrackTimeView(WebDriver Driver) {
		PageFactory.initElements(Driver, this);
	}
	
	public void ViewTrackTime() {
		ViewTrackTime.click();
	}
}
