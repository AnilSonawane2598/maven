package Base_package;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import configure_package.readconfigure;

public class Base_class {
	public static WebDriver driver;
	public static Logger logger;

	readconfigure rc = new readconfigure();
	public String username = rc.getusername();
	public String password = rc.getpassword();

	@SuppressWarnings({ "deprecation" })
	@Parameters("opendriver")
	@BeforeMethod
	public void openbrowser(String opendriver) {
		if (opendriver.equals("chrome")) {
			System.setProperty("WebDriver.Chrome.driver", rc.getchromedriver());
			driver = new ChromeDriver();
		} else if (opendriver.equals("edge")) {
			System.setProperty("Webdriver.edge.driver", rc.getedgedriver());
			driver = new EdgeDriver();
		}

		 logger = Logger.getLogger("open url");
		PropertyConfigurator.configure(
				"C:\\Users\\DELL\\eclipse-workspace\\Maven_project_practice\\src\\test\\resources\\configure_and_log4j\\log4j.properties");
		logger.info("start log");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(rc.geturl());

	}

	@AfterMethod
	public void closebrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		logger.info("close browser");

		
	}
}
