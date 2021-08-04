package task8;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider
	public Object[][] getData() {
		
		Object [][] data = new Object [3][2];
		
		data[0][0]="mngr345660";
		data[0][1]="AsAbEhy";
		
		data[1][0]="mngr345660";
		data[1][1]="AsAbEhy";
		
		data[2][0]="mngr345660";
		data[2][1]="AsAbEhy";
		
		return data;
		
	}

}
