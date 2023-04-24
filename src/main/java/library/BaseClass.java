package library;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected WebDriver driver;
	@Parameters("BrowserName")
	@BeforeClass
	public void LaunchBrowser(String BrowserName) throws EncryptedDocumentException, IOException 
	{	driver = null;
	if(BrowserName.equals("chrome")) 
	{ 
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
	}
	else if(BrowserName.equals("firefox"))
	{	
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else if(BrowserName.equals("edge"))
	{
		WebDriverManager.edgedriver().setup();	
		driver  =new EdgeDriver();
	}
	driver.navigate().to(Utility.GetpropertyFileData("BaseUrl"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Reporter.log("launch Browser", true);

}
	@AfterClass
	public void CloseBrowser() 
	{
		driver.close();
	}
}
