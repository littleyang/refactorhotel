package per.tw.model.customer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import per.tw.customer.comparator.CompatorHotelCollection;
import per.tw.customer.data.adapter.CustomerDataAnalysiAdapter;
import per.tw.model.hotel.Hotel;
import per.tw.model.hotel.databean.HotelCollectionBean;


public class Customer {
	
	// define the customer type
	private String customerType;
	// define the customer date time
	private int[] reservationDateTime;
	
	CustomerDataAnalysiAdapter analysiser = new CustomerDataAnalysiAdapter();
	
	/*
	 * the get and set methods
	 */
	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public int[] getReservationDateTime() {
		return reservationDateTime;
	}

	public void setReservationDateTime(int[] reservationDateTime) {
		this.reservationDateTime = reservationDateTime;
	}
	
	
	/**
	 * this method used to set the date data and customer type according to the read file data!
	 * @param str
	 */
	public void setTypeAndTimeData(String str){
		
		// check the data that passed whether is valid!
		if(str == ""){
			System.out.println("Oh! please,when set the customer type gets something wrong!, your data is wrong!! please check it!");
			return ;
		}else{		
			
			String[] tempStr = str.split(":");
			
			// according to the  data string to get the customer type 
			setCustomerType(tempStr[0]);
			
			// check the date time data is valid!
			if(tempStr.length==1){
				
				System.out.println("Oh! please when set the date time gets something wrong!, your date time data is wrong!! please check it!");				
				throw new IllegalArgumentException("your date time data must be wrong!");	
			
			}else{
				
				// according to the  data string to get the customer date time
				setReservationDateTime(analysisTheDataStringAndGetTheDateTime(tempStr[1]));
			}
		}
			
	}
	
	/**
	 * this  method is used to parse the data to day of the week and set the string date time to an int array
	 * so the hotel will easily to calculate the total afford.
	 * 
	 * change data:["16Mar2009(mon)","17Mar2009(tues)","18Mar2009(wed)","18Mar2009(thur)"]
	 * to data:[1,2,3,4]
	 * 
	 * @param str
	 * @return
	 */
	public int[] analysisTheDataStringAndGetTheDateTime(String str){
		
		String[] tempDateTime = str.split(",");
		int[] returnResultDateTime = new int[tempDateTime.length];
		for(int i=0;i<tempDateTime.length;i++){
			returnResultDateTime[i] = parseTheDateStringToWeekDay(tempDateTime[i]);
		}
		return returnResultDateTime;
	}
	
	/**
	 * this method used to parse the day to the corresponding int number [1,2,3,4,5,6,7]
	 * @param str
	 * @return: int day
	 */
	public int parseTheDateStringToWeekDay(String str){
		int day = 0;
		Matcher m = Pattern.compile("\\(([^)]*)\\)").matcher(str);
		while (m.find()) {
           switch(m.group(1)){
        	   case "mon": day = 1; break;
        	   case "tues": day = 2; break;
        	   case "wed": day = 3; break;
        	   case "thur": day = 4; break;
        	   case "fri": day = 5; break;
        	   case "sat": day = 6; break;
        	   case "sun": day = 7; break;
           }
		}
		return day;
	}
	
	/**
	 * 
	 * search the hotel list and check out the best one according to the the given hotel list and the customer's type
	 * and the customer's data time!
	 * @param hotelList
	 * @return
	 */
	public String searchHotelAndFindAndReturnCheapestAndBestOne(List<Hotel> hotelList){
		
		String returnHotelName = "";
		// do some argument checks!
		if(hotelList.size()==0||getCustomerType().equals("")){
			
			// first, the hotel list should not be null
			System.out.println("your data must be something wrong when serach the hotel!please check it!");
			throw new IllegalArgumentException("your hotel list or your customer type must be something wrong!");
		
		}else if(getReservationDateTime().length==0){
			
			// second, check the date time array before search!
			System.out.println("Your date time is null! please check it!");
			throw new IllegalArgumentException("your date time data must be wrong!");
		
		}else{
			
			// customer type and the data time not null!set the data and check the best one!
			// the compator for the list
			CompatorHotelCollection hotelCompator = new CompatorHotelCollection();
			
			// define the the sort will been srearch!
			List<HotelCollectionBean> tempList = new ArrayList<HotelCollectionBean>();				
			
			// loop to the hotel list and calculate the every total afford and encapsulate the hotel 
			// collection data bean.
			for(Hotel hotel:hotelList){
				HotelCollectionBean bean = new HotelCollectionBean();
				bean.setTotalAffordByCustomer(hotel.returnTotalCostByCustomerTypeAndTime(getCustomerType(), getReservationDateTime()));
				bean.setHotelName(hotel.getHotelName());
				bean.setHotelRate(hotel.getHotelRate());
				tempList.add(bean);
			}
			
			// sort the hotel temp list by ascending order and the lowest one is the best one! 
			Collections.sort(tempList,hotelCompator);
			// get the cheapest one and the best one
			returnHotelName = tempList.get(0).getHotelName();
		}
		
		// return the best one
		return returnHotelName;
	}	
	
	public String getTheBestOne(List<Hotel> hotelList){
		
		return null;
	}
}
