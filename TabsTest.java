package Qa.demo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TabsTest extends TestBase{

	
	@Test
	public void testTabs() {
		clickElement("css","#ui-id-3", true);
		getElementkey("xPath",".//*[@id='tabs-3']/p[2]", true, "text");
		System.out.println(text);
		assertEquals(text,"The content could contain anything text page or submit form or any other HTML objects.");
	}
}
