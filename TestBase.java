package Qa.demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase extends PageBase {

	
	@BeforeClass
	public void Setup() {
		 intSetp("http://demoqa.com/");
	}
	
	@AfterClass
	public void Closedriv() {
		tearDownp();
	}
}
