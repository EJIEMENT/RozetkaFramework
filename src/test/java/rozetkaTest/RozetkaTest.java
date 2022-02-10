package rozetkaTest;

import manager.ConfigManager;
import manager.JacksonReader;
import manager.PageFactoryManager;
import manager.WebDriverSingleton;
import model.ProductModel;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class RozetkaTest {
    private PageFactoryManager pageFactoryManager;

    @DataProvider(name = "xmlData", parallel = true)
    public static Object[][] dataProviderMethod1() {
        List<ProductModel> products = JacksonReader.readListDataFromXml(ConfigManager.getInstance().getTestDataFilePath());
        return products.stream().map(productModel -> new Object[]{productModel.getItem(), productModel.getModel(), productModel.getPrice()}).toArray(Object[][]::new);
    }

    @BeforeMethod
    public void testSetUp() {
        pageFactoryManager = new PageFactoryManager();
        WebDriverSingleton.getInstance().get(ConfigManager.getInstance().getRozetkaUrl());
    }

    @Test(dataProvider = "xmlData")
    public void checkProductPriceInBucket(String item, String model, Integer price) {
        pageFactoryManager.geTHomePage()
                .findItemByName(item);
        pageFactoryManager.getComputersAndLaptops()
                .inputItemModel(model);
        pageFactoryManager.getComputersAndLaptops()
                .selectFirstProduct(model);
        pageFactoryManager.getCatalogPage()
                .clickOnFindProduct();
        pageFactoryManager.getProductPage()
                .clickOnByButton();
        assertTrue(pageFactoryManager.getBucketPage()
                .getItemPrice() < price);
    }
    @Test
    public void negativeTest(){
        assertTrue(false);
    }

    @AfterMethod
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
