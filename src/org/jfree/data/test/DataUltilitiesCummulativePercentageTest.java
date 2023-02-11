package org.jfree.data.test;

import org.jmock.*;
import static org.junit.Assert.*;

import java.util.List;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Range;
import org.jfree.data.UnknownKeyException;
import org.junit.*;

public class DataUltilitiesCummulativePercentageTest {
	private Mockery testArray;
	private KeyedValues testValues;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void testFirstList() {
		testArray = new Mockery();
		testValues = testArray.mock(KeyedValues.class);
		testArray.checking(new Expectations() {
			{
				allowing(testValues).getValue(0);
				will(returnValue(100));
				allowing(testValues).getKey(0);
				will(returnValue(0));
				allowing(testValues).getValue(1);
				will(returnValue(12));
				allowing(testValues).getKey(1);
				will(returnValue(1));
				allowing(testValues).getItemCount();
				will(returnValue(2));
			}
		});
		double[] values = new double[2];
		KeyedValues output = DataUtilities.getCumulativePercentages(testValues);
		values[0] = (double) output.getValue(output.getKey(0));
		values[1] = (double) output.getValue(output.getKey(1));
		assertTrue("Values are greater than one or less than 0", values[0] > 1 || values[0] < 0);
		assertTrue("Values are greater than one or less than 0", values[1] > 1 || values[1] < 0);
	}
	
	@Test
	public void testNegativeList() {
		testArray = new Mockery();
		testValues = testArray.mock(KeyedValues.class);
		testArray.checking(new Expectations() {
			{
				allowing(testValues).getValue(0);
				will(returnValue(-100));
				allowing(testValues).getKey(0);
				will(returnValue(0));
				allowing(testValues).getValue(1);
				will(returnValue(-12));
				allowing(testValues).getKey(1);
				will(returnValue(1));
				allowing(testValues).getItemCount();
				will(returnValue(2));
			}
		});
		double[] values = new double[2];
		KeyedValues output = DataUtilities.getCumulativePercentages(testValues);
		values[0] = (double) output.getValue(output.getKey(0));
		values[1] = (double) output.getValue(output.getKey(1));
		assertTrue("Values are greater than one or less than 0", values[0] > 1 || values[0] < 0);
		assertTrue("Values are greater than one or less than 0", values[1] > 1 || values[1] < 0);
		
	}
	
	@Test
	public void testValueNull() {
		testArray = new Mockery();
		testValues = testArray.mock(KeyedValues.class);
		testArray.checking(new Expectations() {
			{
				allowing(testValues).getValue(0);
				will(throwException(new UnknownKeyException ("0")));
				
				allowing(testValues).getItemCount();
				will(returnValue(1));
			}
		});
		int asserting = 0;
		try {
			DataUtilities.getCumulativePercentages(testValues);
		} catch (Exception e) {
			asserting = 1;
		}
		if (asserting == 0) {
			assertTrue(false);
		}
	}
	
	@Test
	//null argument passed
	public void testNull() {
		
		int asserting = 0;
		try {
			DataUtilities.getCumulativePercentages(null);
		} catch (Exception e) {
			asserting = 1;
		}
		if (asserting == 0) {
			assertTrue(false);
		}
	}

}
