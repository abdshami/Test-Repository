package Core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;

public class TakeScreenShot {
	
	WebDriver driver;
	public TakeScreenShot(WebDriver driver) {
		this.driver = driver;
	}
	
	public void takeScreenShot(String filePath) throws IOException, InterruptedException {
		TakesScreenshot scrShot =((TakesScreenshot) this.driver);
		Thread.sleep(1000);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(filePath);
		FileUtils.copyFile(SrcFile, DestFile);
		Path content = Paths.get(filePath);
		try (InputStream is = Files.newInputStream(content)){
			Allure.addAttachment("HotelImage", is);
		}catch(Exception e){
			e.printStackTrace();
		}
				
		
	}
}

