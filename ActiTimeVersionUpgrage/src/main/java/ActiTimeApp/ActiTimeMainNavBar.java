package ActiTimeApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTimeMainNavBar {
	Actions action;
	@FindBy (xpath = "(//td[@class='navItem relative'])[1]")
	private WebElement Time_Track;
	
	@FindBy (xpath = "(//td[@class='navItem relative'])[2]")
	private WebElement Tasks;
	
	@FindBy (xpath = "(//td[@class='navItem relative'])[3]")
	private WebElement Reports;
	
	@FindBy (xpath = "(//td[@class='navItem relative'])[4]")
	private WebElement Users;
	
	@FindBy (xpath = "(//td[@class='navItem relative'])[5]")
	private WebElement Work_Scedule;
	
	@FindBy (xpath = "//a[text()='Logout']")
	private WebElement Logout;
	
	public ActiTimeMainNavBar(WebDriver Driver) {
		PageFactory.initElements(Driver, this);
	}
	
	public void MoveCursorTo(WebElement webelement , WebDriver Driver) {
		// need to implement if element is not interactable 
	}
	
	public void logoutFromActiTime() {
		Logout.click();
	}
	
	public void ClickOnNavTabs(String Menu) {
		if(Menu.equals("Time-Tranck"))
			Time_Track.click();
		if(Menu.equals("Tasks"))
			Tasks.click();
		if(Menu.equals("Reports"))
			Reports.click();
		if(Menu.equals("Users"))
			Users.click();
		if(Menu.equals("Work Schedule"))
			Work_Scedule.click();
	}
	
	public void MoveElementToUser(Actions act , String Menu) {
		WebElement Temp=null;
		if(Menu.equals("Time-Tranck"))
			Temp=Time_Track;
		if(Menu.equals("Tasks"))
			Temp=Tasks;
		if(Menu.equals("Reports"))
			Temp=Reports;
		if(Menu.equals("Users"))
			Temp=Users;
		if(Menu.equals("Work Schedule"))
			Temp =Work_Scedule;
		if(Temp==null)
			System.out.println("Sorry Wrong option");
		else
			act.moveToElement(Temp).perform();
	}
}
