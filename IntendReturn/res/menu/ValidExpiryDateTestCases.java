package com.flp.pms.testcases;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.flp.pms.util.Validate;

@RunWith(Parameterized.class)
public class ValidExpiryDateTestCases {

	private Date input;
	private boolean output;

	public ValidExpiryDateTestCases(Date input, boolean output) {
		this.input = input;
		this.output = output;
	}

	@SuppressWarnings("deprecation")
	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] { { new Date("02-May-2016"), false }, { new Date("05-May-2017"), true },
				{ new Date("30-May-2016"), false } });
	}

	@Test
	public void testValidExpiryDate() {
		assertEquals(output, Validate.isValidExpiryDate(input));
	}

}
