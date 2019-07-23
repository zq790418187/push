package DOME;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class headless {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src\\main\\drivers\\chromedriver.exe");
        ChromeOptions option=new ChromeOptions();
        option.addArguments("--headless");
        WebDriver driver=new ChromeDriver(option);

        driver.get("https://testerhome.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.quit();
    }
}
