package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Testkh {

	WebDriver driver;
	Add add;
	 

	@BeforeSuite
		public void beforeTest() throws InterruptedException  {
			  add = new Add();   
		      System.out.println("browser"+ "   khaldoun Ok" );  
			 
		           System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				   driver = new ChromeDriver();
		      
//					WebDriverManager.chromedriver().setup();
//					driver = new ChromeDriver();
				
		      System.out.println("After browser 1" );
			  driver.manage().window().maximize();
			  driver.get("https://www.google.com");
			  System.out.println("After browser 2" );
			    
		}
		
	    @Test
	    public void testMethod(){
	        System.out.println("yes" );
	        add.addNums(5, 9);
			Assert.assertEquals(2, 2);
		}
	
	   
	
	

}
