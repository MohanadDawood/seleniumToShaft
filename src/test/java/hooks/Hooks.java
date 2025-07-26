package hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class Hooks {

    @Before
    public void setup() {
        System.out.println(">>> [HOOK] Setting up driver");
        DriverFactory.initDriver();
    }

    @After
    public void tearDown() {
        System.out.println(">>> [HOOK] Quitting driver");
        DriverFactory.quitDriver();
    }
}
