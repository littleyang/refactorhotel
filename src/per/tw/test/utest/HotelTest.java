package per.tw.test.utest;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import per.tw.model.customer.Customer;
import per.tw.model.hotel.Hotel;


import static org.junit.Assert.*;


public class HotelTest {

	@BeforeClass
	public static void testSetup(){
		
	}
	
	@AfterClass
	public static void testCleanup(){
		
	}
	
	@Test
	public void testHotel() {
		Hotel hotel = new Hotel("test", 4, 100, 100, 100, 100);
		assertNotNull("when create an hotel and hotel should not null!",hotel);
	}

	@Test
	public void testGetHotelName() {
		Hotel hotel = new Hotel("test", 4, 100, 100, 100, 100);
		assertSame("the get hotel name method should be right!","test", hotel.getHotelName());
	}

	@Test
	public void testSetHotelName() {
		Hotel hotel = new Hotel("", 4, 100, 100, 100, 100);
		hotel.setHotelName("test");
		assertSame("the set hotel name method should be right!","test", hotel.getHotelName());
	}

	@Test
	public void testGetWeekdayRegularPrice() {
		Hotel hotel = new Hotel("test", 4, 100, 100, 100, 100);
		assertEquals("the get hotel weekday regular price method should be right!",100.0, hotel.getWeekdayRegularPrice(),0);
	}

	@Test
	public void testSetWeekdayRegularPrice() {
		Hotel hotel = new Hotel("test", 4, 0, 100, 100, 100);
		hotel.setWeekdayRegularPrice(110);
		assertEquals("the set hotel weekday regular price method should be right!",110.0, hotel.getWeekdayRegularPrice(),0);
	}

	@Test
	public void testGetWeekendRegularPrice() {
		Hotel hotel = new Hotel("test", 4, 120, 100, 150, 100);
		assertEquals("the get hotel weekend regular price method should be right!",150.0, hotel.getWeekendRegularPrice(),0);
	}

	@Test
	public void testSetWeekendRegularPrice() {
		Hotel hotel = new Hotel("test", 4, 250, 100, 0, 100);
		hotel.setWeekendRegularPrice(200);
		assertEquals("the set hotel weekend regular price method should be right!",200.0, hotel.getWeekendRegularPrice(),0);
	}

	@Test
	public void testGetWeekdayRewardsPrice() {
		Hotel hotel = new Hotel("test", 4, 200, 150, 100, 100);
		assertEquals("the get hotel weekday reawrds price method should be right!",150.0, hotel.getWeekdayRewardsPrice(),0);
	}

	@Test
	public void testSetWeekdayRewardsPrice() {
		Hotel hotel = new Hotel("test", 4, 0, 0, 100, 100);
		hotel.setWeekdayRewardsPrice(140);
		assertEquals("the set hotel weekday rewards price method should be right!",140.0, hotel.getWeekdayRewardsPrice(),0);
	}

	@Test
	public void testGetWeekendRewardsPrice() {
		Hotel hotel = new Hotel("test", 4, 0, 100, 100, 130);
		assertEquals("the get hotel weekend rewards price method should be right!",130.0, hotel.getWeekendRewardsPrice(),0);
	}

	@Test
	public void testSetWeekendRewardsPrice() {
		Hotel hotel = new Hotel("test", 4, 210, 100, 100, 0);
		hotel.setWeekdayRegularPrice(150);
		assertEquals("the set hotel weekend rewards price method should be right!",150.0, hotel.getWeekdayRegularPrice(),0);
	}

	@Test
	public void testGetHotelRate() {
		Hotel hotel = new Hotel("test", 4, 0, 100, 100, 100);
		assertEquals("the get hotel rates method should be right!",4, hotel.getHotelRate(),0);
	}

	@Test
	public void testSetHotelRate() {
		Hotel hotel = new Hotel("test", 4, 0, 100, 100, 100);
		hotel.setHotelRate(5);
		assertEquals("the set hotel rates method should be right!",5, hotel.getHotelRate(),0);
	}

	@Test
	public void testReturnTotalCostByCustomerTypeAndTimeAccordingToRewardsAndWeekday() {
		Hotel hotel = new Hotel("test", 4, 120, 100, 100, 80);
		Customer customer = new Customer();
		int[] date = {1,2,3,4,5};
		customer.setCustomerType("Rewards");
		customer.setReservationDateTime(date);
		assertEquals("rewards customer about five weekday should be right!", 500.0,
				hotel.returnTotalCostByCustomerTypeAndTime(customer.getCustomerType(),customer.getReservationDateTime()),0);
	}
	
	@Test
	public void testReturnTotalCostByCustomerTypeAndTimeAccordingToRewardsAndWeekend() {
		Hotel hotel = new Hotel("test", 4, 120, 100, 100, 80);
		Customer customer = new Customer();
		int[] date = {6,7};
		customer.setCustomerType("Rewards");
		customer.setReservationDateTime(date);
		assertEquals("rewards customer about five weekday should be right!", 160.0,
				hotel.returnTotalCostByCustomerTypeAndTime(customer.getCustomerType(),customer.getReservationDateTime()),0);
	}
	
	@Test
	public void testReturnTotalCostByCustomerTypeAndTimeAccordingToRewardsAndWeekdayAndWeekend() {
		Hotel hotel = new Hotel("test", 4, 120, 100, 100, 80);
		Customer customer = new Customer();
		int[] date = {1,2,3,4,5,6,7};
		customer.setCustomerType("Rewards");
		customer.setReservationDateTime(date);
		assertEquals("rewards customer about five weekday should be right!", 660.0,
				hotel.returnTotalCostByCustomerTypeAndTime(customer.getCustomerType(),customer.getReservationDateTime()),0);
	}
	
	@Test
	public void testReturnTotalCostByCustomerTypeAndTimeAccordingToRegularAndWeekday() {
		Hotel hotel = new Hotel("test", 4, 120, 100, 100, 80);
		Customer customer = new Customer();
		int[] date = {1,2,3,4,5};
		customer.setCustomerType("Regular");
		customer.setReservationDateTime(date);
		assertEquals("rewards customer about five weekday should be right!", 600.0,
				hotel.returnTotalCostByCustomerTypeAndTime(customer.getCustomerType(),customer.getReservationDateTime()),0);
	}
	@Test
	public void testReturnTotalCostByCustomerTypeAndTimeAccaordingToRegularAndWeekend() {
		Hotel hotel = new Hotel("test", 4, 120, 100, 100, 80);
		Customer customer = new Customer();
		int[] date = {6,7};
		customer.setCustomerType("Regular");
		customer.setReservationDateTime(date);
		assertEquals("rewards customer about five weekday should be right!", 200.0,
				hotel.returnTotalCostByCustomerTypeAndTime(customer.getCustomerType(),customer.getReservationDateTime()),0);
	}
	@Test
	public void testReturnTotalCostByCustomerTypeAndTimeAccordingToRegularAndWeekdayAndWeekend() {
		Hotel hotel = new Hotel("test", 4, 120, 100, 100, 80);
		Customer customer = new Customer();
		int[] date = {1,2,3,4,5,6,7};
		customer.setCustomerType("Regular");
		customer.setReservationDateTime(date);
		assertEquals("rewards customer about five weekday should be right!", 800.0,
				hotel.returnTotalCostByCustomerTypeAndTime(customer.getCustomerType(),customer.getReservationDateTime()),0);
	}
	

}
