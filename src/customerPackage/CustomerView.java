package customerPackage;

import java.util.HashMap;
import java.util.Scanner;

public class CustomerView {
    String name,phoneNumber,accountNumber;
    static Scanner in = new Scanner(System.in);
    public void interact(HashMap<String, Customer> customers){
        System.out.println("Enter your name: ");
        name = in.next();
        boolean isCorrectPhoneNumber = true;
        while(isCorrectPhoneNumber){
            System.out.println("Enter your Phone number :");
            phoneNumber = in.next();
            if(phoneNumber.length() == 10 && (phoneNumber.startsWith("9") || phoneNumber.startsWith("8") ||
                    phoneNumber.startsWith("7") || phoneNumber.startsWith("6"))){
                isCorrectPhoneNumber = false;
            }
        }
        boolean hasNoDuplicate = true;
        while(hasNoDuplicate){
            accountNumber = generateAccountNumber();
            if(!customers.containsKey(accountNumber)){
               hasNoDuplicate = false;
                System.out.println("your account number is " + accountNumber + " remember it for accessing the atm card");
            }
        }
    }
    private String generateAccountNumber() {
        int max = 0;
        int min = 9;
        int randomDigit;
        StringBuilder accountString = new StringBuilder();
        for(int i = 0; i < 10; i++){
            randomDigit = ((int)(Math.random()*(max-min+1)) + min);
            accountString.append(randomDigit);
        }
        return accountString.toString();
    }
}
