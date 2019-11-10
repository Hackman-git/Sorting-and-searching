import java.util.ArrayList;

class MergeSort<T extends Comparable<T>> {
    private ArrayList<T> arr;
    private int count = 0;

    MergeSort(ArrayList<T> arr){
        this.arr = arr;
    }

    private void merge(int leftFirst, int leftLast, int rightFirst, int rightLast){
        T[] temp = (T[]) new Comparable[arr.size()];
        int index = leftFirst;
        int save = leftFirst;

        while ((leftFirst <= leftLast) && (rightFirst <= rightLast)){
            if (arr.get(leftFirst).compareTo(arr.get(rightFirst)) < 0){
                temp[index] = arr.get(leftFirst);
                leftFirst++;
                count++;
            }else {
                temp[index] = arr.get(rightFirst);
                rightFirst++;
                count++;
            }
            index ++;
        }

        while (leftFirst <= leftLast){
            temp[index] = arr.get(leftFirst);
            leftFirst++;
            index++;
            count++;
        }

        while (rightFirst <= rightLast){
            temp[index] = arr.get(rightFirst);
            rightFirst++;
            index++;
            count++;
        }

        for (index = save; index <= rightLast; index++){
            arr.set(index, temp[index]);
            count++;
        }
    }

    void mergeSort(int first, int last){
        if (first < last){
            int middle = (first + last) / 2;
            mergeSort(first, middle);
            mergeSort(middle+1, last);
            merge(first, middle,middle + 1, last);
        }
    }

    void printValues(){
        for (T i: arr) {
            System.out.println(i);
        }
    }

}
