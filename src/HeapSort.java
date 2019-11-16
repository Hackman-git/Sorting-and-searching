import java.util.ArrayList;

/*
    This sorting algorithm is a very efficient type and works by
    utilizing the binary max heap structure
 */
class HeapSort<T extends Comparable<T>> {
    //    initializing the arraylist and the heap size
    private ArrayList<T> arr;
    private int size;

    //    class constructor
    HeapSort(ArrayList<T> arr) {
        this.arr = arr;
        this.size = arr.size();
    }

    //   this method builds a heap structure with the elements in the list
    private void generateSwaps() {
//        for each element that is not a leaf of the tree, we call the siftdown operation
        for (int i = arr.size() / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    //    getting the left child of a node
    private int leftChild(int i) {
        return (2 * i + 1);
    }

    //    getting the right child of a node
    private int rightChild(int i) {
        return (2 * i + 2);
    }

    //    the siftDown operation maintains the heap property
    private void siftDown(int i) {
//        initialize the maximum index to i
        int maxIndex = i;
        int l = leftChild(i);

//        if the left child of i is greater than i then the maxindex is now the left child value
        if (l < size && (arr.get(l).compareTo(arr.get(maxIndex)) > 0)) {
            maxIndex = l;
        }
        int r = rightChild(i);

//       if the right child of i is greater than the current maxindex, the right child is now the maxindex
        if (r < size && (arr.get(r).compareTo(arr.get(maxIndex)) > 0)) {
            maxIndex = r;
        }
//        if i is not the maxIndex we perform a swap with the appropriate child and recursively perform
//        siftDown operation on the child that was swapped
        if (i != maxIndex) {
            T temp = arr.get(i);
            arr.set(i, arr.get(maxIndex));
            arr.set(maxIndex, temp);
            siftDown(maxIndex);
        }
    }

    //    this achieves the heap sorting algorithm
    void heapSort() {
//       building the heap first
        generateSwaps();
        System.out.println();

//        each time the max value of the heap(the root node) is swapped with the rightmost
//        leaf and we call siftDown operation on the new root to maintain the heap property
        for (int i = 0; i < (arr.size() - 1); i++) {
            T temp = arr.get(0);
            arr.set(0, arr.get(size - 1));
            arr.set(size - 1, temp);
            size -= 1;
            siftDown(0);
        }
    }

    //   printing the values of the array list
    private void printValues() {
        for (T i : arr) {
            System.out.println(i);
        }
    }
}
