import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean again = true;
        while (again){
            run();
            System.out.println("\nDo you want to run the program again? Enter 1 for Yes and 2 for No");
            int response = scanner.nextInt();
            if (response != 1){
                again = false;
            }
        }

    }

    private static void run(){
        Menu<String> menu = new Menu<>();
        menu.dataTypeOptions();
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        switch (answer){
            case 1:
                Menu<Float> menu1 = new Menu<>();
                ArrayList<Float> arr;
                double start, end;

                menu1.inputOptions();
                int inputMethod = scanner.nextInt();
                if (inputMethod == 1){
                    arr = menu1.fileDirectoryFloat();
                    if (arr.size() == 0){
                        return;
                    }
                }else {
                    arr = menu1.enteredDataFloat();
                }

                ArrayList<Float> unsortedArray = (ArrayList<Float>) arr.clone();

                menu1.printArray(arr);
                menu1.sortOptions();
                int sortingOption = scanner.nextInt();

                switch (sortingOption){
                    case 1:
                        Bubblesort<Float> bubblesort= new Bubblesort<>(arr);
                        start = System.currentTimeMillis();
                        bubblesort.bubbleSort();
                        end = System.currentTimeMillis() - start;
                        menu1.printSortedArray(arr);
                        System.out.println("Total time taken for Bubblesort: "+end+"ms");
                        break;

                    case 2:
                        MergeSort<Float> mergeSort = new MergeSort<>(arr);
                        start = System.currentTimeMillis();
                        mergeSort.mergeSort(0,arr.size()-1);
                        end = System.currentTimeMillis() - start;
                        menu1.printSortedArray(arr);
                        System.out.println("Total time taken for Mergesort: "+end+"ms");
                        break;

                    case 3:
                        HeapSort<Float> heapSort = new HeapSort<>(arr);
                        start = System.currentTimeMillis();
                        heapSort.heapSort();
                        end = System.currentTimeMillis() - start;
                        menu1.printSortedArray(arr);
                        System.out.println("Total time taken for Heapsort: "+end+"ms");
                        break;

                    default:
                        ArrayList<Float> arrForMerge = (ArrayList<Float>) arr.clone();
                        ArrayList<Float> arrForHeap = (ArrayList<Float>) arr.clone();

                        Bubblesort<Float> bubble= new Bubblesort<>(arr);
                        start = System.currentTimeMillis();
                        bubble.bubbleSort();
                        end = System.currentTimeMillis() - start;
                        System.out.println("\nThe result for Bubblesort is as follows:");
                        menu1.printSortedArray(arr);
                        System.out.println("Total time taken for Bubblesort: "+end+"ms");

                        MergeSort<Float> mergeS = new MergeSort<>(arrForMerge);
                        start = System.currentTimeMillis();
                        mergeS.mergeSort(0, arrForMerge.size()-1);
                        end = System.currentTimeMillis() - start;
                        System.out.println("\nThe result for Mergesort is as follows:");
                        menu1.printSortedArray(arrForMerge);
                        System.out.println("Total time taken for Mergesort: "+end+"ms");

                        HeapSort<Float> heapS = new HeapSort<>(arrForHeap);
                        start = System.currentTimeMillis();
                        heapS.heapSort();
                        end = System.currentTimeMillis() - start;
                        System.out.println("\nThe result for Heapsort is as follows:");
                        menu1.printSortedArray(arrForHeap);
                        System.out.println("Total time taken for Heapsort: "+end+"ms");
                }

                menu1.searchOptions();
                int searchingOption = scanner.nextInt();
                switch (searchingOption){
                    case 1:
                        System.out.println("Enter the element you want to search for:");
                        float key = scanner.nextFloat();
                        LinearSearch<Float> linearSearch = new LinearSearch<>();
                        start = System.currentTimeMillis();
                        String response = linearSearch.search(unsortedArray, key);
                        end = System.currentTimeMillis() - start;
                        System.out.println(response);
                        System.out.println("Total time taken for linear search: "+end+"ms");
                        break;

                    case 2:
                        System.out.println("Enter the element you want to search for:");
                        float val = scanner.nextFloat();
                        BinarySearch<Float> binarySearch = new BinarySearch<>();
                        start = System.currentTimeMillis();
                        String check = binarySearch.binarySearch(arr, 0, arr.size()-1, val);
                        end = System.currentTimeMillis() - start;
                        System.out.println(check);
                        System.out.println("Total time taken for binary search: "+end+"ms");
                        break;

                    default:
                        System.out.println("Enter the element you want to search for:");
                        float key2 = scanner.nextFloat();

                        LinearSearch<Float> linearSearch1 = new LinearSearch<>();
                        System.out.println("\nThe result for LinearSearch is as follows:");
                        start = System.currentTimeMillis();
                        String res = linearSearch1.search(unsortedArray, key2);
                        end = System.currentTimeMillis() - start;
                        System.out.println(res);
                        System.out.println("Total time taken for linear search: "+end+"ms");

                        BinarySearch<Float> bSearch = new BinarySearch<>();
                        System.out.println("\nThe result for BinarySearch is as follows:");
                        start = System.currentTimeMillis();
                        String res2 = bSearch.binarySearch(arr, 0, arr.size()-1, key2);
                        end = System.currentTimeMillis() - start;
                        System.out.println(res2);
                        System.out.println("Total time taken for binary search: "+end+"ms");

                }
                break;
            case 2:
                Menu<Integer> menu2 = new Menu<>();
                ArrayList<Integer> arrList;
                double start2, end2;

                menu2.inputOptions();
                int inputMethod2 = scanner.nextInt();
                if (inputMethod2 == 1){
                    arrList = menu2.fileDirectoryInteger();
                    if (arrList.size() == 0){
                        return;
                    }
                }else {
                    arrList = menu2.enteredDataInteger();
                }

                ArrayList<Integer> unsorted = (ArrayList<Integer>) arrList.clone();

                menu2.printArray(arrList);
                menu2.sortOptions();
                int sortingOption2 = scanner.nextInt();

                switch (sortingOption2){
                    case 1:
                        Bubblesort<Integer> bubblesort= new Bubblesort<>(arrList);
                        start2 = System.currentTimeMillis();
                        bubblesort.bubbleSort();
                        end2 = System.currentTimeMillis() - start2;
                        menu2.printSortedArray(arrList);
                        System.out.println("Total time taken for Bubblesort: "+end2+"ms");
                        break;

                    case 2:
                        MergeSort<Integer> mergeSort = new MergeSort<>(arrList);
                        start2 = System.currentTimeMillis();
                        mergeSort.mergeSort(0,arrList.size()-1);
                        end2 = System.currentTimeMillis() - start2;
                        menu2.printSortedArray(arrList);
                        System.out.println("Total time taken for Mergesort: "+end2+"ms");
                        break;

                    case 3:
                        HeapSort<Integer> heapSort = new HeapSort<>(arrList);
                        start2 = System.currentTimeMillis();
                        heapSort.heapSort();
                        end2 = System.currentTimeMillis() - start2;
                        menu2.printSortedArray(arrList);
                        System.out.println("Total time taken for Heapsort: "+end2+"ms");
                        break;

                    default:
                        ArrayList<Integer> arrForMerge = (ArrayList<Integer>) arrList.clone();
                        ArrayList<Integer> arrForHeap = (ArrayList<Integer>) arrList.clone();

                        Bubblesort<Integer> bubble= new Bubblesort<>(arrList);
                        start2 = System.currentTimeMillis();
                        bubble.bubbleSort();
                        end2 = System.currentTimeMillis() - start2;
                        System.out.println("\nThe result for Bubblesort is as follows:");
                        menu2.printSortedArray(arrList);
                        System.out.println("Total time taken for Bubblesort: "+end2+"ms");

                        MergeSort<Integer> mergeS = new MergeSort<>(arrForMerge);
                        start2 = System.currentTimeMillis();
                        mergeS.mergeSort(0, arrForMerge.size()-1);
                        end2 = System.currentTimeMillis() - start2;
                        System.out.println("\nThe result for Mergesort is as follows:");
                        menu2.printSortedArray(arrForMerge);
                        System.out.println("Total time taken for Mergesort: "+end2+"ms");

                        HeapSort<Integer> heapS = new HeapSort<>(arrForHeap);
                        start2 = System.currentTimeMillis();
                        heapS.heapSort();
                        end2 = System.currentTimeMillis() - start2;
                        System.out.println("\nThe result for Heapsort is as follows:");
                        menu2.printSortedArray(arrForHeap);
                        System.out.println("Total time taken for Heapsort: "+end2+"ms");
                }

                menu2.searchOptions();
                int searchingOption2 = scanner.nextInt();
                switch (searchingOption2){
                    case 1:
                        System.out.println("Enter the element you want to search for:");
                        int key = scanner.nextInt();
                        LinearSearch<Integer> linearSearch = new LinearSearch<>();
                        start2 = System.currentTimeMillis();
                        String response = linearSearch.search(unsorted, key);
                        end2 = System.currentTimeMillis() - start2;
                        System.out.println(response);
                        System.out.println("Total time taken for linear search: "+end2+"ms");
                        break;

                    case 2:
                        System.out.println("Enter the element you want to search for:");
                        int val = scanner.nextInt();
                        BinarySearch<Integer> binarySearch = new BinarySearch<>();
                        start2 = System.currentTimeMillis();
                        String check = binarySearch.binarySearch(arrList, 0, arrList.size()-1, val);
                        end2 = System.currentTimeMillis() - start2;
                        System.out.println(check);
                        System.out.println("Total time taken for binary search: "+end2+"ms");
                        break;

                    default:
                        System.out.println("Enter the element you want to search for:");
                        int key2 = scanner.nextInt();
                        LinearSearch<Integer> linearSearch1 = new LinearSearch<>();
                        System.out.println("\nThe result for LinearSearch is as follows:");
                        start2 = System.currentTimeMillis();
                        String res = linearSearch1.search(unsorted, key2);
                        end2 = System.currentTimeMillis() - start2;
                        System.out.println(res);
                        System.out.println("Total time taken for linear search: "+end2+"ms");

                        BinarySearch<Integer> bSearch = new BinarySearch<>();
                        System.out.println("\nThe result for BinarySearch is as follows:");
                        start2 = System.currentTimeMillis();
                        String res2 = bSearch.binarySearch(arrList, 0, arrList.size()-1, key2);
                        end2 = System.currentTimeMillis() - start2;
                        System.out.println(res2);
                        System.out.println("Total time taken for binary search: "+end2+"ms");

                }
                break;

            default:
                ArrayList<String> list;
                double start1, end1;

                menu.inputOptions();
                int inputMethod1 = scanner.nextInt();
                if (inputMethod1 == 1){
                    list = menu.fileDirectory();
                    if (list.size() == 0){
                        return;
                    }
                }else {
                    list = menu.enteredData();
                }

                ArrayList<String> unsortedArr = (ArrayList<String>) list.clone();

                menu.printArray(list);
                menu.sortOptions();
                int sortingOption1 = scanner.nextInt();

                switch (sortingOption1){
                    case 1:
                        Bubblesort<String> bubblesort= new Bubblesort<>(list);
                        start1 = System.currentTimeMillis();
                        bubblesort.bubbleSort();
                        end1 = System.currentTimeMillis() - start1;
                        menu.printSortedArray(list);
                        System.out.println("Total time taken for Bubblesort: "+end1+"ms");
                        break;

                    case 2:
                        MergeSort<String> mergeSort = new MergeSort<>(list);
                        start1 = System.currentTimeMillis();
                        mergeSort.mergeSort(0,list.size()-1);
                        end1 = System.currentTimeMillis() - start1;
                        menu.printSortedArray(list);
                        System.out.println("Total time taken for Mergesort: "+end1+"ms");
                        break;

                    case 3:
                        HeapSort<String> heapSort = new HeapSort<>(list);
                        start1 = System.currentTimeMillis();
                        heapSort.heapSort();
                        end1 = System.currentTimeMillis() - start1;
                        menu.printSortedArray(list);
                        System.out.println("Total time taken for Heapsort: "+end1+"ms");
                        break;

                    default:
                        ArrayList<String> arrForMerge = (ArrayList<String>) list.clone();
                        ArrayList<String> arrForHeap = (ArrayList<String>) list.clone();

                        Bubblesort<String> bubble= new Bubblesort<>(list);
                        start1 = System.currentTimeMillis();
                        bubble.bubbleSort();
                        end1 = System.currentTimeMillis() - start1;
                        System.out.println("\nThe result for Bubblesort is as follows:");
                        menu.printSortedArray(list);
                        System.out.println("Total time taken for Bubblesort: "+end1+"ms");

                        MergeSort<String> mergeS = new MergeSort<>(arrForMerge);
                        start1 = System.currentTimeMillis();
                        mergeS.mergeSort(0, arrForMerge.size()-1);
                        end1 = System.currentTimeMillis() - start1;
                        System.out.println("\nThe result for Mergesort is as follows:");
                        menu.printSortedArray(arrForMerge);
                        System.out.println("Total time taken for Mergesort: "+end1+"ms");

                        HeapSort<String> heapS = new HeapSort<>(arrForHeap);
                        start1 = System.currentTimeMillis();
                        heapS.heapSort();
                        end1 = System.currentTimeMillis() - start1;
                        System.out.println("\nThe result for Heapsort is as follows:");
                        menu.printSortedArray(arrForHeap);
                        System.out.println("Total time taken for Heapsort: "+end1+"ms");
                }

                menu.searchOptions();
                int searchingOption1 = scanner.nextInt();
                switch (searchingOption1){
                    case 1:
                        System.out.println("Enter the element you want to search for:");
                        String key = scanner.next();
                        LinearSearch<String> linearSearch = new LinearSearch<>();
                        start1 = System.currentTimeMillis();
                        String response = linearSearch.search(unsortedArr, key);
                        end1 = System.currentTimeMillis() - start1;
                        System.out.println(response);
                        System.out.println("Total time taken for linear search: "+end1+"ms");
                        break;

                    case 2:
                        System.out.println("Enter the element you want to search for:");
                        String val = scanner.next();
                        BinarySearch<String> binarySearch = new BinarySearch<>();
                        start1 = System.currentTimeMillis();
                        String check = binarySearch.binarySearch(list, 0, list.size()-1, val);
                        end1 = System.currentTimeMillis() - start1;
                        System.out.println(check);
                        System.out.println("Total time taken for binary search: "+end1+"ms");
                        break;

                    default:
                        System.out.println("Enter the element you want to search for:");
                        String key2 = scanner.next();

                        LinearSearch<String> linearSearch1 = new LinearSearch<>();
                        System.out.println("\nThe result for LinearSearch is as follows:");
                        start1 = System.currentTimeMillis();
                        String res = linearSearch1.search(unsortedArr, key2);
                        end1 = System.currentTimeMillis() - start1;
                        System.out.println(res);
                        System.out.println("Total time taken for linear search: "+end1+"ms");

                        BinarySearch<String> bSearch = new BinarySearch<>();
                        System.out.println("\nThe result for BinarySearch is as follows:");
                        start1 = System.currentTimeMillis();
                        String res2 = bSearch.binarySearch(list, 0, list.size()-1, key2);
                        end1 = System.currentTimeMillis() - start1;
                        System.out.println(res2);
                        System.out.println("Total time taken for binary search: "+end1+"ms");

                }

        }



    }
}
