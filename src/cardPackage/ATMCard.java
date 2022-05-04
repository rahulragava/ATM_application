package cardPackage;

public class ATMCard {
    private int cardNumber;
    private double cardBalance;
    public static double minimumBalance = 100.00;

    public double getCardBalance() {
        return cardBalance;
    }
    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
}
