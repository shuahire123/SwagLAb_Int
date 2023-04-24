package LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage 
{	//logo
	@FindBy(xpath = "//div[@class='login_logo']") private WebElement logo;
	//user name
	@FindBy(xpath = "//input[@id='user-name']") private WebElement UN;
	//password
	@FindBy(xpath = "//input[@id='password']") private WebElement PWD;
	//login button
	@FindBy(xpath = "//input[@id='login-button']") private WebElement LoginButton;
	public SwagLabLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public boolean  getSwagLabLoginPageLogoResult() 
	{
		boolean result =logo.isDisplayed();
		return result;
	}
	public void inpSwagLabLoginPageUN(String UserName ) 
	{	UN.clear();
		UN.sendKeys(UserName);
	}
	public void inpSwagLabLoginPagePWD(String Password) 
	{	PWD.clear();
		PWD.sendKeys(Password);
	}
	public void ClickSwagLabLoginPageLoginButton() {
		LoginButton.click();
	}
	
	
}
