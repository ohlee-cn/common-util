/**
 * DecimalUtilTest.java
 * Copyright (c) 2013 by lashou.com
 */
package cn.ohlee.common.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Brody Cai
 *
 */
public class DecimalUtilTest {
	
	/**  */
	private final static Number TEST_NUMBER_1 = -0.0001;
	/**  */
	private final static Number TEST_NUMBER_2 = 12315.2211;
	/**  */
	private final static Number TEST_NUMBER_3 = 12315.2251;

	/**
	 * Test method for {@link cn.ohlee.common.util.DecimalUtil#format(Number, int, boolean)}.
	 */
	@Test
	public void testFormatNumberIntBoolean() {
		Assert.assertTrue(DecimalUtil.format(TEST_NUMBER_1, 2, false).equals("0.00"));
		Assert.assertTrue(DecimalUtil.format(TEST_NUMBER_1, 2, true).equals("0.00"));
		Assert.assertTrue(DecimalUtil.format(TEST_NUMBER_2, 2, false).equals("12,315.22"));
		Assert.assertTrue(DecimalUtil.format(TEST_NUMBER_2, 2, true).equals("+12,315.22"));
		Assert.assertTrue(DecimalUtil.format(TEST_NUMBER_3, 2, false).equals("12,315.23"));
	}

	/**
	 * Test method for {@link cn.ohlee.common.util.DecimalUtil#format(Number, int)}.
	 */
	@Test
	public void testFormatNumberInt() {
		Assert.assertTrue(DecimalUtil.format(TEST_NUMBER_3, 2).equals("12,315.23"));
	}

	/**
	 * Test method for {@link cn.ohlee.common.util.DecimalUtil#format(Number, String, boolean)}.
	 */
	@Test
	public void testFormatNumberStringBoolean() {
		Assert.assertTrue(DecimalUtil.format(TEST_NUMBER_3, "##0.00", false).equals("12315.23"));
		Assert.assertTrue(DecimalUtil.format(TEST_NUMBER_3, "###,##0.00", true).equals("+12,315.23"));
	}

	/**
	 * Test method for {@link cn.ohlee.common.util.DecimalUtil#format(Number, String)}.
	 */
	@Test
	public void testFormatNumberString() {
		Assert.assertTrue(DecimalUtil.format(TEST_NUMBER_3, "##0.00").equals("12315.23"));
		Assert.assertTrue(DecimalUtil.format(TEST_NUMBER_3, "###,##0.00").equals("12,315.23"));
	}

}
