package sorting;

public class InsertionSort implements Sorter {

    public void sort(int[] input)
    {
        int steps = 0;
        for (int idx = 1; idx < input.length; idx++)
        {
            int valueToPlace = input[idx];
            int scan = idx - 1;
            boolean keepSliding = true;
            while (scan >= 0 && keepSliding)
            {
                steps++;
                if (input[scan] > valueToPlace)
                {
                    input[scan + 1] = input[scan];
                    steps++;

                    scan--;
                }
                else
                {
                    keepSliding = false;
                }
            }
            input[scan + 1] = valueToPlace;
            steps++;
        }

        System.out.println("InsertionSort steps: " + steps);
    }
}
