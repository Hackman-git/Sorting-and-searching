import java.util.ArrayList;

class LinearSearch<T extends Comparable<T>> {
    private ArrayList<T> arr;

    String search(ArrayList<T> array, T value){
        int count = 0;
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
