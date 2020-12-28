package Day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.AdventOfCodeConstants.javaFolderPath;

public class Part1 {

    public static void main(String[] args) throws IOException {

        long startTime = System.currentTimeMillis();
        int validPasswords = 0;

        Path inputPath = Path.of(javaFolderPath.toString(), "Day2/input.txt");
        List<String> rulesAndPasswords = Files.readAllLines(inputPath);
        for(String line : rulesAndPasswords) {
            String[] elements = line.split(":");
            String rule = elements[0];
            String password = elements[1];
            if (passwordIsValid(rule, password)) {
                validPasswords++;
            }
        }

        long stopTime = System.currentTimeMillis();

        System.out.println(rulesAndPasswords.size());
        System.out.println(validPasswords);
    }

    public static boolean passwordIsValid(String rule, String password) {
        // rule :  "1-11 t"
        String[] ruleElements = rule.split(" ");
        String letter = ruleElements[1];
        int[] limits = Arrays.stream(ruleElements[0].split("-")).mapToInt(Integer::parseInt).toArray();
        password = password.trim();
        long occurrence = password.chars().filter(ch -> Character.toString(ch).equals(letter)).count();
//        System.out.println(rule + ", " + occurrence + ", result = " + (occurrence >= limits[0] && occurrence <= limits[1]));

        return occurrence >= limits[0] && occurrence <= limits[1];
    }

}
