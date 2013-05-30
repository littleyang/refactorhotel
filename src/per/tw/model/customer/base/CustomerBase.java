package per.tw.model.customer.base;

public class CustomerBase {
	
	// define the customer type
	private String customerType;
	// define the customer date time
	private int[] reservationDateTime;
	
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

}
