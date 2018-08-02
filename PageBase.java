package Qa.demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	 public static WebDriver driver;
	    public static WebDriverWait wait;
	    public WebElement element;
	    public static String text;
	    public static boolean textb;
	
	 public void intSetp(String htt)   { 
	            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Resourses\\chromedriver.exe");
	            driver = new ChromeDriver();
	            wait = new WebDriverWait(driver, 5);
	            driver.manage().window().maximize();
	            driver.navigate().to(htt);
}
	 
	 public WebElement getObject(String select, String entr, boolean mandatory) {

	        element = null;
	        try {

	            switch (select) {

	                case "css":
	                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(entr)));
	                    element = driver.findElement(By.cssSelector(entr));
	                    break;

	                case "xPath":
	                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(entr)));
	                    element = driver.findElement(By.xpath(entr));
	                    break;
	                case "id":
	                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(entr)));
	                    element = driver.findElement(By.id(entr));
	                    break;
	                case "class":
	                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(entr)));
	                    element = driver.findElement(By.className(entr));
	                    break;
	                default:
	                    System.out.println("select only css xPath id or call");
	                    break;
	            }
	        } catch (Exception e) {
	            if (mandatory == true) {
	                System.out.println("mandatory object not found" + " " + select + " " + entr);
	            }
	        }

	        return element;
	    }

	    public void elementKeysend(String select, String entr, String entr2, boolean mandatory) {

	        clickElement(select, entr, mandatory);
	        element.sendKeys(entr2);

	    }

	    public void clickElement(String select, String entr, boolean mandatory) {
	        getObject(select, entr, mandatory);

	        try {
	            element.click();
	        } catch (Exception e) {
	            System.out.println("null object");
	        }
	    }

	    public String getElementkey(String select, String entr, boolean mandatory, String field) {
	        getObject(select, entr, mandatory);
	        try {
	            switch (field) {

	                case "class":
	                    text = (element.getAttribute("strong"));
	                    break;
	                case "text":

	                    text = element.getText();
	                    break;
	                case "display":

	                    if (element.isDisplayed()) {
	                        text = "true";
	                    } else {
	                        text = "false";
	                    }

	                    break;
	            }
	        } catch (Exception e) {
	            if (mandatory == true) {
	                System.out.println("null properties");
	            }

	        }
	        return text;
	    }
	 
	    public void tearDownp() {

	        driver.close();
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	 
}
