package swagLabs.ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swagLabs.GenericUtilities.FileUtility;

public class LoginPage {
	@FindBy(id = "user-name") public WebElement usernameTF;
	@FindBy(id = "password") public WebElement passwordTF;
	@FindBy(id = "login-button") public WebElement loginBtn;
	public WebElement getUsernameTF() {
		return usernameTF;
	}
	public WebElement getPasswordTF() {
		return passwordTF;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	public void loginIntoSwagLabsApp() throws IOException {
		FileUtility fu = new FileUtility();
		String USERNAME = fu.readDataFromPropertiesFile("username");
		String PASSWORD = fu.readDataFromPropertiesFile("password");
		usernameTF.sendKeys(USERNAME);
		passwordTF.sendKeys(PASSWORD);
		loginBtn.click();
	}
}
