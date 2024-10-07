import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses{

    // Method to check if the closing bracket matches the top of the stack
  
    private static boolean matches(char closing, Stack<Character> stack) {
        if (stack.isEmpty()) {
            return false;
        }
        char opening = stack.peek();
        return (closing == ']' && opening == '[') || 
               (closing == '}' && opening == '{') || 
               (closing == ')' && opening == '(');
    }

    // Main method to check if the string s has valid parentheses
    public static boolean isValid(String s) {
      
        Stack<Character> stack = new Stack<>(); // Created Empty Stack
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (!matches(ch, stack)) {
                    return false;
                }
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input string from the user
        System.out.print("Enter a string of parentheses: ");
        String input = scanner.nextLine();
        
        boolean result = isValid(input);
        
        if (result) {
            System.out.println("The parentheses are valid.");
        } else {
            System.out.println("The parentheses are not valid.");
        }
        
        scanner.close();
    }
}
