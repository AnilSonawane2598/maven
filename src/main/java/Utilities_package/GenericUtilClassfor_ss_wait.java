package Utilities_package;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base_package.Base_class;

public class GenericUtilClassfor_ss_wait extends Base_class {
	public static String getScreenshotAs(String testcasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String Timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.ss").format(new Date());
		String name = "-Sctreenshot-" + Timestamp;
		Path root = Paths.get(
				"C:\\Users\\DELL\\eclipse-workspace\\Maven_project_practice\\src\\test\\resources\\Screenshot_folder\\");
		String absolutpath = root.toFile().getAbsolutePath();
		System.out.println(absolutpath);
		String dest = absolutpath + testcasename + "" + name + ".jpg";
		FileUtils.copyFile(source, new File(dest));
		return dest;
	}

	public static void clickelementusingjavascript(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}

	public static WebElement waitforelement(WebDriver driver, By locator, int timeout) {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		mywait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}

}
