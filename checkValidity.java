import java.util.Scanner;

public class checkValidity {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //get input
        String input = keyboard.nextLine();
        String oldInput = input;
        //get a simplified input using simplify() function
        String newInput = simplify(input);
        //as long as simplify() changes newInput, keep calling it
        while (oldInput != newInput) {
            oldInput = newInput;
            newInput = simplify(oldInput);
        }
        //when its fully simplified, check if the input is now 1 character long
        //a simplified string with length 1 means the initial input was valid
        if (newInput.length() != 1)
            System.out.println("INVALID");
        else
            System.out.println("VALID");
    }

    public static String simplify(String input) {
        //find every possible combination between R, S and P in the input
        //replace the instance to which letter would win
        if (input.contains("(R&R)"))
            //R wins in a fight of R&R
            input = input.replace("(R&R)", "R");
        if (input.contains("(R&S)"))
            //R wins in a fight of R&S
            input = input.replace("(R&S)", "R");
        if (input.contains("(R&P)"))
            //P wins in a fight of R&P
            input = input.replace("(R&P)", "P");
        if (input.contains("(S&S)"))
            input = input.replace("(S&S)", "S");
        if (input.contains("(S&R)"))
            input = input.replace("(S&R)", "R");
        if (input.contains("(S&P)"))
            input = input.replace("(S&P)", "S");
        if (input.contains("(P&P)"))
            input = input.replace("(P&P)", "P");
        if (input.contains("(P&S)"))
            input = input.replace("(P&S)", "S");
        if (input.contains("(P&R)"))
            input = input.replace("(P&R)", "P");
        //return the simplified input
        return input;
    }
}
