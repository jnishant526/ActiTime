package ActiTimeApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActitimeCreateUser {

	@FindBy (xpath = "//span[text()='User']")
	private WebElement AddUsrBtn;
	
	@FindBy (xpath = "//input[@name='firstName']")
	private WebElement FirstName;
	
	@FindBy (xpath = "//input[@name='lastName']")
	private WebElement LastName;
	
	@FindBy (xpath = "//input[@name='username']")
	private WebElement UserName;
	
	@FindBy (xpath = "//input[@name='middleName']")
	private WebElement MiddleLatter;
	
	@FindBy (xpath = "//input[@name='password']")
	private WebElement Password;
	
	@FindBy (xpath = "//input[@name='passwordCopy']")
	private WebElement ConfirmPass;
	
	@FindBy (xpath = "//input[@name='email']")
	private WebElement Email;
	
	@FindBy (xpath = "//button[text()='select date']")
	private WebElement SelectReleaseDate;
	
	@FindBy (xpath = "//button[@id='ext-gen173']]")
	private WebElement ReleaseDate;
	
	@FindBy (xpath="//div[@id='userDataLightBox_cancelBtn']")
	private WebElement closeUserTab;
	
	// permissions 
	
	@FindBy (xpath = "//input[@id='userDataLightBox_generateTimeReportsChBox']")
	private WebElement GenTimeReport;
	
	@FindBy (xpath = "//input[@id='userDataLightBox_manageTasksChBox']")
	private WebElement ManageTasks;
	
	@FindBy (xpath = "//input[@id='userDataLightBox_generateMoneyReportsChBox']")
	private WebElement GenBillingReport;
	
	@FindBy (xpath = "//span[text()='Create User']")
	private WebElement CreateUserBtn;
	
	public ActitimeCreateUser(WebDriver Driver) {
		PageFactory.initElements(Driver, this);
	}
	
	public void setFnameLnameUsername(String Fname,String Lname , String username) {
		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		UserName.sendKeys(username);
	}
	
	public void setPassAndConfirmPass(String Pass, String ConfPass) {
		Password.sendKeys(Pass);
		ConfirmPass.sendKeys(ConfPass);
	}
	
	public void setEmailAndMiddleLetter(String email , String middleLetter) {
		Email.sendKeys(email);
		MiddleLatter.sendKeys(middleLetter);
	}
	
	public void SetReleaseDate() throws InterruptedException {
		//SelectReleaseDate.click();
		Thread.sleep(4000);
		//ReleaseDate.click();
	}
	
	public void setPermissions() {
		GenTimeReport.click();
		GenBillingReport.click();
		ManageTasks.click();
	}
	
	public void CreateUser() {
		CreateUserBtn.click();
	}
	
	public void AddUser() {
		AddUsrBtn.click();
	}
	
	public void CloseuserTab() {
		closeUserTab.click();
	}
}
