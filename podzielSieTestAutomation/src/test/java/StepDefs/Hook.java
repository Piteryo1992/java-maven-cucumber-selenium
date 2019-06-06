package StepDefs;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initializeTest() {
        System.out.println("Opening browser: GoogleChrome");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        base.Driver = new ChromeDriver();
    }

    @After
    public void teardownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("\nTest failed. \nClosing browser: GoogleChrome");
        } else {
            System.out.println("\nTest passed. \nClosing browser: GoogleChrome");
        }
        //base.Driver.quit();
    }
}