package swagLabs.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	@FindBy(id = "react-burger-menu-btn") public WebElement menuIcon;
	@FindBy(id = "logout_sidebar_link") public WebElement logoutL;
	public WebElement getAddToCartBtn(WebDriver driver,String title) {
		WebElement ele = driver.findElement(By.xpath("//div[.='"+title+"']/../../..//button[@id='add-to-cart-sauce-labs-backpack']"));
		return ele;
	}
	public WebElement getMenuIcon() {
		return menuIcon;
	}
	public WebElement getLogoutL() {
		return logoutL;
	}
	public WebElement clickOnElementByTitleL(WebDriver driver,String title) {
		WebElement ele = driver.findElement(By.xpath("//div[.='"+title+"']"));
		return ele;
	}
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void LogoutFromApp() throws InterruptedException {
		menuIcon.click();
		Thread.sleep(2000);
		logoutL.click();
	}
	
}
