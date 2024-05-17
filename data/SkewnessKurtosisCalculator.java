package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SkewnessKurtosisCalculator {

    public static List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(values);
            }
        }
        return records;
    }

    public static void calculateSkewnessAndKurtosis(String csvFile) throws IOException {
        List<String[]> dataset = readCSV(csvFile);
        if (dataset.isEmpty()) {
            System.out.println("No data available for calculating skewness and kurtosis.");
            return;
        }

        String[] headers = dataset.get(0);
        for (int i = 1; i < headers.length; i++) {
            List<Double> values = new ArrayList<>();
            for (int j = 1; j < dataset.size(); j++) {
                String value = dataset.get(j)[i];
                if (isNumeric(value)) {
                    values.add(Double.parseDouble(value));
                }
            }
            if (!values.isEmpty()) {
                double mean = calculateMean(values);
                double variance = calculateVariance(values, mean);
                double skewness = calculateSkewness(values, mean, variance);
                double kurtosis = calculateKurtosis(values, mean, variance);
                
                System.out.println("Column: " + headers[i]);
                System.out.println("Skewness: " + skewness);
                System.out.println("Kurtosis: " + kurtosis);
                System.out.println();
            }
        }
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static double calculateMean(List<Double> values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.size();
    }

    private static double calculateVariance(List<Double> values, double mean) {
        double sum = 0;
        for (double value : values) {
            sum += Math.pow(value - mean, 2);
        }
        return sum / values.size();
    }

    private static double calculateSkewness(List<Double> values, double mean, double variance) {
        double sum = 0;
        for (double value : values) {
            sum += Math.pow(value - mean, 3);
        }
        double n = values.size();
        double skewness = (n / ((n - 1) * (n - 2))) * (sum / Math.pow(variance, 1.5));
        return skewness;
    }

    private static double calculateKurtosis(List<Double> values, double mean, double variance) {
        double sum = 0;
        for (double value : values) {
            sum += Math.pow(value - mean, 4);
        }
        double n = values.size();
        double kurtosis = ((n * (n + 1)) / ((n - 1) * (n - 2) * (n - 3))) * (sum / Math.pow(variance, 2))
                - (3 * Math.pow(n - 1, 2)) / ((n - 2) * (n - 3));
        return kurtosis;
    }
}
