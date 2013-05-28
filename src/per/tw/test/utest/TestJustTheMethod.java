package per.tw.test.utest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import per.tw.model.customer.Customer;
import per.tw.model.hotel.Hotel;


/**
 * this is about the methods test about the customer and hotel!
 * read the data from the data.txt and find the best one!
 * @author yangyang
 *
 */

public class TestJustTheMethod {
	
	public static void main(String[] args){
		
		List<Hotel> hotelList = new ArrayList<Hotel>();
		
		/*
		String hotelName, String hotelRate, float weekdayRegularPrice,
		float weekdayRewardsPrice, float weekendRegularPrice,
		float weekendRewardsPrice
		*/
		Hotel lakewoodHotel = new Hotel("Lakewood",3,110,80,90,80);
		hotelList.add(lakewoodHotel);
		
		Hotel bridgewoodHotel = new Hotel("Bridgewood",4,160,110,60,50);
		hotelList.add(bridgewoodHotel);
		
		Hotel ridgewoodHotel = new Hotel("Ridgewood",5,220,100,150,40);
		hotelList.add(ridgewoodHotel);
		
		
		
		//Date today = new Date();
		
		Customer cs = new Customer();
		cs.setTypeAndTimeData("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)");
		//System.out.println(cs.getCustomerType());
		//System.out.println(cs.getReservationDateTime()[0]);
		System.out.println(cs.searchHotelAndFindAndReturnCheapestAndBestOne(hotelList));
		
		
		Customer tcs = new Customer();
		tcs.setTypeAndTimeData("Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)");
		//System.out.println(tcs.getCustomerType());
		//System.out.println(tcs.getReservationDateTime()[0]);
		System.out.println(tcs.searchHotelAndFindAndReturnCheapestAndBestOne(hotelList));
		
		
		Customer wcs = new Customer();
		wcs.setTypeAndTimeData("Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)");
		//System.out.println(wcs.getCustomerType());
		//System.out.println(wcs.getReservationDateTime()[0]);
		System.out.println(wcs.searchHotelAndFindAndReturnCheapestAndBestOne(hotelList));
		
		try {
			FileReader data = new FileReader(new File(System.getProperty("user.dir")+"/src/data.txt"));
			BufferedReader dataBuffer = new BufferedReader(data);
			String str = "";
			while((str = dataBuffer.readLine()) != null) {
				Customer c = new Customer();
				c.setTypeAndTimeData(str);
				//System.out.println(str.split(":")[1].split(",")[1]);
				System.out.println(c.searchHotelAndFindAndReturnCheapestAndBestOne(hotelList));
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
