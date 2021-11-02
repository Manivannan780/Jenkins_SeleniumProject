package page_Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import commonFunctions.General_Functions;

public class Page_HomePage extends General_Functions{

	
	@FindBy(xpath="//div[@id=\"logo\"]//following::a[@href=\"/collections/fall-harvest\"]")
	public static WebElement Menu1_FallHalloween;
	
	
	@FindBy(xpath="//div[@id=\"breadcrumb\"]//following::h1")
	public static WebElement Menu1_Text;
	
	
	@FindBy(xpath="//div[@id=\"breadcrumb\"]//following::img[1]")
	public static WebElement Product1;
	
	
	@FindBy(xpath="//input[@id=\"addToCart\"]")
	public static WebElement AddtoCartbutton;
	
	
	@FindBy(xpath="//input[@id=\"mini-cart-checkout\"]")
	public static WebElement Minicart_CheckoutButton;
	
	
	@FindBy(xpath="//h2[contains(@Class,'dynamic-checkout__title')]")
	public static WebElement CheckoutPageText;
	
}
