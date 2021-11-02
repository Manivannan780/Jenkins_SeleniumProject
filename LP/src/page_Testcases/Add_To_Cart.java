package page_Testcases;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonFunctions.General_Functions;
import page_Elements.Page_HomePage;


public class Add_To_Cart extends General_Functions{

	public static void objectcreation() {

		PageFactory.initElements(driver, Page_HomePage.class);
	}

	public void Navigate_To_Menu1() {
		//PauseExecution();
		Page_HomePage.Menu1_FallHalloween.click();
		String Menu1Text=Page_HomePage.Menu1_Text.getText();
		if(Menu1Text.equalsIgnoreCase("Fall Harvest")) {
			System.out.println("Menu Text Matched");
		}

		else {
			System.out.println("Menu Text Not Matched");

		}

		String Menu1URL=driver.getCurrentUrl();
		System.out.println("My Current URL is"+Menu1URL);

	}


	public void AddingProd_To_Cart() {
	
		Actions actobject=new Actions(driver);
		actobject.moveToElement(Page_HomePage.Product1).click().build().perform();
		PauseExecution();
		Page_HomePage.AddtoCartbutton.click();
		PauseExecution();
		Page_HomePage.Minicart_CheckoutButton.click();
		String CheckoutText=Page_HomePage.CheckoutPageText.getText();

		if(CheckoutText.equalsIgnoreCase("Express checkout")) {
			System.out.println("Checkout Page Text  Matched");	
		}
		else {
			System.out.println("Checkout Page Text not Matched");

		}
	}

	@Test
	public void CheckoutPageVerification() {
		objectcreation();
		Navigate_To_Menu1();
		AddingProd_To_Cart();
	}


}
