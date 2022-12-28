/**
 * CS151 Fall 2022 Team Project - 9ine
 * @Tam Ly, Jose Betancourt Jr. Huizar, Maryia Sakharava
 * @version 1.0 12/01/2022
 */

import javax.swing.JFrame;

/**
 * Test Mancala Project Class
 */
public class MancalaTest {
	/**
	 * Test the application
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		JFrame menuFrame = new JFrame("CS151 Mancala Project Team 9ine");
		TheSelectionMenu theSelectionMenu = new TheSelectionMenu();
		MenuFormatter menuFormatter = new MenuFormatter(theSelectionMenu);
		theSelectionMenu.setFormatter(menuFormatter);

		menuFrame.setResizable(false);
		menuFrame.add(theSelectionMenu);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		menuFrame.pack();
		menuFrame.setLocationRelativeTo(null);
		menuFrame.setVisible(true);
	}
}