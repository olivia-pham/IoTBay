/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;
import java.sql.*;

/**
 *
 * @author olivi
 */
public abstract class DB {
    protected String URL = "jdbc:mysql://database-isd2021.cp1vsrjedvsf.us-east-1.rds.amazonaws.com/";
    protected String db = "isd2021";
    protected String dbuser = "dbadmin";
    protected String dbpass = "dbadmin";
    protected String driver = "com.mysql.cj.jdbc.Driver";
    protected Connection conn;
    


        public DB()
        {
            try
            {
                Class.forName(driver); // This is the process for loading DB driver
                this.conn = DriverManager.getConnection(URL, dbuser, dbpass);
                
                // DB Server connection status if==null: disconnected, !=connected 
                if (conn != null) { System.out.println("DB server connection Success!"); }
            }
            catch (ClassNotFoundException e) { System.out.println("DB driver loading Failed");}
            catch (SQLException e) { e.getMessage(); }
        }

        public void testQuery()
        {
            String selectDB = "use isd2021;";
            String sql = "Select * From test";
            try
            {
            
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
            
                //Creates an Object for sending sql to DB server
                preparedStatement =this.conn.prepareStatement(selectDB);
                // Seding sql to DB server by using Object above
                resultSet = preparedStatement.executeQuery();
                preparedStatement =this.conn.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                
                while(resultSet.next())
                {
                    //the parameter valueX in getAccessor(X) Must have same attribute Name on DBServer
                    System.out.print("   Name: " + resultSet.getString("StudentName"));
                    System.out.print("  From: " + resultSet.getString("Address"));
                    System.out.println("");
            }
        }
        catch (SQLException e) { e.printStackTrace(); }
    }
}




