package controller;

import repository.JobRepo;
import repository.UserProfileRepo;
import service.JobRecommendation;

import java.util.Scanner;

public class UserController {
    UserProfileController userProfileController = new UserProfileController();
    UserProfileRepo userProfileRepo = new UserProfileRepo();
    JobController jobController = new JobController();
    JobRepo jobRepo = new JobRepo();
    JobRecommendation recommendation = new JobRecommendation();

    public void display(){
        Scanner sc = new Scanner(System.in);
        loop:
        while(true){
            System.out.println("=======User Actions=======");
            System.out.println("1.Update Profile");
            System.out.println("2.View All Jobs");
            System.out.println("3.Filter Jobs");
            System.out.println("4.Get Job Recommendations");
            System.out.println("5.View Profile");
            System.out.println("6.Logout");
            System.out.println("Enter your choice:");
            int choice= sc.nextInt();

            switch (choice){
                case 1: userProfileController.display();
                break;

                case 2: jobRepo.viewAllJobs();
                break;

                case 3: {
                    jobController.display();
                    break;
                }

                case 4: {
                    recommendation.generateRecommendation();
                    break;
                }

                case 5: {
                    userProfileRepo.getProfile();
                    break;
                }

                case 6:break loop;

                default: {
                    System.out.println("Invalid Entry!!");
                    break;
                }
            }

        }
    }
}
