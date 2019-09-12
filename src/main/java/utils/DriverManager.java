package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static WebDriver driver;
    private String property = ConfigProperties.getTestProperty("browser");

    private DriverManager(){
        if (driver == null && System.getProperty("browser").equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if (driver == null && property.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        if (driver == null && System.getProperty("browser").equals("opera")){
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }
        if (driver == null && System.getProperty("browser").equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        if(driver==null) {
            new DriverManager();
        }
        return driver;
    }
}
