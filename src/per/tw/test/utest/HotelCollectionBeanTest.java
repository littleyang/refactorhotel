package per.tw.test.utest;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import per.tw.customer.databean.HotelCollectionBean;

public class HotelCollectionBeanTest {

	
	@BeforeClass
	public static void testSetup(){
		
	}
	
	@AfterClass
	public static void testCleanup(){
		
	}
	
	@Test
	public void testGetTotalAffordByCustomer() {
		HotelCollectionBean hcb = new HotelCollectionBean();
		hcb.setTotalAffordByCustomer(500.0f);
		assertNotNull("should not null when get the total afford!", hcb.getTotalAffordByCustomer());
	}

	@Test
	public void testSetTotalAffordByCustomer() {
		HotelCollectionBean hcb = new HotelCollectionBean();
		hcb.setTotalAffordByCustomer(500.0f);
		assertNotNull("should not null when set the total afford!", hcb.getTotalAffordByCustomer());
	}

	@Test
	public void testGetHotelName() {
		HotelCollectionBean hcb = new HotelCollectionBean();
		hcb.setHotelName("hoteltest");
		assertEquals("should do the right when set and get the name", "hoteltest", hcb.getHotelName());
	}

	@Test
	public void testSetHotelName() {
		HotelCollectionBean hcb = new HotelCollectionBean();
		hcb.setHotelName("hoteltest");
		assertEquals("should do the right when set and get the name", "hoteltest", hcb.getHotelName());
	}

	@Test
	public void testGetHotelRate() {
		HotelCollectionBean hcb = new HotelCollectionBean();
		hcb.setHotelRate(5);
		assertEquals("should be right set and set the hotel rate!", 5, hcb.getHotelRate(), 0);
	}

	@Test
	public void testSetHotelRate() {
		HotelCollectionBean hcb = new HotelCollectionBean();
		hcb.setHotelRate(5);
		assertEquals("should be right set and set the hotel rate!", 5, hcb.getHotelRate(), 0);
	}

}
