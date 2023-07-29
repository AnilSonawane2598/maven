package Page_package;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Regester_page_class {
	public static WebDriver driver;

	@SuppressWarnings("static-access")
	public Regester_page_class(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "enterimg")
	WebElement clickonsignin;

	@FindBy(xpath = "//input[@placeholder=\"First Name\"]")
	WebElement firstname;

	@FindBy(xpath = "//input[@placeholder=\"Last Name\"]")
	WebElement lastname;

	@FindBy(xpath = "//input[@type=\"email\"]")
	WebElement email;

	@FindBy(xpath = "//input[@type=\"tel\"]")
	WebElement mobile;

	@FindBy(xpath = "//input[@value=\"Male\"]")
	WebElement gendermale;

	@FindBy(xpath = "//select[@type=\"text\"]//option")
	List<WebElement> selectskill;

	@FindBy(xpath = "//input[@id=\"firstpassword\"]")
	WebElement firstpassword;

	@FindBy(id = "secondpassword")
	WebElement confirmpassword;

	@FindBy(id = "submitbtn")
	WebElement submitbutton;

	String data = "Android";

	public void signin() {
		clickonsignin.click();
	}

	public void firstname(String fname) {
		firstname.sendKeys(fname);
	}

	public void lastname(String lname) {
		lastname.sendKeys(lname);
	}

	public void email(String email1) {
		email.sendKeys(email1);
	}

	public void mobile() {
		mobile.sendKeys("7089989908");
	}

	public void gendermale() {
		gendermale.click();
	}

	public void selectskill() {
		System.out.println("Total size-->" + selectskill.size());
		for (int i = 0; i < selectskill.size(); i++) {
			if (selectskill.get(i).getText().equals(data))
				selectskill.get(i).click();
		}

	}

	public void firstpassword(String fpass) {
		firstpassword.sendKeys(fpass);
	}

	public void confirmpassword(String cpass) {
		confirmpassword.sendKeys(cpass);
	}

	public void submitbutton() {
		submitbutton.click();
	}

}
