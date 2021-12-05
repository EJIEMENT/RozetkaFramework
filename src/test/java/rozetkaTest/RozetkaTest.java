package rozetkaTest;

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

import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RozetkaTest {
    private WebDriver driver;
    private String categoriesMenu = "//ul[@class = \"menu-categories menu-categories_type_main\"]//a[contains(@class , \"menu-categories\")]";
    private String bucketLogo = "//app-buy-button";

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void checkThatUrlContainsSearchWord() {
        driver.findElements(xpath(this.categoriesMenu)).get(0).click();
        driver.findElement(xpath("//section[@class = \"portal-section\"]//a[@href = \"https://rozetka.com.ua/notebooks/c80004/\"]//img")).click();
        driver.findElements(xpath(this.bucketLogo)).stream().findFirst().get().click();
        driver.findElement(xpath("//img[@alt = \"Rozetka Logo\"]")).click();
        driver.findElements(xpath(this.categoriesMenu)).get(1).click();
        driver.findElement(xpath("//a[@href = \"https://rozetka.com.ua/mobile-phones/c80003/producer=apple/\"]")).click();
        driver.findElements(xpath(this.bucketLogo)).stream().findFirst().get().click();
        driver.findElement(xpath("//img[@alt = \"Rozetka Logo\"]")).click();
        driver.findElements(xpath(this.categoriesMenu)).get(15).click();
        driver.findElement(xpath("//a[@href = \"https://bt.rozetka.com.ua/seyfy/c163969/\"]")).click();
        driver.findElements(xpath(this.bucketLogo)).stream().findFirst().get().click();
        driver.findElement(xpath("//button[contains (@class ,\"header__button ng-star-inserted \")]")).click();
        assertEquals(driver.findElements(xpath("//li[contains (@class ,\"cart-list__item ng-star-inserted\")]")).size(), 3, "Wrong product count");
        assertTrue(Integer.parseInt(driver.findElement(xpath("//div[@class = \"cart-receipt__sum-price\"]/span[1]")).getText()) < 100000);

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
