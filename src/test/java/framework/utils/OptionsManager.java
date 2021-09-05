package framework.utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static framework.utils.Utils.applyDefaultIfMissing;

public class OptionsManager {
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        if (Boolean.parseBoolean(applyDefaultIfMissing(System.getProperty("headless"),
                "false"))) {
            options.addArguments("--headless");
        }
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-insecure-localhost");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking",
                "enable-automation"));
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile", false);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        options.setProfile(profile);
        return options;
    }
}
