package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class HomePage {
    @FindBy(partialLinkText = "登录")
    WebElement Linklogin;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        new WebDriverWait(driver,15).until(ExpectedConditions.titleContains("TesterHome"));
    }

    public void clickLogin(){
        Linklogin.click();
        Reporter.log("点击登录链接",true);
    }
}
