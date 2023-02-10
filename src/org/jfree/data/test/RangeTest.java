package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    private Range secondRange;
    private Range thirdRange;
    private Range sameValuesRange;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }
    

    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-1, 1);
    	secondRange = new Range (5, 30);
    	thirdRange = new Range(-30, -5);
    	sameValuesRange = new Range(0,0);
    }
    
    //Testing Contains
    
    public void testContainHasValue() {
    	boolean result = exampleRange.contains(0);
    	boolean isTrue = false;
    	
    	if (exampleRange.getLowerBound() >= 0 && exampleRange.getUpperBound() <= 0) {
    		isTrue = true;
    	}
    	
    	assertTrue("0 is in exampleRange (-1,1)", result == isTrue);
    	
    	result = thirdRange.contains(0);
    	isTrue = false;
    	
    	if (thirdRange.getLowerBound() >= 0 && thirdRange.getUpperBound() <= 0) {
    		isTrue = true;
    	}
    	
    	assertTrue("0 is in thirdRange (-1,1)", result == isTrue);
    	
    	result = sameValuesRange.contains(0);
    	isTrue = false;
    	
    	if (sameValuesRange.getLowerBound() >= 0 && sameValuesRange.getUpperBound() <= 0) {
    		isTrue = true;
    	}
    	
    	assertTrue("0 is in sameValuesRange (-1,1)", result == isTrue);
    }
    
    public void testContainsDoesntHaveValue() {
    	boolean result = secondRange.contains(0);
    	boolean isTrue = false;
    	
    	if (secondRange.getLowerBound() >= 0 && secondRange.getUpperBound() <= 0) {
    		isTrue = true;
    	}
    	
    	assertTrue("0 is in secondRange (-1,1)", result == isTrue);
    }
    
    
    //Testing Length()
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
    

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    
}
