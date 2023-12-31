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
4. [Chapter IV. Stacks and Queues](#chapter-iv-stacks-and-queues)  
   4.1. [Write a method display()](#41-write-a-method-display)  
   4.2. [Create a Deque class](#42-create-a-deque-class)  
   4.3. [Write a stack based on the Deque](#43-write-a-stack-based-on-the-deque)  
   4.4. [Quiq insert in PriorityQ](#44-quick-insert-in-priotiryq)
5. [Chapter V. Linked lists](#chapter-v-linked-lists)  
   5.1. [PriorityQ on linked list inplementation](#51-priorityq-on-linked-list-inplementation)  
   5.2. [Deque on doubly linked list inplementation](#52-deque-on-doubly-linked-list-inplementation)  
   5.3. [Make a singly linked circular list](#53-make-a-singly-linked-circular-list)
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

## Chapter IV. Stacks and Queues

### 4.1. Write a method display()

Write a method for the Queue class in the queue.java program that
displays the contents of the queue.
Note that this does not mean simply
displaying the contents of the underlying array.
You should show the queue
contents from the first item inserted to the last, without indicating to the
viewer whether the sequence is broken by wrapping around the end of the
array.
Be careful that one item and no items display properly, no matter where
the front and rear are.

**My implementation of display() method:**

```
public void display() {
    if (!isEmpty()) {
        int i;
        if (rear < front) {
            for (i = front; i != maxSize; i++)
                System.out.print(queArray[i] + "\t");
            for (i = 0; i < rear; i++)
                System.out.print(queArray[i] + "\t");
        } else
            for (i = front; i <= rear; i++)
                System.out.print(queArray[i] + "\t");
        for (; i < maxSize; i++)
            System.out.print('░' + "\t");
    } else
        for (int i = 0; i < maxSize; i++)
            System.out.print('░' + "\t");
}
```

### 4.2. Create a Deque class

Create a Deque class based on the discussion of deques (double-ended queues) in
this chapter. It should include insertLeft(), insertRight(), removeLeft(),
removeRight(), isEmpty(), and isFull() methods. It will need to support wraparound
at the end of the array, as queues do.

**My implementation of Deque class:**

```
public class Deque {

    private final long[] dequeArray;
    private final int maxSize;
    private int front, rear;
    private int nElems;

    public Deque(int size) {
        this.maxSize = size;
        this.dequeArray = new long[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nElems = 0;
    }

    public void insertLeft(long value) {
        if (!isFull()) {
            if (rear == maxSize - 1)
                rear = -1;
            shift(value);
        } else
            System.err.println("Can't insert the value " + value + "\nDeque is full");
    }

    public void removeLeft() {
        if (!isEmpty()) {
            front++;
            if (front == maxSize)
                front = 0;
            nElems--;
        } else
            System.err.println("Can't remove the value.\nQueue is empty");
    }

    public void insertRight(long value) {
        if (!isFull()) {
            if (rear == maxSize - 1)
                rear = -1;
            dequeArray[++rear] = value;
            nElems++;
        } else
            System.err.println("Can't insert the value " + value + "\nDeque is full");
    }

    public void removeRight() {
        if (!isEmpty()) {
            rear--;
            if (rear == maxSize)
                rear = -1;
            nElems--;
        } else
            System.err.println("Can't remove the value.\nQueue is empty");
    }

    public long peekFront() {
        if (isEmpty()) {
            System.err.println("Can't peek.\nDeque is empty");
        }
        return dequeArray[front];
    }

    public boolean isEmpty() {
        return nElems == 0;
    }

    public boolean isFull() {
        return maxSize == nElems;
    }

    private void shift(long value) {
        if (rear == -1 || rear < front) {
            dequeArray[++rear] = value;
        } else {
            for (int i = rear; i >= 0; i--)
                dequeArray[i + 1] = dequeArray[i];
            dequeArray[front] = value;
            rear++;
        }
        nElems++;
    }
}
```

### 4.3. Write a stack based on the Deque

Write a program that implements a stack class that is based on the Deque class
in Programming Project 4.2. This stack class should have the same methods
and capabilities as the StackX class in the stack.java program.

**My implementation of Stack:**

```
import exercises.chapter_4_stacks_and_queues.deque.Deque;

public class StackOnDeque {
    private final Deque deque;

    public StackOnDeque(int maxSize) {
        this.deque = new Deque(maxSize);
    }

    public void push(long value) {
        deque.insertRight(value);
    }

    public void pop() {
        deque.removeRight();
    }

    public long peek() {
        return deque.peekRear();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.isFull();
    }
}
```

### 4.4. Quick insert in PriorityQ

The priority queue features fast removal of the high-priority
item but slow insertion of new items. Write a program with a revised
PriorityQ class that has fast O(1) insertion time but slower removal of the highpriority
item. Include a method that displays the contents of the priority
queue.

**My implementation of PriorityQ:**

```
public class PriorityQ {
    private final int maxSize;
    private final long[] queArray;
    private int nItems;


    public PriorityQ(int s) // constructor
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    // insert item
    public void insert(long item) {
        if (!isFull())
            queArray[nItems++] = item;
        else
            System.err.println("Can't insert the value " + item + "\nDeque is full");
    }

    // remove minimum item
    public long remove() {
        long minVal = peekMin();
        if (!isEmpty()) {
            int i;
            for (i = 0; i < nItems; i++) {
                if (minVal == queArray[i])
                    break;
            }
            for (int j = i; j < nItems - 1; j++) {
                queArray[j] = queArray[j + 1];
            }
            nItems--;
        }
        return minVal;
    }

    // peek at minimum item
    public long peekMin() {
        long min = queArray[0];
        if (!isEmpty()) {
            for (int i = 1; i < nItems; i++) {
                if (queArray[i] < min)
                    min = queArray[i];
            }
        } else
            System.err.println("Can't peek.\nDeque is full");
        return min;
    }

    public void display() {
        if (!isEmpty()) {
            while (!isEmpty()) {
                long n = remove();
                System.out.print(n + "\t");
            }
        } else {
            System.err.println("Queue is empty");
        }
    }

    // true if the queue is empty
    public boolean isEmpty() {
        return (nItems == 0);
    }

    // true if the queue is full
    public boolean isFull() {
        return (nItems == maxSize);
    }
}
```

## Chapter V. Linked Lists

### 5.1. PriorityQ on linked list inplementation

Implement a priority queue based on a sorted linked list.
The remove operationon the priority queue should remove the item with the smallest key.

**My implementation of PriorityQ based on a sorted linked list:**

```
import exercises.chapter_5_linked_lists.first_last_list.Link;
import exercises.chapter_5_linked_lists.sorted_list.SortedList;

public class PriorityQueue {
    private final SortedList list;

    public PriorityQueue() {
        this.list = new SortedList();
    }

    public void insert(long data) {
        list.insert(data);
    }

    public Link remove() {
        return list.remove();
    }

    public long peek() {
        return list.peek();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
```

### 5.2. Deque on doubly linked list inplementation

Implement a deque based on a doubly linked list. The user should be able to carry
out the normaloperations on the deque

**My implementation of Deque based on a doubly linked list:**

```
import exercises.chapter_5_linked_lists.doubly_linked_list.DoublyLinkedList;
import exercises.chapter_5_linked_lists.doubly_linked_list.Link;

public class Deque {
    private final DoublyLinkedList list;

    public Deque() {
        this.list = new DoublyLinkedList();
    }

    public void insertLeft(long data) {
        list.insertFirst(data);
    }

    public void insertRight(long data) {
        list.insertLast(data);
    }

    public Link removeLeft() {
        return list.deleteFirst();
    }

    public Link removeRight() {
        return list.deleteLast();
    }

    public long peekFront() {
        return list.peekFirst();
    }

    public long peekRear() {
        return list.peekLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
```

### 5.3. Make a singly linked circular list

A circular list is a linked list in which the last link points back to the first link.
There are many ways to design a circular list. Sometimes there is a pointer to
the “start” of the list. However, this makes the list less like a real circle and
more like an ordinary list that has its end attached to its beginning. Make a
class for a singly linked circular list that has no end and no beginning. The
only access to the list is a single reference, current, that can point to any link
on the list. This reference can move around the list as needed. Your list should handle insertion, searching, and deletion. You may
find it convenient if these operations take place one link downstream of the
link pointed to by current. (Because the upstream link is singly linked, you
can’t get at it without going all the way around the circle.) You should also be
able to display the list (although you’ll need to break the circle at some arbitrary
point to print it on the screen). A step() method that moves current
along to the next link might come in handy too.

**My implementation of Circular linked list:**

```
public class CircularList {
    private Link current;

    public void insert(int data) {
        Link newLink = new Link(data);
        if (!isEmpty()) {
            newLink.next = current.next;
            current.next = newLink;
            current = newLink;
        } else {
            current = newLink;
            current.next = newLink;
        }
    }

    public void displayList() {
        System.out.println("first --> last");
        Link cur = current.next;
        while (cur != current) {
            cur.displayLink();
            cur = cur.next;
        }
        cur.displayLink();
        System.out.println();
    }

    public Link find(long data) {
        if (!isEmpty()) {
            Link desiredLink = current.next;
            while (desiredLink.data != data) {
                if (desiredLink == current) {
                    return null;
                }
                desiredLink = desiredLink.next;
            }
            return desiredLink;
        }
        return null;
    }

    public Link remove(long data) {
        if (!isEmpty()) {
            Link cur = current.next, prev = current;
            while (cur.data != data) {
                if (cur == current) {
                    return null;
                }
                prev = cur;
                cur = cur.next;
            }
            prev.next = cur.next;
        }
        return null;
    }

    public boolean isEmpty() {
        return current == null;
    }
}
```