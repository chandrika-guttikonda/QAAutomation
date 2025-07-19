package Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	 @Override
	    public void onTestStart(ITestResult result) {
	        System.out.println("START: " + result.getName());
	    }
	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("SUCCESS: " + result.getName());
	    }
	    @Override
	    public void onTestFailure(ITestResult result) {
	        System.out.println("FAIL: " + result.getName());
	    }
	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Listener: Test skipped → " + result.getName());
	    }
}
