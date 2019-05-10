package SeleniumAutomation;


import SeleniumAutomation.Utils.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeClass
    public void setup(){
        Driver.init(System.getProperty("browser"));
    }

//    @BeforeClass
//    @Parameters("browser")
//    public void setup(String browser){
//        Driver.init(browser);
//    }

    @BeforeMethod
    public void openBrowser () {
        Driver.getInstance();
        Driver.getInstance().manage().deleteAllCookies();
        Driver.getInstance().manage().window().maximize();
        BasePage.setDriver(Driver.getInstance());
    }

    @AfterMethod
    public void teardown () {
        Driver.quit();
    }
}