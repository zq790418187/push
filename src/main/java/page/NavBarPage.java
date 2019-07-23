package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NavBarPage {
    WebDriver driver;
    WebDriverWait wait;
    long time=30;

    @FindBy(css="#main-nav-menu .nav li")
    List<WebElement> navList;

    public NavBarPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,time);
        PageFactory.initElements(driver,this);
    }

    public boolean clicknavbyText(String nume) {
        for (WebElement e : navList){
            if (e.getText().trim().equalsIgnoreCase(nume)){
                e.click();
                return true;
            }
        }
        return false;
    }
}
