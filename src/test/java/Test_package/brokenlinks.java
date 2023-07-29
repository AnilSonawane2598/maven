package Test_package;

import java.io.IOException;

import org.testng.annotations.Test;

import Base_package.Base_class;
import Page_package.broken_links;

public class brokenlinks extends Base_class {
	@Test
	public void printalllink() throws IOException {

		broken_links bl = new broken_links(driver);
		bl.links();

	}
}
