package per.tw.test.utest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * this is the test suit about the hotel,customer,data bean and so on
 * @author yangyang
 *
 */


@RunWith(Suite.class)
@SuiteClasses({
	HotelTest.class,
	CustomerTest.class,
	HotelCollectionBeanTest.class,
	CompatorHotelCollectionTest.class
})

public class AllTestsAboutTheHotelAndCustomer {

}
