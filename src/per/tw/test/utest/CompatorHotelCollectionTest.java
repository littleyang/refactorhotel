package per.tw.test.utest;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import per.tw.customer.comparator.CompatorHotelCollection;
import per.tw.customer.databean.HotelCollectionBean;


public class CompatorHotelCollectionTest {

	@BeforeClass
	public static void testSetup(){
		
	}
	
	@AfterClass
	public static void testCleanup(){
		
	}
	
	@Test
	public void testCompareWhenTheTotalAffordNotEquals() {
		HotelCollectionBean beanOne = new HotelCollectionBean();
		beanOne.setHotelName("one");
		beanOne.setHotelRate(4);
		beanOne.setTotalAffordByCustomer(500.0f);
		HotelCollectionBean beanTwo = new HotelCollectionBean();
		beanTwo.setHotelName("two");
		beanTwo.setHotelRate(4);
		beanTwo.setTotalAffordByCustomer(600.0f);
		CompatorHotelCollection cp = new CompatorHotelCollection();
		cp.compare(beanOne, beanTwo);
		assertTrue("one should better than two!",cp.compare(beanOne, beanTwo)<0);
	}
	
	@Test
	public void testCompareWhenTheTotalAffordEquals() {
		HotelCollectionBean beanOne = new HotelCollectionBean();
		beanOne.setHotelName("one");
		beanOne.setHotelRate(4);
		beanOne.setTotalAffordByCustomer(500.0f);
		HotelCollectionBean beanTwo = new HotelCollectionBean();
		beanTwo.setHotelName("two");
		beanTwo.setHotelRate(5);
		beanTwo.setTotalAffordByCustomer(500.0f);
		CompatorHotelCollection cp = new CompatorHotelCollection();
		cp.compare(beanOne, beanTwo);
		assertFalse("one should better than two!",cp.compare(beanOne, beanTwo)<0);
	}

}
