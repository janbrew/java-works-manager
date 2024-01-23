package works.mgr.activities;

public class Comparison {
    public static StringBuilder compare(String var1, String var2, String var3) {
        int x = Integer.parseInt(var1);
        int y = Integer.parseInt(var2);
        int z = Integer.parseInt(var3);

        StringBuilder message = new StringBuilder(
            "The highest number among " + String.format("%,d", x) + 
            ", " + String.format("%,d", y) + 
            ", and " + String.format("%,d", z) + " is ");

        if (x > y && x > z) {
            message.append(String.format("%,d", x));
        }
        else if (y > z) {
            message.append(String.format("%,d", y));
        }
        else {
            message.append(String.format("%,d", z));
        }

        return message;
    }
}
