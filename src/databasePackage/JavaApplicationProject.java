/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasePackage;

import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;

/**
 *
 * @author Abhi
 */
public class JavaApplicationProject
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
      // System.out.println("Welcome to the online gradebook/group allocator.");
        Teacher teacher = new Teacher();
        teacher.addGrade(40001, 1435,"Timmy", "Turner", "A");
    }
    
}
