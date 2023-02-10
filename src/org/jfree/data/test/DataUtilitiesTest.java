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
    //=============================================================
    
    /*
     * Begin test for calculateRowTotal-----------------------
     */
    
    //valid test, test row sum total for table of two column 
    //Mock table of two column and return 4.5 and 5.5 
    //for position of [0,1] and [1,0]
    //function should return (double) 10 as sum
	@Test
	public void calculateRowTotalTwoPosValids() {
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
	
	//valid test, test row sum total for table of two column 
    //Mock table of two column and return -4.5 and -5.5 
    //for position of [0,1] and [1,0]
    //function should return (double) 10 as sum
	@Test
	public void calcRowTotalNegativeValids() {
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				
				one(values).getValue(1,0);
				will(returnValue(-3.14));
				one(values).getValue(1, 1);
				will(returnValue(-2));
				
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 1);
		assertEquals(result, -5.14, .000000001d);
	}

	
	//test for calculating out of bound raw index sums
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
		DataUtilities.calculateRowTotal(values, 1);
	}
	
	
	
	//test for calculating invalid raw index sums
	//mock for table of 2 column 
	//call function to calculate the -1 row of the table
	//out of bound exception should be throw
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
		DataUtilities.calculateRowTotal(values, -1);
	}
	
	
	//Test on boundary cases
	//crate table with 3 rows,
	//call function to calculate 3rd row sum
	@Test
	public void calculateRowTotalOnBoundaryValid() {
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				
				
				one(values).getValue(2,0);
				will(returnValue(3.14));
				one(values).getValue(2,1);
				will(returnValue(2));
				
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 2);
		//System.out.println(result);
		assertEquals(result, 5.14, .000000001d);
	}
	
	
	
	//check how function handle invalid input
	//according to specification:
	//With invalid input, a total of zero will be returned.
	@Test
	public void calculateRowTotalInvalidDataInput() {
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(0));
				one(values).getValue(0, 0);
				will(throwException(new NullPointerException("Null entries")));
				
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(result, 0.0000, .000000001d);
	}
	
	
	//pass in null as values2D
	//which should cause a exception
	@Test(expected = Exception.class)
	public void calcRowNullTest() {
		DataUtilities.calculateRowTotal(null, 0);
	}
    
    
	/*
     * End of test for calculateRowTotal----------------------
     */
	
	
	
	/*
     * Begin test for calculateColumnTotal---------------------
     */
	
	
    //valid test, test Column sum total for table of two row 
    //Mock table of two row and return 4.5 and 5.5 
    //for position of [0,1] and [1,0]
    //function should return (double) 10 as sum
	@Test
	public void calculateColumnTotalTwoPosValids() {
		mockingContext.checking(new Expectations() {
			{
				
				one(values).getRowCount();
				will(returnValue(2));
				
				one(values).getValue(0,0);
				will(returnValue(4.5));
				one(values).getValue(1,0);
				will(returnValue(5.5));
			}
		});
		double calcResult = DataUtilities.calculateColumnTotal(values, 0);
		//System.out.println(calcResult);
		assertEquals(calcResult, 10.0, .000000001d);
	}
	
	//valid test, test row sum total for table of two column 
    //Mock table of two column and return -4.5 and -5.5 
    //for position of [0,1] and [1,0]
    //function should return (double) 10 as sum
	@Test
	public void calculateColumnTotalTwoNegativeValids() {
		mockingContext.checking(new Expectations() {
			{
				
				one(values).getRowCount();
				will(returnValue(2));
				
				one(values).getValue(0,0);
				will(returnValue(-9.9));
				one(values).getValue(1,0);
				will(returnValue(-6.4));
			}
		});
		double calcResult = DataUtilities.calculateColumnTotal(values, 0);
		//System.out.println(calcResult);
		assertEquals(calcResult, (-9.9-6.4), .000000001d);
	}

	
	//test for calculating out of bound raw index sums
	//mock for table of 2 row but only one col
	//call function to calculate the 2nd row of the table
	//out of bound exception should be throw
	@Test(expected = IndexOutOfBoundsException.class)
	public void calculateColumnTotalOutOfBounds() {
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				
				one(values).getValue(0, 1);
				will(throwException(new IndexOutOfBoundsException("Index out of bounds")));
				
			}
		});
		DataUtilities.calculateColumnTotal(values, 1);
	}
	
	
	
	//test for calculating invalid raw index sums
	//mock for table of 2 column 
	//call function to calculate the -1 row of the table
	//out of bound exception should be throw
	@Test(expected = IndexOutOfBoundsException.class)
	public void calculateColumnTotalNegativeRows() {
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				
				one(values).getValue(0, -1);
				will(throwException(new IndexOutOfBoundsException("Index out of bounds")));
				
			}
		});
		DataUtilities.calculateColumnTotal(values, -1);
	}
	
	
	//Test on boundary cases
	//crate table with 3 rows,
	//call function to calculate 3rd row sum
	@Test
	public void calculateColumnTotalOnBoundaryValid() {
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				
				
				one(values).getValue(0,2);
				will(returnValue(3.14));
				one(values).getValue(1,2);
				will(returnValue(2));
				
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 2);
		System.out.println(result);
		assertEquals(result, 5.14, .000000001d);
	}
	
	
	
	//check how function handle invalid input
	//according to specification:
	//With invalid input, a total of zero will be returned.
	@Test
	public void calculateColumnTotalInvalidDataInput() {
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(0));
				one(values).getValue(0, 0);
				will(throwException(new NullPointerException("Null entries")));
				
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(result, 0.0000, .000000001d);
	}
	
	
	
	//pass in null as values2D
	//which should cause a exception
	@Test(expected = Exception.class)
	public void calcColumnNullTest() {
		DataUtilities.calculateColumnTotal(null, 0);
	}
	
	
	/*
     * End of test for calculateColumnTotal---------------------------
     */
	
	
	
	
	
	
	
	
	

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	System.out.println("All test completed (hopefully)");
    }
    
    
}
