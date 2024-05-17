
package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataCleaning {
    public static List<String[]> cleanData(String csvFile, String cleanedCsvFile) {
        List<String[]> dataset = new ArrayList<>();
        String[] headings = null; // Store the headings

        // Step 1: Read the file and import the dataset
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read the first line (headings)
            String headingsLine = br.readLine();
            headings = headingsLine.split(",");
            

            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into fields
                String[] fields = line.split(",");
                dataset.add(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Exit the program if an error occurs during file reading
        }
        // Step 2: Clean the dataset
        List<String[]> cleanedDataset = new ArrayList<>();
        for (String[] row : dataset) {
            boolean hasMissingValues = false;
            for (String value : row) {
                if (value == null || value.isEmpty()) {
                    hasMissingValues = true;
                    break;
                }
            }
            if (!hasMissingValues) {
                cleanedDataset.add(row);
            }
        }

        // Print success message before writing the cleaned data to a new file
        System.out.println("Data cleaned successfully!");

        // Step 3: Write the cleaned dataset to a new file
        try (FileWriter writer = new FileWriter(cleanedCsvFile)) {
            // Write headings to the new file
            for (int i = 0; i < headings.length; i++) {
                writer.append(headings[i]);
                if (i < headings.length - 1) {
                    writer.append(",");
                }
            }
            writer.append("\n");

            // Write cleaned data to the new file
            for (String[] row : cleanedDataset) {
                for (int i = 0; i < row.length; i++) {
                    writer.append(row[i]);
                    if (i < row.length - 1) {
                        writer.append(",");
                    }
                }
                writer.append("\n");
            }
            System.out.println("Cleaned data has been written to " + cleanedCsvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print head and tail of the cleaned data
        printHeadAndTail(cleanedDataset, 5); // Adjust the number of rows to print as needed

        return cleanedDataset;
    }

    // Method to print the head and tail of the dataset
    public static void printHeadAndTail(List<String[]> dataset, int n) {
        int dataSize = dataset.size();
        System.out.println("Head of the cleaned data:");
        for (int i = 0; i < Math.min(n, dataSize); i++) {
            printRow(dataset.get(i));
        }

        System.out.println("\nTail of the cleaned data:");
        for (int i = Math.max(dataSize - n, 0); i < dataSize; i++) {
            printRow(dataset.get(i));
        }
    }

    // Helper method to print a single row
    private static void printRow(String[] row) {
        for (int i = 0; i < row.length; i++) {
            System.out.print(row[i]);
            if (i < row.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    public static List<String[]> readCSV(String csvFile) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readCSV'");
    }
}




