package service;


import repository.DBconnection;
import repository.UserProfileRepo;
import repository.UserRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JobRecommendation {
private UserProfileRepo userProfileRepo = new UserProfileRepo();
private JobService jobService = new JobService();
DBconnection db = new DBconnection();
String getSkills= "Select skills from profile where uid = ?";
String location = "Select location from profile where uid = ?";

public void generateRecommendation(){
    int uid = UserRepo.currentUid;
    System.out.println(uid);
    String skills=null, location1=null;

    try {
        Connection con = db.getConnection();
        PreparedStatement getskillps= con.prepareStatement(getSkills);
        getskillps.setInt(1,uid);
        ResultSet rs= getskillps.executeQuery();
        if(rs.next()){
            skills= rs.getString("skills");
        }

        PreparedStatement getLocation = con.prepareStatement(location);
        getLocation.setInt(1, uid);
        ResultSet rsLoc = getLocation.executeQuery();
        if(rsLoc.next()){
            location1= rsLoc.getString("location");
        }
       if(skills!=null && location1!=null){
           jobService.filterCombined(location1,skills);
       }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

}
}
