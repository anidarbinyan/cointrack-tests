import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestHome extends BaseTest{

    private HomePage homePage;

    @BeforeMethod
    public void initPages(){
        homePage = new HomePage();
    }

    @Test
    public void testHomePage(){
        homePage.get();

        homePage.goToSignInPage();
        String actualURL = homePage.getDriverCurrentUrl();
        String expectedURL = "https://cointrack.ai/app/auth/login";
        Assert.assertEquals(actualURL, expectedURL);

        homePage.goBackPage();

        homePage.goToSignUpPage();
        String actualRegURL = homePage.getDriverCurrentUrl();
        String expectedRegURL = "https://cointrack.ai/app/auth/sign-up";
        Assert.assertEquals(actualRegURL, expectedRegURL);
    }
}