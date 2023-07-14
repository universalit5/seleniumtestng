
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class SeleniumGridDemo {
    WebDriver driver ;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) throws MalformedURLException {
        switch (browser){
            case "chrome":
                driver = new ChromeDriver();

//               DesiredCapabilities cap1 = new DesiredCapabilities();
//                cap1.setBrowserName(browser);
//               // cap1.setCapability("browserName","chrome");
//                driver = new RemoteWebDriver(new URL("http://18.212.26.204:4444/wd/hub"),cap1);
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
            case "firefox":
               driver = new FirefoxDriver();

//                DesiredCapabilities cap2 = new DesiredCapabilities();
//                cap2.setBrowserName(browser);
//                driver = new RemoteWebDriver(new URL("http://18.212.26.204:4444/wd/hub"),cap2);
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
            case "edge":
               driver = new EdgeDriver();

//                DesiredCapabilities cap3 = new DesiredCapabilities();
//                cap3.setBrowserName(browser);
//                driver = new RemoteWebDriver(new URL("http://18.212.26.204:4444/wd/hub"),cap3);
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
          }


    }

    @Test
    public void testLinks(){
       driver.get("https://www.bbc.co.uk");
       WebElement e = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div[3]/div/div[2]/div/div[1]/a"));
        System.out.println(e.getText());
        System.out.println(driver.getCurrentUrl());
       assertTrue(driver.getCurrentUrl().contains("bbc"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
