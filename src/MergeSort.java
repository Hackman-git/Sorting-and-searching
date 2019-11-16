import java.util.ArrayList;

/*
    The merge sort is an efficient sorting algorithm that applies a divide and
    conquer approach to sorting a list of elements. It splits the list recursively
    to a granular level and then sorts while merging back all the elements.
 */
class MergeSort<T extends Comparable<T>> {
    private ArrayList<T> arr;
    private int count = 0;

    //    class constructor
    MergeSort(ArrayList<T> arr) {
        this.arr = arr;
    }

    //    performing the merge operation of the split values
    private void merge(int leftFirst, int leftLast, int rightFirst, int rightLast) {
//        create temporary array to store sorted values
        T[] temp = (T[]) new Comparable[arr.size()];

//        index is the starting point of sorted elements, hence leftFirst
        int index = leftFirst;

//        store the starting index of sorting from the original list in a variable
        int save = leftFirst;

//      compare the first values of the two subarrays and store the smallest in the temp array
        while ((leftFirst <= leftLast) && (rightFirst <= rightLast)) {
            if (arr.get(leftFirst).compareTo(arr.get(rightFirst)) < 0) {
                temp[index] = arr.get(leftFirst);
                leftFirst++;
                count++;
            } else {
                temp[index] = arr.get(rightFirst);
                rightFirst++;
                count++;
            }
            index++;
        }
//      if elements remain in the left subarray after the previous selection process move them
//        to the temporary array
        while (leftFirst <= leftLast) {
            temp[index] = arr.get(leftFirst);
            leftFirst++;
            index++;
            count++;
        }

//      if elements remain in the right subarray after the previous selection process move them
//        to the temporary array
        while (rightFirst <= rightLast) {
            temp[index] = arr.get(rightFirst);
            rightFirst++;
            index++;
            count++;
        }

//      move the sorted values to the original list starting from the saved starting index
        for (index = save; index <= rightLast; index++) {
            arr.set(index, temp[index]);
            count++;
        }
    }

    //   performing the merge sort operation
    void mergeSort(int first, int last) {
        if (first < last) {
//          splitting the list recursively
            int middle = (first + last) / 2;

//           recursion on the left split
            mergeSort(first, middle);

//           recursion on the right split
            mergeSort(middle + 1, last);

//           calling the merge method on the two splits
            merge(first, middle, middle + 1, last);
        }
    }

    //    printing the values of the array list
    void printValues() {
        for (T i : arr) {
            System.out.println(i);
        }
    }

}
