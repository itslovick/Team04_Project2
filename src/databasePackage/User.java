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
public class User 
{
    protected String firstName;
    protected String lastName;
    protected char middleI;
    String password;
    //String ID;
    
    
    public User()
    {
        firstName = " ";
        lastName = " ";
        middleI = '*';
        password = " ";
       // ID = " ";
    }
    
    public void setFirstName(String f)
    {
        this.firstName = f;
        
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setLastName(String l)
    {
        this.lastName = l;
        
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setMiddleInitial(char m)
    {
        this.middleI = m;
        
    }
    
    public char getMiddleInitial()
    {
        return middleI;
    }
    
    public void setPassword(String p)
    {
        this.password = p;
        
    }
    
    public String getPassword()
    {
        return password;
    }
    
   /* public void setUser(User u)
    {
        
    }
    
    public User getUser()
    {
        return ;
    }
    */
    
    
}
