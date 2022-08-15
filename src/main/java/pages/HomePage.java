package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@href='https://cointrack.ai/app/auth/login']")
    private WebElement signIn;

    @FindBy(xpath = "//a[@href='https://cointrack.ai/app/auth/sign-up']")
    private WebElement signUp;

    protected String pageUrl(){
        return "https://cointrack.ai/";
    }

    public void goToSignInPage(){
        this.signIn.click();
    }

    public void goToSignUpPage(){
            this.signUp.click();
    }
}