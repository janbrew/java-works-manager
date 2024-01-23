package works.mgr.activities;

public class HighestLowest {
    public static StringBuilder highestLowest(int[][] matrix) {
        StringBuilder message = new StringBuilder();

        int highest = matrix[0][0];
        int lowest = matrix[0][0];

        for(int matrixRow = 0; matrixRow < matrix.length; matrixRow++) {
            for (int matrixColumn = 0; matrixColumn < matrix[matrixRow].length; matrixColumn++) {
                int current = matrix[matrixRow][matrixColumn];

                if (current > highest) {
                    highest = current;
                }
                else if (current < lowest) {
                    lowest = current;
                }
            }
        }

        message.append("The highest number is " + String.format("%,d", highest) + " while the lowest number is " + String.format("%,d", lowest));

        return message;
    }
}
