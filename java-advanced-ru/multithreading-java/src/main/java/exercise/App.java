package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {

        var result = new HashMap<String, Integer>();

        MaxThread maxThread = new MaxThread(numbers);
        LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " started");
        MinThread minThread = new MinThread(numbers);
        LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " started");
        minThread.start();
        maxThread.start();

        try {
            minThread.join();
            LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " finished");
            maxThread.join();
            LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " finished");
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Interruption", e);
        }

        result.put("max", maxThread.getMax());
        result.put("min", minThread.getMin());

        LOGGER.log(Level.INFO, "Result: " + result.toString());

        return result;

    }
    // END
}
