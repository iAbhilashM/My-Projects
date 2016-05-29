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
public class ValidProductNameTestCases {

	private String input;
	private boolean output;

	public ValidProductNameTestCases(String input, boolean output) {
		this.input = input;
		this.output = output;
	}

	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] { { "mrt", false }, { "Mrr", true }, { "5Mrt", false }, { "$56_", false },
				{ "My Product", true } });
	}

	@Test
	public void testValidProductName() {
		assertEquals(output, Validate.isValidProductName(input));
	}
}
