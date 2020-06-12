import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DocenteTest {

	@Test
	void test() {
		Docente d1=new Docente("zzz", "jjj", "777", "666", "789", "1/1/1998","205154",1,5000.0f);
		assertEquals(5500.0f, d1.getSueldoBruto());
		
		Docente d2=new Docente("zzz", "jjj", "777", "666", "789", "1/1/1998","205154",10,5000.0f);
		assertEquals(5500.0f, d2.getSueldoBruto());
		
		Docente d3=new Docente("zzz", "jjj", "777", "666", "789", "1/1/1998","205154",11,5000.0f);
		assertEquals(5750.0f, d3.getSueldoBruto());
		
		Docente d4=new Docente("zzz", "jjj", "777", "666", "789", "1/1/1998","205154",15,5000.0f);
		assertEquals(5750.0f, d4.getSueldoBruto());
		
		Docente d5=new Docente("zzz", "jjj", "777", "666", "789", "1/1/1998","205154",16,5000.0f);
		assertEquals(6000.0f, d5.getSueldoBruto());
		
		Docente d6=new Docente("zzz", "jjj", "777", "666", "789", "1/1/1998","205154",20,5000.0f);
		assertEquals(6000.0f, d6.getSueldoBruto());
		
		Docente d7=new Docente("zzz", "jjj", "777", "666", "789", "1/1/1998","205154",21,5000.0f);
		assertEquals(6250.0f, d7.getSueldoBruto());
		
		Docente d8=new Docente("zzz", "jjj", "777", "666", "789", "1/1/1998","205154",31,5000.0f);
		assertEquals(6250.0f, d8.getSueldoBruto());
	}

}
