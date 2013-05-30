package per.tw.test.utest;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import per.tw.model.customer.Customer;
import per.tw.model.hotel.Hotel;



public class CustomerTest {

	@BeforeClass
	public static void testSetup(){
		
	}
	
	@AfterClass
	public static void testCleanup(){
		
	}
	
	@Test
	public void testGetCustomerType() {
		Customer customer = new Customer();
		customer.setCustomerType("Rewards");
		assertEquals("should get the right customer type!","Rewards", customer.getCustomerType());
	}

	@Test
	public void testSetCustomerType() {
		Customer customer = new Customer();
		customer.setCustomerType("Rewards");
		assertEquals("should get the right customer type!","Rewards", customer.getCustomerType());
	}

	@Test
	public void testGetReservationDateTime() {
		Customer customer = new Customer();
		int[] date = {1,2,3,4,5};
		customer.setReservationDateTime(date);
		assertNotNull("the customer date int should not null!",customer.getReservationDateTime());
	}

	@Test
	public void testSetReservationDateTime() {
		Customer customer = new Customer();
		int[] date = {1,2,3,4,5};
		customer.setReservationDateTime(date);
		assertNotNull("the customer date int should not null!",customer.getReservationDateTime());
	}

	@Test
	public void testSetTypeAndTimeDataAndGetTheType() {
		Customer customer = new Customer();
		customer.setTypeAndTimeData("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)");
		assertEquals("when set the customer type and date time should get customer type right!","Regular",customer.getCustomerType());
	}
	
	@Test
	public void testSetTypeAndTimeDataAndGetTheDate() {
		Customer customer = new Customer();
		int[] date = {1,2,3};
		customer.setTypeAndTimeData("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)");
		assertNotNull("when set the customer date time string and should get customer date array right!", customer.getReservationDateTime());
		for(int i=0;i<date.length;i++){
			assertEquals("when set the customer date time string and should get customer date array right!",date[i],customer.getReservationDateTime()[i]);
		}
	}

//	@Test
//	public void testAnalysisTheDataStringAndGetTheDateTime() {
//		Customer customer = new Customer();
//		int[] date = {1,2,3};
//		int[] returns = customer.analysisTheDataStringAndGetTheDateTime("16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)");
//		for(int i=0;i<date.length;i++){
//			assertEquals("when set the customer date time string and should get customer date array right!",date[i],returns[i]);
//		}
//	}

//	@Test
//	public void testParseTheDateStringToWeekDay() {
//		Customer customer = new Customer();
//		assertEquals("should get the right day!", 1, customer.parseTheDateStringToWeekDay("16Mar2009(mon)"));
//		
//	}

	@Test
	public void testSearchHotelAndFindAndReturnCheapestAndBestOneByRegularCustomer() {
		Customer customer = new Customer();
		List<Hotel> hotelList = new ArrayList<Hotel>();
		
		Hotel lakewoodHotel = new Hotel("Lakewood",3,110,80,90,80);
		hotelList.add(lakewoodHotel);
		
		Hotel bridgewoodHotel = new Hotel("Bridgewood",4,160,110,60,50);
		hotelList.add(bridgewoodHotel);
		
		Hotel ridgewoodHotel = new Hotel("Ridgewood",5,220,100,150,40);
		hotelList.add(ridgewoodHotel);
		
		customer.setTypeAndTimeData("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)");
		assertEquals("should find the best hotle!", "Lakewood", customer.searchHotelAndFindAndReturnCheapestAndBestOne(hotelList));
	}
	
	@Test
	public void testSearchHotelAndFindAndReturnCheapestAndBestOneByRewardsCustomer() {
		Customer customer = new Customer();
		List<Hotel> hotelList = new ArrayList<Hotel>();
		
		Hotel lakewoodHotel = new Hotel("Lakewood",3,110,80,90,80);
		hotelList.add(lakewoodHotel);
		
		Hotel bridgewoodHotel = new Hotel("Bridgewood",4,160,110,60,50);
		hotelList.add(bridgewoodHotel);
		
		Hotel ridgewoodHotel = new Hotel("Ridgewood",5,220,100,150,40);
		hotelList.add(ridgewoodHotel);
		
		customer.setTypeAndTimeData("Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)");
		assertEquals("should find the best hotle!", "Ridgewood", customer.searchHotelAndFindAndReturnCheapestAndBestOne(hotelList));
	}
	
	@Test
	public void testSearchHotelAndFindAndReturnCheapestAndBestOneByRewardsCustomerAndWeekdayAndWeekend() {
		Customer customer = new Customer();
		List<Hotel> hotelList = new ArrayList<Hotel>();
		
		Hotel lakewoodHotel = new Hotel("Lakewood",3,110,80,90,80);
		hotelList.add(lakewoodHotel);
		
		Hotel bridgewoodHotel = new Hotel("Bridgewood",4,160,110,60,50);
		hotelList.add(bridgewoodHotel);
		
		Hotel ridgewoodHotel = new Hotel("Ridgewood",5,220,100,150,40);
		hotelList.add(ridgewoodHotel);
		
		customer.setTypeAndTimeData("Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)");
		assertEquals("should find the best hotle!", "Bridgewood", customer.searchHotelAndFindAndReturnCheapestAndBestOne(hotelList));
	}
	
	@Test
	public void testSearchHotelAndFindAndReturnCheapestAndBestOneByReadTheDataFile() {
		List<Hotel> hotelList = new ArrayList<Hotel>();
		
		Hotel lakewoodHotel = new Hotel("Lakewood",3,110,80,90,80);
		hotelList.add(lakewoodHotel);
		
		Hotel bridgewoodHotel = new Hotel("Bridgewood",4,160,110,60,50);
		hotelList.add(bridgewoodHotel);
		
		Hotel ridgewoodHotel = new Hotel("Ridgewood",5,220,100,150,40);
		hotelList.add(ridgewoodHotel);
		
		try {
			FileReader data = new FileReader(new File(System.getProperty("user.dir")+"/src/data.txt"));
			BufferedReader dataBuffer = new BufferedReader(data);
			String str = "";
			while((str = dataBuffer.readLine()) != null) {
				Customer c = new Customer();
				c.setTypeAndTimeData(str);
				System.out.println(c.searchHotelAndFindAndReturnCheapestAndBestOne(hotelList));
				assertNotNull("ervey line data should have the best one!", c.searchHotelAndFindAndReturnCheapestAndBestOne(hotelList));
			}
			
			data.close();
			dataBuffer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
