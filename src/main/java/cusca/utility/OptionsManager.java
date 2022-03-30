package cusca.utility;

import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class OptionsManager {
	Properties prop;
	ChromeOptions chromeOptions;
	FirefoxOptions firefoxOptions;
	FirefoxProfile firefoxProf;
	
	public ChromeOptions getChromeOptions() {
		chromeOptions = new ChromeOptions();
			HashMap <String, Object> chromePrefs = new HashMap <String, Object>();
			chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
			chromePrefs.put("profile.default_content_setting_values.notifications", 2);
			chromePrefs.put("credentials_enable_service", false);
			chromePrefs.put("profile.password_manager_enabled", false);
			chromePrefs.put("plugins.always_open_pdf_externally", true);
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		chromeOptions.addArguments("--headless");
		return chromeOptions;
	}
}
