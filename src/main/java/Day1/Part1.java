package Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.AdventOfCodeConstants.javaFolderPath;


public class Part1 {


    // find the two entries that sum 2020 and get their product
    public static void main(String[] args) throws IOException {
        findTheNumberV1();
        findTheNumberV2();
    }



    public static List<Integer> readTheNumbers(Path inputPath) throws IOException {
        List<Integer> numbers = new ArrayList<>();

        boolean exists = Files.exists(inputPath);
        if (exists) {
            BufferedReader reader = Files.newBufferedReader(inputPath);
            while (reader.ready()) {
                numbers.add(Integer.parseInt(reader.readLine()));
            }
        } else{
            System.out.println("File could not be found");
        }
        return numbers;
    }

    //find number On2 time complexity
    public static void findTheNumberV1() throws IOException {
        long startTime = System.currentTimeMillis();
        String inputFile = "Day1/input.txt";
        Path inputFilePath = Path.of(javaFolderPath.toString(), inputFile);
        List<Integer> numbers = readTheNumbers(inputFilePath);

        if (numbers.size() > 2) {
            for (int i = 0; i < numbers.size(); i++) {
                for(int j = i + 1; j <= numbers.size() - 1; j++) {
                    int a = numbers.get(i);
                    int b = numbers.get(j);

                    String sbA = "index[" + i + "]" + " = " + a;
                    String sbB = "index[" + j + "]" + " = " + b;

                    if (a + b == 2020) {
                        System.out.println(sbA + ", " + sbB + ". Product a * b = " + (a*b));
                        long stopTime = System.currentTimeMillis();
                        System.out.println("findTheNumberV1() took: " + (stopTime - startTime));
                        break;
                    }

                }
            }
        }
    }

    //find number On time complexity
    public static void findTheNumberV2() throws IOException {

        long startTime = System.currentTimeMillis();
        String inputFile = "Day1/input.txt";
        Path inputFilePath = Path.of(javaFolderPath.toString(), inputFile);
        List<Integer> numbers = readTheNumbers(inputFilePath);

        if (numbers.size() > 2) {
            for (int i = 0; i < numbers.size(); i++) {
                int currentNumber = numbers.get(i);
                int remainder = 2020 - currentNumber;
                if (numbers.contains(remainder)) {
                    System.out.println(currentNumber + " * " + remainder + " = " + (currentNumber* remainder) );
                    long stopTime = System.currentTimeMillis();
                    System.out.println("findTheNumberV2() took: " + (stopTime - startTime));
                    break;
                }
            }
        }
    }

}
