package Core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
	 
	 WebDriver driver;
	 String  newTabUrl;

	public WindowHandle(WebDriver driver , String newTabUrl) {
		this.driver = driver;
		this.newTabUrl = newTabUrl;
	}
//	public void changeTab() throws InterruptedException {
//		   String  firstTab;
//		   String  secondTab;
//		   firstTab = driver.getWindowHandle();
//		  // String url = driver.getCurrentUrl();
//		   driver.switchTo().newWindow(WindowType.TAB);
//		   secondTab = driver.getWindowHandle();
//           driver.get(url);
//           Thread.sleep(4000);
//       
//       
//	}
	
}
