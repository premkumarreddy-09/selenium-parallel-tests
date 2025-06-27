package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;
import java.util.HashMap;

public class InputFormTest {

    ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    @Parameters("browser")
    @BeforeMethod
    public void setUp() throws Exception {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("138");

        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", "premkumarreddykarri668");
        ltOptions.put("accessKey", "LT_hWR6qVDp4vQM0SWlKgoAAwTtZ2vY9F6ehPmsqw3m5C1GOxy");
        ltOptions.put("project", "Untitled");
        ltOptions.put("build", "Selenium 101 Build");
        ltOptions.put("name", "InputFormTest");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-java");
        ltOptions.put("console", true);
        ltOptions.put("network", true);
        ltOptions.put("video", true);
        ltOptions.put("visual", true);

        browserOptions.setCapability("LT:Options", ltOptions);

        driver.set(new RemoteWebDriver(
                new URL("https://hub.lambdatest.com/wd/hub"), browserOptions));
    }

    @Test
    public void testInputFormSubmit() {
        WebDriver drv = driver.get();
        drv.get("https://www.lambdatest.com/selenium-playground");
        drv.findElement(By.linkText("Input Form Submit")).click();


        WebElement nameField = drv.findElement(By.name("name"));

        nameField.sendKeys("Prem");
        drv.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("prem@example.com");
        drv.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Prem3331");
        drv.findElement(By.xpath("//input[@placeholder='Company']")).sendKeys("Capgemini");
        drv.findElement(By.xpath("//input[@placeholder='Website']")).sendKeys("https://example.com");
        WebElement countryDropdown = drv.findElement(By.name("country"));
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText("India");
        drv.findElement(By.xpath("//input[@placeholder='City']")).sendKeys("Hyderabad");
        drv.findElement(By.xpath("//input[@placeholder='Address 1']")).sendKeys("123 Road");
        drv.findElement(By.xpath("//input[@placeholder='Address 2']")).sendKeys("456 Lane");
        drv.findElement(By.xpath("//input[@placeholder='State']")).sendKeys("Telangana");
        drv.findElement(By.xpath("//input[@placeholder='Zip code']")).sendKeys("500001");
        drv.findElement(By.xpath("//button[text()='Submit']")).click();
        WebElement successMsg = drv.findElement(By.className("success-msg"));
        Assert.assertTrue(successMsg.getText().contains("Thanks for contacting us"),
                "Success message not found or incorrect");
    }
    @AfterMethod
    public void tearDown() {
        driver.get().quit();
    }
}

