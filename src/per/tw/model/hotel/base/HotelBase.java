package per.tw.model.hotel.base;

public class HotelBase {
	
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

	public HotelBase(String hotelName, Integer hotelRate, float weekdayRegularPrice,
				float weekdayRewardsPrice, float weekendRegularPrice,
				float weekendRewardsPrice) {
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

}
