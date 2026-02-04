package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input)
    {
        int steps = 0;
        for (int left = 0; left < input.length - 1; left++)
        {
            int bestPos = left;
            for (int look = left + 1; look < input.length; look++)
            {
                steps++;
                if (input[look] < input[bestPos])
                {
                    bestPos = look;
                }
            }
            if (bestPos != left)
            {
                int temp = input[left];
                input[left] = input[bestPos];
                steps++;
                input[bestPos] = temp;
                steps++;
            }
        }
        System.out.println("SelectionSort steps: " + steps);
    }
}
