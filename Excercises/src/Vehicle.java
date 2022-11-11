
import java.util.Date;

public abstract class Vehicle implements Comparable<Object> {

        private String name;
        private Boolean canFly;
        private String color;
        private Integer age;

        private Date createdAT;



        public Vehicle() {

        }


        public Vehicle(String name, boolean canFly, int age) {
            this.name = name;
            this.canFly = canFly;
            this.age = age;
            
            try
            {
                this.validate(this.name);
            }
            catch (InvalidNameExce ex)
            {
                System.out.println("Caught the exception");

                System.out.println("Exception occured: " + ex);
            }
        }

        public Vehicle(String name , boolean canFly , String color , int age) {
            this.name = name ;
            this.canFly = canFly;
            this.color = color;
            this.age = age;
            
            try
            {
                this.validate(this.name);
            }
            catch (InvalidNameExce ex)
            {
                System.out.println("Caught the exception");

                System.out.println("Exception occured: " + ex);
            }
        }

    public Vehicle(String name, Boolean canFly, String color, Integer age, Date createdAT) {
        this.name = name;
        this.canFly = canFly;
        this.color = color;
        this.age = age;
        this.createdAT = createdAT;
        
        try
        {
            this.validate(this.name);
        }
        catch (InvalidNameExce ex)
        {
            System.out.println("Caught the exception");

            System.out.println("Exception occured: " + ex);
        }
    }
    
    public abstract int compareTo(Object o);
    

     void validate(String name) throws InvalidNameExce {
        if(name.length() > 10) {
            throw new InvalidNameExce("Name must be less than 10 chars");
        }
        else {
            System.out.println("Name is Ok");
        }
    }

    public Date getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(Date createdAT) {
        this.createdAT = createdAT;
    }

    public abstract String move(int x , int y);


        public String describeMe() {
            String me = null;

            if (name != null) {
                me += "My name is " + name ;
            }

            if (canFly != null) {
                me += " I can fly (" + canFly + ") ";
            }

            if (color != null) {
                me += " my color is " + color ;
            }

            if (age != null) {
                me += " my age is " + age ;
            }

            return me;
        }


        public abstract boolean equals(Object o); 
        
       

        public Boolean getCanFly() {
            return canFly;
        }


        public void setCanFly(Boolean canFly) {
            this.canFly = canFly;
        }


        public void setAge(Integer age) {
            this.age = age;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isCanFly() {
            return canFly;
        }

        public void setCanFly(boolean canFly) {
            this.canFly = canFly;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

