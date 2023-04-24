package HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SwagLabHomePage {
	@FindBy(xpath = "//button[text()='Open Menu']") private WebElement OpenMenuBtn;
	@FindBy(linkText = "Logout") private WebElement LogoutBtn;
	@FindBy(xpath = "(//button[text()='Add to cart'])[2]") private WebElement AddCartBtn;
	@FindBy(xpath = "(//div[@class='inventory_item_price'])[2]") private WebElement PriceOfproduct;
	@FindBy(className = "shopping_cart_link") private WebElement cartLink;
	@FindBy(xpath = "(//div[@class='inventory_item_name'])[2]") private WebElement ProductNameexp;
	//cartpage
	@FindBy(xpath = "(//div[@class='inventory_item_name'])") private WebElement ProductInCart;
	@FindBy(id = "checkout") private WebElement checkOutBtn;
	@FindBy(id = "continue-shopping") private WebElement ContinueShoppingBtn;
	@FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']") private WebElement removeBtn;
	
	public SwagLabHomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	public void ClickSwagLabHomePageOpenMenuButton() 
	{
		OpenMenuBtn.click();
	}
	public void ClickSwagLabHomePageLogOutButton() {
		LogoutBtn.click();
	}
	public void ClickSwagLabHomePageAddtoCartButton() {
		AddCartBtn.click();
	}
	public String SwagLabHomePagePriceOfproduct() 
	{
		String price=PriceOfproduct.getText();
		return price;
	}
	public void ClickSwagLabHomePageCartLink() {
		cartLink.click();
	}
	public String VerifyProductSwagLabHomePageProductInCart() {
		String ProductName=ProductInCart.getText();
		return ProductName;
	}
	public void ClickSwagLabHomePagecheckOutBtn() {
		checkOutBtn.click();
	}
	public void ClickSwagLabHomePageCartContinueShoppingBtn() {
		ContinueShoppingBtn.click();
	}
	public void ClickSwagLabHomePageremoveBtn() {
		removeBtn.click();
	}
	public String VerifyProductSwagLabHomePageProductName2() {
		String ProductName=ProductNameexp.getText();
		return ProductName;
	}
	
	
}
