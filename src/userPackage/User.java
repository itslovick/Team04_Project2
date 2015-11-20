package userPackage;

public abstract class User {
	protected String username,firstname,middle,lastname,department,aType;
	protected int uid;
	
	/*
	 * Name:
	 * Pre: N/A
	 * Post: N/A
	 * Description:Default constructor.
	*/
	public User (){
		username = null;
		firstname=null;
		middle=null;
		lastname=null;
		department=null;
		aType=null;
		uid=0;
	}
	
	protected User(String user, String first, String mi, String last, String dpmt, String aType,int uid){
		username = user;
		firstname = first;
		middle = mi;
		lastname = last;
		department = dpmt;
		this.aType=aType;
		this.uid=uid;
	}
	

}
