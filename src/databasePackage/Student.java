/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasePackage;

/**
 *
 * @author Abhi
 */
public class Student extends User 
{
    protected String ANumber;
    
    public Student()
    {
        ANumber = " ";
    }
    
    public void setANumber(String a)
    {
        this.ANumber = a;
    }
    
    public String getANumber()
    {
        return ANumber;
    }
}
