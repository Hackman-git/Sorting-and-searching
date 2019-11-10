import java.util.ArrayList;

class BinarySearch<T extends Comparable<T>> {
    private ArrayList<T> array;
    private int count = 0;

    String binarySearch(ArrayList<T> arr, int first, int last, T target){
        int mid = (first + last) / 2;
        if (first > last) {
            System.out.println("total number of comparisons:" + count);
            return "the element was not found!";
        }else {
            if (target.compareTo(arr.get(mid)) == 0){
                count++;
                System.out.println("total number of comparisons:" + count);
                return "The element was found";
            }else {
                if (target.compareTo(arr.get(mid)) > 0){
                    count++;
                    return binarySearch(arr, mid+1, last, target);
                }else {
                    count++;
                    return binarySearch(arr, first, mid-1, target);
                }
            }
        }
    }

}
