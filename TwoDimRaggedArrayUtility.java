
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<double[]> rows = new ArrayList<>();
        
        while (scanner.hasNextLine()) {
            String[] rowValues = scanner.nextLine().trim().split("\\s+");
            double[] row = new double[rowValues.length];
            
            for (int i = 0; i < rowValues.length; i++) {
                row[i] = Double.parseDouble(rowValues[i]);
            }
            
            rows.add(row);
        }
        
        scanner.close();
        
        return rows.toArray(new double[0][]);
    }

    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        
        for (double[] row : data) {
            for (double value : row) {
                writer.print(value + " ");
            }
            writer.println();
        }
        
        writer.close();
    }

    public static double getTotal(double[][] data) {
        double total = 0.0;
        
        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }
        
        return total;
    }

    public static double getAverage(double[][] data) {
        double total = getTotal(data);
        int count = 0;
        
        for (double[] row : data) {
            count += row.length;
        }
        
        return total / count;
    }

    public static double getRowTotal(double[][] data, int row) {
        double total = 0.0;
        
        if (row >= 0 && row < data.length) {
            for (double value : data[row]) {
                total += value;
            }
        }
        
        return total;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double total = 0.0;
        
        for (double[] row : data) {
            if (col >= 0 && col < row.length) {
                total += (col < row.length) ? row[col] : 0.0;
            }
        }
        
        return total;
    }

    public static double getHighestInRow(double[][] data, int row) {
        double highest = Double.MIN_VALUE;
        
        if (row >= 0 && row < data.length) {
            for (double value : data[row]) {
                highest = Math.max(highest, value);
            }
        }
        
        return highest;
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
        double highest = Double.MIN_VALUE;
        int highestIndex = -1;
        
        if (row >= 0 && row < data.length) {
            for (int i = 0; i < data[row].length; i++) {
                if (data[row][i] > highest) {
                    highest = data[row][i];
                    highestIndex = i;
                }
            }
        }
        
        return highestIndex;
    }

    
}
