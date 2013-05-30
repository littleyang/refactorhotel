package per.tw.customer.databean;

public class HotelCollectionBean {
	
	// define the hotel total afford
		private Float totalAffordByCustomer;
		
		// set hotel rate
		private Integer hotelRate;
		
		// define the respondent hotel
		private String hotelName;
		/*
		 * define the set and get methods for hotel and total afford
		 */
		public Float getTotalAffordByCustomer() {
			return totalAffordByCustomer;
		}

		public void setTotalAffordByCustomer(Float totalAffordByCustomer) {
			this.totalAffordByCustomer = totalAffordByCustomer;
		}

		public String getHotelName() {
			return hotelName;
		}

		public void setHotelName(String hotelName) {
			this.hotelName = hotelName;
		}

		public Integer getHotelRate() {
			return hotelRate;
		}

		public void setHotelRate(Integer hotelRate) {
			this.hotelRate = hotelRate;
		}


}
