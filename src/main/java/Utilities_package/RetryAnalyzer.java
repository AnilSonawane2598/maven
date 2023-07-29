package Utilities_package;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
 // create class to implement IRetryAnalyzer
// for repetitive execution of failed test cases
public class RetryAnalyzer implements IRetryAnalyzer {

	public int count = 0;
	public int limit = 1;

	public boolean retry(ITestResult result) {
		if (count < limit) {
			count++;
			return true;
		}
		return false;
	}

}
