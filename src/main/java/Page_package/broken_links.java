package Page_package;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class broken_links {
	public WebDriver driver;

	public broken_links(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "a")
	List<WebElement> alllinks;
	int crashlink = 0;

	public void links() throws IOException {
		alllinks.addAll(driver.findElements(By.tagName("img")));
		System.out.println("total links-->" + alllinks.size());
		List<WebElement> activelink = new ArrayList<WebElement>();

		for (int i = 0; i < alllinks.size(); i++) {
			if (alllinks.get(i).getAttribute("href") != null
					&& (!alllinks.get(i).getAttribute("href").contains("javascript"))) {
				activelink.add(alllinks.get(i));
			}
		}
		System.out.println("active links -->" + activelink.size());

		for (int j = 0; j < activelink.size(); j++) {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection conection = (HttpURLConnection) new URL(activelink.get(j).getAttribute("href"))
					.openConnection();
			conection.connect();
			@SuppressWarnings("unused")
			String responce = conection.getResponseMessage();
			int statuscode = conection.getResponseCode();
			if (conection.getResponseCode() >= 400) {
				System.out.println(
						statuscode + "-->" + activelink.get(j).getAttribute("href") + "---> the link is broken");
				crashlink++;
			} else {
				System.out.println(
						statuscode + "-->" + activelink.get(j).getAttribute("href") + "---> the link is valid");
			}

		}
		System.out.println("total number of crashlink is---->" + crashlink);

	}
}
