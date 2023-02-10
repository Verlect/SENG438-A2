package original.test;

import static org.junit.Assert.*;

import java.util.List;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Range;
import org.jfree.data.UnknownKeyException;
import org.junit.*;

public class ArrayTest2D {
	
	//This test case checks that the method returns 
	//the expected output for valid input data. 
	//The input data is a 2D array of doubles, 
    //and the expected output is a 2D array of Number objects.
	
	@Test
    public void testWithValidPositive() {
        double[][] data = {{1.0, 2.0,3.0}, {4.0, 5.0, 6.0}};
        Number[][] expected = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
        Number[][] result = DataUtilities.createNumberArray2D(data);
        assertArrayEquals(expected, result);
    }

   

	@Test
    public void testWithEmptyInputData() {
        double[][] data = {{}};
        Number[][] expected = {{}};
        Number[][] result = DataUtilities.createNumberArray2D(data);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testOutputNegative() {
        double[][] data = {{-1.0, -2.0, -3.0}, {-4.0, -5.0, -6.0}};
        Number[][] expected = {{-1.0, -2.0, -3.0}, {-4.0, -5.0, -6.0}};
        Number[][] result = DataUtilities.createNumberArray2D(data);
        assertArrayEquals(expected, result);
    }
    
    
    @Test
    public void testNull() {
    	boolean test = false;
        try {
        	Number[][] result = DataUtilities.createNumberArray2D(null);
        } catch (Exception e) {
        	test = true;
        }
        assertTrue(test);
        
    }
}
