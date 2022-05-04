package cardPackage;

public class ATMCardController {
    ATMCard atmCard;
    ATMCardView atmCardView;

    public ATMCardController(ATMCard atmCard, ATMCardView atmCardView) {
        this.atmCard = atmCard;
        this.atmCardView = atmCardView;
    }

    public void interact() {
        atmCardView.interaction();
        atmCard.setCardNumber(ATMCardView.cardNumber);
        atmCard.setCardBalance(atmCardView.cardBalance);
    }
}
