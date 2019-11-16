import java.util.ArrayList;

/*
   This class implements the bubble sort algorithm
 */
class Bubblesort<T extends Comparable<T>> {
    private ArrayList<T> arr;
    private int count = 0;

    //    class constructor
    Bubblesort(ArrayList<T> arr) {
        this.arr = arr;
    }

    //    swapping two specified elements in the arraylist
    private void Swap(int index1, int index2) {
        T temp = arr.get(index1);
        arr.set(index1, arr.get(index2));
        arr.set(index2, temp);
    }

    //    printing the values of the arraylist
    void printValues() {
        for (T i : arr
        ) {
            System.out.println(i);
        }
    }

    //    this method swaps each element in a range of indices to eventually achieve an ascending order
    private void bubbleUp(int startIndex, int endIndex) {
        for (int index = endIndex; index > startIndex; index--) {
            if (arr.get(index).compareTo(arr.get(index - 1)) < 0) {
                Swap(index, index - 1);
                count++;
            }
        }
    }

    //    this method calls BubbleUp iteratively to sort the whole arraylist of elements
    void bubbleSort() {
        int current = 0;
        while (current < (arr.size() - 1)) {
            bubbleUp(current, arr.size() - 1);
            current++;
        }
    }

}
