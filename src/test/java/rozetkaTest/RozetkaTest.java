package rozetkaTest;

import manager.JacksonReader;
import manager.PageFactoryManager;
import manager.WebDriverSingleton;
import model.ProductModel;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class RozetkaTest {
    private PageFactoryManager pageFactoryManager;

    @DataProvider(name = "xmlData", parallel = true)
    public static Object[][] dataProviderMethod1() {
        List<ProductModel> users = JacksonReader.readListDataFromXml("src/main/resources/testData.xml");
        Object[][] objects = new Object[users.size()][3];
        for (int i = 0; i < users.size(); i++) {
            objects[i][0] = users.get(i).getItem();
            objects[i][1] = users.get(i).getModel();
            objects[i][2] = users.get(i).getPrice();
        }
        return objects;
    }

    @BeforeMethod
    public void testSetUp() {
               pageFactoryManager = new PageFactoryManager();
        WebDriverSingleton.getInstance().get("https://rozetka.com.ua/");
    }

    @Test(dataProvider = "xmlData")
    public void checkProductPriceInBucket(String item, String model, Integer price) {
        pageFactoryManager.geTHomePage().findItemByName(item);
        pageFactoryManager.getComputersAndLaptops().inputItemModel(model);
        pageFactoryManager.getComputersAndLaptops().selectFirstProduct(model);
        pageFactoryManager.getCatalogPage().clickOnFindProduct();
        pageFactoryManager.getProductPage().clickOnByButton();
        assertTrue(pageFactoryManager.getBucketPage().getItemPrice() < price);

    }

    @AfterMethod
    public void tearDown() {
        File scrFile = ((TakesScreenshot) WebDriverSingleton.getInstance()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("src/main/resources/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        WebDriverSingleton.dropDriver();
    }
}
