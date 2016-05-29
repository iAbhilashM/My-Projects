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
public class ValidQuantityTestCases {

	private int input;
	private boolean output;

	public ValidQuantityTestCases(int input, boolean output) {
		this.input = input;
		this.output = output;
	}

	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] { { 1, true }, { 0, false }, { 1000, true }, { -5, false } });
	}

	@Test
	public void testValidQuantity() {
		assertEquals(output, Validate.isValidQuantity(input));
	}
}