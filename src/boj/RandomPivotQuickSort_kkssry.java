import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] numbers = new int[input];
        numbersInit(numbers, input, br);
        quickSort(numbers, 0, input - 1);
        Arrays.stream(numbers).forEach(System.out::println);
    }

    private static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int index = partition(numbers, start, end);
            quickSort(numbers, start, index - 1);
            quickSort(numbers, index + 1, end);
        }
    }

    private static int partition(int[] numbers, int start, int end) {
        Random random = new Random();
        int randomIndex = start + random.nextInt(end - start + 1 );
        int temp;

        temp = numbers[randomIndex];
        numbers[randomIndex] = numbers[end];
        numbers[end] = temp;

        int pivot = numbers[end];
        int rose = start;

        for (int i = start; i < end; i++) {
            if (numbers[i] <= pivot) {
                temp = numbers[rose];
                numbers[rose] = numbers[i];
                numbers[i] = temp;
                rose++;
            }
        }

        temp = numbers[rose];
        numbers[rose] = numbers[end];
        numbers[end] = temp;

        return rose;
    }

    private static void numbersInit(int[] numbers, int input, BufferedReader br) throws IOException {
        for (int i = 0; i < input; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
    }
}