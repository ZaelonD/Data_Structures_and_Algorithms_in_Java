package exercises.chapter_2_arrays;

public class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        HighArray arr; // reference to array
        arr = new HighArray(maxSize); // create the array
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
        arr.display(); // display items
        System.out.println("\nMax key = " + arr.removeMax()); // testing removeMax method
        arr.display(); // display items
        int searchKey = 35; // search for item
        if (arr.find(searchKey))
            System.out.println("\nFound " + searchKey);
        else
            System.out.println("\nCan’t find " + searchKey);
        arr.delete(0); // delete 3 items
        arr.delete(55);
        arr.delete(99);
        arr.display(); // display items again
        System.out.println("\nMax key = " + arr.removeMax());
        arr.display(); // display items again
    }
}