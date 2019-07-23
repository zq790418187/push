package DOME;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class dome2 {
    WebDriver driver;

    @BeforeMethod
    public void befor(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void handleTest() {
        driver.get("https://sh.lianjia.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector(".announce-btn")).click();
        //切换窗口
        String handle1=driver.getWindowHandle();
        WebElement element=driver.findElement(By.cssSelector(".home-nav a"));
        //滚动
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElements(By.cssSelector(".home-nav a")).get(0).click();
        String handle2=driver.getWindowHandle();
        if (!handle1.equals(handle2)){
            driver.switchTo().window(handle1);
        }
    }

    @Test
    public void alertTest() throws InterruptedException {
        driver.get("https://weibo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Thread.sleep(5000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        }

    @Test
    public void iframeTest(){
        driver.get("https://weibo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //切换到iframe（显示等待）
        new WebDriverWait(driver,30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".other_login_list iframe")));
        driver.switchTo().frame(driver.findElement(By.cssSelector(".other_login_list iframe")));

        System.out.println(driver.getPageSource());
        new WebDriverWait(driver,30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#J_Login .taobao-enter a")))
                .click();
        //退出iframe
        driver.switchTo().defaultContent();
    }

    @Test
    public void cookieTest(){
        driver.get("https://sh.lianjia.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        for(Cookie cook:driver.manage().getCookies()){
            System.out.print(cook.getName());
            System.out.println();
            System.out.print(cook.getValue());
        }

        driver.manage().deleteAllCookies();

        Cookie cookie=new Cookie("name","value","/",null);
        driver.manage().addCookie(cookie);
    }

    @Test
    public void actionTest(){
        driver.get("https://testerhome.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Actions actions=new Actions(driver);
        actions.keyDown(Keys.ENTER);//回车
        actions.sendKeys(Keys.ENTER);
    }

    @Test
    public void javascripeTest(){
        driver.get("https://testerhome.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        //修改背景颜色
        WebElement element=driver.findElement(By.cssSelector(".navbar-header"));
        String style="background:yellow";
        String js="arguments[0].setAttribute('style',arguments[1])";
        ((JavascriptExecutor)driver).executeScript(js,element,style);


        //滚动到某元素
        WebElement element1=driver.findElement(By.cssSelector(".home-icons"));
        String js1="arguments[0].scrollIntoView(true)";
        ((JavascriptExecutor)driver).executeScript(js1,element);

        //按坐标滚动
        String js2="document.documentElement.scrollTop=500";
        ((JavascriptExecutor)driver).executeScript(js2);

        //界面宽度
        String js3="return window.innerWidth";
        System.out.println(((JavascriptExecutor) driver).executeScript(js3));
        //滚动条高度
        String js4="return document.documentElement.scrollTop";
        System.out.println(((JavascriptExecutor) driver).executeScript(js4));
    }

    @Test
    public void screenTest() {
        driver.get("https://testerhome.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("E:\\pictrue\\screenshot"+ System.currentTimeMillis()+".png"));
        } catch (Exception e) {
            throw new SkipException(e.getMessage());
        }
    }

        @AfterMethod
        public void after() {
        //driver.quit();
        }
    }

