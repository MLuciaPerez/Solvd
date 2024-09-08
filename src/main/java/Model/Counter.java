package Model;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Counter {
    public static int countUniqueWords(File file) throws IOException {
        // Read the entire file content as a String
        String content = FileUtils.readFileToString(file, "UTF-8");

        // Split the content into words using spaces, commas, periods, etc.
        String[] words = StringUtils.split(content, " .,!?\"';:\n\r\t");

        // Use a HashSet to store unique words
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word.toLowerCase()); // Convert to lowercase to avoid case sensitivity
        }

        // Return the number of unique words
        return uniqueWords.size();
    }

    public static void writeResultToFile(File file, int uniqueWordCount) throws IOException {
        // Write the result to the output file
        String result = "Unique word count: " + uniqueWordCount;
        FileUtils.writeStringToFile(file, result, "UTF-8");
    }
}
