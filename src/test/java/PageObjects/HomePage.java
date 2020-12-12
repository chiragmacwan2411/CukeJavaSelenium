package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	protected WebDriver driver;
//	private By logOut_btn = By.xpath("/html/body/div[3]/div/ul/li[15]/a");
	
	@FindBy (xpath = "/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	private WebElement logOut_btn;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logOut() throws InterruptedException {
		logOut_btn.click();
		Thread.sleep(1000);
	}
}