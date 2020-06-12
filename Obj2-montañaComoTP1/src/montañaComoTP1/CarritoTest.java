package montañaComoTP1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class CarritoTest {

	@Test
	void test() {
		Scanner leo=new Scanner(System.in);
		try {
			leo=new Scanner(new File("como.out"));
			
			assertEquals(475, leo.nextInt());
			assertEquals(95, leo.nextInt());
			
							
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(leo!=null) leo.close();
		}
		
	}

}
