package pages;

import core.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-btn-submit")
    private WebElement loginBtn;

    @FindBy(className = "chakra-alert__desc")
    private WebElement error;

    @FindBy(xpath = "//button[contains(text(), 'Forgot Password?')]")
    private WebElement forgotPass;

    @FindBy(xpath = "//button/p[contains(text(), 'Recover Password')]")
    private WebElement recoveryBtn;

    protected String pageUrl(){
        return "https://cointrack.ai/app/auth/login";
    }

    public void login(final String email, final String pswd){
        this.email.sendKeys(email);
        this.password.sendKeys(pswd);
        this.loginBtn.click();
    }

    public String loginInvalidParams(final String email, final String pswd){
        this.login(email, pswd);
        WaitHelper.waitElementToBeVisible(error);
        return error.getText();
    }

    public String  testForgotPassword(final String email){
        this.forgotPass.click();
        this.email.sendKeys(email);
        this.recoveryBtn.click();
        WaitHelper.waitElementToBeVisible(error);
        return error.getText();
    }
}