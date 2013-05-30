package per.tw.model.hotel;

import per.tw.hotel.common.HotelCommonMethod;
import per.tw.model.hotel.base.HotelBase;

/**
 * this is the hotel model class and some method thats match customer to find out the best hotel among
 * the hotel list!
 * @author yangyang
 *
 */
public class Hotel extends HotelBase implements HotelCommonMethod {
	
	/**
	 * the constructor method for hotel
	 * @param hotelName
	 * @param hotelRate
	 * @param weekdayRegularPrice
	 * @param weekdayRewardsPrice
	 * @param weekendRegularPrice
	 * @param weekendRewardsPrice
	 */
	public Hotel(String hotelName, Integer hotelRate,
			float weekdayRegularPrice, float weekdayRewardsPrice,
			float weekendRegularPrice, float weekendRewardsPrice) {
		super(hotelName, hotelRate, weekdayRegularPrice, weekdayRewardsPrice,
				weekendRegularPrice, weekendRewardsPrice);
		// TODO Auto-generated constructor stub
	}

	/**
	 * every hotel should have the method to calculate the total afford according to customerType and 
	 * customerDate and return to the customer
	 * 
	 * @param customerType
	 * @param customrDate[]
	 * @return totalAfford
	 */
	public float returnTotalCostByCustomerTypeAndTime(String customerType,int[] customrDate){
		float totalAfford = 0;
		// the data is valid!
		if(customerType.equals("Rewards")){
			// if the customer is Rewards type,then get the rewards price
			for(int i=0;i<customrDate.length;i++){
				// whether the day in [1..5],then get the weekday rewards price and calculate the total afford
				if(0<customrDate[i] && customrDate[i]<6){
					totalAfford = totalAfford + getWeekdayRewardsPrice();
				}
				else{
					// if the day is saturday or sunday, then get the weekend rewards price and calculate the total afford
					totalAfford = totalAfford + getWeekendRewardsPrice();
				}
			}
		}else{ // the customer is regular type,then get the regular price!	
			// for regular customers, just distinguish from the weekday or weekend
			for(int i=0;i<customrDate.length;i++){
				if(0<customrDate[i]&&customrDate[i]<6){
					totalAfford = totalAfford + getWeekdayRegularPrice();
				}
				else{
					totalAfford = totalAfford + getWeekendRegularPrice();
				}
			}
		}
		
		// return the total affords that the customer should afford
		return totalAfford;
	}
}
