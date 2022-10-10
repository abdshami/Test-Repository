package Core;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestKh {
	
	@Test
	public void beforeSuite()  {
    	System.out.println("khaldoun Nono Yes");
    	Assert.assertEquals(Math.add(5, 5),10);
    }
	
	

}
