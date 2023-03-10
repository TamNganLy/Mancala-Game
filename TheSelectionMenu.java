/**
 * CS151 Fall 2022 Team Project - 9ine
 * @Tam Ly, Jose Betancourt Jr. Huizar, Maryia Sakharava
 * @version 1.0 12/01/2022
 */

import javax.swing.*;
import java.awt.*;

/**
 * Selection Menu
 */
public class TheSelectionMenu extends JPanel {
    private JLabel gameTitle;
    private JButton threePitButton, fourPitButton, exitButton, themeOneButton, themeTwoButton, themeThreeButton;
    private int frameWidth = 630;
    private int frameHeight = 350;
    private int buttonWidth = 100;
    private int buttonHeight = 50;
    private MenuFormatter menuFormatter;
    private DisplayBoard displayboard;

	private MancalaFormatter formatter = new SimpleFormatter();


    /**
     * Selection Menu Constructor
     */
    public TheSelectionMenu() {
        gameTitle = new JLabel("CS151 Mancala Game", JLabel.CENTER);
        threePitButton = new JButton("3 Pits");
        fourPitButton = new JButton("4 Pits");
        exitButton = new JButton("Exit");
        themeOneButton = new JButton("Simple Theme");
        themeTwoButton = new JButton("Realistic Theme");
    }

    /**
     * Sets menuFormatter
     *
     * @param menuFormatter the MenuFormatter
     */
    public void setFormatter(MenuFormatter menuFormatter) {
        this.menuFormatter = menuFormatter;
        DisplayComponents(menuFormatter);
    }

    /**
     * Sets style formatter for MenuFormatter
     *
     * @param formatter the MenuFormatter
     */
    public void setStyleFormatter(MancalaFormatter formatter) {
        this.formatter = formatter;
    }

    /**
     * Display components MenuFormatter
     *
     * @param formatter the MenuFormatter
     */
    public void DisplayComponents(MenuFormatter formatter) {
        formatter.setLayout();
        this.setBackground(new Color(0.2f, 0.4f, 0.8f, 0.95f));
        this.add(formatter.addPlayButtonPanel(), BorderLayout.CENTER);
        this.add(formatter.addThemeButtonPanel(), BorderLayout.SOUTH);
        this.add(formatter.addJLabel(), BorderLayout.NORTH);
    }

    /**
     * Start game setting formatters
     *
     * @param numberOfPits the number of marbles
     */
    public void startGame(int numberOfPits){
        SwingUtilities.getWindowAncestor(this).dispose();
        JFrame gameFrame = new JFrame("CS151 Mancala Project Team 9ine | %s Pit Game".formatted(numberOfPits));      
        
        MancalaModel mancalaModel = new MancalaModel(numberOfPits);
        displayboard = new DisplayBoard(mancalaModel, this);
        MancalaFormatter newFoo = null;
        try {
			newFoo = (MancalaFormatter) formatter.getClass().newInstance();
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
        displayboard.setFormatter(newFoo);   

        gameFrame.setResizable(false);
        gameFrame.add(displayboard);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }

    /**
     * Exit app
     */
    public void exitButtonApplication(){
        SwingUtilities.getWindowAncestor(this).dispose();
    }

    /**
     * Display main menu
     */
    public void displayMainMenu(){
        JFrame menuFrame = new JFrame("CS151 Mancala Project Team 9ine");

        menuFrame.setResizable(false);
        menuFrame.add(this);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.pack();
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);
    }

    /**
     * Gets displayboard.
     *
     * @return the displayboard
     */
    public DisplayBoard getDisplayboard() {
		return displayboard;
	}

    /**
     * Gets exit button.
     *
     * @return the exit button
     */
    public JButton getExitButton() {
        return exitButton;
    }

    /**
     * Gets three pit button.
     *
     * @return the three pit button
     */
    public JButton getThreePitButton() {
        return threePitButton;
    }

    /**
     * Gets four pit button.
     *
     * @return the four pit button
     */
    public JButton getFourPitButton() {
        return fourPitButton;
    }

    /**
     * Gets theme one button.
     *
     * @return the theme one button
     */
    public JButton getThemeOneButton() {
        return themeOneButton;
    }

    /**
     * Gets theme two button.
     *
     * @return the theme two button
     */
    public JButton getThemeTwoButton() {
        return themeTwoButton;
    }

    /**
     * Gets theme three button.
     *
     * @return the theme three button
     */
    public JButton getThemeThreeButton() {
        return themeThreeButton;
    }

    /**
     * Gets game title.
     *
     * @return the game title
     */
    public JLabel getGameTitle() {
        return gameTitle;
    }

}