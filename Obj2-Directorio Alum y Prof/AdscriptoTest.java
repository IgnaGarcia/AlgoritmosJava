import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdscriptoTest {

	@Test
	void test() {
		Adscripto ad1=new Adscripto("bab", "aba", "222", "333", "321", "10/10/1998", "2014", 9.0f, 2, 5000.0f);
		assertEquals(10000.0f, ad1.getSueldoBruto(), 1.0f);
		
		Adscripto ad2=new Adscripto("bab", "aba", "222", "333", "321", "10/10/1998", "2014", 9.0f, 1, 5000.0f);
		assertEquals(5000.0f, ad2.getSueldoBruto(), 1.0f);
		
		Adscripto ad3=new Adscripto("bab", "aba", "222", "333", "321", "10/10/1998", "2014", 9.0f, 3, 5000.0f);
		assertEquals(15000.0f, ad3.getSueldoBruto(), 1.0f);
		
		Adscripto ad4=new Adscripto("bab", "aba", "222", "333", "321", "10/10/1998", "2014", 9.0f, 0, 5000.0f);
		assertEquals(0.0f, ad4.getSueldoBruto(), 1.0f);
		
		Adscripto ad5=new Adscripto("bab", "aba", "222", "333", "321", "10/10/1998", "2014", 9.0f, 4, 5000.0f);
		assertEquals(0.0f, ad5.getSueldoBruto(), 1.0f);
		
		Adscripto ad6=new Adscripto("bab", "aba", "222", "333", "321", "10/10/1998", "2014", 9.0f, 10, 5000.0f);
		assertEquals(0.0f, ad6.getSueldoBruto(), 1.0f);
	}

}
