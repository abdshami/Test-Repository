import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestCollections {
   public static void main(String[] args) {
	

       
	    Set<String> set = new HashSet();
	    set.add("khaldoun");
	    set.add("khaldoun Tak");
	    set.add("khaldoun Tamimi");
	   
	    System.out.println("Values : " + set);
	    set.add(null);
	    System.out.println("Values : " +  set);
	    System.out.println("is allow duplicates. ? " + set.add("khaldoun"));
	    System.out.println("Values : " +  set);
	  
	    //--------------------------------------------------------------------------------------------
	    
        List<Integer> arrList1 = new ArrayList<Integer>();

        for (int i = 1; i <= 5; i++) {
        	arrList1.add(i);
        }
        
        System.out.println(arrList1);

        arrList1.remove(3);

        System.out.println(arrList1);

        for (int i = 0; i < arrList1.size(); i++) {
            System.out.print(arrList1.get(i) + " ");
        }
    
	    
   }
	    


}
