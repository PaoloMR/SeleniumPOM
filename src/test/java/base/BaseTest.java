package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverManager;
import utils.Log;
import utils.PropertyReader;

public class BaseTest extends DriverManager {
    public WebDriver driver;
    PropertyReader pr = new PropertyReader();

    public  BaseTest(){
        this.driver = super.getDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        try{
            if(PropertyReader.readItem("browser").equalsIgnoreCase("Chrome")){
                String projectPath = System.getProperty("user.dir");
                System.setProperty("webdriver.chrome.driver", projectPath+"//drivers/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
            else {
                try{
                    throw new Exception("Browser Driver is not supported");
                }
                catch (Exception e)
                {
                    Log.error("No Compatible browser found", e);
                }
            }
        }catch (Exception e)
        {
            Log.error("Browser Launch error", e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp(){
        driver.quit();
    }
}
