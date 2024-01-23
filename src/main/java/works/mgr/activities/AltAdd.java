package works.mgr.activities;

public class AltAdd {
    public static StringBuilder altAdd(String input) {
        int number = Integer.parseInt(input);
        
        StringBuilder message = new StringBuilder("The sum of every other 10th number of " + number + " is: ");
        
        int sum = 0;
        int counter = 0;
        int increment = 0;
    
        for (int iter = 0; iter <= number; iter++) {
            counter++;
            increment++;

            if (counter <= 10) {
                sum += increment;
            }
            else if (counter == 20) {
                counter = 0;
            }
        }
    
        message.append(String.format("%,d", sum));

        return message;
    }
}
