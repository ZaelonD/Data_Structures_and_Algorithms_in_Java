# Data_Structures_and_Algorithms_in_Java

## Contents

2. [Chapter II. Arrays](#chapter-ii-arrays)  
   2.1. [Add a method called getMax()](#21-add-a-method-called-getmax)

## Chapter II. Arrays

### 2.1. Add a method called getMax()

To the HighArray class in the highArray.java program,
add a method called getMax() that returns the value of the highest key in the array,
or –1 if the array is empty. Add some code in main() to exercise this method.
You can assume all the keys are positive numbers.

**My implementation of the getMax() method:**

```
public long getMax() {
    if (nElems == 0)
        return -1;
    long max = a[0];
    for (int i = 1; i < nElems; i++)
        if (a[i] > max)
            max = a[i];
    return max;
}
```