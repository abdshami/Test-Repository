package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Test11 {
	
	
	WebDriver driver;

	
	@Parameters("browser")
	
	@BeforeTest
		public void beforeTest(String browser) throws InterruptedException  {
			
		      System.out.println(browser + "   khaldoun Ok" );
		   
		
		      
			  if (browser.equals("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}else if (browser.equals("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}else if (browser.equals("edge")) {
					WebDriverManager.edgedriver();
					driver = new EdgeDriver();
				}	
			 
			  

		      System.out.println("After browser 1" );
		      
			  driver.manage().window().maximize();
			  driver.get("https://www.google.com");
			  
			  System.out.println("After browser 2" );
			    
		}
		
    
	
	
	
	    @Test
	    public void testMethod(){
	        System.out.println("yes" );
			Assert.assertEquals(2, 2);
		}
	
	   
	
	

}
