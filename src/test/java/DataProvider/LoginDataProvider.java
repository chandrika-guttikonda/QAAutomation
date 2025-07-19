package DataProvider;

import org.testng.annotations.DataProvider;

import Utilities.ExcelUtils;

public class LoginDataProvider {
	 @DataProvider(name = "loginData")
	    public static Object[][] loginData() throws Exception {
	        return ExcelUtils.readExcelData("TestData/UserData.xlsx", "Sheet1");
	    }

}
