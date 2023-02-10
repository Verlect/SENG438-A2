**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |  13 |
| -------------- | --- |
| Student Names: | David Tran    |
|                | Bismarck Leung    |
|                | Shichao Han    |
|                | Zirui Wang    |

# 1 Introduction

The following lab document outlines the unit tests that our group has completed for the ``Range`` and ``DataUtilities`` class as part of ``org.jfree.data``. As part of this, we will discuss our unit test strategy, the cases that were developed, team management, challenges faced and finally, feedback on this lab.

# 2 Detailed description of unit test strategy

## Range.java

### getLength()
> Returns the length of the range.

From the included javadoc and preliminary investigation, this method returns the difference between ``upper`` and ``lower``. Then the equivalency and boundary class must be derived by these 2 parameters:

- ``lower`` equals ``upper``
- range is null
- both bounds are zero
- both bounds are negative
- both bounds are positive
- one bound is negative
- one bound is a very large value

Note: Some boundary cases that pertain to the parameters remain untested, such as ``upper``<``lower`` as they're not applicable to this particular method.

### getLowerBound()
> Returns the lower bound for the range.

From the included javadoc and preliminary investigation, this method returns the ``lower`` in a ``Range`` object. Then the equivalency and boundary class must be derived based on this:

- ``lower`` is positive
- ``lower`` is negative
- ``lower`` is zero
- ``lower`` is one less than the maximum value of a java Double
- ``lower`` is the minimum value of a java Double
- range is null

### getUpperBound()
> Returns the upper bound for the range.

From the included javadoc and preliminary investigation, this method returns the ``lower`` in a ``Range`` object. Then the equivalency and boundary class must be derived based on this:

- ``upper`` is positive
- ``upper`` is negative
- ``upper`` is zero
- ``upper`` is the maximum value of a java Double
- ``upper`` is one greater than the minimum value of a java Double
- range is null

### toString()
> Returns a string representation of this Range.

From the included javadoc and preliminary investigation, this method returns "``Range[lower,upper]``". Then the equivalency and boundary class must be derived based on this:

- ``lower`` equals ``upper``
- range is null
- both bounds are zero
- both bounds are negative
- both bounds are positive
- one bound is negative
- one bound is a very large value

### contain()
> Returns if a value is within a range.

From the included javadoc and preliminary investigation, this method returns "``int``" from a range. Then the equivalency and boundary class must be derived based on this:

- ``lower`` equals ``upper``
- range is null
- both bounds are zero
- both bounds are negative
- both bounds are positive
- one bound is negative

...

## DataUtilities

### calculateRowTotal()
> Returns sum total of a row
From the included javadoc and preliminary investigation, this method returns a double from the sun of one row. 

The equivalency and boundary calss can be derived based on:

- Valid row input
- Negative row input
- On bound row input
- Out of bound row input
- Invalid Value2D input
- Null Valud2D input


### calculateColoumTotal()
> Returns sum total of a col
From the included javadoc and preliminary investigation, this method returns a double from the sun of one row. 

The equivalency and boundary calss can be derived based on:

- Valid col input
- Negative col input
- On bound col input
- Out of bound row input
- Invalid Value2D input
- Null Valud2D input

### createNumberArrayTestValid
> convert given double array to number array
From the included javadoc and preliminary investigation, this method returns a double from the sun of one row. 

The equivalency and boundary calss can be derived based on:

- Valid interger input
- Valid decimal 
- Valid Negative input
- Empty array input


### createNumberArray2D()
> this function should return a 2D array that is in the form of number data types

From the included javadoc and preliminary investigation, this method returns "``number``" from a double. Then the equivalency and boundary class must be derived based on this:


- values are negative
- values are positive
- there are no values
- the array is null

...
// including the input partitions you have designed

### getCumulativePercentages(KeyedValues data)

> Returns keyedvalues of the cumulative percentages of the keyvalues inside the list provided as input, the equivalency and boundary class must be derived must be based on this:
- ``positive`` integers in the list
- ``negative`` integers in the list
- if the value inside the list is ``null``
- if the value ``doesn't exist``
# 3 Test cases developed

## Range

### contain()

This test tests ranges by checking if a value is within the range, testContainHasValue and testContainsDoesntHave Value tests all combinations of positive and negative integers. 

|_Method_|_Function_|
|---|---|
| testContainHasValue | this tests tests the values are contained inside the range |
| testContainsDoesntHaveValue | this tests tests the values are contained not inside the range |
| testContainsNull | tests ranges that are null, should give an error |

### length()

This test tests the values returned by the function length(), giving the length of the range.

|_Method_|_Function_|
|---|---|
| getLengthNULL | tests ranges that are null, should give an error |
| testGetLengthnegativelowerpostiviveupper | this test tests the range between a negative to a postitive integer |
| testGetLengthbothpositive | this test tests the range between a positive to a postitive integer |
| testGetLengthbothnegative | this test tests the range between a negative to a negative integer |
| testGetLengthequalvalue | this test tests the range between a two values that are equal |


### getLowerBound()
| _Method_ | _Function_ |
| --------- | -------|
| getNegativeLowerBound | `lower`  is negative|
| getPositiveLowerBound |   `lower`  is positive|
| getZeroLowerBound |   `lower`  is zero|
| getOneLessThanMaxDoubleLowerBound | `lower`  is one less than the maximum value of a java Double|
| getMinimumDoubleLowerBound |   `lower`  is the minimum value of a java Double|
|getNullLowerBound|  range is null|

### getUpperBound()
| _Method_ | _Function_ |
| --- | --- |
|getNegativeUpperBound | `upper`  is negative |
|getPositiveUpperBound | `upper`  is positive|
|getZeroUpperBound | `upper`  is zero|
|getMaximumDoubleUpperBound | `upper`  is the maximum value of a java Double|
|getOneGreaterThanMinDoubleUpperBound |   `upper`  is one greater than the minimum value of a java Double|
|getNullUpperBound|  range is null|

### toString()
| _Method_ | _Function_ |
| --- | --- |
|correctToStringWithPositiveUpperAndLower |   both bounds are positive |
|correctToStringWithNegativeUpperAndLower |  both bounds are negative |
|correctToStringWithNegativeLowerAndPositiveUpper | one bound is negative |
|correctToStringWithEquivilentLowerAndUpper |   `lower`  equals  `upper` , both bounds are zero|
|correctToStringWithNullRange | range is null|
|correctToStringWithVeryLargeBound |one bound is a very large value|

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

## DataUltilitiesCummulativePercentageTest.java

### getCumulativePercentages(KeyedValues data)

These tests uses mockery to tests the values returned by the function getCumulativePercentages(KeyedValues data), giving the cumulative percentages of teh values inside the keyedvalues.

|_Method_|_Function_|
|---|---|
| testFirstList | tests a list that has positive numbers |
| testNegativeList | this test tests a list that has negative numbers  |
| testValueNull | this test tests the list if there was a value that doesn't exist |
| testNull | this test tests the function on a null keyedvalues |

# 4 How the team work/effort was divided and managed

For distributing the work, our group divided the required 10 methods evenly amongst the 4 of us. As such each person was initially assigned 2 methods each and would transition to covering the last 2 methods, aiding in the completion of another method or completion of the assignment write-up, depending on the current state of the assignment. 

# 5 Difficulties encountered, challenges overcome, and lessons learned
The first thing is team communication, Depending on our writing tests and having regular meetings to discuss and coordinate their work. So it is easy to overcome when we have different approaches to writing tests, which can lead to difficulty communicating and coordinating their work. On the other hand, test management is still critical because we may need help managing and organizing extensive tests when different team members are responsible for different parts of the code. However, we are tracking our processes all the time, and we have good communication so that we overcome these challenges as well. Moreover, we leraned how to use version control systems, like Git, and organizing tests into suites and categories can help teams manage and maintain their tests. Also, Establishing a clear process for writing, updating, and maintaining tests can help teams work more efficiently and effectively with JUnit and Jmock.


# 6 Comments/feedback on the lab itself
Provide a better example of Mocking, and the specific requirement is needed.
Update version for Eclipse IDE.
Need more precise instructions about this lab, and something still needs to be clarified.

