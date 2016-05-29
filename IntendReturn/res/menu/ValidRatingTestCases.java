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
public class ValidRatingTestCases {

	private float input;
	private boolean output;

	public ValidRatingTestCases(float input, boolean output) {
		this.input = input;
		this.output = output;
	}

	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] { { 1, true }, { 1.0f, true }, { 2.9f, true }, { -5, false },
				{ 5.9f, false }, { 6, false } });
	}

	@Test
	public void testValidRating() {
		assertEquals(output, Validate.isValidRating(input));
	}

}
