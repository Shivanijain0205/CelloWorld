import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LogInPage;
import pages.MyAccountPage;
import pages.ProductPage;
import testBase.WebTestBase;

import java.io.IOException;

public class MyAccountTest extends WebTestBase {

    public ProductPage productPage;
    //define LogIn page
    public LogInPage logInPage;

    public MyAccountPage myAccountPage;

    public MyAccountTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void beforeMethod() throws IOException {
        Initialization();

        productPage = new ProductPage();
        logInPage = new LogInPage();
        myAccountPage = new MyAccountPage();

    }

    @Test(priority = 0, description = "Verify My Account Text")
    public void verifyMyAccountTextDisplay() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(myAccountPage.getTextMyAccount(), "My account", "Text should match");
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}


