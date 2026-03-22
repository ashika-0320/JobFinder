package controller;

import repository.UserProfileRepo;

import java.util.Scanner;

public class UserProfileController {
    UserProfileRepo repo = new UserProfileRepo();
    public void display() {
        UserController userController = new UserController();
        Scanner sc = new Scanner(System.in);
        String jtitle;
        String skills;
        String location;
        System.out.println("=======Update Profile=======");
        System.out.println("Enter Job title");
        jtitle=sc.nextLine();
        System.out.println("Enter your skills (comma separated)");
        skills= sc.nextLine();
        System.out.println("Enter preferred location");
        location= sc.nextLine();
        repo.updateProfile(jtitle,skills,location);
    }
}
