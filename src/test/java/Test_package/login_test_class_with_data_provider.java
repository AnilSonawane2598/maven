package Test_package;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base_package.Base_class;
import Page_package.login_class;
import Utilities_package.RetryAnalyzer;
import Utilities_package.exceldatautil;

public class login_test_class_with_data_provider extends Base_class {
	@Test(dataProvider = "excel", retryAnalyzer = RetryAnalyzer.class)

	public void log_in(String userdata, String passdata, String expected) {
		login_class lc = new login_class(driver);
		lc.signin();
		lc.emailid(userdata);
		lc.passwordid(passdata);
		lc.enterbutton();

		String title = driver.getTitle();
		if (expected.equals("valid")) {
			if (title.equals(title)) {
				Assert.assertFalse(true);
			} else {
				Assert.assertFalse(false);
			}
		} else if (expected.equals("invalid")) {
			if (title.equals(title)) {
				Assert.assertFalse(false);
			} else {
				Assert.assertFalse(true);
			}
		}
	}

	@DataProvider(name = "excel")
	public String[][] exceldataprovider() throws IOException {
		String path = "C:\\Users\\DELL\\eclipse-workspace\\Maven_project_practice\\src\\main\\java\\Testdata_package\\multipledata.xlsx";
		int rownum = exceldatautil.getrowcount(path, "Sheet1");
		int colnum = exceldatautil.getcellcount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colnum];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				logindata[i - 1][j] = exceldatautil.getcelldata(path, "Sheet1", i, j);
			}
		}
		return logindata;

	}

}
