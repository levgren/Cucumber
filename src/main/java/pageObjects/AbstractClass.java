package pageObjects;

import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class AbstractClass {

    protected WebDriver driver = DriverManager.getDriver();

    public void closeDriver(){
        if(driver!=null)
            driver.quit();
    }
}
