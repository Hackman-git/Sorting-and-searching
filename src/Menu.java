import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
This class contains all the methods pertaining to the program
menu that the user relates with
 */
class Menu<T extends Comparable<T>> {
    //  Prompts the user to select the intended data type of the elements to be sorted
    void dataTypeOptions() {
        System.out.println("\nWhat type of values do you want to sort?");
        System.out.println("Enter 1 for decimals\nEnter 2 for integers\nEnter 3 for strings");
    }

    //  Prompts the user to select the algorithm to be used for sorting
    void sortOptions() {
        System.out.println("Which sorting algorithm do you want to use?");
        System.out.println("Enter 1 for bubblesort\nEnter 2 for mergesort\nEnter 3 for heapsort\n" +
                "Enter 4 to compare all three algorithms");
    }

    // Prompts the user to select the method of entering input data
    void inputOptions() {
        System.out.println("\nEnter the data you want to sort");
        System.out.println("Enter 1 if you want to import a file\nEnter 2 if you want to manually enter data");
    }

    //  Getting an input file of String data type from the local machine
    ArrayList<T> fileDirectory() {
        ArrayList<T> array = new ArrayList<T>();
        JFileChooser jFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

//        get the response from the open dialog operation
        int returnValue = jFile.showOpenDialog(null);

//        get the file if user chooses to open a selected file
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = jFile.getSelectedFile();
            System.out.println("opening:" + file.getName() + "\n");
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    T element = (T) scanner.next();
                    array.add(element);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        } else {
            System.out.println("\nOpen command cancelled by user.\n");
        }

        return array;
    }

    //  Getting an input file of elements of float data type from the local machine
    ArrayList<Float> fileDirectoryFloat() {
        ArrayList<Float> array = new ArrayList<Float>();
        JFileChooser jFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jFile.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = jFile.getSelectedFile();
            System.out.println("opening:" + file.getName() + "\n");
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    float element = scanner.nextFloat();
                    array.add(element);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        } else {
            System.out.println("\nOpen command cancelled by user.\n");
        }
        return array;
    }

    //  Getting an input file of elements of Integer data type from the local machine
    ArrayList<Integer> fileDirectoryInteger() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        JFileChooser jFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jFile.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = jFile.getSelectedFile();
            System.out.println("opening:" + file.getName() + "\n");
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    int element = scanner.nextInt();
                    array.add(element);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        } else {
            System.out.println("\nOpen command cancelled by user.\n");
        }
        return array;
    }

    //    getting the manually entered data of type 'String' from the user
    ArrayList<T> enteredData() {
        ArrayList<T> array = new ArrayList<T>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements do you want to sort? ");
        int count = scanner.nextInt();
        System.out.println("Enter the elements separated by a space (e.g. lam kim ross jim) and hit enter");

        for (int i = 0; i < count; i++) {
            T e = (T) scanner.next();
            array.add(e);
        }

        return array;
    }

    //    getting the manually entered data of type 'Float' from the user
    ArrayList<Float> enteredDataFloat() {
        ArrayList<Float> array = new ArrayList<Float>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements do you want to sort? ");
        int count = scanner.nextInt();
        System.out.println("Enter the elements separated by a space (e.g. lam kim ross jim) and hit enter");

        for (int i = 0; i < count; i++) {
            float e = scanner.nextFloat();
            array.add(e);
        }

        return array;
    }

    //    getting the manually entered data of type 'Integer' from the user
    ArrayList<Integer> enteredDataInteger() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements do you want to sort? ");
        int count = scanner.nextInt();
        System.out.println("Enter the elements separated by a space (e.g. lam kim ross jim) and hit enter");

        for (int i = 0; i < count; i++) {
            int e = scanner.nextInt();
            array.add(e);
        }

        return array;
    }

    //    printing the unsorted arraylist
    void printArray(ArrayList<T> array) {
        System.out.println("The unsorted list is:");
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println("\n");
    }

    //    printing the sorted arraylist
    void printSortedArray(ArrayList<T> array) {
        System.out.println("The list in a sorted form is:");
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    //    prompt the user to select a searching algorithm
    void searchOptions() {
        System.out.println("\nWhich searching algorithm do you want to use?");
        System.out.println("Enter 1 for a linear search\nEnter 2 for a binary search\nEnter 3 to compare both");
    }

}
