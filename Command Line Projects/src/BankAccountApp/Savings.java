package BankAccountApp;

public class Savings extends Account {

    private int saveDepositBoxID;
    private int saveDepositBoxKey;

    Savings(String name, String SIN, double initDeposit) {
        super(name,SIN,initDeposit);
        System.out.println("SAVINGS ACCOUNT ");
        setAccNumber();
        setSaveDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    @Override
    void showInfo() {
        super.showInfo();
        System.out.println("ACCOUNT TYPE: SAVINGS" + "\n" +
                "Your Savings Account Features" + "\n" +
                "SAFETY DEPOSIT BOX ID: " + saveDepositBoxID + "\n" +
                "SAFETY DEPOSIT BOX KEY: " + saveDepositBoxKey);
    }

    private void setAccNumber() {
        this.accountNumber = "2" + generateAccountNumber();
    }

    private void setSaveDepositBox() {
        saveDepositBoxID = (int)(Math.random() * 1000); // generate 3 digits number
        saveDepositBoxKey = (int)(Math.random() * 10000); // generate 4 digits number
    }
}
