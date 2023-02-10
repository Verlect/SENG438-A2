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

### bismarckIncludeYourMethodHere()
> Returns...

...

## DataUtilities

### chachiMethodsHere()
> Returns ...

...

### samuelMethodsHere()
> Returns ...

...
// including the input partitions you have designed

# 3 Test cases developed

Text…

## Range

### contain()

This test tests ranges by checking if a value is within the range. 

|_Method_|_Function_|
|---|---|
| testContainHasValue | this tests tests the values are contained inside the range |
| testContainsDoesntHaveValue | this tests tests the values are contained not inside the range |
| testContainsNull | tests ranges that are null |

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

For distributing the work, our group divided the required 10 methods evenly amongst the 4 of us. As such each person was initially assigned 2 methods each and would transition to covering the last 2 methods, aiding in the completion of another method or completion of the assignment write-up, depending on the current state of the assignment. 

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

Text…
