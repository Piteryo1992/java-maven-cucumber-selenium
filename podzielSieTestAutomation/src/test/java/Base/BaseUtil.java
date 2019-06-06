package Base;

import org.openqa.selenium.WebDriver;

public class BaseUtil {

    public WebDriver Driver;

    private String baseUrl = "http://serwer1925383.home.pl/osclass.3.8.0/";

    public String getBaseUrl() {
        return baseUrl;
    }
}