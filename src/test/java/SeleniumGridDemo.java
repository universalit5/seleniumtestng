

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class SeleniumGridDemo {
    WebDriver driver ;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser)  {
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless"));
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");

                ChromeOptions co = new ChromeOptions();
                co.setHeadless(isHeadless);
                driver = new ChromeDriver(co);
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fo = new FirefoxOptions();
                fo.setHeadless(isHeadless);
                driver = new FirefoxDriver(fo);
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
               driver = new EdgeDriver();
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
        System.out.println("bor");
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
