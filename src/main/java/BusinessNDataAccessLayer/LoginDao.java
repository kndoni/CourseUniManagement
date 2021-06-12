/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessNDataAccessLayer;

/**
 *
 * @author user
 */
import java.sql.*;
import PresentationLayer.DB;


public class LoginDao {

	
	
public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from login where UserName=? and Password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}