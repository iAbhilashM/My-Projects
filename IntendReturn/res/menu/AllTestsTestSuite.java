package com.flp.pms.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.flp.pms.testcases.*;

@RunWith(Suite.class)
@SuiteClasses({ DaoTestCases.class, ServiceTestCases.class, ValidateTestSuite.class, ValidContactNoTestCases.class,
		ValidDateFormatTestCases.class, ValidExpiryDateRespectToManufacturingDateTestCases.class,
		ValidExpiryDateTestCases.class, ValidFebruaryDateTestCases.class, ValidProductNameTestCases.class,
		ValidQuantityTestCases.class, ValidRatingTestCases.class,
		ValidManufacturingDateRespectToExpiryDateTestCases.class })
public class AllTestsTestSuite {

}
