package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PropertiesReader;

public class LoginPage {
	protected WebDriver driver;
	/*
	private By txtBox_UserName = By.name("uid");
	private By txtBox_PassWord = By.name("password");
	private By login_btn = By.name("btnLogin");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void EnterUsernameAndPassword(String UserName, String Password) throws InterruptedException {
		driver.findElement(txtBox_UserName).sendKeys(UserName);
//		Thread.sleep(500);
		driver.findElement(txtBox_PassWord).sendKeys(Password);
		Thread.sleep(500);
	}
	
	public void ClickLoginBtn() throws InterruptedException {
		driver.findElement(login_btn).click();
		Thread.sleep(500);
	}
	*/
	
	
	// PAGEFACTORY IMPLEMENTED
	@FindBy(name = "uid")
	@CacheLookup
	private WebElement txtBox_UserName;
	
	@FindBy(name = "password")
	@CacheLookup
	private WebElement txtBox_PassWord;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	private WebElement login_btn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void EnterUsernameAndPassword(String UserName, String Password) throws InterruptedException {
		txtBox_UserName.sendKeys(UserName);
//		Thread.sleep(500);
		txtBox_PassWord.sendKeys(Password);
		Thread.sleep(500);
	}
	
	public void ClickLoginBtn() throws InterruptedException {
		login_btn.click();
		Thread.sleep(500);
	}
	
}
