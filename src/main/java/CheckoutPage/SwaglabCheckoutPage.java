package CheckoutPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwaglabCheckoutPage {
@FindBy(id = "first-name") private WebElement FN;
@FindBy(id = "last-name") private WebElement LN;
@FindBy(id = "postal-code") private WebElement ZipCode;
public SwaglabCheckoutPage(WebDriver driver) 
{
	PageFactory.initElements(driver,this);
}
public void inpSwaglabCheckoutPageFN(String firstname) {
	FN.sendKeys(firstname);
}
public void inpSwaglabCheckoutPageLN(String lastName) {
	LN.sendKeys(lastName);
}
public void inpSwaglabCheckoutPageZipCode(String zip) {
	ZipCode.sendKeys(zip);
}
}
