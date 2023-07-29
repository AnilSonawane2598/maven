package Test_package;

import org.testng.annotations.Test;

import Base_package.Base_class;
import Page_package.login_class;
import Utilities_package.RetryAnalyzer;

public class login_test_class extends Base_class {
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void log_in() {
		login_class lc = new login_class(driver);
		lc.signin();
		lc.emailid(username);
		lc.passwordid(password);
		lc.enterbutton();

	}

}
