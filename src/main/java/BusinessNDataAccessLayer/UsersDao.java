/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessNDataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import PresentationLayer.DB;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ndoni
 */
public class UsersDao {
    
    
    public static boolean validate(String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from login where Password=?");
			//ps.setString(1,name);
			ps.setString(1,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
    
    public static boolean CheckIfAlready(String UserName)
    {
        boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from login where UserName=?");
			ps.setString(1,UserName);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
        
    }
   
    public static boolean saveUser(String username, String password, String fullName, String email, int age, String MajorN){
        Connection con=DB.getConnection();
        boolean status=false;
        try {
            String input = "06-10-2013 18:29:09";
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
            java.util.Date dt = sdf.parse(input);
            java.sql.Date dtSql = new java.sql.Date(dt.getTime());
            
            int returned = 4;
            
            PreparedStatement stat;
            ResultSet rs;
            String sql = "SELECT MAX(LoginID) AS LoginID FROM login";
            stat = con.prepareStatement(sql);
            rs = stat.executeQuery();
            
            status = rs.next();
            System.out.println("usersdao" + status);
            if (rs.next()) {
                returned = rs.getInt("LoginID") + 1;
            }
            
            
            PreparedStatement ps = con.prepareStatement("insert into login (LoginID,UserName, Password, FullName, Email, Age, MajorN, RegDate) values (?,?,?,?,?,?,?,?)");
            ps.setInt(1, returned);
            ps.setString(2, username);
	    ps.setString(3, password);
            ps.setString(4, fullName);
            ps.setString(5, email);
            ps.setInt(6, age);
            ps.setString(7, MajorN);
            ps.setDate(8,dtSql);
            ps.execute();
           

	    //ps.execute();
        } catch(Exception e){System.out.println(e);}
        return status;
    }
    
    public static Connection getC() {
	Connection con=DB.getConnection();
        return con;
    }
    
    public void close() {
	try {
	    Connection con=DB.getConnection();
            con.close();
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }
}
