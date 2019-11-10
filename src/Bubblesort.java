import java.util.ArrayList;

class Bubblesort<T extends Comparable<T>> {
    private ArrayList<T> arr;
    private int count = 0;

    Bubblesort(ArrayList<T> arr){
        this.arr = arr;
    }

    private void Swap(int index1, int index2){
        T temp = arr.get(index1);
        arr.set(index1, arr.get(index2));
        arr.set(index2, temp);
    }

    void printValues(){
        for (T i: arr
        ) {
            System.out.println(i);
        }
    }

    private void bubbleUp(int startIndex, int endIndex){
        for (int index = endIndex; index > startIndex; index--){
            if (arr.get(index).compareTo(arr.get(index-1)) < 0){
                Swap(index, index-1);
                count++;
            }
        }
    }

    void bubbleSort(){
        int current = 0;
        while (current < (arr.size() -1)){
            bubbleUp(current, arr.size()-1);
            current++;
        }
    }

}
