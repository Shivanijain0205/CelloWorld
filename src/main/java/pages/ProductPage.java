package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.WebTestBase;
import utility.Utility;

import java.io.IOException;

public class ProductPage extends WebTestBase {
    @FindBy(xpath = "//button[@type='button']")
    WebElement firstAction;

    @FindBy(xpath = "//li[@id='menu-item-213143']")
    WebElement lunchBoxOption;

    @FindBy(xpath = "//div[@class='woof_container_inner woof_container_inner_category']//child::h4")
    WebElement categoriesOption;

    @FindBy(xpath = "//input[@name='insulated-lunch-boxes-lunch-boxes-2']")
    WebElement checkBox;

    @FindBy(xpath = "//a[text()='Max Fresh Micro Lunch Box']")
    WebElement chooseProduct;

    @FindBy(xpath = "(//a[@href='https://celloworld.com/my-account/'])[1]")
    WebElement logIn;

    public ProductPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    public void firstAction() {
        Utility.waitUntilElementToBeClickable(firstAction);
    }

    public void lunchBoxOption() {
        Utility.waitUntilElementToBeClickable(lunchBoxOption);
    }

    public void categoriesOption() {
        Utility.waitUntilElementToBeClickable(categoriesOption);
    }

    public void checkBox() {
        Utility.waitUntilElementToBeClickable(checkBox);
    }

    public void chooseProduct() {
        Utility.scrollDownByPixel(0, 500);
        Utility.waitUntilElementToBeClickable(chooseProduct);
    }

    public void logIn() {
        Utility.waitUntilElementToBeClickable(logIn);
    }

    public boolean lunchBoxOptionDisplay() {
        Utility.isDisplayElement(lunchBoxOption);
        return false;
    }

    public void checkBoxOptionIsSelected() {
        Utility.checkBoxElement(checkBox);
    }

}
