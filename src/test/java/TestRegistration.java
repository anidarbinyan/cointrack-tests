import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class TestRegistration extends BaseTest{

    private RegistrationPage testRegistration;

    @BeforeMethod
    public void initPages(){
        testRegistration = new RegistrationPage();
    }

    @Test
    public void testRegistration(){
        testRegistration.get();
        String success = testRegistration.registration("anidarbinyan10@yahoo.com", "testPswd");
        Assert.assertEquals("Sign Up success", success);
    }
}