package per.tw.customer.comparator;

import java.util.Comparator;

import per.tw.model.hotel.databean.HotelCollectionBean;

public class CompatorHotelCollection implements Comparator<Object>  {

	/*
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Object beanOne, Object beanTwo) {
		// TODO Auto-generated method stub
		
		
		// cast the object one,two to HotelCollectionBean 
		HotelCollectionBean beanTempOne = (HotelCollectionBean)beanOne;
		HotelCollectionBean beanTempTwo = (HotelCollectionBean)beanTwo;
		
		
		// compare the total afford ,if same,compare the hotel rate
		// set compare flag
		int comparatorFlag = beanTempOne.getTotalAffordByCustomer().compareTo(beanTempTwo.getTotalAffordByCustomer());
		if( comparatorFlag == 0){
			// if total afford is same,the check the hotel rate!
			return beanTempTwo.getHotelRate().compareTo(beanTempOne.getHotelRate());
		}else{
			return comparatorFlag;
		}
		
	}
}
