package Core;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestHotelsReservation {
	
	WebDriver driver;
	JavascriptExecutor js;
	static String csvfilePath;
	
	@Parameters("csvfilePath")
	@BeforeSuite
	public void BeforeSuite(String csvfilePath){
		TestHotelsReservation.csvfilePath = csvfilePath;
		driver = OpenBrowser.openchromeWithOptions();
		driver.manage().window().maximize();
		
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		driver.get("https://www.ratehawk.com/");
		js = (JavascriptExecutor) driver;
		Thread.sleep(10000);
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
		   for(String  s :  line) {
			   System.out.print(s + "  ");
		   }
		   System.out.println();
		}
		return data;
	}
	

	
	@Test(dataProvider = "getCsvData")
	public void testCsvDataString(String location, String chkIn, String chkOut) throws InterruptedException {
		HomePage homePage = new HomePage(driver,js);
		homePage.reserveInfo(location,chkIn,chkOut);
		HotelsPage hotelsPage = new HotelsPage(driver,js);
		hotelsPage.firstChoiseHotel();
		SelectedHotelPage selectedHotelPage = new SelectedHotelPage(driver,js);
		selectedHotelPage.getPageInfo();
	}
//	@Test
//	public void testReserve() throws InterruptedException {
//		
//	}

}
