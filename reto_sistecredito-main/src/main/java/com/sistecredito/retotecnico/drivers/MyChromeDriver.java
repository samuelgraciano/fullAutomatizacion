package com.sistecredito.retotecnico.drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class MyChromeDriver {

    private ChromeDriver driver;

    private MyChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap();
        prefs.put("profile.default_content_settings.geolocation", 2);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("test-type");
        options.addArguments("start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("test-type=browser");
        options.addArguments("disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-notifications");
        options.addArguments("--user-data-dir=C:\\Users\\Juan\\AppData\\Local\\Google\\Chrome\\User Data\\");
        options.addArguments("--profile-directory=Default");
        driver = new ChromeDriver(options);
    }

    public static MyChromeDriver createDriver(){
        return new MyChromeDriver();
    }

    public ChromeDriver withSomePrefs(){
        return driver;
    }




}
