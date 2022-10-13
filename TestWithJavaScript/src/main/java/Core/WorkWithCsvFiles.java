package Core;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.*;
		
public class WorkWithCsvFiles{
    
//    public static List<String[]> readDataFromCsvFile(String file){
//	ArrayList<String[]> testCases = new  ArrayList<String[]>();
//		    try {
//		        FileReader filereader = new FileReader(file);
//		        CSVReader csvReader = new CSVReader(filereader);
//		        String[] record;
//		        while ((record = csvReader.readNext()) != null) {	
//		        	testCases.add(record);
//		        }
//		        csvReader.close();
//		    }
//		    catch (Exception e) {
//		        e.printStackTrace();
//		    }
//		    return testCases;
//		}
    
    
    
    public static List<String[]> readDataFromCsvFile(String filePath) throws Exception {
		CSVReader reader = new CSVReader(new FileReader(filePath), ',');

		List<String[]> data = new ArrayList<String[]>();

		// read line by line
		String[] record = null;

		while ((record = reader.readNext()) != null  ) {
			data.add(record);
		}		
		reader.close();
		return data;
	}
	
    
    
    
	
	public static String writeToCsvFile(String filePath , List<String[]> data){
		     ArrayList<String[]> newData = (ArrayList<String[]>) data;
		    File file = new File(filePath);
		    try {
		        FileWriter outputfile = new FileWriter(file,true);
		        CSVWriter writer = new CSVWriter(outputfile);
		        writer.writeAll(newData);
		        writer.close();
		    }
		    catch (IOException e) {
		       
		        e.printStackTrace();
		    }
		    return filePath;
		}
    }
	
