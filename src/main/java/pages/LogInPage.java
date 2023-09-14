package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.WebTestBase;
import utility.Utility;

import java.io.IOException;

public class LogInPage extends WebTestBase {
    @FindBy(id = "username")
    WebElement userNameTextBox;

    @FindBy(id = "password")
    WebElement passwordTextBox;

    @FindBy(xpath = "//button[text()='Log in']")
    WebElement logInBtn;

    @FindBy(xpath = "//input[@id='rememberme']")
    WebElement rememberMeCheckBox;

    public LogInPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    public void clickOnLogInBtn(String username, String password) {
        userNameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);

        Utility.waitUntilElementToBeClickable(rememberMeCheckBox);
        logInBtn.click();

    }

}
