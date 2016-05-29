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
public class ValidContactNoTestCases {

	private String input;
	private boolean output;

	public ValidContactNoTestCases(String input, boolean output) {
		this.input = input;
		this.output = output;
	}

	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] { { "0123456789", true }, { "123456789", false }, { "aaaaaaaaaa", false },
				{ "3333dddddd", false } });
	}

	@Test
	public void testValidContactNo() {
		assertEquals(output, Validate.isValidContactNo(input));
	}

}
