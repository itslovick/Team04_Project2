/*
 * Contains the main() method to "run" the application.
 */
package UI;

/**
 *
 * @author Fernando Vela
 */
public class runApplication {
	/**
	 *
	 * @param args
	 */
	public static void main(String args[]) {
		boolean loginAuthenticated = false; 
		
		// Display login window
		new LoginUI().setVisible(true);
	}
}
