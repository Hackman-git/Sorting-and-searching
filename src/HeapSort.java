import java.util.ArrayList;

class HeapSort<T extends Comparable<T>> {
    private ArrayList<T> arr;
    private int size;
    private int count = 0;

    HeapSort(ArrayList<T> arr){
        this.arr = arr;
        this.size = arr.size();
    }

    private void generateSwaps(){
        for (int i = arr.size()/2; i >=0; i--){
            siftDown(i);
        }
    }

    private int leftChild(int i){
        return (2*i + 1);
    }

    private int rightChild(int i){
        return (2*i + 2);
    }

    private void siftDown(int i){
        int maxIndex = i;
        int l = leftChild(i);
        if (l < size && (arr.get(l).compareTo(arr.get(maxIndex)) > 0)){
            maxIndex = l;
        }
        int r = rightChild(i);
        if (r < size && (arr.get(r).compareTo(arr.get(maxIndex)) > 0)){
            maxIndex = r;
        }
        if (i != maxIndex){
            T temp = arr.get(i);
            arr.set(i, arr.get(maxIndex));
            arr.set(maxIndex, temp);
            count++;
            siftDown(maxIndex);
        }
    }

    void heapSort(){
        generateSwaps();
        System.out.println();
        for (int i = 0; i < (arr.size()-1); i++){
            T temp = arr.get(0);
            arr.set(0, arr.get(size - 1));
            arr.set(size-1, temp);
            size -= 1;
            count++;
            siftDown(0);
        }
    }

    private void printValues(){
        for (T i: arr) {
            System.out.println(i);
        }
    }
}
