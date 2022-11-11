import javax.naming.InvalidNameException;

public class TestComparapleAndEqualsObjects {
	
    public static void main(String args[])
    {
         Car car1 = new Car("mercedes", false, "red" , 7 , 4);
         
         Car car2 = new Car("mercedes1", false, "blue" , 5 , 6);
         
         Car car3 = new Car("mercedes1", false, "blue" , 5 , 6);
         
         Object object1 = new Object();
         

         System.out.println(Comp(car1,car1));
         
         System.out.println(Comp(car1,car2));
         
         System.out.println(Comp(car2,car3));
         
         System.out.println(Comp(car3,car3));
         
         
         
    }
    
    public static boolean Comp(Vehicle v1 , Vehicle v2) {
    	if (v1.compareTo(v2) == 1){
            return true;
         }else {
        	 return false;
         }
    }

}
