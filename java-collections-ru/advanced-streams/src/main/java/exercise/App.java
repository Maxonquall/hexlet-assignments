package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

class App {
    public static String getForwardedVariables(String config) {
        return Arrays.stream(config.split("\n"))
                   .filter(line -> line.startsWith("environment="))
                   .map(line -> line.replaceAll("environment=", ""))
                   .map(line -> line.replaceAll("\"", ""))
                   .map(line -> line.split(","))
                   .flatMap(Arrays::stream)
                   .filter(kv -> kv.startsWith("X_FORWARDED"))
                   .map(kv -> kv.replaceFirst("X_FORWARDED_", ""))
                   .collect(Collectors.joining(","));
    }
}
