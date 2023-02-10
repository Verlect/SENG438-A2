package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.jmock.*;
import org.junit.*;

/*
 * This test will test DataUtilites class 
 * function includes:
 * calculateColumTotal, calculateTowTotal, creatNumberArray
 * createNumberArray2D, getCumulativePercentages
 */

public class DataUtilitiesTest {
    //declare mock variable 
  	private Mockery mockingContext;
  	Values2D values;
    
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }
    

    @Before
    public void setUp() throws Exception { 
    	//Mock setup
    	mockingContext = new Mockery();
    	values = mockingContext.mock(Values2D.class);
    }
    
    
    
    //=============================================================
    //Chachi's Test
    
    
    //valid test, test row sum total for table of two column 
    //Mock table of two column and return 4.5 and 5.5 
    //for position of [0,1] and [1,0]
    //function should return (double) 10 as sum
	@Test
	public void calculateRowTotalTwoValids() {
		mockingContext.checking(new Expectations() {
			{
				
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0,0);
				will(returnValue(4.5));
				one(values).getValue(0, 1);
				will(returnValue(5.5));
			}
		});
		double calcResult = DataUtilities.calculateRowTotal(values, 0);
		//System.out.println(calcResult);
		assertEquals(calcResult, 10.0, .000000001d);
	}

	
	//test for calculating invalid raw index sums
	//mock for table of 2 column but only one raw
	//call function to calculate the 2nd row of the table
	//out of bound exception should be throw
	@Test(expected = IndexOutOfBoundsException.class)
	public void calculateRowTotalOutOfBounds() {
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0,0);
				will(returnValue(4.5));
				one(values).getValue(0, 1);
				will(returnValue(5.5));
				
				one(values).getValue(1, 0);
				will(throwException(new IndexOutOfBoundsException("Index out of bounds")));
				
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 1);
	}
	
	
	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void calculateRowTotalNegativeRows() {
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0,0);
				will(returnValue(4.5));
				one(values).getValue(0, 1);
				will(returnValue(5.5));
				
				one(values).getValue(-1, 0);
				will(throwException(new IndexOutOfBoundsException("Index out of bounds")));
				
			}
		});
		double Result = DataUtilities.calculateRowTotal(values, -1);
	}
	
    
    
    

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	System.out.println("All test completed (hopefully)");
    }
    
    
}
