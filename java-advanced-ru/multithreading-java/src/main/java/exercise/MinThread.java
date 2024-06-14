package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {

    private int[] numbers;
    private int min;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int min = Arrays.stream(numbers).min().getAsInt();
        this.min = min;
    }

    public int getMin() {
        return min;
    }
}
// END
