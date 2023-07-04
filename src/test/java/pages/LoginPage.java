package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utlis.CommonMethods;

public class LoginPage extends CommonMethods {
    @FindBy(xpath="//*[@id='txtUsername']")
    public WebElement usernameField;

    @FindBy(id="txtPassword")
    public WebElement passwordField;

    @FindBy(id="btnLogin")
    public WebElement loginButton;
    @FindBy(id = "spanMessage")
    public WebElement errorMsgField;
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

}
