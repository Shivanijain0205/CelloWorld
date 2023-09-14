package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.WebTestBase;
import utility.Utility;

import java.io.IOException;

public class MyAccountPage extends WebTestBase {
    @FindBy(xpath = "//h1[text()='My account']")
    WebElement myAccountText;

    public MyAccountPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    public String getTextMyAccount() {
        return Utility.getTextofElement(myAccountText);
    }


}
