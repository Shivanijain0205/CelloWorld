package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utility.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class WebTestBase {
    public static WebDriver driver;

    public Properties prop;


    public WebTestBase() throws IOException {
        prop = new Properties();

        FileInputStream fileInputStream;

        fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
        prop.load(fileInputStream);
    }

    public void Initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:/Users/shiva/Downloads/chrome-win64/chrome-win64/chrome.exe");
            options.addArguments("--remote-allow-origin");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/Drivers/chromedriver.exe");
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setBinary("C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe");
            edgeOptions.addArguments("--remote-allow-origins=*");
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/main/resources/Drivers/msedgedriver.exe");
            driver = new EdgeDriver(edgeOptions);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/Drivers/geckodriver.exe");
            driver = new FirefoxDriver(firefoxOptions);

        } else {
            throw new RuntimeException("Please select correct browser name");
        }
        driver.navigate().to(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.PAGE_LOAD));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.IMPLICIT_WAIT));
        driver.manage().deleteAllCookies();

    }
}
