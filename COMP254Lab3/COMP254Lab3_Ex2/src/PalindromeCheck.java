
import java.util.Scanner;

public class PalindromeCheck {
	public static boolean isPalindrome(String value) {
		// if length is 0 or 1 then the string is palindrome
		if(value.length() == 0 || value.length() == 1) {
			return true;
		}
		
		// lets check for the first and last characters of the string
		// if they are same, go deeper with the substring with the first and last characters removed
		// Do this until we completely checked the string or if the condition fails.
		if(value.charAt(0) == value.charAt(value.length()-1)) {
			// recursive call
			return isPalindrome(value.substring(1, value.length()-1));
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		// Lets capture the user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the String to check if Palindrome:");
        String inputValue = scanner.nextLine();
        // If the function returns true, then it is a palindrome
        
        // lets remove the spaces and make all small caps 
        // limitation of this test is it doesn't handle strings with special characters
        String editedValue = inputValue.replaceAll("\\s","").toLowerCase(); ;
        
        System.out.println(" edited value " + editedValue);

        if(isPalindrome(editedValue))
            System.out.println(inputValue + " is a palindrome");
        else
            System.out.println(inputValue + " is not a palindrome");
        
        // close the scanner
        scanner.close();
	}
}
