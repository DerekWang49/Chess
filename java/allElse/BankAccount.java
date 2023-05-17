import java.util.Scanner;
public class BankAccount {
    String name;
    private String password;
    double balance;

    public double getBalance(String enteredPassword) {
        if (password.equals(enteredPassword)) {
            return balance;
        }
        else {
            return -1;
        }
    }

    public boolean setPassword(String oldPassword, String newPassword) {
        if (password.equals(oldPassword)) {
            password = newPassword;
            return true;
        }
        else {
            return false;
        }
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    public BankAccount(String initName, String initPass, double initBalance) {
        this.name = initName;
        this.password = initPass;
        this.balance = initBalance;
    }
    public void withdraw(String enteredPassword, double amount) {
        if (password.equals(enteredPassword) && balance >= amount) {
            balance = balance - amount;
        }
    }
    public void deposit(String enteredPassword, double amount) {
        if (password.equals(enteredPassword)) {
            balance = balance + amount;
        }
    }

    public void transfer(BankAccount altAccount, String enteredPassword, double amount) {
        System.out.println("Enter the other account's password: ");
        Scanner myScanner = new Scanner(System.in);
        String input = myScanner.nextLine();
        if (enteredPassword.equals(this.password) && altAccount.password.equals(input) && amount <= balance) {
            balance = balance - amount;
            altAccount.deposit(input, amount);
        }
        System.out.println(this.name + "'s balance is " + this.balance);
        System.out.println(altAccount.getName() + "'s balance is " + altAccount.getBalance(input));
    }
    public static void main(String[] args) {
        BankAccount Derek = new BankAccount("Derek", "CSCI1933 rules!",
                100);
//        // myAccount.deposit("CSCI1933 rules!", 100.50);
//        System.out.println("Enter your password: ");
//        Scanner myScanner = new Scanner(System.in);
//        String input = myScanner.nextLine();
//        // myAccount.getBalance(input);
//        System.out.println(myAccount.getBalance(input));
        BankAccount Judah = new BankAccount("Judah", "CSCI1133 rules!", 10);
        Derek.transfer(Judah, "CSCI133 rules!", 10);



    }
}



