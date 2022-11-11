


public class Car extends Vehicle implements Description    {

	private int numOfWheels;


	public Car(String name, boolean canFly, String color, int age ,int numOfWheels) {
		super(name, canFly, color, age);
		this.numOfWheels = numOfWheels;
	}
	

	public int getNumOfWheels() {
		return numOfWheels;
	}

	public void setNumOfWheels(int numOfWheels) {
		this.numOfWheels = numOfWheels;
	}


	@Override
	public String describe(boolean capitalize) {
	   if(capitalize) {
		   return capitalize(this.getName()) + "  " + capitalize(this.getCanFly() + "") + " " + capitalize(this.getColor()) + " " + capitalize(this.getAge() + "") + " " + numOfWheels ;
	   }
		return 	this.getName() + "  " + this.getCanFly()  + " " + this.getColor() + " " + this.getAge()  + " " + this.getNumOfWheels() ;

	}
	
	public String capitalize(String str) {
		     String first = str.substring(0,1);  
	         String afterfirst=str.substring(1);  
	         return first.toUpperCase() + afterfirst;  
	}


	@Override
	public String move(int x, int y) {
		
		return  "This car move to (" + x + "," + y +") point";
	}


	@Override
	public boolean equals(Object o) {
		{
      	  if (this == o)
      	     return true;
      	  if (o == null)  // this extra check is needed to avoid a NPE
      	    return false;
    
      	    if(o.getClass() == this.getClass()) {
      	        Car c = (Car) o;
      	    	if(this.getName().equals(c.getName())){
      	    		if(this.getCanFly() == c.getCanFly()){
      	    			if(this.getColor().equals(c.getColor())){
      	    				if(this.getAge() == c.getAge()){
      	    					if(this.getNumOfWheels() == c.getNumOfWheels()){
      	    						return true;
      	    					}
      	    				}
      	    			}
      	    		}
      	    		
      	    	}
      	    			
      	    			
      	    }
      	  }

      	  return false;
    }

	public int compareTo(Object o){ 
		if(this.equals(o)) {
    	   return 1;
       }else return 0;
    }
	
	public String toString() {
		return this.getName();
	}
	
	
}