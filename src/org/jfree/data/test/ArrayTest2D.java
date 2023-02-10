package original.test;

import org.jmock.*;
import static org.junit.Assert.*;

import java.util.List;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Range;
import org.jfree.data.UnknownKeyException;
import org.junit.*;

public class ArrayTest2D {
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

    @Test
    public void testAccuracyOfConversion() {
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
        Number[][] result = DataUtilities.createNumberArray2D(data);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                assertEquals(data[i][j], result[i][j].doubleValue(), 0.0);
            }
        }
    }
}
