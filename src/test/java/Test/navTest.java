package Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CommunityPage;
import page.HomePage;
import page.NavBarPage;
import utils.DateUtils;

import java.util.concurrent.TimeUnit;

public class navTest {
    WebDriver driver=null;
    @BeforeMethod
    public void befor(){
        System.out.println("启动浏览器时间"+ DateUtils.getTime());
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void notSinginTest(){
        //driver.get(FileUtils.readYmlFile(FileUtils.getPath("/config.yml"),"url"));
        driver.get("https://testerhome.com/");
        NavBarPage navBarPage=new NavBarPage(driver);
        //navBarPage.clicknavbyText(FileUtils.readYmlFile(FileUtils.getPath("/notSignln.yml"),"menu"));
        navBarPage.clicknavbyText("社团");

        CommunityPage communityPage=new CommunityPage(driver);
        communityPage.clicCommunityByText("霍格沃兹测试学院");
    }

    @AfterMethod
    public void  after(){
        driver.quit();
    }
}
