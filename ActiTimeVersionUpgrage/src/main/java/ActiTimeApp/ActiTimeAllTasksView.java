package ActiTimeApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTimeAllTasksView {
	@FindBy (xpath = "//input[@name='pwd']")
	private WebElement OpenTasks;
	
	@FindBy (xpath = "//input[@name='pwd']")
	private WebElement CompletedTask;
	
	@FindBy (xpath = "//input[@name='pwd']")
	private WebElement ProjrctCustTask;
	
	@FindBy (xpath = "//input[@name='pwd']")
	private WebElement Archive;

	public ActiTimeAllTasksView(WebDriver Driver) {
		PageFactory.initElements(Driver, this);
	}
	
	public void OpenTask() {
		OpenTasks.click();
	}
	
	public void CompleteTask() {
		CompletedTask.click();
	}
	
	public void ProjectCustomerTask() {
		ProjrctCustTask.click();
	}
	
	public void ArchiveTask() {
		Archive.click();
	}
}
