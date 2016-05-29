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
public class ValidManufacturingDateRespectToExpiryDateTestCases {
	private Date[] input;
	private boolean output;

	public ValidManufacturingDateRespectToExpiryDateTestCases(Date[] input, boolean output) {
		this.input = input;
		this.output = output;
	}

	@SuppressWarnings({ "deprecation" })
	@Parameters
	public static List<Object[]> data() {
		Date i1[] = new Date[2];
		i1[0] = new Date("02-May-2016");
		i1[1] = new Date("01-May-2016");

		Date i2[] = new Date[2];
		i2[0] = new Date("02-May-2016");
		i2[1] = new Date("02-May-2016");

		Date i3[] = new Date[2];
		i3[0] = new Date("03-May-2016");
		i3[1] = new Date("04-May-2016");
		return Arrays.asList(new Object[][] { { i1, false }, { i2, false }, { i3, true } });
	}

	@Test
	public void testManufacturingDateRespectToExpiryDate() {
		assertEquals(output, Validate.isValidManufacturingDateRespectToExpiryDate(input[0], input[1]));
	}
}
