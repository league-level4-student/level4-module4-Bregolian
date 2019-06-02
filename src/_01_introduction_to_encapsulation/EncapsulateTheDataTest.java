package _01_introduction_to_encapsulation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EncapsulateTheDataTest {

	@Test
	void test() {
		EncapsulateTheData eTD = new EncapsulateTheData();
		eTD.setItemsReceived(-5);
		assertEquals(0,eTD.getItemsReceived());
	}
}
