package per.tw.customer.data.imp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import per.tw.customer.data.common.AnalysisTheStringForCustomer;

public class CustomerDataStringAnalysiser implements AnalysisTheStringForCustomer {

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
	@Override
	public int[] analysisTheDataStringAndGetTheDateTime(String str) {
		// TODO Auto-generated method stub

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
	
	@Override
	public int parseTheDateStringToWeekDay(String str) {
		// TODO Auto-generated method stub
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

}
