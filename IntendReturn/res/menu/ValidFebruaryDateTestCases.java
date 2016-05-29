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
public class ValidFebruaryDateTestCases {

	private String input;
	private boolean output;

	public ValidFebruaryDateTestCases(String input, boolean output) {
		this.input = input;
		this.output = output;
	}

	@Parameters
	public static List<Object[]> data() {
		return Arrays
				.asList(new Object[][] { { "02-Feb-2016", true }, { "29-Feb-2016", true }, { "30-Feb-2018", false },
						{ "29-Feb-2017", false }, { "28-Feb-2017", true }, { "31-Feb-2016", false }, });
	}

	@Test
	public void testValidFebruaryDate() {
		assertEquals(output, Validate.isValidFebruaryDate(input));
	}

}
