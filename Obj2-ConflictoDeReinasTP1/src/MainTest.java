import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void test() {	
		Scanner leo=new Scanner(System.in);
			
		try{
			leo=new Scanner(new File("reinas.out"));
			
			assertEquals("1 5",leo.nextLine());
			assertEquals("1 5",leo.nextLine());
			assertEquals("1 5",leo.nextLine());
			assertEquals("1 5",leo.nextLine());
			assertEquals("7 1 2 3 4 6 7 8",leo.nextLine());
			assertEquals("1 5",leo.nextLine());
			assertEquals("1 5",leo.nextLine());
			assertEquals("1 5",leo.nextLine());
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(leo!=null) leo.close();
		}		
	}
}



