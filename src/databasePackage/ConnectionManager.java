package databasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static Connection conn = null;

    public static Connection getConnection()
    {
        if(conn != null)
            return conn;

        String host     = "ec2-54-174-90-208.compute-1.amazonaws.com";
        String dbname   = "Team04_Project2_Database";
        String username = "team04";
        String password = "team04";
        String url      = "jdbc:mysql://" + host + "/" + dbname;

        String driver = "com.mysql.jdbc.Driver";
        
        try 
        {
            Class.forName(driver);
        } 
        catch(ClassNotFoundException ex)
        {
            System.err.println(ex);
            System.exit(1);
        }
        try
        {
            conn = DriverManager.getConnection(url, username, password);
        }
        catch(SQLException ex)
        {
            System.err.println("Unable to connect to the database");
            System.err.println(ex);
            System.exit(1);
        }

        /**
         * The following lines closes the connection to the database
         * even if the program is being forcefully shutdown by the user
         */
        Runtime
            .getRuntime()
            .addShutdownHook(
                    new Thread(){
                        public void run() {
                            try
                            {
                                if(conn != null)
                                    conn.close();
                            }
                            catch(SQLException ex)
                            {
                                System.err.println(ex);
                            }
                        }
        });


        return conn;
    }

}



