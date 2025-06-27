package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class SimpleFormTest {

    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() throws Exception {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("138");


        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", "premkumarreddykarri668");
        ltOptions.put("accessKey", "LT_hWR6qVDp4vQM0SWlKgoAAwTtZ2vY9F6ehPmsqw3m5C1GOxy");
        ltOptions.put("project", "Selenium Playground Project");
        ltOptions.put("build", "Selenium 101 Build");
        ltOptions.put("name", "SimpleFormTest");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-java");
        ltOptions.put("console", true);
        ltOptions.put("network", true);
        ltOptions.put("video", true);
        ltOptions.put("visual", true);

        browserOptions.setCapability("LT:Options", ltOptions);


        driver.set(new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions));
    }

    @Test
    public void testSimpleFormScenario() {
        WebDriver drv = driver.get();

        drv.get("https://www.lambdatest.com/selenium-playground");


        drv.findElement(By.linkText("Simple Form Demo")).click();

        String currentUrl = drv.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("simple-form-demo"), "URL validation failed!");

        String message = "Welcome to LambdaTest";
        drv.findElement(By.id("user-message")).sendKeys(message);
        drv.findElement(By.id("showInput")).click();

        WebDriverWait wait = new WebDriverWait(drv, Duration.ofSeconds(5));

        WebElement outputMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String actualMessage = outputMessage.getText();
        Assert.assertEquals(actualMessage, message, "Displayed message does not match input!");
    }
    @AfterMethod
    public void tearDown() {
        driver.get().quit();
    }
}
