package OverviewPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwaglabOverviewPage {
@FindBy(xpath = "//div[@class='inventory_item_name']") private WebElement ProductName;
@FindBy(id = "continue") private WebElement ContinueShoppingBtn;

public SwaglabOverviewPage(WebDriver driver) 
{
	PageFactory.initElements(driver,this);
}
public String GetSwaglabOverviewPageProductName() {
	return ProductName.getText();
}
public void ClickSwaglabOverviewPageContinueShoppingBtn() {
	ContinueShoppingBtn.click();
}

}
