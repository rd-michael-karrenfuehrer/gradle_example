/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package gradle_example;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class App {
    public String getGreeting() {
        try {
            URL url = Resources.getResource("test.txt");
            String text = Resources.toString(url, StandardCharsets.UTF_8);
            int[] numbers = Arrays.stream(text.split("\n"))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .mapToInt(i -> i)
                    .toArray();
            var current = System.currentTimeMillis();
            Mergesort.mergeSort(numbers);
            System.out.println("Time: " + (System.currentTimeMillis() - current));
            return Arrays.toString(numbers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
