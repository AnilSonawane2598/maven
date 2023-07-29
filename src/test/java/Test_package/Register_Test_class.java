package Test_package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base_package.Base_class;
import Page_package.Regester_page_class;
import Utilities_package.RetryAnalyzer;

public class Register_Test_class extends Base_class {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void registerpage() throws EncryptedDocumentException, IOException, InterruptedException {
		String source = "C:\\Users\\DELL\\eclipse-workspace\\Maven_project_practice\\src\\main\\java\\Testdata_package\\namelmaneandmobiledata.xlsx";
		FileInputStream fis = new FileInputStream(source);
		Sheet data = WorkbookFactory.create(fis).getSheet("Sheet1");

		Regester_page_class rpc = new Regester_page_class(driver);
		rpc.signin();
		logger.info("sign in page");
		Thread.sleep(4000);
		String fname1 = data.getRow(0).getCell(0).getStringCellValue();
		rpc.firstname(fname1);
		logger.info("ente firstname");
		String lname1 = data.getRow(0).getCell(1).getStringCellValue();
		rpc.lastname(lname1);
		logger.info("enter last name");
		rpc.email(username);
		rpc.mobile();
		logger.info("enter mobile number");
		rpc.gendermale();

		WebElement ele = driver.findElement(By.xpath("//label[text()='Languages']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

		rpc.selectskill();
		rpc.firstpassword(password);
		rpc.confirmpassword(password);
		rpc.submitbutton();
		logger.info("submit button");
		String title = driver.getTitle();
		if (title.equals(title)) {
			Assert.assertTrue(true);
			System.out.println("correct title");
			logger.info("title is currect");
		} else {
			Assert.assertTrue(false);
			System.out.println("wrong title");
			logger.info("title is wrong");

		}
	}
}
