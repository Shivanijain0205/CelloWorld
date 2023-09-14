package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.WebTestBase;

import java.io.IOException;
import java.time.Duration;

public class Utility extends WebTestBase {

    public static final long IMPLICIT_WAIT = 40;

    public static final long PAGE_LOAD = 40;

    public static final long EXPLICIT_WAIT = 40;
    public static WebDriverWait wait;

    public Utility() throws IOException {
    }

    public static void waitUntilElementToBeClickable(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public static void scrollDownByPixel(int i, int i1) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,500);");

    }

    public static String getTextofElement(WebElement element) {
        return element.getText();
    }

    public static boolean isDisplayElement(WebElement element) {
        return element.isDisplayed();
    }

    public static void checkBoxElement(WebElement element) {
        element.isSelected();
    }
}
