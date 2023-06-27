package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utlis.CommonMethods;

public class DashBoardPage extends CommonMethods {

    @FindBy(xpath = "//a[text()='Welcome Admin']")
    public WebElement WelcomeMsg;

    public DashBoardPage(){
        PageFactory.initElements(driver,this);
    }
}
