package ActiTimeApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackTimeAddTask {
	
	@FindBy (xpath = "//span[text()='New']")
	private WebElement AddNewTakBtn;
	
	@FindBy (xpath = "(//td[@class='navItem relative'])[1]")
	private WebElement Select_Customer;
	
	@FindBy (xpath = "//a[text()='nishan']]")
	private WebElement Select_Cust_dropdown;
	
	
	@FindBy (xpath = "//button[@id='ext-gen263']")
	private WebElement Select_project;
	
	@FindBy (xpath = "//a[@id='ext-gen287']")
	private WebElement Select_project_dropdown;
	
	@FindBy (xpath = "//input[@id='createTasksPopup_newProject']")
	private WebElement Project_Name;
	
	@FindBy (xpath = "(//td[@class='nameCell first'])[1]//input")
	private WebElement Task1;
	
	@FindBy (xpath = "(//td[@class='nameCell first'])[2]//input")
	private WebElement Task2;
	
	@FindBy (xpath = "//div[@id='createTasksPopup_commitBtn']")
	private WebElement AddTaskBtn;
	
	public TrackTimeAddTask(WebDriver Driver) {
		PageFactory.initElements(Driver, this);
	}
	
	public void AddnewTask() {
		AddNewTakBtn.click();
	}
	
	public void SelectCustomer() {
		Select_Customer.click();
		Select_Cust_dropdown.click();
	}
	
	public void SelectProject(String ProjectName) {
		Select_project.click();
		Select_project_dropdown.click();
		Project_Name.sendKeys(ProjectName);
	}
	
	public void AddTask1(String task1) {
		Task1.sendKeys(task1);
	}
	
	public void AddTask2(String task2) {
		Task1.sendKeys(task2);
	}
	
	public void ClickToAddTask() {
		AddTaskBtn.click();
	}
}

