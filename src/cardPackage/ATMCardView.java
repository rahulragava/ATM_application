package cardPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMCardView {
    int cardBalance;
    static int cardNumber = 0;

    public void interaction() {
        Scanner in = new Scanner(System.in);
        boolean isMismatch = true;
        while(isMismatch){
            try {
                boolean isOk = true;
                while(isOk){
                    System.out.println("Enter your card balance : ");
                    cardBalance = in.nextInt();
                    if(cardBalance >= ATMCard.minimumBalance){
                        isOk = false;
                        isMismatch = false;
                    }
                    else{
                        System.out.println("please enter card balance greater than the minimum balance");
                    }
                }
            }
            catch (InputMismatchException ime){
                System.out.println("invalid number");
                in.reset();
                in.next();
            }
        }
        cardNumber+=1;

    }
}
