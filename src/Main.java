import controller.NewAccount;
import controller.UserController;
import repository.UserRepo;

import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static int currentUid;
    public static void main(String[] args){
        NewAccount newAccount = new NewAccount();
        UserRepo userRepo = new UserRepo();
        int choice=0;
        while(true) {
            System.out.println("======Welcome to Job Finder=======");
            System.out.println("1.Create Account");
            System.out.println("2.Login to Existing Account");
            System.out.println("Enter Your Choice");
            Scanner sc= new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    newAccount.display();
                    break;
                case 2:
                    userRepo.checkUser();
                    break;
                default:
                    System.out.println("Invalid Entry!");
                    break;
            }
        }
    }
}