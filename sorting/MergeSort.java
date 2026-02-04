package sorting;

public class MergeSort implements Sorter {

    private long steps;  
    public void sort(int[] input)
    {
        steps = 0;
        mergeSortRange(input, input.length);
        System.out.println("MergeSort steps: " + steps);
    }

    private void mergeSortRange(int[] data, int size)
    {
        if (size < 2)
        {
            return;
        }

        int mid = size / 2;

        int[] leftChunk = new int[mid];
        int[] rightChunk = new int[size - mid];


        for (int a = 0; a < mid; a++)
        {
            leftChunk[a] = data[a];
            steps++;
        }

        for (int b = mid; b < size; b++)
        {
            rightChunk[b - mid] = data[b];
            steps++;
        }

        mergeSortRange(leftChunk, leftChunk.length);
        mergeSortRange(rightChunk, rightChunk.length);

        merge(data, leftChunk, rightChunk);
    }
    private void merge(int[] target, int[] leftChunk, int[] rightChunk)
    {
        int i = 0;
        int j = 0;
        int out = 0;

        while (i < leftChunk.length && j < rightChunk.length)
        {
            
            steps++;

            if (leftChunk[i] <= rightChunk[j])
            {
                target[out] = leftChunk[i];
                steps++;     
                i++;
            }
            else
            {
                target[out] = rightChunk[j];
                steps++;      
                j++;
            }
            out++;
        }

        while (i < leftChunk.length)
        {
            target[out] = leftChunk[i];
            steps++;          
            i++;
            out++;
        }

        while (j < rightChunk.length)
        {
            target[out] = rightChunk[j];
            steps++;         
            j++;
            out++;
        }
    }
}
