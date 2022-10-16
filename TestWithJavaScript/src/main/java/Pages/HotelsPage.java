package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelsPage {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	public HotelsPage(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}
	
	public void firstChoiseHotel() throws InterruptedException {
		Thread.sleep(8000);
		WebElement hotelLink = driver.findElement(By.xpath("//div[@class='hotels-inner']//a"));
		String nextUrl = hotelLink.getAttribute("href");
		driver.get(nextUrl);
	}
}
