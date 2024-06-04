## Urinalysis Data Analysis Suite

A powerful Java application suite for comprehensive analysis of urinalysis test data. This tool offers data cleaning, statistical analysis, and distribution shape assessment to help medical professionals gain deeper insights from their datasets.

### Key Components

- **Main Application (Main.java)**: The central control unit that provides a user-friendly menu interface for accessing various data analysis tools.

- **Data Cleaning (DataCleaning.java)**:
  - Removes rows with missing values
  - Saves cleaned data to cleaned_data.csv
  - Displays head and tail of cleaned data

- **Null Value Analysis (NullValueCounter.java)**:
  - Counts null or empty values in the dataset
  - Helps assess data completeness

- **Range Statistics (MinMaxRangeCalculator.java)**:
  - Calculates min, max, and range for each numerical column
  - Provides insights into data spread

- **Descriptive Statistics (DescriptiveStatistics.java)**:
  - Computes mean, median, mode, variance, standard deviation
  - Calculates quartiles (Q1, Q2, Q3)
  - Generates correlation and covariance matrices

- **Distribution Shape (SkewnessKurtosisCalculator.java)**:
  - Calculates skewness to assess asymmetry
  - Computes kurtosis to understand tailedness
  - Helps identify outliers and distribution shape

### Key Features

- Data Import: Reads and parses CSV files into manageable datasets.
- Data Cleaning: Removes incomplete records for more accurate analysis.
- Statistical Analysis: Offers a wide range of statistical measures.
- Correlation Analysis: Assesses relationships between different urinalysis parameters.
- Distribution Analysis: Provides insights into data distribution shapes.
- Error Handling: Gracefully manages file errors and invalid inputs.
- User-Friendly Interface: Simple menu-driven system for easy navigation.

### Usage

1. Place urinalysis_tests.csv in the application directory.
2. Run Main.java.
3. Choose from six menu options:
   - Clean Data
   - Count Null Values
   - Calculate Min, Max, Range
   - Calculate Descriptive Statistics
   - Calculate Skewness & Kurtosis
   - Exit

### Requirements

- Java Development Kit (JDK) 8 or higher
- urinalysis_tests.csv file

### Project Structure

- **Main.java**: Core application with user interface
- **data Package**:
  - DataCleaning.java: Data cleaning and file handling
  - DescriptiveStatistics.java: Core statistical operations
  - MinMaxRangeCalculator.java: Range statistics
  - NullValueCounter.java: Null value analysis
  - SkewnessKurtosisCalculator.java: Distribution shape analysis

### Advanced Features

- Matrix Generation: Creates correlation and covariance matrices for in-depth relationship analysis.
- Data Preview: Shows head and tail of cleaned data for quick verification.
- Robust Data Handling: Extracts numerical columns automatically.
- Edge Case Handling: Manages scenarios like constant values in columns.

### Future Enhancements

1. Machine Learning Integration for Predictive Analysis
2. Data Visualization Tools
3. Support for Multiple File Formats
4. Web-Based Interface
5. Real-Time Data Processing

### Contributing

We welcome contributions! Fork the repository, make improvements, and submit pull requests. For major changes, please open an issue first.