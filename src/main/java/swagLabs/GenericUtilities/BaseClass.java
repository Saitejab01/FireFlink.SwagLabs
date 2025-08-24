package swagLabs.GenericUtilities;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import swagLabs.ObjectRepository.InventoryPage;
import swagLabs.ObjectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public FileUtility fu = new FileUtility();
	public WebDriverUtility wu = new WebDriverUtility();
	public static WebDriver sdriver;
	@BeforeSuite 
	public void bsConfig() {
		System.out.println("===============Database connection done====================");
	}
	
	@BeforeClass
	public void bcConfig() throws IOException {
		String BROWSER = fu.readDataFromPropertiesFile("browser");
		String URL = fu.readDataFromPropertiesFile("url");
		switch(BROWSER) {
		case "chrome":driver = new ChromeDriver();break;
		case "edge":driver = new EdgeDriver();break;
		case "firefox":driver = new FirefoxDriver();break;
		default:driver =new EdgeDriver();
		}
		wu.maximizeTheWindow(driver);
		driver.get(URL);
		sdriver=driver;
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.loginIntoSwagLabsApp();
	}
	
	
	@AfterMethod
	public void amConfig() throws InterruptedException {
		InventoryPage ip = new InventoryPage(driver);
		ip.LogoutFromApp();
	}
	@AfterClass
	public void acConfig() {
		driver.quit();
	}
	@AfterSuite
	public void asConfig() {
		System.out.println("===============Database connection closed====================");
	}
}
