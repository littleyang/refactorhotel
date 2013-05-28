package per.tw.model.hotel;
/**
 * this is the hotel model class and some method thats match customer to find out the best hotel among
 * the hotel list!
 * @author yangyang
 *
 */
public class Hotel {
	
	// define the hotel name
	private String hotelName;
	
	// define the hotel rate
	private Integer hotelRate;
	
	// define the hotel weekday regular price
	private float weekdayRegularPrice;
	
	// define the hotel weekday regular price
	private float weekdayRewardsPrice;
	
	// define the weekend regular price
	private float weekendRegularPrice;
	
	// define the weekend reward price
	private float weekendRewardsPrice;
	
	/*
	 * the hotel constructor
	 */

	public Hotel(String hotelName, Integer hotelRate, float weekdayRegularPrice,
			float weekdayRewardsPrice, float weekendRegularPrice,
			float weekendRewardsPrice) {
		super();
		this.hotelName = hotelName;
		this.hotelRate = hotelRate;
		this.weekdayRegularPrice = weekdayRegularPrice;
		this.weekdayRewardsPrice = weekdayRewardsPrice;
		this.weekendRegularPrice = weekendRegularPrice;
		this.weekendRewardsPrice = weekendRewardsPrice;
	}

	/*
	 * all get and set methods about the fileds
	 */
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public float getWeekdayRegularPrice() {
		return weekdayRegularPrice;
	}

	public void setWeekdayRegularPrice(float weekdayRegularPrice) {
		this.weekdayRegularPrice = weekdayRegularPrice;
	}

	public float getWeekendRegularPrice() {
		return weekendRegularPrice;
	}

	public void setWeekendRegularPrice(float weekendayRegularPrice) {
		this.weekendRegularPrice = weekendayRegularPrice;
	}

	public float getWeekdayRewardsPrice() {
		return weekdayRewardsPrice;
	}

	public void setWeekdayRewardsPrice(float weekdayRewardsPrice) {
		this.weekdayRewardsPrice = weekdayRewardsPrice;
	}

	public float getWeekendRewardsPrice() {
		return weekendRewardsPrice;
	}

	public void setWeekendRewardsPrice(float weekendayRewardsPrice) {
		this.weekendRewardsPrice = weekendayRewardsPrice;
	}
	
	public Integer getHotelRate() {
		return hotelRate;
	}

	public void setHotelRate(Integer hotelRate) {
		this.hotelRate = hotelRate;
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
		if(customerType.equals("")||customrDate.length==0){
			// check the data whether is valid!
			// the data is invalid!
			System.out.println("Oh! when hotel check the total offord, your data is wrong!! please check it!");
		}else{
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
		}
		// return the total affords that the customer should afford
		return totalAfford;
	}
}
