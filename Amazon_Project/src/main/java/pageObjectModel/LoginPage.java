package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	By signin = By.id("nav-link-accountList-nav-line-1");
	By title = By.id("glow-ingress-line1");//

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getLogin() {

		return driver.findElement(signin);
		

	}
  public WebElement getTitle()
  {
	  return driver.findElement(title);
  }
}