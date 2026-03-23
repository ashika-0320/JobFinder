package service;

import model.Job;
import repository.JobRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class JobService {
    JobRepo repo = new JobRepo();

    public void filterByLocation(String location) {
        List<Job> jobs = repo.getJobFromDB();
        List<Job> filteredJobs = jobs.stream().filter(job-> job.getLocation().equalsIgnoreCase(location)).toList();
        if(filteredJobs.isEmpty()){
            System.out.println("Not Found!");
        }
        else {
            filteredJobs.stream().forEach(printJobs());
        }
    }

    public Consumer<Job> printJobs(){
        Consumer<Job> jobPrinter = job->{
            System.out.println("ID: " + job.getJid());
            System.out.println("Job Title: " + job.getJtitle());
            System.out.println("Required Skills: "+job.getSkills());
            System.out.println("Location: "+job.getLocation());
            System.out.println("\n");
        };
        return jobPrinter;
    }

    public void filterBySkill(String skills){
        List <Job> jobs = repo.getJobFromDB();
        List <String> inputskills= Arrays.stream(skills.split(",")).map(s->s.trim().toLowerCase()).toList();
        List <Job> filteredJobs = jobs.stream().filter(job->Arrays.stream(job.getSkills().split(",")).map(s->s.trim().toLowerCase()).anyMatch(skill->inputskills.contains(skill))).toList();
        if (filteredJobs.isEmpty()){
            System.out.println("Not Found!");
        }
        else {
            filteredJobs.stream().forEach(printJobs());
        }
    }

    public void filterCombined(String location, String skills){
        List <Job> jobs = repo.getJobFromDB();
        List <String> inputSkills = Arrays.stream(skills.split(",")).map(s->s.trim().toLowerCase()).toList();
        System.out.println(inputSkills);
        List <Job> filteredJobs = jobs.stream().filter(job->job.getLocation().equalsIgnoreCase(location)).filter(job->Arrays.stream(job.getSkills().split(",")).map(s->s.trim().toLowerCase()).anyMatch(skill->inputSkills.contains(skill))).toList();
        if (filteredJobs.isEmpty()){
            System.out.println("Not Found!");
        }
        else {
            filteredJobs.stream().forEach(printJobs());
        }
    }
}
