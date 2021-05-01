package amazonTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amazon.Base;
import pageObjectModel.LoginPage;
import pageObjectModel.SignInPage;

public class TestHomepage extends Base {
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(TestValidatetitle.class.getName());
	@BeforeTest
	public void start() throws Throwable {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.debug("url is clicked");
	}

	@Test(dataProvider="getData")
	public void amazonLogin(String UserName, String Password) throws Throwable {
		/*driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		*/
		// we can call another class two ways:- inheritance OR  creating object of that class and invoking methods of it
		
		//we here create object and invoke
		
		LoginPage lp = new LoginPage(driver);
		lp.getLogin().click();
		SignInPage sig = new SignInPage(driver);
		sig.email().sendKeys(UserName);
		sig.getClick().click();
		sig.getPassword().sendKeys(Password);
		sig.getsubmit().click();
		log.info("Successfully entered in HomePage");
		Assert.assertEquals(sig.getTitleLog().getText(),"Hello, shrey");
		log.info("Title is verified");
	
	}
	@DataProvider
	public Object[][] getData() {
		
		//Rows stands for how many  different data types test should be run
		//column stands for how many value for each test
		Object[] [] data= new Object[1] [2];
		data[0][0] ="9599198075";
		data[0][1] ="Shrey@9386";
		
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}

}
