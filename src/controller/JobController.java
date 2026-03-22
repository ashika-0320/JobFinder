package controller;

import service.JobService;

import java.util.Scanner;

public class JobController {

    JobService jobService = new JobService();
    public void display(){
        Scanner sc = new Scanner(System.in);
        int filterChoice;
        System.out.println("1.Filter By Location");
        System.out.println("2.Filter by Skills");
        System.out.println("3.Combined Filter");
        System.out.println("Enter Your Choice:");
        filterChoice = sc.nextInt();

        switch (filterChoice){
            case 1: {
                System.out.println("Enter the location you prefer:");
                String Location = sc.next();
                jobService.filterByLocation(Location);
                break;
            }
            case 2: {
                System.out.println("Enter the skills to filter:");
                String skills = sc.next();
                jobService.filterBySkill(skills);
                break;
            }
            case 3: {
                System.out.println("Enter the location you prefer:");
                String Location = sc.next();
                System.out.println("Enter the skills to filter:");
                String skills = sc.next();
                jobService.filterCombined(Location,skills);
                break;
            }
            default:{
                System.out.println("Enter a valid number");
                break;
            }
        }
    }
}
