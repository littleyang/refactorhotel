package per.tw.customer.data.imp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import per.tw.customer.data.common.AnalysisTheStringForCustomer;

public class CustomerDataStringAnalysiser implements AnalysisTheStringForCustomer {

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
