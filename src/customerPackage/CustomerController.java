package customerPackage;

import cardPackage.ATMCard;
import cardPackage.ATMCardController;
import cardPackage.ATMCardView;

import java.util.HashMap;

public class CustomerController {
    private Customer customer;
    private CustomerView customerView;


    public CustomerController(Customer customer, CustomerView customerView) {
        this.customer =customer;
        this.customerView = customerView;
    }

    public void interact(HashMap<String, Customer> customers) {
        customerView.interact(customers);
        customer.setCustomerName(customerView.name);
        customer.setPhoneNumber(customerView.phoneNumber);
        customer.setAccountNumber(customerView.accountNumber);
        customer.setAtmCard(getAtmCard());
    }

    private ATMCard getAtmCard() {
        ATMCard atmCard = new ATMCard();
        ATMCardView atmCardView = new ATMCardView();
        ATMCardController atmCardController = new ATMCardController(atmCard, atmCardView);
        atmCardController.interact();
        return atmCard;
    }
}
