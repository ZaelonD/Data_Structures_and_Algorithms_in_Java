package exercises.chapter_2_arrays.order;

public class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        OrdArray arr; // reference to array
        arr = new OrdArray(maxSize); // create the array
        arr.insert(77); // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);
        int searchKey = 55; // search for item
        if (arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can’t find " + searchKey);
        arr.display(); // display items
        System.out.println();
        arr.delete(0); // delete 3 items
        arr.delete(55);
        arr.delete(99);
        arr.display(); // display items again
    }
}
