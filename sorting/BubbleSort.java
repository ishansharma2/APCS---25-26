package sorting;
public class BubbleSort implements Sorter {
    public void sort(int[] input)
    {
        long steps = 0;
        for (int pass = 0; pass < input.length - 1; pass++)
        {
            for (int spot = 0; spot < input.length - 1 - pass; spot++)
            {
                steps++;
                if (input[spot] > input[spot + 1])
                {
                    int hold = input[spot];
                    input[spot] = input[spot + 1];
                    steps++;
                    input[spot + 1] = hold;
                    steps++;
                }
            }
        }
        System.out.println("BubbleSort steps: " + steps);
    }
}
