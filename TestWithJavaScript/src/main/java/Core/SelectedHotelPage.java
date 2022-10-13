package Core;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectedHotelPage {
	WebDriver driver;
	JavascriptExecutor js;
	
	public SelectedHotelPage(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}
	
	public String[] getPageInfo() throws InterruptedException {
		String[] pageInfo = new String[3];
		Thread.sleep(6000);
		String url = driver.getCurrentUrl();
		Thread.sleep(8000);
		WebElement  rating = driver.findElement(By.xpath("//p[@class='zenroomspageperks-rating-info-total-description']"));	
		WebElement hotelName = driver.findElement(By.xpath("//*[@id=':0']//h1"));
		pageInfo[0] = hotelName.getText();
		pageInfo[1] = rating.getText();
		pageInfo[2] = url;
		return pageInfo;
	}

}
