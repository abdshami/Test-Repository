package Core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.HotelsPage;
import Pages.SelectedHotelPage;

public class TestHotelsReservation {
	
	WebDriver driver;
	JavascriptExecutor js;
	static String csvfilePath;
	List<String[]> hotelsInfo;
	String[] headers;
	TakeScreenShot takeShot; 
	
	@Parameters("csvfilePath")
	@BeforeSuite
	public void BeforeSuite(String csvfilePath){
		hotelsInfo = new ArrayList<String[]>();	
		TestHotelsReservation.csvfilePath = csvfilePath;
		driver = OpenBrowser.openFFWithOptions();
		driver.manage().window().maximize();
		takeShot = new TakeScreenShot(driver);
		headers = new String[6];
		headers[0] = "Hotel name";
		headers[1] = "Rating";
		headers[2] = "Hotel Url";
		headers[3] = "City";
		headers[4] = "Check In";
		headers[5] = "Check out";
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		System.out.println("before method 1 ");
		driver.get("https://www.ratehawk.com");
		Thread.sleep(10000);
		System.out.println("before method 2");
		js = (JavascriptExecutor) driver;
		System.out.println("before method 3");
	}
	
	
	@DataProvider
	public static Object[][]  getCsvData() throws Exception{
		List<String[]>  lines = WorkWithCsvFiles.readDataFromCsvFile(csvfilePath);
		lines.remove(0);
		Object[][] data = new Object[lines.size()][lines.get(0).length];
		int i = 0;
		for(String[] line : lines) {
			data[i]  = line;
		    i++; 
		}
		return data;
	}
	

	
	@Test(dataProvider = "getCsvData")
	public void testCsvDataString(String location, String chkIn, String chkOut) throws InterruptedException, IOException {
		System.out.println("dataProvider");
		String[] pageInfo = new String[3];
		String[] rawInfo = new String[6];
		HomePage homePage = new HomePage(driver,js);
		homePage.reserveInfo(location,chkIn,chkOut);
		HotelsPage hotelsPage = new HotelsPage(driver,js);
		hotelsPage.firstChoiseHotel();
		SelectedHotelPage selectedHotelPage = new SelectedHotelPage(driver,js);
		pageInfo = selectedHotelPage.getPageInfo();
		takeShot.takeScreenShot(".//src//test//resources//"+ pageInfo[0] + "hotel Image.png");

       if (pageInfo[0] != null) {
		        rawInfo[0] = pageInfo[0];
				rawInfo[1] = pageInfo[1];
				rawInfo[2] = pageInfo[2];
				rawInfo[3] = location;
				rawInfo[4] = chkIn;
				rawInfo[5] = chkOut;
       }else {
	    	    rawInfo[0] = "Null";
				rawInfo[1] = "Null";
				rawInfo[2] = "Null";
				rawInfo[3] = "Null";
				rawInfo[4] = "Null";
				rawInfo[5] = "Null";
	    	    System.out.println("There is no hotel data - sorry");
       }
       hotelsInfo.add(rawInfo);
	}

	@AfterSuite
	public void afterSuite() throws InterruptedException {
		WorkWithCsvFiles.writeDataLineByLine("hotelsInfo.csv", hotelsInfo, headers);
	}
	
	

}
