import java.util.ArrayList;

/*
    This search algorithm works by divide and conquer and achieves
    a much faster searching time complexity than linear search
    precondition: The list must be in sorted order
 */
class BinarySearch<T extends Comparable<T>> {
    private ArrayList<T> array;
    private int count = 0;

    //    The binarySearch method splits the list into 2 parts recursively and
//    searches the appropriate portion
    String binarySearch(ArrayList<T> arr, int first, int last, T target) {
//        get the middle index
        int mid = (first + last) / 2;

//        stop when the whole list has been searched and the element is still not found
        if (first > last) {
            System.out.println("total number of comparisons:" + count);
            return "the element was not found!";
        }

//        check if the element is equal to the midpoint
        else {
            if (target.compareTo(arr.get(mid)) == 0) {
                count++;
                System.out.println("total number of comparisons:" + count);
                return "The element was found";
            }
//           if the element is greater than the midpoint search the right portion of the split
            else {
                if (target.compareTo(arr.get(mid)) > 0) {
                    count++;
                    return binarySearch(arr, mid + 1, last, target);
                }
//              if the element is less than the midpoint search the left portion of the split
                else {
                    count++;
                    return binarySearch(arr, first, mid - 1, target);
                }
            }
        }
    }

}
