import java.util.*;

public class User {
    int accountNumber;
    String name;                                                                                                                                        
    int pin;
    int balance;
    ArrayList<String> transactions = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public User(int accountNumber,String name,int pin,int balance){
        this.accountNumber = accountNumber;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }

    public void userMenu(ArrayList<User> users){

        while(true){

            System.out.println("\n---USER MENU---");
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Transfer");
            System.out.println("4.Change PIN");
            System.out.println("5.Mini Statement");
            System.out.println("6.Logout");
            System.out.println("Enter your choice:");

            int choice = sc.nextInt();

            switch(choice){

                case 1:
                    deposit();
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    transfer(users);
                    break;

                case 4:
                    changePin();
                    break;

                case 5:
                    miniStatement();
                    break;

                case 6:
                    System.out.println("Invalid options Entered..");
                    return;
            }
        }
    }

    void deposit(){

        System.out.print("Enter number of 100 notes: ");
        int n100 = sc.nextInt();

        System.out.print("Enter number of 200 notes: ");
        int n200 = sc.nextInt();

        System.out.print("Enter number of 500 notes: ");
        int n500 = sc.nextInt();

        int amount = n100*100 + n200*200 + n500*500;

        balance += amount;

        Admin.note100 += n100;
        Admin.note200 += n200;
        Admin.note500 += n500;

        transactions.add("Deposit: "+amount);

        System.out.println("Deposit Successful");
    }

    void withdraw(){

        System.out.print("Enter amount: ");
        int amount = sc.nextInt();

        if(amount % 100 != 0){
            System.out.println("Amount must be multiple of 100");
            return;
        }

        if(balance < amount){
            System.out.println("Insufficient Balance");
            return;
        }

        int remaining = amount;

        int use500 = Math.min(remaining/500 , Admin.note500);
        remaining -= use500*500;

        int use200 = Math.min(remaining/200 , Admin.note200);
        remaining -= use200*200;

        int use100 = Math.min(remaining/100 , Admin.note100);
        remaining -= use100*100;

        if(remaining != 0){
            System.out.println("ATM cannot dispense this amount");
            return;
        }

        Admin.note500 -= use500;
        Admin.note200 -= use200;
        Admin.note100 -= use100;

        balance -= amount;

        transactions.add("Withdraw: "+amount);

        System.out.println("Withdraw Successful");
        System.out.println("500 notes: "+use500);
        System.out.println("200 notes: "+use200);
        System.out.println("100 notes: "+use100);
    }

    void transfer(ArrayList<User> users){

        System.out.print("Enter receiver account number: ");
        int acc = sc.nextInt();

        User receiver = null;

        for(User u : users){
            if(u.accountNumber == acc){
                receiver = u;
                break;
            }
        }

        if(receiver == null){
            System.out.println("Account not found");
            return;
        }

        System.out.print("Enter amount: ");
        int amount = sc.nextInt();

        if(balance < amount){
            System.out.println("Insufficient Balance");
            return;
        }

        balance -= amount;
        receiver.balance += amount;

        transactions.add("Transfer to "+receiver.accountNumber+" : "+amount);

        System.out.println("Transfer Successful");
    }

    void changePin(){

        System.out.print("Enter old pin: ");
        int old = sc.nextInt();

        if(old != pin){
            System.out.println("Wrong PIN");
            return;
        }

        System.out.print("Enter new pin: ");
        pin = sc.nextInt();

        System.out.println("PIN Updated");
    }

    void miniStatement(){

        System.out.println("\nLast Transactions:");

        int start = Math.max(0, transactions.size()-5);

        for(int i=start;i<transactions.size();i++){
            System.out.println(transactions.get(i));
        }
    }
}
