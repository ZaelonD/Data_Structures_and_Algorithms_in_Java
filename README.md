# Data_Structures_and_Algorithms_in_Java

## Contents

1. [Chapter I. Overview](#chapter-i-overview)
2. [Chapter II. Arrays](#chapter-ii-arrays)  
   2.1. [Add a method called getMax()](#21-add-a-method-called-getmax)  
   2.2. [Modify the method getMax() to removeMax()](#22-modify-the-method-getmax-to-removemax)  
   2.3. [Implement a sorting scheme](#23-implement-a-sorting-scheme)  
   2.4. [Insert with use a binary search](#24-insert-with-use-a-binary-search)  
   2.5. [Add merge() method](#25-add-merge-method)  
   2.6. [Add noDups() method](#26-add-nodups-method)
3. [Chapter III. Simple Sorting](#chapter-iii-simple-sorting)  
   3.1. [Modify the bubbleSort() method](#31-modify-the-bubblesort-method)  
   3.2. [Add median() method](#32-add-median-method)

## Chapter I. Overview

### Solving programming projects from the book Data Structures & Algorithms in Java

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

### 2.2. Modify the method getMax() to removeMax()

Modify the method in Programming Project 2.1 so that the item with the
highest key is not only returned by the method, but also removed from the
array. Call the method removeMax().

**My implementation of the removeMax() method:**

```
public long removeMax() {
    if (nElems == 0)
        return -1;
    long max = a[0];
    for (int i = 1; i < nElems; i++)
        if (a[i] > max)
            max = a[i];
    delete(max);
    return max;
}
```

### 2.3. Implement a sorting scheme

The removeMax() method in Programming Project 2.2 suggests a way to sort
the contents of an array by key value. Implement a sorting scheme that does
not require modifying the HighArray class, but only the code in main().
You’ll need a second array, which will end up inversely sorted.
(This scheme is a rather crude variant of the selection sort in Chapter 3, "Simple Sorting.")

**My implementation of sorting scheme:**

```
long elem;
    while ((elem = arr.removeMax()) != -1) {
        arr1.insert(elem);
    }
}
```

### 2.4. Insert with use a binary search

Modify the orderedArray.java program so that the insert() and
delete() routines, as well as find(), use a binary search, as suggested in the text.

**My implementation of insert():**

```
public void insert(long value) {
    int lowerBound = 0;
    int upperBound = nElems - 1;
    int curIn;
    while (true) {
        curIn = (lowerBound + upperBound) / 2;
        if (a[curIn] == value) {
            break;
        } else if (lowerBound > upperBound) {
            if (value >= a[curIn]) {
                if (a[curIn] == 0 && nElems == 0) {
                    curIn = 0;
                } else {
                    curIn++;
                }
            }
            break;
        } else {
            if (a[curIn] < value) {
                lowerBound = curIn + 1;
            } else {
                upperBound = curIn - 1;
            }
        }
    }
    for (int k = nElems; k > curIn; k--) // move bigger ones up
        a[k] = a[k - 1];
    a[curIn] = value; // insert it
    nElems++; // increment size
}
```

### 2.5. Add merge() method

Add a merge() method to the OrdArray class in the orderedArray.java
program so that you can merge two ordered source arrays into an
ordered destination array. Write code in main() that inserts some random
numbers into the two source arrays, invokes merge(), and displays the contents
of the resulting destination array. The source arrays may hold different
numbers of data items. In your algorithm you will need to compare the keys of
the source arrays, picking the smallest one to copy to the destination. You’ll
also need to handle the situation when one source array exhausts its contents
before the other.

**My implementation of merge() method:**

```
public void merge(long[] inputArr) {
    for (long value : inputArr)
        if (find(value) == nElems)
            insert(value);
}
```

### 2.6. Add noDups() method

Write a noDups() method for the HighArray class of the highArray.java
program. This method should remove all duplicates from the
array. That is, if three items with the key 17 appear in the array, noDups()
should remove two of them. Don’t worry about maintaining the order of the
items. One approach is to first compare every item with all the other items and
overwrite any duplicates with a null (or a distinctive value that isn’t used for
real keys). Then remove all the nulls. Of course, the array size will be reduced.

**My implementation of noDups() method:**

```
public void noDups() {
    for (int i = 0; i < nElems; i++) {
        for (int j = 0; j < nElems; j++) {
            if (i == j)
                continue;
            if (a[i] == a[j]) {
                a[j] = -1;
                delete(-1);
            }
        }
    }
}
```

## Chapter III. Simple Sorting

### 3.1. Modify the bubbleSort() method

In the bubbleSort.java program and the BubbleSort Workshop
applet, the in index always goes from left to right, finding the largest item and
carrying it toward out on the right. Modify the bubbleSort() method so that it’s
bidirectional. This means the in index will first carry the largest item from left
to right as before, but when it reaches out, it will reverse and carry the smallest
item from right to left. You’ll need two outer indexes, one on the right (the old
out) and another on the left.

**My modify of bubbleSort() method:**

```
public void bubbleSort() {
    int right, left, in;
    for (right = nElems - 1, left = 0; right > left + 1; right--, left++) {
        for (in = 0; in < right; in++) // inner loop (forward)
            if (a[in] > a[in + 1]) // right of order?
                swap(in, in + 1); // swap them
        for (in = right - 1; in > left; in--)
            if (a[in] < a[in - 1]) // left of order?
                swap(in, in - 1); // swap them
    }
}
```

### 3.2. Add median() method

Add a method called median() to the ArrayIns class in the insertSort.java
program. This method should return the median value in the
array. (Recall that in a group of numbers half are larger than the median and
half are smaller.) Do it the easy way.

**My implementation of median() method:**

```
public long median() {
    return nElems % 2 == 0 ? (a[nElems / 2] + a[(nElems - 1) / 2]) / 2 : a[nElems / 2];
}
```