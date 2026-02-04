package sorting;

public class InsertionSort implements Sorter {

    @Override
    public void sort(int[] data) {
        long steps = 0;

       
        for (int pos = 1; pos < data.length; pos++) {
            int item = data[pos];
            steps++; 

