package Login;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import CheckoutPage.SwaglabCheckoutPage;
import HomePage.SwagLabHomePage;
import LoginPage.SwagLabLoginPage;
import OverviewPage.SwaglabOverviewPage;
import library.BaseClass;
import library.Utility;

public class test extends BaseClass
{	SwagLabLoginPage login;
SwagLabHomePage home;
SwaglabCheckoutPage checkout;
SwaglabOverviewPage overview;

int TCID;
ExtentReports extent = new ExtentReports();
ExtentSparkReporter spark = new ExtentSparkReporter("extentReportSwagLab.html");
@BeforeMethod
public void Initialize() 
{
extent.attachReporter(spark);
login = new SwagLabLoginPage(driver);
home= new SwagLabHomePage(driver);
checkout = new SwaglabCheckoutPage(driver);
overview = new SwaglabOverviewPage(driver);
}
//verify swaglab logo
@Test(priority = 0)
public void VerifySwagLabLogo() 
{TCID=101;
	ExtentTest test1= extent.createTest("Verify SwagLab Logo").assignAuthor("shubham").assignDevice("chrome"); 
	boolean result = login.getSwagLabLoginPageLogoResult();
if(result==true)
{
	test1.pass("logo is present on login page");
}
else {
	test1.fail("logo is not present on login page");
}
}
//login in swaglab with different user name & password
@Test(dataProvider = "LoginData",priority = 2)
public void LoginSwagLab(String UN, String PWD) 
{	TCID=102;
login.inpSwagLabLoginPageUN(UN);
login.inpSwagLabLoginPagePWD(PWD);
login.ClickSwagLabLoginPageLoginButton();

}
@Test(priority = 1)
public void VerifyProductinCart() throws IOException 
{	ExtentTest test2= extent.createTest("Verify Product in Cart"+TCID).assignAuthor("shubham").assignDevice("chrome"); 
	TCID=103;
login.inpSwagLabLoginPageUN(Utility.GetpropertyFileData("UN"));
login.inpSwagLabLoginPagePWD(Utility.GetpropertyFileData("PWD"));
login.ClickSwagLabLoginPageLoginButton();
String productNameAct=home.VerifyProductSwagLabHomePageProductName2();
home.ClickSwagLabHomePageAddtoCartButton();
home.ClickSwagLabHomePageCartLink();
home.ClickSwagLabHomePagecheckOutBtn();
checkout.inpSwaglabCheckoutPageFN(Utility.GetDataFromExcel(1, 0));
checkout.inpSwaglabCheckoutPageLN(Utility.GetDataFromExcel(1, 1));
checkout.inpSwaglabCheckoutPageZipCode(Utility.GetDataFromExcel(1, 2));
overview.ClickSwaglabOverviewPageContinueShoppingBtn();
String productNameExp =overview.GetSwaglabOverviewPageProductName();
if(productNameAct.equals(productNameExp))
{
	test2.pass("Actual and expected name are matched");
}
else {
	test2.pass("Actual and expected name are not  matched");
}

}
@DataProvider(name="LoginData")
public static String[][] DataProvider() throws EncryptedDocumentException, IOException {
	String [][] data= {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},{"problem_user","secret_sauce"}};

	return data;
}
@AfterMethod
public void FailedTCSS(ITestResult result) throws IOException 
{	
	if(result.getStatus()==ITestResult.FAILURE)
{
	Utility.TakeSS(driver, 0);
}
	extent.flush();

}

}
