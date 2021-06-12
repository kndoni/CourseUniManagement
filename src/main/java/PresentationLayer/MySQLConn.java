/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kristi
 */
package PresentationLayer;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class MySQLConn {
     public static Connection getConnection() throws Exception {
        
        String dbRoot = "jdbc:mysql://";
        String hostName = "127.0.0.1:3306/";
        String dbName = "projectdatabase";
        String dbUrl = dbRoot+hostName+dbName;
        
        String hostUsername = "root";
        String hostPassword = "";
        
        Connection myConn = (Connection)DriverManager.getConnection(dbUrl, hostUsername, hostPassword);
        return myConn;
    }
}
