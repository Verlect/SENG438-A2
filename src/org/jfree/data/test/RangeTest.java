package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.jmock.*;
import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    private Range secondRange;
    private Range thirdRange;
    private Range sameValuesRange;
    //declare mock variable 
  	private Mockery mockingContext;
  	Values2D values;
    
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }
    

    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-1, 1);
    	secondRange = new Range (5, 30);
    	thirdRange = new Range(-30, -5);
    	sameValuesRange = new Range(0,0);
    	
    	//Mock setup
    	mockingContext = new Mockery();
    	values = mockingContext.mock(Values2D.class);
    }
    
    //Testing Contains
    
    @Test
    public void testContainHasValue() {
    	boolean result = exampleRange.contains(0);
    	boolean isTrue = true;
    	
    	assertTrue("0 is in exampleRange (-1,1)", result == isTrue);
    	
    	result = secondRange.contains(0);
    	
    	assertTrue("5 is in thirdRange (5,30)", result == isTrue);
    	
    	result = thirdRange.contains(-5);
    	
    	assertTrue("-5 is in thirdRange (-30,-5)", result == isTrue);
    	
    	result = sameValuesRange.contains(0);
    	
    	assertTrue("0 is in sameValuesRange (-1,1)", result == isTrue);
    }
    
    @Test
    public void testContainsDoesntHaveValue() {
    	boolean result = exampleRange.contains(-100);
    	boolean isTrue = false;
    	
    	assertTrue("-100 is not in exampleRange (-1,1)", result == isTrue);
    	
    	result = secondRange.contains(-100);
    	
    	assertTrue("-100 is not in thirdRange (5,30)", result == isTrue);
    	
    	result = thirdRange.contains(100);
    	
    	assertTrue("100 is not in thirdRange (-30,-5)", result == isTrue);
    	
    	result = sameValuesRange.contains(100);
    	
    	assertTrue("100 is not in sameValuesRange (-1,1)", result == isTrue);
    }
    
    
    
    
    //Testing Length()
    @Test
    public void testContainsNull() {
    	try {
    		Range empty = null;
    		boolean length = empty.contains(0);
    		
    		assertTrue("Did not throw error correctly", false);
    	} catch(Exception e) {
    		assertTrue("Threw error correctly", true);
    	} 
    }
    @Test
    public void testGetLengthnegativelowerpostiviveupper() {
        double length = this.exampleRange.getLength();
        double expectedRange = 2.0;
        assertTrue("Incorrect Range for exampleRange (-1,1)", expectedRange == length);
    }
    
    @Test
    public void testGetLengthbothpositive() {
    	double length = this.secondRange.getLength();
    	double expectedRange = 25.0;
    	assertTrue("Incorrect Range for exampleRange (5,30)", expectedRange == length);
    }
    
    @Test
    public void testGetLengthbothnegative() {
    	double length = this.thirdRange.getLength();
    	double expectedRange = 25.0;
    	assertTrue("Incorrect Range for exampleRange (5,30)", expectedRange == length);
    }
    
    @Test
    public void testGetLengthequalvalue() {
    	double length = this.sameValuesRange.getLength();
    	double expectedRange = 0.0;
    	assertTrue("Incorrect Range for exampleRange (5,30)", expectedRange == length);
    }


    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    
    //Testing getLowerBound()
    @Test
    public void getNegativeLowerBound() {
    	assertEquals("Incorrect Lower Bound was returned.", -1, exampleRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getPositiveLowerBound() {
    	assertEquals("Incorrect Lower Bound was returned.", 5, secondRange.getLowerBound(), .000000001d);
    }
    
    // Testing getUpperBound()
    @Test
    public void getNegativeUpperBound() {
    	assertEquals("Incorrect Upper Bound was returned.", -5, thirdRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getPositiveUpperBound() {
    	assertEquals("Incorrect Upper Bound was returned.", 30, secondRange.getUpperBound(), .000000001d);
    } 
    
    // Testing toString()
    @Test
    public void correctToStringWithPositiveUpperAndLower() {
    	assertEquals("Incorrect String Returned.", "Range[5.0,30.0]", secondRange.toString());
    }
    
    @Test
    public void correctToStringWithNegativeUpperAndLower() {
    	assertEquals("Incorrect String Returned.", "Range[-30.0,-5.0]", thirdRange.toString());
    }
    
    @Test
    public void correctToStringWithNegativeLowerAndPositiveUpper() {
    	assertEquals("Incorrect String Returned.", "Range[-1.0,1.0]", exampleRange.toString());
    }
    
    @Test
    public void correctToStringWithEquivilentLowerAndUpper() {
    	assertEquals("Incorrect String Returned.", "Range[0.0,0.0]", sameValuesRange.toString());
    }
    
    
    
    //=============================================================
    //Chachi's Test
    
    
    //valid test, total of 2 raw
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
		
		assertEquals(calcResult, 10.0, .000000001d);
	}

	
	
	
    
    
    

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	System.out.println("All test completed (hopefully)");
    }
    
    
}
