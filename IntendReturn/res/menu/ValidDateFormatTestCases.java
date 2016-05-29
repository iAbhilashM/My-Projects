package com.flp.pms.testcases;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.flp.pms.util.Validate;

@RunWith(Parameterized.class)
public class ValidDateFormatTestCases {

	private String input;
	private boolean output;

	public ValidDateFormatTestCases(String input, boolean output) {
		this.input = input;
		this.output = output;
	}

	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] { { "02-10-2016", false }, { "02-May-2016", true }, { "02-MAY-2016", true },
				{ "02-may-2016", true }, { "32-May-2016", false }, { "30102016", false }, { "2016-May-10", false },
				{ "May-32-2016", false }, { "2016-May-32", false }, { "2016May32", false }, { "10-May-12", false },
				{ "10-May-2012", true } });
	}

	@Test
	public void testValidDateFormat() {
		assertEquals(output, Validate.isValidDateFormat(input));
	}
}
