package per.tw.customer.data.adapter;

import per.tw.customer.common.DataEncapsulateAndParseInterface;
import per.tw.customer.data.imp.CustomerDataStringAnalysiser;

public class CustomerDataAnalysiAdapter implements DataEncapsulateAndParseInterface {

	@Override
	public int[] setCustomerTypeAndTimeData(String str) {
		// TODO Auto-generated method stub
		CustomerDataStringAnalysiser analysis = new CustomerDataStringAnalysiser();
		return analysis.analysisTheDataStringAndGetTheDateTime(str);
	}

}
