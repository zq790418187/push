package DOME;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

    public class dome {
    WebDriver driver;

    @BeforeClass
    public void befor(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testdome() {
        driver.get("https://testerhome.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //显示等待
        //WebDriverWait wait=new WebDriverWait(driver,30);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""))).click();
        ((ChromeDriver) driver).findElementByLinkText("登录").click();
        driver.findElement(By.cssSelector("#user_login")).sendKeys("790418187@qq.com");
        driver.findElement(By.cssSelector("#user_password")).sendKeys("zq643566");
        driver.findElement(By.cssSelector("input[name='commit']")).click();
        driver.findElement(By.cssSelector(".dropdown-toggle[aria-expanded='false']")).click();
        String actual = driver.findElements(By.cssSelector(".dropdown-menu>li")).get(0).getText();
        Assert.assertTrue(actual.equals("Ching-Ching"));
    }

    @Test
    void dome1(){
        System.out.println("1");
    }

    @AfterClass
    void after() {
            driver.quit();
        }
    }

