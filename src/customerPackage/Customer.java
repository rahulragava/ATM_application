package customerPackage;

import cardPackage.ATMCard;

public class Customer {
    private String accountNumber;
    private String customerName;
    private String phoneNumber;
    private ATMCard atmCard;

    //getters

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public ATMCard getAtmCard() {
        return atmCard;
    }

    public void setAtmCard(ATMCard atmCard) {
        this.atmCard = atmCard;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
