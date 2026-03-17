import java.util.*;

public class Main {

    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Admin admin = new Admin();

        users.add(new User(1001,"Vithyaa",1234,5000));
        users.add(new User(1002,"Arun",1111,4000));
        users.add(new User(1003,"Priya",2222,7000));
        users.add(new User(1004,"Rahul",3333,3000));
        users.add(new User(1005,"Anitha",4444,6000));

        while(true){

            System.out.println("\n----- ATM SYSTEM -----");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.println("Enter your choice..");

            int choice = sc.nextInt();

            switch(choice){

                case 1:

                    System.out.print("Enter Admin Password: ");
                    String pass = sc.next();

                    if(pass.equals("admin")){
                        admin.adminMenu();
                    }else{
                        System.out.println("Wrong Password");
                    }

                    break;

                case 2:

                    System.out.print("Enter Account Number: ");
                    int acc = sc.nextInt();

                    System.out.print("Enter PIN: ");
                    int pin = sc.nextInt();

                    User currentUser = null;

                    for(User u : users){
                        if(u.accountNumber == acc && u.pin == pin){
                            currentUser = u;
                            break;
                        }
                    }

                    if(currentUser == null){
                        System.out.println("Invalid Login");
                    }else{
                        currentUser.userMenu(users);
                    }

                    break;

                case 3:
                    System.exit(0);
            }
        }
    }
}
