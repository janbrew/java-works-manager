package works.mgr.activities;

public class RPS {
    private static String decipher(String choice) {
        String decode = "";

        if (choice.equalsIgnoreCase("r")) {
            decode = "Rock";
        }
        else if (choice.equalsIgnoreCase("p")) {
            decode = "Paper";
        }
        else if (choice.equalsIgnoreCase("s")) {
            decode = "Scissors";
        }

        return decode;
    }

    private static String checkWinner(String playerOne, String playerTwo) {
        String result = "";
        
        if (playerOne.equalsIgnoreCase(playerTwo)) {
            result = "It's a draw! Both picked the same choice!";
        }

        else if (playerOne.equalsIgnoreCase("rock")) {
            if (playerTwo.equalsIgnoreCase("scissors")) {
                result = "Player One wins! Rock smashes Scissors!";
            }
            else if (playerTwo.equalsIgnoreCase("paper")) {
                result = "Player Two wins! Paper covers Rock!";
            }
        }
        else if (playerOne.equalsIgnoreCase("paper")) {
            if (playerTwo.equalsIgnoreCase("rock")) {
                result = "Player One wins! Paper covers Rock!";
            }
            else if (playerTwo.equalsIgnoreCase("scissors")) {
                result = "Player Two wins! Scissors cut Paper!";
            }
        }
        else if (playerOne.equalsIgnoreCase("scissors")) {
            if (playerTwo.equalsIgnoreCase("paper")) {
                result = "Player One wins! Scissors cut Paper!";
            }
            else if (playerTwo.equalsIgnoreCase("rock")) {
                result = "Player Two wins! Rock smashes Scissors!";
            }
        }
        return result;
    }
    public static StringBuilder rps(String playerOne, String playerTwo) {
        playerOne = decipher(playerOne);
        playerTwo = decipher(playerTwo);

        StringBuilder message = new StringBuilder("Player 1 chose " + playerOne + "\nPlayer 2 chose " + playerTwo + "\n\nResult: ");

        message.append(checkWinner(playerOne, playerTwo));

        return message;
    }
}
