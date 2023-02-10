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
    
    
    
    
    
    //Test Length for Ranges
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
