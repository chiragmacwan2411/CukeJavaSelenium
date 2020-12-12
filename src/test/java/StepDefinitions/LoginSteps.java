package StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import utilities.*;

@SuppressWarnings("deprecation")
public class LoginSteps {
	WebDriver this_driver = null;
	LoginPage loginPage;
	HomePage homePage;
	PropertiesReader propertiesReader;
	
	@Before
	public void browserSetUp() throws IOException {
		propertiesReader = new PropertiesReader();
		String chromeDriverPath = propertiesReader.ReadProperties("./Properties/config.properties","ChromeDriverPath");
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		this_driver = new ChromeDriver();
		
//		String FireFoxDriverPath = propertiesReader.ReadProperties("./Properties/config.properties","ChromeDriverPath");
//		System.setProperty("webdriver.gecko.driver", FireFoxDriverPath);
//		this_driver = new FirefoxDriver();
		
		this_driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this_driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		this_driver.manage().window().maximize();
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() throws IOException {
		this_driver.get("http://www.demo.guru99.com/V4/");
		String expectedLoginPageTitle = propertiesReader.ReadProperties("./Properties/config.properties", "LoginPageTitle");
		Assert.assertEquals(expectedLoginPageTitle, this_driver.getTitle());
	} 
	
	@When("user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String UserName, String Password) throws InterruptedException {
		loginPage = new LoginPage(this_driver);
		loginPage.EnterUsernameAndPassword(UserName, Password);
	}
	
	@When("clicks login button")
	public void clicks_login_button() throws InterruptedException {
	    loginPage = new LoginPage(this_driver);
	    loginPage.ClickLoginBtn();
	}
	
	@Then("user is successfully logged in and navigated to the Home page")
	public void user_is_successfully_logged_in_and_navigated_to_the_home_page() throws IOException {
	    String managerHonePageTitleString = propertiesReader.ReadProperties("./Properties/config.properties", "ManagerHomePageTitle");
		Assert.assertEquals(managerHonePageTitleString, this_driver.getTitle());
	}
	
	@And("user logs out")
	public void user_logs_out() throws InterruptedException {
	    homePage = new HomePage(this_driver);
	    homePage.logOut();
	}
	
	@After
	public void quitBrowser() {
		this_driver.quit();
	}
}
