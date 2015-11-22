package databasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Stephen Lovick(A00016066)
 */
public class database{
//Column number for Student Table.
public final static int id=1;
public final static int username=2;
public final static int fname=3;
public final static int middle=4;
public final static int lname=5;
public final static int grade_level=6;
//Column number for User Tables
public final static int User_username=2;
public final static int User_firstname=3;
public final static int User_middle=4;
public final static int User_lastname=5;
public final static int User_account=6;
public final static int User_password=7;
//Column number for Teacher tables;
public final static int Teacher_id=1;
public final static int Teacher_username=2;
public final static int Teacher_firstname=3;
public final static int Teacher_middle=4;
public final static int Teacher_lastname=5;
//Column number for Course table
public final static int Course_courseID=1;
public final static int Course_department=2;
public final static int Course_courseName=3;
public final static int Course_hours=4;
//Column number for Section table;
public final static int Section_course_id=1;
public final static int Section_id=2;
public final static int Section_days=3;
public final static int Section_time=4;
public final static int Section_professor=5;
public final static int Section_start_date=6;
public final static int Section_end_date=7;
//Column number for Student Stat table
public final static int Stat_id=1;
public final static int Stat1=2;
public final static int Stat2=3;
public final static int Stat3=4;
public final static int Stat4=5;
//Column number for Grades Table
public final static int Grade_anum=1;
public final static int Grade_firstname=2;
public final static int Grade_lastname=3;
public final static int Grade_class1=4;

//Connection parameters
private final static String url = "jdbc:mysql://ec2-54-174-90-208.compute-1.amazonaws.com:3306/";
private final static String user = "team04";
private final static String password = "team04";
private final static String dbname = "Team04_Project2_Database";
private final static String driverName = "com.mysql.jdbc.Driver";

//used for all connection and disconnection
private Connection dbCon;
//query variables
protected String q_user,q_fname,q_middle,q_last,q_department;
protected int q_schoolID;

//public constructor
public database() {
	dbCon=null;
	q_user=null;
	q_fname=null;
	q_middle=null;
	q_last=null;
	q_department=null;
//Accessing drivers from JAR file
	try {
			Class.forName(driverName);
		} 
	catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
}

//Setters
/*
private void setQuser(String user){
	q_user=user;
}
private void setQfname(String fname){
	q_fname=fname;
	//todo
}
private void setQmiddle(String middle){
	q_middle=middle;
	//todo
}
private void setQlast(String lname){
	q_last=lname;
	//todo
}
private void setQdepartment(String dept){
	q_department=dept;
	//todo
}
private void setQschoolID(int id){
	q_schoolID=id;
}
*/

//Getters
public String getQ_user(){
	return q_user;
}
public String getQ_fname(){
	return q_fname;	
}
public String getQ_middle(){
	return q_middle;
}
public String getQ_last(){
	return q_last;
}
public String getQ_department(){
	return q_department;
}
public int getQschoolID(){
	return q_schoolID;
}

//opens connection for database
//error handles sqlexception
/**
 * Opens Connection to database
 * @param n/a
 * @throws SQLException
 */
private void openConnection() throws SQLException {
	
		//Creating a variable for the connection called "con"
	try{
			dbCon = DriverManager.getConnection(url+dbname,user,password);
			//url: jdbc:mysql://:
			//database user:
			//database password:		
		}
	catch (Exception SQLException) {
		System.out.println(SQLException.getMessage()+"\nConnection Failed.");	
		}

}

/**
 * @return Boolean
 * @param n/a
 * @throws SQLException
 * Closes connection for to database
 */
private void closeConnection() throws SQLException{
		dbCon.close();
}

/**
 * @param username, password
 * @return String (T,S,N)
 * @throws SQLException
 * Test username and password against records in database
 */
public String validateUser(String username, String password) throws SQLException{
	try {
			openConnection();
			PreparedStatement statement = dbCon.prepareStatement("Select * from User where username = ?");
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.next()&&(result.getString(User_username).equals(username)&&result.getString(User_password).equals(password)))
				return result.getString(User_account);
			else
				return "N";

		} 
	catch (SQLException e) {
			e.printStackTrace();
			closeConnection();
		}
	return null;
	}

//Shows all Stats from Student Stat Table. Ends output with null value.
//outputs records in rows.
/**
 * @return String
 * @throws SQLException
 * -Opens Connection
 * -All records in Stats
 * -Closes connections
 */
public String studentStats() throws SQLException{
	openConnection();
	PreparedStatement displayStats=dbCon.prepareStatement("Select * from Stat");
	ResultSet result = displayStats.executeQuery();
	while (result.next()) {
		return (result.getString(Stat_id)+result.getString(Stat1)+result.getString(Stat2)+result.getString(Stat3));
	}
	closeConnection();
	return null;
}

//Shows Student Stats if it anumber specified.
/**
 * @param id
 * @return String
 * @throws SQLException
 * -Open connection
 * -Returns record associated with id
 * -Closes connection
 */
public String studentStats(int id) throws SQLException{
	openConnection();
	PreparedStatement displayStats=dbCon.prepareStatement("Select * from Stat where a_num = ?");
	displayStats.setInt(1, id);
	ResultSet result = displayStats.executeQuery();
	while (result.next()) {
		return (result.getString(Stat_id)+result.getString(Stat1)+result.getString(Stat2)+result.getString(Stat3));
	}
	closeConnection();
	return null;
	
}
/**
 * @param user
 * @return String
 * @throws SQLException
 * -Open connection
 * -Returns user info from table.
 * -Close connection
 */
//done
public String getUserInfo(String user) throws SQLException{
	openConnection();
	PreparedStatement displayInfo=dbCon.prepareStatement("Select * from User where username = ?");
	displayInfo.setString(1, user);
	ResultSet result = displayInfo.executeQuery();
	while (result.next()) {
		return (result.getString(User_username)+" "+result.getString(User_firstname)+" "+result.getString(User_middle)+" "+result.getString(User_lastname)+" "+result.getString(User_account));
	}
	closeConnection();
	return null;
	
}
/**
 * 
 * @param user
 * @param fname
 * @param mi
 * @param lname
 * @param pass
 * @throws SQLException
 * -Open Connection
 * -Adds User
 * -Close Connection
 */
//done
public void insertUser(String user, String fname, String mi, String lname,String accountType) throws SQLException{
	openConnection();
	String pass ="password1234";
	String insertQuery = " insert into users (username, firstname, middle, lastname, account type, password) values (?, ?, ?, ?, ?,?)";
	PreparedStatement insertStmt = dbCon.prepareStatement(insertQuery);
	insertStmt.setString(1, user);
	insertStmt.setString(2, fname);
	insertStmt.setString(3, mi);
	insertStmt.setString(4, lname);
	insertStmt.setString(5, accountType);
	insertStmt.setString(6, pass);
	try{
	switch(accountType){
	case "S":{
		PreparedStatement studentStmt = dbCon.prepareStatement("insert into Student (a_num,username,first_name,m.i,last_name,grade_level) values (?,?,?,?,?,?)");
		String grade_level = "F";
		studentStmt.setString(2,user);
		studentStmt.setString(3, fname);
		studentStmt.setString(4,mi);
		studentStmt.setString(5,lname);
		studentStmt.setString(6,grade_level);
		studentStmt.executeQuery();
		break;
	}
	case "T":{
		PreparedStatement teacherStmt = dbCon.prepareStatement("insert into Student (username,First_name,M.I.,Last_Name) values (?,?,?,?)");
		teacherStmt.setString(1,user);
		teacherStmt.setString(2, fname);
		teacherStmt.setString(3, mi);
		teacherStmt.setString(4,lname);
		teacherStmt.executeQuery();
		break;
		
	}
	case "*":{
		System.out.println("Added User");
	}
	}
	insertStmt.executeQuery();
	}
	catch(Exception SQLException){
		SQLException.getCause();
		SQLException.getMessage();
		closeConnection();
	}
}
/**
 * needs to add grades to database into
 * student , course_id = composite key
 *	@param username, course, grade earned.
 */
//todo
public void insertStudentGrades(){
	
}
/**
 * it query for last anum used
 * returns value
 * does calculation to add new anum 
 * displays it to admin and put it into database.
 * @throws SQLException 
 */
//done
public int createAnum() throws SQLException{
	openConnection();
    int newAnum=0;
	PreparedStatement createAnum = dbCon.prepareStatement("select * from student order by a_num desc Limit 1");
	ResultSet result = createAnum.executeQuery();
	while (result.next()){
		newAnum = result.getInt(1)+1;
	}
	
	closeConnection();
	return newAnum;
	
}
/**
 * allows user to change pasword.
 * @param username
 * @param newpassword
 */
public void changePassword(String User, String pass){
	
}

/**
 * used to help display the course names per column in grades
 * make a String vector thats going to save the column names for each table
 * @return string
 */
//todo
protected String getColumnName(String table, int ColumnNumber){
	//todo
	return table;

}
/**
 * used to set column from input grades.
 * @param table
 * @param ColumnNumber
 */
//todo
protected void setColumnName(String table, int ColumnNumber){
	//todo
	
}
//Still need to figure out e
//todo
private void registerStudent(){
	
}


}
