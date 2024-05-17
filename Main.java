import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import data.DataCleaning;
import data.DescriptiveStatistics;
import data.MinMaxRangeCalculator;
import data.NullValueCounter;
import data.SkewnessKurtosisCalculator;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Define the path to the CSV file
        String csvFile = "urinalysis_tests.csv";

        try {
            // Read the CSV file into a dataset (list of string arrays)
            List<String[]> dataset = DescriptiveStatistics.readCSV(csvFile);
            
            // Check if the dataset is not empty
            if (!dataset.isEmpty()) {
                boolean exit = false;

                // Loop to display the menu until the user chooses to exit
                while (!exit) {
                    // Display menu options
                    System.out.println("\nMenu:");
                    System.out.println("1. Clean Data");
                    System.out.println("2. Count Null Values");
                    System.out.println("3. Calculate Min, Max, and Range");
                    System.out.println("4. Calculate Descriptive Statistics");
                    System.out.println("5. Calculate Skewness and Kurtosis");
                    System.out.println("6. Exit");

                    // Prompt user for their choice
                    System.out.print("\nEnter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    // Handle user's choice
                    switch (choice) {
                        case 1:
                            // Clean data and store it in a new CSV file
                            String cleanedCsvFile = "cleaned_data.csv"; // New file to store cleaned data
                            List<String[]> cleanedData = DataCleaning.cleanData(csvFile, cleanedCsvFile);
                            System.out.println("Data cleaned successfully!");
                            break;
                        case 2:
                            // Count and display null values in the original dataset
                            System.out.println("Null values in the original data:");
                            NullValueCounter.countNullValues(dataset);
                            break;
                        case 3:
                            // Calculate and display min, max, and range for each numerical column in the original dataset
                            System.out.println("\nMin, Max, and Range for each numerical column in the original data:");
                            MinMaxRangeCalculator.calculateMinMaxRangeForColumns(dataset.subList(1, dataset.size()));
                            break;
                        case 4:
                            // Calculate and display descriptive statistics for each numerical column
                            System.out.println("\nDescriptive Statistics for each numerical column:");
                            DescriptiveStatistics.calculateStatistics(csvFile);
                            break;
                        case 5:
                            // Calculate and display skewness and kurtosis for each numerical column
                            System.out.println("\nSkewness and Kurtosis for each numerical column:");
                            SkewnessKurtosisCalculator.calculateSkewnessAndKurtosis(csvFile);
                            break;
                        case 6:
                            // Exit the program
                            exit = true;
                            break;
                        default:
                            // Handle invalid menu choices
                            System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    }
                }
            } else {
                // Handle case when the CSV file is empty or no data is found
                System.out.println("No data found in the CSV file.");
            }
        } catch (IOException e) {
            // Handle exceptions related to file operations
            e.printStackTrace();
        }
    }
}





