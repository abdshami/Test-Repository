
public class Plane extends Vehicle implements Description{
	
	private int numOfSeats;
	
	
	public Plane(String name, boolean canFly, String color, int age ,int numOfSeats) {
		super(name, canFly, color, age);
        this.numOfSeats = numOfSeats;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	@Override
	public String describe(boolean capitalize) {
	   if(capitalize) {
		   return capitalize(this.getName()) + "  " + capitalize(this.getCanFly() + "") + " " + capitalize(this.getColor()) + " " + capitalize(this.getAge() + "") + " " + numOfSeats ;
	   }
		return 	this.getName() + "  " + this.getCanFly()  + " " + this.getColor() + " " + this.getAge()  + " " + this.getNumOfSeats() ;

	}
	
	public String capitalize(String str) {
		     String first = str.substring(0,1);  
	         String afterfirst=str.substring(1);  
	         return first.toUpperCase() + afterfirst;  
	}

	@Override
	public String move(int x, int y) {
		return "This plane fly to (" + x + "," + y +") point";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	

}
