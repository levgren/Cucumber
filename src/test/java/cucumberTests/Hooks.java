package cucumberTests;

import org.junit.After;
import pageObjects.AbstractClass;

public class Hooks {
    @After
    public void closeDriver(){
        new AbstractClass().closeDriver();
    }
}
