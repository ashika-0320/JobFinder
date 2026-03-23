package controller;

import model.User;
import repository.UserProfileRepo;
import repository.UserRepo;

import java.util.Scanner;

public class NewAccount {
private UserRepo userRepo = new UserRepo();
private UserProfileRepo userProfileRepo = new UserProfileRepo();
    public void display() {
        UserController userController = new UserController();
        Scanner sc = new Scanner(System.in);
        String name;
        String jtitle;
        String skills;
        String location;
        System.out.println("=======Create New Account=======");
        System.out.println("Enter Your Name");
        name = sc.nextLine();
        System.out.println("Enter Job title");
        jtitle=sc.nextLine();
        System.out.println("Enter your skills (comma separated)");
        skills= sc.nextLine();
        System.out.println("Enter preferred location");
        location= sc.nextLine();
        int uid= userRepo.insertUser(name);
        UserRepo.currentUid = uid;
        userProfileRepo.insertProile(uid,jtitle,skills,location);
        userController.display();
    }
}
