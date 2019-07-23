package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPage {
    @FindBy(id="user_login")
    WebElement Username;
    @FindBy(id="user_password")
    WebElement Password;
    @FindBy(css="input[name='commit']")
    WebElement loginbutton;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void inputUsername(String username) {
        Username.clear();
        Username.sendKeys(username);
        Reporter.log("输入用户名",true);
    }
    public void inputPassword(String password) {
        Password.clear();
        Password.sendKeys(password);
        Reporter.log("输入密码",true);
    }
    public void clickLogin(){
        loginbutton.click();
        Reporter.log("点击登录按钮",true);
    }

    public void login(String username,String password){
        inputUsername(username);
        inputPassword(password);
        clickLogin();
    }
}
