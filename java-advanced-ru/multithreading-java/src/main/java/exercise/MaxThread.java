package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread {

    private int[] numbers;
    private int max;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int max = Arrays.stream(numbers).max().getAsInt();
        this.max = max;
    }

    public int getMax() {
        return max;
    }
}
// END
