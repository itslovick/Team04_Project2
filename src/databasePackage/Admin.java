
package databasePackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
    
    private Connection conn;

    public Admin()
    {
        this.conn = ConnectionManager.getConnection();
    }

    public void createUser(String username, String firstName, String middle, String lastName, String accountType, String password)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try
        {
            pstmt = conn.prepareStatement("INSERT INTO User(username, firstname, middle, lastname, `account type`, password) VALUES(?, ?, ?, ?, ?, ?)");
            
            pstmt.setString(1, username);
            pstmt.setString(2, firstName);
            pstmt.setString(3, middle);
            pstmt.setString(4, lastName);
            pstmt.setString(5, accountType);
            pstmt.setString(6, password);
            
            pstmt.execute();
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            try
            {
                if(rset != null)
                    rset.close();
            }
            catch(SQLException ex)
            {
                System.err.println(ex);
            }

            try
            {
                if(pstmt != null)
                    pstmt.close();
            }
            catch(SQLException ex)
            {
                System.err.println(ex);
            }
        }

    }

    public static void main(String[] args)
    {
        
    }
}
   
