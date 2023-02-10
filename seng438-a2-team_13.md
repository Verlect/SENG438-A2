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

// including the input partitions you have designed

# 3 Test cases developed

Text…

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

Text…

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

Text…
