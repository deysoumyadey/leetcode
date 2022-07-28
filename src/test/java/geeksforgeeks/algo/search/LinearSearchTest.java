package geeksforgeeks.algo.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinearSearchTest {
	
	LinearSearch ls;
	
	@BeforeEach
	void setUp() {
		ls = new LinearSearch();
	}

	@Test
	void test() {
		assertEquals(2, ls.findByLinearSearch(new int[] {1,2,3,5,3,5,6,8}, 3));
	}
	
	@Test
	void negetiveTest() {
		assertNotEquals(1, ls.findByLinearSearch(new int[] {1,2,3,5,3,5,6,8}, 3));
	}

}
