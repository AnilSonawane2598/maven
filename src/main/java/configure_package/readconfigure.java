package configure_package;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class readconfigure {
	Properties pro;

	public readconfigure() {
		String path = "C:\\Users\\DELL\\eclipse-workspace\\Maven_project_practice\\src\\test\\resources\\configure_and_log4j\\Configure.properties";
		File s = new File(path);
		pro = new Properties();
		try {
			FileInputStream file = new FileInputStream(s);
			try {
				pro.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException a) {
			System.out.println(a.getMessage());
			a.printStackTrace();
		}
	}

	public String getchromedriver() {
		return pro.getProperty("chromedriver");
	}

	public String getedgedriver() {
		return pro.getProperty("edgedriver");
	}

	public String geturl() {
		return pro.getProperty("mainurl");

	}

	public String getusername() {
		return pro.getProperty("user");

	}

	public String getpassword() {
		return pro.getProperty("pass");

	}
}
