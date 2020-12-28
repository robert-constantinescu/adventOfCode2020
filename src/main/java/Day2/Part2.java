package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static utils.AdventOfCodeConstants.javaFolderPath;

public class Part2 {

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
        System.out.println(validPasswords);
        System.out.println("Took: " + (stopTime - startTime) + "ms");
    }

    public static boolean passwordIsValid(String rule, String password) {
        // rule :  "1-11 t"
        boolean valid = false;
        String[] ruleElements = rule.split(" ");
        String letter = ruleElements[1];
        int[] positions = Arrays.stream(ruleElements[0].split("-")).mapToInt(Integer::parseInt).toArray();
        password = password.trim();
        if(password.charAt(positions[0] - 1) == letter.charAt(0)) {
            valid = password.charAt(positions[1] - 1) != letter.charAt(0);
        }
        else {
            valid = password.charAt(positions[1] - 1) == letter.charAt(0);
        }

        return valid;

    }
}
