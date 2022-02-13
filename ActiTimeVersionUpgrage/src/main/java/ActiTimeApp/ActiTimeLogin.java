package ActiTimeApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTimeLogin {
	
	@FindBy (xpath = "//input[@name='username']")
	private WebElement UserName;
	
	@FindBy (xpath = "//input[@name='pwd']")
	private WebElement Password;
	
	@FindBy (xpath = "//div[text()='Login ']")
	private WebElement LoginBtn;
	
	@FindBy (xpath = "//input[@type='checkbox']")
	private WebElement KeepMeLoginBtn;
	
	@FindBy (xpath = "(//span[@class='errormsg'])[1]")
	private WebElement ErrorMsg;
	
	public ActiTimeLogin(WebDriver Driver) {
		PageFactory.initElements(Driver, this);
	}
	
	public void SetDataToUsername(String Data){
		if(UserName.isDisplayed()) {
			UserName.clear();
			UserName.sendKeys(Data);
		}
		else
			System.out.println("Element is not Displayed");
	}
	
	public void SetDataToPassword(String Data){
		if(Password.isDisplayed()) {
			Password.clear();
			Password.sendKeys(Data);
		}
		else
			System.out.println("Element is not Displayed");
	}
	
	public void ClickToLogin(){
		if(LoginBtn.isDisplayed()) {
			LoginBtn.click();
		}
		else
			System.out.println("Element is not Displayed");
	}
	
	public void EnableKeepMeLogin() {
		if(! KeepMeLoginBtn.isSelected()) {
			KeepMeLoginBtn.click();
		}
		else
			System.out.println("Already Clicked");
	}
	
	public boolean IsUsernameWrong() {
		if(ErrorMsg.isDisplayed()) {
			return true;
		}
		return false;
	}
	
}
