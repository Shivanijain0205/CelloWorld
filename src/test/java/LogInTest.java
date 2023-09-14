import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LogInPage;
import pages.MyAccountPage;
import pages.ProductPage;
import testBase.WebTestBase;

import java.io.IOException;

public class LogInTest extends WebTestBase {

    public ProductPage productPage;

    public LogInPage logInPage;

    public MyAccountPage myAccountPage;

    public LogInTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void beforeMethod() throws IOException {
        Initialization();
        productPage = new ProductPage();
        logInPage = new LogInPage();
        myAccountPage = new MyAccountPage();
    }

    @Test(priority = 0, description = "Verify LogIn with Valid Username and Password")
    public void verifyLogInWithValidUserNameAndPassword() {
        SoftAssert softAssert = new SoftAssert();
        productPage.firstAction();
        productPage.lunchBoxOption();
        productPage.categoriesOption();
        productPage.checkBox();
        productPage.chooseProduct();
        productPage.logIn();
        logInPage.clickOnLogInBtn(prop.getProperty("username"), prop.getProperty("password"));
        softAssert.assertEquals(myAccountPage.getTextMyAccount(), "My account", "Text should match");
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
