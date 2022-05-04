package app;

import cardPackage.ATMCard;
import customerPackage.Customer;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {
    Customer customer;
    static Scanner in = new Scanner(System.in);

    public static void ATMCardAction(HashMap<String, Customer> customers) {
        Customer customer;
        String accountNumber;
        double withdrawMoney;
        double depositAmount = 0;
        double swipeAmount;
        int choice;
        while(true){
            System.out.println("Enter your account number: ");
            accountNumber = in.next();
            if(customers.containsKey(accountNumber)){
                customer = customers.get(accountNumber);
                break;
            }
            else{
                System.out.println("Account number you typed is incorrect. try again!");
            }
        }
        showContext();
        loop:
        while(true){
            System.out.println("press your choice (1/2/3/4/5): ");
            choice = in.nextInt();
            switch(choice){
                case 1 ->{ // show balance
                    System.out.println("your current balance : " + customer.getAtmCard().getCardBalance());
                }
                case 2 ->{ // withdraw
                    boolean isMismatch = true;
                    while(isMismatch){
                        try {
                            while(true){
                                System.out.println("Enter the withdraw amount : ");
                                withdrawMoney = in.nextInt();
                                if(((customer.getAtmCard().getCardBalance() - withdrawMoney) >= ATMCard.minimumBalance) && withdrawMoney > 0){
                                    if(withdrawMoney%5 == 0){
                                        System.out.println("bank charge : " + ((withdrawMoney*2)/100));
                                        double finalAmount = (customer.getAtmCard().getCardBalance() - withdrawMoney) - ((withdrawMoney*2)/100);
                                        customer.getAtmCard().setCardBalance(finalAmount);
                                        System.out.println("card balance : " + customer.getAtmCard().getCardBalance());
                                        break;
                                    }
                                    else{
                                        System.out.println("withdraw amount should be multiple of 5");
                                    }
                                }
                                else{
                                    System.out.println("if you withdraw this amount your account will have lesser amount than minimum balance. so withdraw lesser amount");
                                }
                            }
                            isMismatch = false;
                        }
                        catch (InputMismatchException ime){
                            System.out.println("invalid number");
                            in.reset();
                            in.next();
                        }
                    }
                }
                case 3 ->{ // deposit
                    boolean isMismatch = true;
                    while(isMismatch){
                        try {
                            System.out.println("depositing amount: ");
                            depositAmount = in.nextInt();
                            isMismatch = false;
                        }
                        catch (InputMismatchException ime){
                            System.out.println("invalid number");
                            in.reset();
                            in.next();
                        }
                        if(depositAmount <= 0){
                            System.out.println("deposit amount cannot be zero or negative number");
                        }
                        else{
                            customer.getAtmCard().setCardBalance(customer.getAtmCard().getCardBalance() + depositAmount);
                            System.out.println("current balance : " + customer.getAtmCard().getCardBalance());
                        }
                    }

                }
                case 4 ->{ // card swiping
                    boolean isMismatch = true;
                    while(isMismatch){
                        try {
                            while(true){
                                System.out.println("Enter the amount to swipe: ");
                                swipeAmount = in.nextInt();
                                if((customer.getAtmCard().getCardBalance() - swipeAmount) >= ATMCard.minimumBalance && swipeAmount > 0){
//                                System.out.println("bank charge : " + ((swipAmount*2)/100));
                                    double finalAmount = (customer.getAtmCard().getCardBalance() - swipeAmount) + (swipeAmount/100);
                                    customer.getAtmCard().setCardBalance(finalAmount);
                                    System.out.println("card balance : " + customer.getAtmCard().getCardBalance());
                                    break;
                                }
                                else{
                                    System.out.println("if you withdraw this amount your account will have lesser amount than minimum balance. so withdraw lesser amount");
                                }
                            }
                            isMismatch = false;
                        }
                        catch (InputMismatchException ime){
                            System.out.println("invalid number");
                            in.reset();
                            in.next();
                        }
                    }
                }
                case 5 -> {
                    break loop;
                }
            }
        }
    }

    private static void showContext() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * ");
        System.out.println("*        1. Show customer balance                *");
        System.out.println("*        2. Withdraw                             *");
        System.out.println("*        3. Deposit                              *");
        System.out.println("*        4. Card swipe                           *");
        System.out.println("*        5. exit                                 *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * ");
    }
}
