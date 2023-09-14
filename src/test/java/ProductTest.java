import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LogInPage;
import pages.MyAccountPage;
import pages.ProductPage;
import testBase.WebTestBase;

import java.io.IOException;

public class ProductTest extends WebTestBase {
    public ProductPage productPage;
    public LogInPage logInPage;

    public MyAccountPage myAccountPage;

    public ProductTest() throws IOException {
        super();

    }

    @BeforeMethod
    public void beforeMethod() throws IOException {

        Initialization();

        productPage = new ProductPage();

        logInPage = new LogInPage();

        myAccountPage = new MyAccountPage();

    }

    @Test(priority = 0, description = "Verify Mouse Hover Action on Product Page")
    public void verifyMouseHoverAction() {
        SoftAssert softAssert = new SoftAssert();
        productPage.firstAction();
        productPage.lunchBoxOption();
        softAssert.assertTrue(productPage.lunchBoxOptionDisplay(), "The Lunch Box Web Element Should get Displayed");
        softAssert.assertAll();
    }

    @Test(priority = 1, description = "Verify Drop down and check box option")
    public void verifyDropDownAndCheckBoxOption() {
        SoftAssert softAssert = new SoftAssert();
        productPage.categoriesOption();
        productPage.checkBox();
        productPage.checkBoxOptionIsSelected();
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Verify Scroll down to choose the product")
    public void verifyScrollDownToChooseTheProduct() {
        SoftAssert softAssert = new SoftAssert();
        productPage.chooseProduct();
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
