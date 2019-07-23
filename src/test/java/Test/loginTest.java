package Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

import java.util.concurrent.TimeUnit;

public class loginTest {
    WebDriver driver;
    @BeforeMethod
    public void befor(){
        //System.setProperty("webdriver.chrome.driver", "src\\main\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://testerhome.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void login(){
        HomePage homePage=new HomePage(driver);
        homePage.clickLogin();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("790418187@qq.com","zq643566");
    }

    @AfterMethod
    public void  after(){
        driver.quit();
    }
}
