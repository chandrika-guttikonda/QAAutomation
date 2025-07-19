package Day14And15_TestNg;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SamplePriorityAndParametersTest {
	@Test(priority = 1)
    public void openApplication() {
        System.out.println("Step 1: Open the application");
    }

    @Test(priority = 2)
    @Parameters("browser")
    public void login(String browserName) {
        System.out.println("Step 2: Login using browser: " + browserName);
    }

    @Test(priority = 3)
    public void logout() {
        System.out.println("Step 3: Logout from the application");
    }
}
