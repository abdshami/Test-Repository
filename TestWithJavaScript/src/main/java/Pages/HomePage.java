package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePage {

	WebDriver driver;
	JavascriptExecutor js;

	public HomePage(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
	}

	public void reserveInfo(String location , String chkIn , String chkOut) throws InterruptedException {
		
		WebElement property  = driver.findElement(By.xpath("//input[@data-testid = 'destination-input']"));
		property.sendKeys(location);
		Thread.sleep(8000);
		List<WebElement>  options = driver.findElements(By.xpath("//div[@class='Suggest_destinationTitle__1lMnV']"));
		if(options.size() > 0) {
				for(WebElement loc : options) {
					String text = (String) js.executeScript(" return arguments[0].innerText;", loc);
					if(text.contains(location)) {
						js.executeScript("arguments[0].value = '" + text + "';", property);
						Thread.sleep(3000);
						property.sendKeys(Keys.ENTER);
						break;
					}
				}
				Thread.sleep(4000);
				WebElement ChkIn  = driver.findElement(By.xpath("//div[@data-testid = 'date-start-input']"));
				WebElement ChkOut  = driver.findElement(By.xpath("//div[@data-testid = 'date-end-input']"));
				Thread.sleep(2000);
				js.executeScript("arguments[0].click();", ChkIn);
				Thread.sleep(2000);
				js.executeScript("arguments[0].innerText = '" + chkIn + "';", ChkIn);
				Thread.sleep(2000);
				js.executeScript("arguments[0].click();", ChkOut);
				Thread.sleep(2000);
				js.executeScript("arguments[0].innerText = '" + chkOut + "';", ChkOut);
				Thread.sleep(2000);
		}else {
			System.out.println("There is no results");
		}
		WebElement searchBtn = driver.findElement(By.xpath("//button[@data-testid='search-button']"));
		js.executeScript("arguments[0].click();", searchBtn);
		Thread.sleep(10000);
	}
}