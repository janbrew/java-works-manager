package works.mgr.activities;

import java.util.Map;
import java.util.HashMap;

public class MatrixComp {
    public static StringBuilder matrixComputation(int[][] matrix) {
        StringBuilder message = new StringBuilder();
        String pad = " ";
  
        Map<String, int[]> sumMap = new HashMap<>();
        sumMap.put("total", new int[matrix.length]);
        Map<String, int[]> prodMap = new HashMap<>();
        prodMap.put("total", new int[matrix[0].length]);

        int[] sumTotal = sumMap.get("total");
        int[] prodTotal = prodMap.get("total");

        for (int row = 0; row < matrix.length; row++) {
            int sum = 0;

            for (int column = 0; column < matrix[row].length; column++) {
                sum += matrix[row][column];
                }
            
            sumTotal[row] = sum;
            sumMap.put("total", sumTotal);
        }

        for (int column = 0; column < matrix[0].length; column++) {
            int prod = 1;
            for (int row = 0; row < matrix.length; row++) {
                prod *= matrix[row][column];
            }
            prodTotal[column] = prod;
            prodMap.put("total", prodTotal);
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                int columnProdLen = String.valueOf(prodMap.get("total")[0]).length();
                int columnValueLen = String.valueOf(matrix[row][column]).length();
                int padIter = Math.abs(columnProdLen - columnValueLen);
                message.append(pad.repeat(padIter) + String.format("%,d", matrix[row][column]) + pad.repeat(padIter) + pad.repeat(10));
            }
            message.append(" = " + String.format("%,d", sumMap.get("total")[row]));
            message.append("\n\n");
        }

        message.append("_".repeat(10 * matrix[0].length - 1) + "\n");

        for (int prod: prodMap.get("total")) {
            message.append(String.format("%,d", prod) + pad.repeat(10));
        }
        return message;
            

    }
        
}

