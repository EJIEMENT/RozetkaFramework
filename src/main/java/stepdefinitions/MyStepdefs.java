package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import manager.ConfigManager;
import manager.PageFactoryManager;
import manager.WebDriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class MyStepdefs {
    PageFactoryManager pageFactoryManager;

    @Before
    public void testSetUp() {
        pageFactoryManager = new PageFactoryManager();
    }

    @Given("User opens home page page")
    public void userOpensHomePagePage() {
        WebDriverSingleton.getInstance().get(ConfigManager.getInstance().getRozetkaUrl());
    }

    @And("User find item by {string}")
    public void userFindItemByItemName(String item) {
        pageFactoryManager.geTHomePage().findItemByName(item);

    }

    @And("User input item {string}")
    public void userInputItemModel(String model) {
        pageFactoryManager.getComputersAndLaptops()
                .inputItemModel(model);
    }

    @And("User select the found product {string}")
    public void userSelectTheFoundProduct(String itemModel) {
        pageFactoryManager.getComputersAndLaptops()
                .selectFirstProduct(itemModel);
    }

    @And("User click on first product in list")
    public void userClickOnFirstProductInList() {
        pageFactoryManager.getCatalogPage()
                .clickOnFindProduct();
    }

    @And("User click on buy button")
    public void userClickOnBuyButton() {
        pageFactoryManager.getProductPage()
                .clickOnByButton();
    }

    @Then("User checks the total product {string}")
    public void userChecksTheTotalProductPrice(String price) {
        Assert.assertTrue(pageFactoryManager.getBucketPage().getItemPrice() < Integer.parseInt(price));
    }

    @After
    public void tearDown() {
        File scrFile = ((TakesScreenshot) WebDriverSingleton.getInstance()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(ConfigManager.getInstance().getScreenshotsFilePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        WebDriverSingleton.dropDriver();
    }
}
