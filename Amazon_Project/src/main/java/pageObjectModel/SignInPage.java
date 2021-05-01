package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

	public WebDriver driver;

	By email = By.xpath("//input[@type='email']");
	By click = By.xpath("//input[@id='continue']");
	By password = By.xpath("//input[@type='password']");
	By submit = By.xpath("//input[@id='signInSubmit']");
	//checking assertion
	By verify = By.id("nav-link-accountList-nav-line-1");//id="nav-link-accountList-nav-line-1"

	public SignInPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement email()

	{

		return driver.findElement(email);

	}

	public WebElement getClick() {

		return driver.findElement(click);
	}
	
		public WebElement getPassword() {
			
		return driver.findElement(password);
		
	}
		public WebElement getsubmit() {
			
			return driver.findElement(submit);
		}
		public WebElement getTitleLog() {
			return driver.findElement(verify);
		}
}
