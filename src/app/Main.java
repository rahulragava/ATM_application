package app;

import cardPackage.ATMCard;
import customerPackage.Customer;
import customerPackage.CustomerController;
import customerPackage.CustomerView;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String adminName = "Rahul";
    static String adminPasswd = "Rahulragava3";
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        Customer customer;
        CustomerController customerController;
        CustomerView customerView;

        HashMap<String,Customer> customers = new HashMap<>();
        initAction(customers);
        boolean atmOpened = true;
        while(atmOpened){
            showMenu();
            System.out.println("Enter your choice(1/2/3)");
            boolean isMismatch = true;
            int choice = 0;
            while(isMismatch){
                try {
                    choice = in.nextInt();
                    isMismatch = false;
                }
                catch (InputMismatchException ime){
                    System.out.println("invalid number");
                    in.reset();
                    in.next();
                }
            }
            switch(choice){
                case 1 ->{                    // new customer to get new atm card
                    customer = new Customer();
                    customerView = new CustomerView();
                    customerController = new CustomerController(customer,customerView);
                    customerController.interact(customers);
                    customers.put(customer.getAccountNumber(), customer);
                }

                case 2 ->{                    // atm actions (deposit/withdraw/swipe)
                    Bank.ATMCardAction(customers);

                }
                case 3 ->{                    // admin to close the system
                    boolean isAdmin = false;
                    while(!isAdmin){
                        System.out.println("Enter your name: ");
                        String checkName = in.next();
                        System.out.println("Enter password: ");
                        String checkPasswd = in.next();
                        if(checkName.equalsIgnoreCase(adminName) && checkPasswd.equals(adminPasswd)){
                            System.out.println("captcha to check you are not a robot :");
                            String captcha = generateCaptcha();
                            System.out.println("captcha : " + captcha);
                            String checkCaptcha = in.next();
                            if (captcha.equals(checkCaptcha)) {
                                isAdmin = true;
                            }
                        }
                    }
                    while(true){
                        try{
                            System.out.println("want to close the system ? (true/false)");
                            atmOpened = !(in.nextBoolean());
                            break;
                        }
                        catch (InputMismatchException ime){
                            System.out.println("Invalid input");
                            in.reset();
                            in.next();
                        }
                    }
                }
            }
        }
    }

    private static void showMenu() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * ");
        System.out.println("*        1. new customer                         *");
        System.out.println("*        2. ATM actions                          *");
        System.out.println("*        3. Admin                                *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * ");
    }

    private static void initAction(HashMap<String, Customer> customers) {
        Customer customer1 = new Customer();
        customer1.setCustomerName("michael");
        customer1.setAccountNumber("1234521");
        customer1.setPhoneNumber("9523456789");
        ATMCard atmCard1 = new ATMCard();
        atmCard1.setCardBalance(400);
        atmCard1.setCardNumber(9669);
        customer1.setAtmCard(atmCard1);

        Customer customer2 = new Customer();
        customer2.setCustomerName("shyam");
        customer2.setAccountNumber("123456789");
        customer2.setPhoneNumber("8723456789");
        ATMCard atmCard2 = new ATMCard();
        atmCard2.setCardBalance(600);
        atmCard2.setCardNumber(9169);
        customer2.setAtmCard(atmCard2);

        Customer customer3 = new Customer();
        customer3.setCustomerName("akbar");
        customer3.setAccountNumber("123452783");
        customer3.setPhoneNumber("7823456789");
        ATMCard atmCard3 = new ATMCard();
        atmCard3.setCardBalance(200);
        atmCard3.setCardNumber(9269);
        customer3.setAtmCard(atmCard3);

        Customer customer4 = new Customer();
        customer4.setCustomerName("michael");
        customer4.setAccountNumber("123452489");
        customer4.setPhoneNumber("6823456789");
        ATMCard atmCard4 = new ATMCard();
        atmCard4.setCardBalance(400);
        atmCard4.setCardNumber(9369);
        customer4.setAtmCard(atmCard4);

        customers.put(customer1.getAccountNumber(), customer1);
        customers.put(customer2.getAccountNumber(), customer2);
        customers.put(customer3.getAccountNumber(), customer3);
        customers.put(customer4.getAccountNumber(), customer4);

    }
    public static String generateCaptcha() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
