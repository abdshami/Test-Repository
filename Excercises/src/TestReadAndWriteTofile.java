import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestReadAndWriteTofile {

	public static void main(String[] args) throws FileNotFoundException {
		writeToFile(readFromFile());
	}
	
	public static List<Vehicle> readFromFile() throws FileNotFoundException  {  

	        File file = new File("C:\\Users\\LENOVO\\eclipse-workspace\\Test-Repository\\TestForKh.txt");
	 
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        List<String[]> stringsList = new ArrayList<String[]>();
	        List<Vehicle> vehicles = new ArrayList<Vehicle>();
	        String st;
	        String[] arr = new String[6];
	        
	        try {
				while ((st = br.readLine()) != null) {
					arr = st.split(" ");
					stringsList.add(arr);
				}

					for( int i = 0 ; i < stringsList.size() ; i++) {
						String[] arr1 = stringsList.get(i);
						String carObj = (String) arr1[0];
						String name = (String) arr1[1];
						Boolean canFly = Boolean.valueOf(arr1[2]) ;
						String color = (String) arr1[3];
						int age = Integer.valueOf(arr1[4]);
						int numOfWheels = Integer.valueOf(arr1[5]) ;
						
						switch(carObj) {
						    case "Car":
						    	Car car = new Car(name,canFly,color,age,numOfWheels);
						    	vehicles.add(car);
						    	break;
						    case "Plane":
						    	Plane plane = new Plane(name,canFly,color,age,numOfWheels);
						    	vehicles.add(plane);
                       }
					   
					}
				
			} catch (IOException e) {
			//	e.printStackTrace();
			}
	        
	        for(Vehicle v : vehicles) {
	        	System.out.println(v.getName());
	        }
	        
	        return vehicles;
	            
	    }
	
	public static void writeToFile(List<Vehicle> vehicles) {
    
		String fileContent = "";
        for(Vehicle v : vehicles) {
        	if (v instanceof Car) {
        		Car car = (Car) v;
        		fileContent +=  "Car " + car.getName() + " " + car.getCanFly() + " " + car.getColor() + " " + car.getAge() + " " + car.getNumOfWheels() + " " + car.getName() + "\n";
        	}else if(v instanceof Plane) {
        		Plane plane = (Plane) v;
        		fileContent += "Plane " + plane.getName() + " " + plane.getCanFly() + " " + plane.getColor() + " " + plane.getAge() + " " + plane.getNumOfSeats() + " " + plane.getName() + "\n";
        	}
        	
        }
		

        try {
            
            BufferedWriter writer =  new BufferedWriter(new FileWriter("C:\\Users\\LENOVO\\eclipse-workspace\\Test-Repository\\TestForKh22.txt"));
            writer.write(fileContent);
            writer.close();
        } catch (IOException e) {
          //  e.printStackTrace();
        }
    }
	
	
	
}
