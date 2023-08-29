package exercises.chapter_5_linked_lists.list_insertion_sort;

import exercises.chapter_5_linked_lists.first_last_list.Link;

public class ListInsertionSortApp {
    public static void main(String[] args) {
        int size = 10;
        Link[] linkArray = new Link[size];
        for (int j = 0; j < size; j++) {
            int n = (int) (java.lang.Math.random() * 99);
            Link newLink = new Link(n);
            linkArray[j] = newLink;
        }
        System.out.print("Unsorted array: ");
        for (int j = 0; j < size; j++)
            System.out.print(linkArray[j].dData + " ");
        System.out.println();
        SortedList theSortedList = new SortedList(linkArray);
        for (int j = 0; j < size; j++)
            linkArray[j] = theSortedList.remove();
        System.out.print("Sorted Array: ");
        for (int j = 0; j < size; j++)
            System.out.print(linkArray[j].dData + " ");
        System.out.println();
    }
}
