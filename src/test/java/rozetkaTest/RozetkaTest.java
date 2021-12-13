package rozetkaTest;

import manager.JacksonReader;
import manager.PageFactoryManager;
import model.ProductModel;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class RozetkaTest {
    private WebDriver driver;
    private PageFactoryManager pageFactoryManager;
    private ProductModel productModel = JacksonReader.readDataFromXml("src/main/resources/testData.xml");

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        pageFactoryManager = new PageFactoryManager(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void checkProductPriceInBucket() {
        pageFactoryManager.geTHomePage().findItemByName(productModel.getItem());
        pageFactoryManager.getComputersAndLaptops().inputItemModel(productModel.getModel());
        pageFactoryManager.getComputersAndLaptops().getFirstProduct();
        pageFactoryManager.getCatalogPage().clickOnFindProduct();
        pageFactoryManager.getProductPage().clickOnByButton();
        assertTrue(pageFactoryManager.getBucketPage().getItemPrice() < productModel.getPrice());

    }

    @AfterMethod
    public void tearDown() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("src/main/resources/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
