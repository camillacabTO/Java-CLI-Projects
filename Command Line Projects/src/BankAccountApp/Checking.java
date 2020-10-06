package BankAccountApp;

public class Checking extends Account {

    private int debitCardNumber;
    private int debitCardPin;

    Checking(String name, String SIN, double initDeposit) {
        super(name,SIN,initDeposit);
        System.out.println("CHECKING ACCOUNT");
        setAccNumber();
        setDebitCard();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * 0.15;
    }

    @Override
    void showInfo() {
        super.showInfo();
        System.out.println("ACCOUNT TYPE: CHECKING" + "\n" +
                "Your Checking Account Features" + "\n" +
                "DEBIT CARD NUMBER: " + debitCardNumber + "\n" +
                "DEBIT CARD PIN: " + debitCardPin);
    }

    private void setAccNumber() {
        this.accountNumber = "1" + generateAccountNumber();
    }

    private void setDebitCard() {
        debitCardNumber = (int)(Math.random() * Math.pow(10, 12)); // generate 12 digits number
        debitCardPin = (int)(Math.random() * Math.pow(10, 4)); // generate 4 digits number
    }
}
