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
	
	public List<String> getPageInfo() throws InterruptedException {
		List<String> pageInfo = new ArrayList<String>();
		Thread.sleep(6000);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		//driver.get("https://www.ratehawk.com/hotel/united_states_of_america/sandy/mid6375364/hyatt_house_salt_lake_citysandy/?q=172989&dates=12.10.2022-13.10.2022&guests=2&price=one&room=s-18a36ef9-1287-5da8-b1eb-682c50084b56&serp_price=hyatt_house_salt_lake_citysandy.1389.ILS.h-1eeae85f-ec39-5d45-af52-6dee43727ab9&sid=aac7719c-4ba7-43c0-9538-fa25897e6b97");
		Thread.sleep(8000);
		WebElement  rating = driver.findElement(By.xpath("//p[@class='zenroomspageperks-rating-info-total-description']"));	
		WebElement hotelName = driver.findElement(By.xpath("//*[@id=':0']//h1"));
		System.out.println("hotel name : " + hotelName.getText());
		System.out.println("rating : " + rating.getText());
		System.out.println("page url : " + url);
		pageInfo.add( hotelName.getText());
		pageInfo.add(rating.getText());
		pageInfo.add(url);
		return pageInfo;
	}

}
