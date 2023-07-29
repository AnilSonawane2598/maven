package Page_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_class {
	public WebDriver driver;

	public login_class(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signin;

	@FindBy(xpath = "//input[@placeholder=\"E mail\"]")
	WebElement emailid;

	@FindBy(xpath = "//input[@type=\"password\"]")
	WebElement passwordid;

	@FindBy(id = "enterbtn")
	WebElement enterbutton;

	public void signin() {
		signin.click();
	}

	public void emailid(String emailid1) {
		emailid.sendKeys(emailid1);
	}

	public void passwordid(String passid1) {
		passwordid.sendKeys(passid1);
	}

	public void enterbutton() {
		enterbutton.click();

	}

}
