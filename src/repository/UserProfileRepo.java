package repository;

import model.UserProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserProfileRepo {

    DBconnection db = new DBconnection();
    String storeProfile = "INSERT INTO profile (uid, jtitle, skills, location)\n" +
            "VALUES (?, ?, ?,?)";

    String getProfileInfo = "Select *from profile where uid = ?";

    public void insertProile(int uid, String jtitle, String skills, String location) {
        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(storeProfile);
            ps.setInt(1, uid);
            ps.setString(2, jtitle);
            ps.setString(3, skills);
            ps.setString(4, location);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void getProfile() {
        try {
            int uid= UserRepo.currentUid;
            Connection connection = db.getConnection();
            PreparedStatement ps = connection.prepareStatement(getProfileInfo);
            ps.setInt(1, uid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                int id = rs.getInt("uid");
                String jtitle = rs.getString("jtitle");
                String skills = rs.getString("skills");
                String location = rs.getString("location");
                UserProfile Profile = new UserProfile(jtitle,skills,location);
                Profile.setUid(id);
                System.out.println("======= User Profile =======");
                System.out.println("UID      : " + Profile.getUid());
                System.out.println("Job Title: " + Profile.getJtitle());
                System.out.println("Skills   : " + Profile.getSkills());
                System.out.println("Location : " + Profile.getLocation());

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


        public void updateProfile(String jtitle, String skills, String location) {

        int uid = UserRepo.currentUid;
            String query = "UPDATE profile SET jtitle = ?, skills = ?, location = ? WHERE uid = ?";

            try {
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(query);

                ps.setString(1, jtitle);
                ps.setString(2, skills);
                ps.setString(3, location);
                ps.setInt(4, uid);

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    System.out.println("Profile updated successfully!");
                } else {
                    System.out.println("Profile not found for this user. Please create it first.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
