package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;
import java.util.HashMap;

public class SliderTest {

    ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    @BeforeMethod
    public void setUp() throws Exception {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("138");

        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", "premkumarreddykarri668");
        ltOptions.put("accessKey", "LT_hWR6qVDp4vQM0SWlKgoAAwTtZ2vY9F6ehPmsqw3m5C1GOxy");
        ltOptions.put("project", "Selenium 101 Project");
        ltOptions.put("build", "Selenium 101 Build");
        ltOptions.put("name", "SliderTest");
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
    public void testSliderTo100() throws InterruptedException {
        WebDriver drv = driver.get();
        drv.get("https://www.lambdatest.com/selenium-playground");
        drv.findElement(By.linkText("Drag & Drop Sliders")).click();
        WebElement slider = drv.findElement(By.xpath("//input[@type='range' and @value='15']"));
        WebElement output = drv.findElement(By.xpath("//output[@id='rangeSuccess']"));
        Actions actions = new Actions(drv);
        actions.clickAndHold(slider).moveByOffset(215, 0).release().perform();
        Thread.sleep(1000); // wait for UI to update (just to be safe)
        String actualValue = output.getText();
        Assert.assertEquals(actualValue, "95", "Slider value should be 95");
    }
    @AfterMethod
    public void tearDown() {
        driver.get().quit();
    }
}
