package tests;

import java.util.Collections;

import org.testng.TestNG;

public class Day16_TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestNG testng = new TestNG();
		testng.setTestSuites(Collections.singletonList("testngPom.xml"));
		testng.run();

	}

}
