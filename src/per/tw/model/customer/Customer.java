package per.tw.model.customer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import per.tw.customer.comparator.CompatorHotelCollection;
import per.tw.customer.data.adapter.CustomerDataAnalysiAdapter;
import per.tw.customer.databean.HotelCollectionBean;
import per.tw.model.customer.base.CustomerBase;
import per.tw.model.hotel.Hotel;


public class Customer extends CustomerBase {
	/**
	 * this method used to set the date data and customer type according to the read file data!
	 * @param str
	 */
	public void setTypeAndTimeData(String str){
		
		// 创建数据处理适配器
		CustomerDataAnalysiAdapter analysiser = new CustomerDataAnalysiAdapter();
		// check the data that passed whether is valid!
		if(str.equals("")){
			throw new IllegalArgumentException("Oh! please,when set the customer type gets something wrong!, your data is wrong!! please check it!");
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
				setReservationDateTime(analysiser.setCustomerTypeAndTimeData(tempStr[1]));
			}
		}
			
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
			throw new IllegalArgumentException("your hotel list or your customer type must be something wrong!");
		
		}else if(getReservationDateTime().length==0){
			
			// second, check the date time array before search!
			throw new IllegalArgumentException("your date time data must be wrong!");
		
		}else{
			
			// customer type and the data time not null!set the data and check the best one!
			// the comparator for the list
			CompatorHotelCollection hotelCompator = new CompatorHotelCollection();
			
			// define the the sort will been search!
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
}
