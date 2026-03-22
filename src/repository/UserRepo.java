package repository;

import controller.UserController;

import java.sql.*;
import java.util.Scanner;

public class UserRepo {
    public static int currentUid;
    DBconnection db= new DBconnection();
    UserController userController = new UserController();
    String uidSearch = "Select 1 from user where uid = ?";
    String storeUser = "Insert into user (name) values (?)";

    public void checkUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your uid to login");
        int uid = sc.nextInt();
        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(uidSearch);
            ps.setInt(1,uid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                currentUid =rs.getInt(1);
            userController.display();

            }
            else{
                System.out.println("Your id doesn't exist!! Create your account first");

            }
        } catch (SQLException e) {
            System.out.println("Cannot create user");
            e.printStackTrace();
        }

    }

    public int insertUser( String name){
        int uid = -1;
        try {
            Connection con = db.getConnection();
            PreparedStatement st= con.prepareStatement(storeUser, Statement.RETURN_GENERATED_KEYS);
            st.setString(1,name);
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()){
                uid = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return uid;
    }
}
