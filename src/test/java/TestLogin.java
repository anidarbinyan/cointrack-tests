import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TestLogin extends BaseTest{

    private LoginPage loginPage;

    @BeforeMethod
    public void initPages(){
        loginPage = new LoginPage();
        loginPage.get();
    }

    @Test
    public void testLoginPage() throws InterruptedException {
        loginPage.login("anidarbinyan14@yahoo.com", "testPswd");
        Thread.sleep(2000);

        String actualURL = loginPage.getDriverCurrentUrl();
        String expectedURL = "https://cointrack.ai/app/dashboard";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void testLoginWithInvalidParams() {
        Assert.assertEquals("User not found", loginPage.loginInvalidParams("test@yahoo.com", "123456789"));
    }

    @Test
    public void testForgotPassword(){
        String success = loginPage.testForgotPassword("anidarbinyan18@yahoo.com");
        Assert.assertEquals("Check your email", success);
    }
}