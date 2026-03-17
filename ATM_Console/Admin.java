import java.util.Scanner;
public class Admin{
    static int note100=10;
    static int note200=10;
    static int note500=10;

    Scanner sc=new Scanner(System.in);

    public  void adminMenu(){
        while(true){
            System.out.println("Choose your operations");
            System.out.println("1.Cash Deposit");
            System.out.println("2.View ATM Balance");
            System.out.println("3.View Note Details");
            System.out.println("4.Back");

            System.out.println("Choose option");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    cashDeposit();
                    break;
                case 2:
                    checkBalance();
                    break;
                case 3:
                    viewNotes();
                    break;
                default:
                    System.out.println("Invlaid options entered");
                    return;

            }
        }

    }
    void cashDeposit(){
        System.out.println("Enter the number of 100 rupee notes");
        int n100=sc.nextInt();

        System.out.println("Enter the number of 200 rupee notes");
        int n200=sc.nextInt();

        System.out.println("Enter the number of 500 rupee notes");
        int n500=sc.nextInt();

        note100+=n100;
        note200+=n200;
        note500+=n500;

        System.out.println("Cash Successfully deposited to ATM");

    }
    void checkBalance(){
        System.out.println("Total Balance in the atm :"+note100*100 + note200*200 + note500*500);

    }
    void viewNotes(){
        System.out.println("No of 100 rupee notes :"+note100);
        System.out.println("No of 200 rupee notes :"+note200);
        System.out.println("No of 500 rupee notes :"+note500);

    }


}
