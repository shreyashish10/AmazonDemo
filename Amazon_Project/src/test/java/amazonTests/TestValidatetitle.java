package amazonTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import amazon.Base;
import pageObjectModel.LoginPage;

public class TestValidatetitle extends Base {

	public WebDriver driver;
	//public static Logger log = (Logger) LogManager.getLogger( TestValidatetitle.class.getName());
	 public static Logger log =LogManager.getLogger(TestValidatetitle.class.getName());
	
	
	
	
	@BeforeTest
	public void start() throws Throwable {
		driver = initializeDriver();
		log.debug("Driver is initialize");
		driver.get(prop.getProperty("url"));
		log.info("url is clicked");
		
	}

	@Test
	public void amazonVerifytitle() throws Throwable {

		LoginPage l = new LoginPage(driver);
		// Comapre the text from the browser with actual test
		Assert.assertEquals(l.getTitle().getText(), "Heello");
		log.debug("Title is verified");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}