package pages;

import core.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegistrationPage extends BasePage{
    @FindBy(id = "email")
    private List<WebElement> email;

    @FindBy(id = "password")
    private List<WebElement> password;

    @FindBy(id = "login-btn-submit")
    private List<WebElement> signUpBtn;

    @FindBy(className = "chakra-alert__desc")
    private WebElement error;

    protected String pageUrl(){
        return "https://cointrack.ai/app/auth/sign-up";
    }

    public String registration(final String email, final String pswd){
        this.email.get(1).sendKeys(email);
        this.password.get(1).sendKeys(pswd);
        this.signUpBtn.get(1).click();
        WaitHelper.waitElementToBeVisible(error);
        return error.getText();
    }
}