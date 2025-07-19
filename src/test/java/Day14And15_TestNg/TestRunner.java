package Day14And15_TestNg;

import java.util.Collections;

import org.testng.TestNG;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestNG testng = new TestNG();
        testng.setTestSuites(Collections.singletonList("testng.xml"));
        testng.run();

	}

}
