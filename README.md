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
   3.3. [Add noDups() method](#33-add-nodups-method)  
   3.4. [Add oddEvenSort() method](#34-add-oddevensort-method)  
   3.5. [Modify insertionSort() method with counting](#35-modify-insertionsort-method-with-counting)  
   3.6. [Modify insertionSort() method with remove duplicates](#36-modify-insertionsort-method-with-remove-duplicates)

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
You'll need a second array, which will end up inversely sorted.
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
numbers of data items. In your algorithm, you will need to compare the keys of
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
overwrite any duplicates with a null (or a distinctive value that is not used for
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
item from right to left. You'll need two outer indexes, one on the right (the old
out) and another on the left.

**My modifying of bubbleSort() method:**

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

### 3.3. Add noDups() method

To the insertSort.java program, add a method called noDups() that
removes duplicates from a previously sorted array without disrupting the order.
(You can use the insertionSort() method to sort the data, or you can simply
use main() to insert the data in sorted order.) One can imagine schemes in
which all the items from the place where a duplicate was discovered to the end
of the array would be shifted down one space every time a duplicate was
discovered, but this would lead to slow O(N²) time, at least when there were a
lot of duplicates. In your algorithm, make sure no item is moved more than
once, no matter how many duplicates there are. This will give you an algorithm
with O(N) time.

**My implementation of noDups() method:**

```
public void noDups() {
    long[] temp = new long[nElems];
    int j = 0, k = 0;
    for (int i = 0; i < nElems - 1; i++) {
        if (a[i] != a[i + 1]) {
            temp[j++] = a[i];
        } else {
            k++;
        }
    }
    temp[j] = a[nElems - 1];
    nElems -= k;
    if (nElems >= 0) System.arraycopy(temp, 0, a, 0, nElems);
}
```

### 3.4. Add oddEvenSort() method

Another simple sort is the odd-even sort. The idea is to repeatedly make two
passes through the array. On the first pass you look at all the pairs of items,
a[j] and a[j + 1] where j is odd (j = 1, 3, 5, ...). If their key values are out of
order, you swap them. On the second pass you do the same for all the even
values (j = 2, 4, 6, ...). You do these two passes repeatedly until the array is
sorted. Replace the bubbleSort() method in bubbleSort.java with
an oddEvenSort() method. Make sure it works for varying amounts of data.
You'll need to figure out how many times to do the two passes.  
The odd-even sort is actually useful in a multiprocessing environment, where a
separate processor can operate on each odd pair simultaneously and then on
each even pair. Because the odd pairs are independent of each other, each pair
can be checked—and swapped, if necessary—by a different processor. This
makes for a very fast sort.

**My implementation of oddEvenSort() method:**

```
public void oddEvenSort() {
    boolean isSorted = true;
    int count = 0;
    while (isSorted) {
        int flag = 0;
        for (int i = 0; i < nElems - 1; i += 2) {
        if (a[i] > a[i + 1]) {
                swap(i, i + 1);
                flag++;
            }
        }
        for (int i = 1; i < nElems - 1; i += 2) {
            if (a[i] > a[i + 1]) {
                swap(i, i + 1);
                flag++;
            }
        }
        if (flag == 0) {
            isSorted = false;
        } else {
            count++;
        }
    }
    System.out.println("The two passes were made: " + count + " times");
}
```

### 3.5. Modify insertionSort() method with counting

Modify the insertionSort() method in insertSort.java, so it counts
the number of copies and the number of comparisons it makes during a sort
and displays the totals.
To count comparisons, you'll need to break up the
double condition in the inner while loop.
Use this program to measure the
number of copies and comparisons for different amounts of inversely sorted
data.
Do the results verify O(N²) efficiency?
Do the same for almost-sorted data
(only a few items out of place).
What can you deduce about the efficiency of
this algorithm for almost-sorted data?

**My implementation of insertionSort() method:**

```
public void insertionSort() {
    int in, out, comp = 0, perm = 0;
    for (out = 1; out < nElems; out++) // out is dividing line
    {
        long temp = a[out]; // remove marked item
        in = out; // start shifts at out
        while (a[in - 1] >= temp) // until one is smaller,
        {
            a[in] = a[in - 1]; // shift item to right
            --in; // go left one position
            comp++;
            perm++;
            if (in == 0) {
                break;
            }
        }
        a[in] = temp; // insert marked item
        perm++;
    }
    System.out.println("Comparisons: " + comp + "\tPermutations: " + perm);
}
```

### 3.6. Modify insertionSort() method with remove duplicates

Here’s an interesting way to remove duplicates from an array.
The insertion sort
uses a loop-within-a-loop algorithm that compares every item in the array with
every other item.
If you want to remove duplicates, this is one way to start.
Modify the insertionSort() method in the
insertSort.java program so that it removes duplicates as it sorts.
Here’s one
approach: When a duplicate is found, write over one of the duplicated items
with a key value less than any normally used (such as –1, if all the normal keys
are positive).
Then the normal insertion sort algorithm, treating this new key
like any other item, will put it at index 0.
From now on, the algorithm can
ignore this item.
The next duplicate will go at index 1, and so on.
When the
sort is finished, all the removed dups (now represented by –1 values) will be
found at the beginning of the array.
The array can then be resized and shifted
down, so it starts at 0.

**My implementation of insertionSort() method:**

```
public void insertionSort() {
    int in, out, comp = 0, perm = 0;
    for (out = 1; out < nElems; out++) // out is dividing line
    {
        long temp = a[out]; // remove marked item
        in = out; // start shifts at out
        while (a[in - 1] >= temp) // until one is smaller,
        {
            if (a[in - 1] == temp)
                temp = -1;

        a[in] = a[in - 1]; // shift item to right
        --in; // go left one position
        comp++;
        perm++;
        if (in == 0)
            break;
        }
        a[in] = temp; // insert marked item
        perm++;
    }
    for (int i = 0; i < nElems; i++)
        if (a[0] == -1)
            delete(-1);
        else
            break;
    System.out.println("Comparisons: " + comp + "\tPermutations: " + perm);
}
```