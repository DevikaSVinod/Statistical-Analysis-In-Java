package data;
import java.util.ArrayList;
import java.util.List;

public class MinMaxRangeCalculator {

    // Method to find the minimum value in a list of doubles
    public static double findMin(List<Double> data) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        double min = data.get(0);
        for (double value : data) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    // Method to find the maximum value in a list of doubles
    public static double findMax(List<Double> data) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        double max = data.get(0);
        for (double value : data) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    // Method to calculate the range given the minimum and maximum values
    public static double calculateRange(double min, double max) {
        return max - min;
    }

    // Method to calculate min, max, and range for each numerical column
    public static void calculateMinMaxRangeForColumns(List<String[]> data) {
        if (data.isEmpty()) {
            System.out.println("The dataset is empty.");
            return;
        }

        int numColumns = data.get(0).length;

        for (int colIndex = 0; colIndex < numColumns; colIndex++) {
            List<Double> numericalColumnData = extractNumericalColumn(data, colIndex);
            if (!numericalColumnData.isEmpty()) {
                double min = findMin(numericalColumnData);
                double max = findMax(numericalColumnData);
                double range = calculateRange(min, max);

                System.out.println("Column " + (colIndex + 1) + ":");
                System.out.println("\tMinimum value: " + min);
                System.out.println("\tMaximum value: " + max);
                System.out.println("\tRange: " + range + "\n");
            } else {
                System.out.println("Column " + (colIndex + 1) + " - No numerical data found.\n");
            }
        }
    }

    // Helper method to extract a specific numerical column from the dataset
    private static List<Double> extractNumericalColumn(List<String[]> data, int columnIndex) {
        List<Double> numericalColumn = new ArrayList<>();
        for (String[] row : data) {
            try {
                String value = row[columnIndex].trim();
                if (!value.isEmpty()) {
                    double numValue = Double.parseDouble(value);
                    numericalColumn.add(numValue);
                }
            } catch (NumberFormatException e) {
                // Ignore non-numerical data
            }
        }
        return numericalColumn;
    }
}


