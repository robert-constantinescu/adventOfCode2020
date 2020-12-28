package Day1;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static Day1.Part1.readTheNumbers;
import static utils.AdventOfCodeConstants.javaFolderPath;

public class Part2 {

    // find the three entries that sum 2020 and get their product
    public static void main(String[] args) throws IOException {

        findTheNumberV1();
        findTheNumberV2();

    }


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

                    if (a + b <= 2020) {
                        for (int n = j; n <= numbers.size() - 2; n++) {
                            int c = numbers.get(n);
                            String sbC = "index[" + n + "]" + " = " + c;

                            if ( a + b + c == 2020) {
                                System.out.println(sbA + ", " + sbB + ", " + sbC + ". Product= " + (a*b*c));
                                long stopTime = System.currentTimeMillis();
                                System.out.println("findTheNumberV1() took: " + (stopTime - startTime));
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void findTheNumberV2() throws IOException {
        long startTime = System.currentTimeMillis();
        String inputFile = "Day1/input.txt";
        Path inputFilePath = Path.of(javaFolderPath.toString(), inputFile);
        List<Integer> numbers = readTheNumbers(inputFilePath);

        boolean found = false;
        for (int i = 0; i < numbers.size(); i++) {
            int a = numbers.get(i);
            for (int j = i + 1; j < numbers.size() -1; j++) {
                int b = numbers.get(j);
                int remainder = 2020 - a - b;
                if (remainder > 0 && numbers.contains(remainder)) {
                    System.out.println("a = " + a + ", b = " + b + ", c = " + remainder + ". Product = " + (a * b * remainder));
                    long stopTime = System.currentTimeMillis();
                    System.out.println("findTheNumberV2() took: " + (stopTime - startTime));
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

    }



}
