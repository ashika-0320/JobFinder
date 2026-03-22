package repository;

import model.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class JobRepo {
    private final DBconnection db = new DBconnection();
    String viewAllJobsSql = "Select *from job";

    public void viewAllJobs(){
            List<Job> jobs = getJobFromDB();
            Stream<Job> stream = jobs.stream();
            Consumer<Job> jobPrinter = job->{
                System.out.println("ID: " + job.getJid());
                System.out.println("Job Title: " + job.getJtitle());
                System.out.println("Required Skills: "+job.getSkills());
                System.out.println("Location: "+job.getLocation());
                System.out.println("\n");
            };
            stream.forEach(jobPrinter);
        }


    public List<Job> getJobFromDB() {
        List<Job> jobs = new ArrayList<Job>();
        try {
            Connection con = db.getConnection();
            PreparedStatement st = con.prepareStatement(viewAllJobsSql);
            ResultSet rs = st.executeQuery();
            int jid;
            String jtitle;
            String skills;
            String location;
            while (rs.next()) {

                jid = rs.getInt("jid");
                jtitle = rs.getString("jtitle");
                skills = rs.getString("skills");
                location = rs.getString("location");
                Job job = new Job(jtitle, skills, location);
                job.setJid(jid);
                jobs.add(job);
            }
            return jobs;
        } catch (SQLException e) {
            System.out.println("Couldn't retrieve all jobs from db");
            e.printStackTrace();
        }

        return null;
    }

}
