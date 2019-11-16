import java.util.ArrayList;

/*
    This algorithm works in linear time and searches
    for a target value by scanning the whole list
 */
class LinearSearch<T extends Comparable<T>> {
    private ArrayList<T> arr;

    String search(ArrayList<T> array, T value) {
        int count = 0;

//        test each element in the list for equality with the target element
        for (T t : array) {
            count++;
            if (t.compareTo(value) == 0) {
                System.out.println("Total number of comparisons:" + count);
                return "The element was found";
            }
        }
        System.out.println("total number of comparisons:" + count);
        return "The element was not found!";
    }

}
