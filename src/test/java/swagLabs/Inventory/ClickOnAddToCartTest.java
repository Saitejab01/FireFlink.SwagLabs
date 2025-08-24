package swagLabs.Inventory;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import swagLabs.GenericUtilities.BaseClass;
import swagLabs.ObjectRepository.CartsPage;
import swagLabs.ObjectRepository.InventoryPage;
@Listeners(swagLabs.GenericUtilities.ListenersImplementation.class)
public class ClickOnAddToCartTest extends BaseClass{
	@Test
	public void clickOnAddToCart() throws EncryptedDocumentException, IOException {
		InventoryPage ip = new InventoryPage(driver);
		String title = fu.getDataFromExcel("Titles",1, 2);
		ip.getAddToCartBtn(driver, title).click();
		ip.clickOnElementByTitleL(driver, title).click();
		CartsPage cp = new CartsPage(driver);
		cp.getCartIcon().click();
		cp.clickOnElementByTitleL(driver, title).click();
	}
}
