package works.mgr.activities;

public class Grading {
    private final float[][] grades = {
        {74F, 5.00F},
        {75F, 3.00F},
        {78F, 2.75F},
        {81F, 2.50F},
        {84F, 2.25F},
        {87F, 2.00F},
        {90F, 1.75F},
        {93F, 1.50F},
        {96F, 1.25F},
        {100F, 1.00F} 
    };

    public static StringBuilder gradingSystem(int rawScore) {
        StringBuilder message = new StringBuilder("The equivalent of " + rawScore + " is: ");

        float equivalent = 0.00F;
        float[][] grades = new Grading().grades;
        float parseRawScore = (float) rawScore;

        for (int gradeIndex = 0; gradeIndex < grades.length; gradeIndex++) {
            float[] currentIteration = grades[gradeIndex];
            
            if (gradeIndex == 0) {
                if (parseRawScore <= currentIteration[0]) {
                    equivalent = currentIteration[1];
                }
            }
            else {
                if (parseRawScore >= grades[gradeIndex - 1][0] + 1 && parseRawScore <= currentIteration[0]) {
                    equivalent = currentIteration[1];
                }
            }
        }

        message.append(equivalent);
        
        return message;
    }
}
