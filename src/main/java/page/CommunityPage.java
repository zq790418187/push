package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommunityPage extends NavBarPage {
    @FindBy(css=".panel-body .media-heading a")
    List<WebElement> CommunityList;

    public CommunityPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        wait.until(ExpectedConditions.titleContains("社团"));
    }

    public boolean clicCommunityByText(String CommunityName) {
        for (WebElement e : CommunityList){
            if (e.getText().trim().equalsIgnoreCase(CommunityName)){
                e.click();
                return true;
            }
        }
        return false;
    }
}
