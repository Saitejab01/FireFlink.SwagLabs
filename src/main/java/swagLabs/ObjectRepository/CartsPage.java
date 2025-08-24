package swagLabs.ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartsPage {
	@FindBy(id = "shopping_cart_container") private WebElement cartIcon;
	public WebElement clickOnElementByTitleL(WebDriver driver,String title) {
		WebElement ele = driver.findElement(By.xpath("//div[.='"+title+"']/../../..//button[.='Remove']"));
		return ele;
	}
	public WebElement getCartIcon() {
		return cartIcon;
	}
	public CartsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
