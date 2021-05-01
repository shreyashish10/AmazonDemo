package amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;
	
	public  WebDriver initializeDriver() throws Throwable {
		
		//Chrome 
		//Firefox
		
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\shrey\\eclipse-workspace\\Amazon_Project\\src\\main\\java\\amazon\\Properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome")) {
			// execute in chrome driver
			
			
			System.setProperty("webdriver.chrome.driver", ".//resources//drivers//chromedriver.exe");
			 driver= new ChromeDriver();
		}
		//Firefox
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver",".//driver//geckodriver.exe");
			 driver= new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public void screenShot(String testCaseName,WebDriver driver) throws IOException {
	TakesScreenshot	ts =(TakesScreenshot) driver;
	File source= ts.getScreenshotAs(OutputType.FILE);
	String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
		
	}
	
	
}
