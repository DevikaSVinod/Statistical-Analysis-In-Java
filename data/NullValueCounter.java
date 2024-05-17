package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NullValueCounter {

    // Method to clean the data and save it to a new file (assumed to exist already)
    public static List<String[]> cleanData(String csvFile, String cleanedCsvFile) {
        // Implement your data cleaning logic here
        // Return the cleaned data as a List of String arrays
        return new ArrayList<>(); // Placeholder
    }

    // Method to read the CSV file into a List of String arrays
    public static List<String[]> readCSV(String csvFile) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Adjust the delimiter if necessary
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void countNullValues(List<String[]> originalData) {
        int nullCount = 0;
        for (String[] row : originalData) {
            for (String value : row) {
                if (value == null || value.isEmpty()) {
                    nullCount++;
                }
            }
        }
        System.out.println("Number of null values in the original data: " + nullCount);
    }
}



