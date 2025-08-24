package swagLabs.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class WebDriverUtility {
	FileUtility fu = new FileUtility();
	public void openBrowser() throws IOException {
		WebDriver driver;
		String BROWSER = fu.readDataFromPropertiesFile("browser");
		String URL = fu.readDataFromPropertiesFile("url");
		switch(BROWSER) {
		case "chrome":driver = new ChromeDriver();break;
		case "edge":driver = new EdgeDriver();break;
		case "firefox":driver = new FirefoxDriver();break;
		default:driver =new EdgeDriver();
		}
		driver.get(URL);
	}
	public void maximizeTheWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void addImplicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void ClickOnElement(WebElement ele,WebDriver driver) {
		Actions act = new Actions(driver);
		act.click(ele).perform();
	}
	public void SwitchToWindowByURL(WebDriver driver,String URL) {
		Set<String> childwins = driver.getWindowHandles();
		for (String win : childwins) {
			if (driver.getCurrentUrl().contains(URL)) {
				driver.switchTo().window(win);
				break;
			}
		}
	}
	
	public void enterInputIntoTextField(WebDriver driver,WebElement ele,String text) {
		Actions act = new Actions(driver);
		act.sendKeys(ele,text).perform();
	}
	public String captureScreenShot(WebDriver driver,String ssname) {
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(".\\ScreenShots\\"+ssname+".png");
		try {
			FileHandler.copy(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return des.getAbsolutePath();
	}
}
