/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasePackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Abhi
 */
public class Teacher extends User
{
    protected String UIN;
    private Connection conn;
    
    public Teacher()
    {
        UIN = " ";
        conn = ConnectionManager.getConnection();
    }
    
    public void setUIN(String x)
    {
        this.UIN = x;
    }
    
    public String getUIN()
    {
        return UIN;
    }
    
    public void addGrade(int id, int courseId, String firstName, String lastName, String grade)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try
        {
            pstmt = conn.prepareStatement(String.format("INSERT INTO Grade(`a_num`, `%d`, `firstname`, `lastname`) VALUES(?, ?, ?, ?)", courseId));
            
            pstmt.setInt(1, id);
            pstmt.setString(2, grade);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
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
    

}
