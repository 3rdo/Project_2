import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class GUI implements ActionListener
{
	private JFrame menuFrame;
	private JFrame openPackFrame;
	private JFrame storageFrame;
	private JFrame cardRarityFrame;
	private JButton openPackButton;
	private JButton storageButton;
	private JButton cardRarityButton;
	private JButton menuButton;
	private JButton leftButton;
	private JButton rightButton;
	private Game game;
	private String[] playerNames;
	private int currentLocation;
	
	
	public GUI() {		
		game = new Game();
		game.availableCards();
		
		menuFrame = new JFrame();
		openPackFrame = new JFrame();
		storageFrame = new JFrame();
		cardRarityFrame = new JFrame();
		
		openPackButton = new JButton("Open Pack");
		storageButton = new JButton("Storage");
		cardRarityButton = new JButton("Card Rarity");
		menuButton = new JButton("Menu");
		leftButton= new JButton("Left");
		rightButton = new JButton("Right");

		
		openPackButton.addActionListener(this);
		storageButton.addActionListener(this);
		cardRarityButton.addActionListener(this);
		menuButton.addActionListener(this);
		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
		
		openPackButton.setBounds(200, 175, 100, 50);
		storageButton.setBounds(200, 235, 100, 50);
		cardRarityButton.setBounds(200, 295, 100, 50);
		menuButton.setBounds(400, 250, 50, 20);
		leftButton.setBounds(50, 260, 50, 20);
		rightButton.setBounds(100, 260, 50, 20);
		
		
		
	
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setTitle("NBA Cards");
		menuFrame.setSize(500, 500);
		menuFrame.setLayout(null);
		menuFrame.add(openPackButton);
		menuFrame.add(storageButton);
		menuFrame.add(cardRarityButton);
		menuFrame.setVisible(true);
		
		openPackFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		openPackFrame.setTitle("Opening Pack");
		openPackFrame.setSize(500, 500);
		openPackFrame.setLayout(null);
		openPack();
		openPackFrame.setVisible(false);
		
		storageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		storageFrame.setTitle("Storage");
		storageFrame.setSize(500, 500);
		storageFrame.setLayout(null);
		storage();
		storageFrame.setVisible(false);

		playerNames=game.getPlayerNames();
		currentLocation = 0;
	}
	
	
	
	public void openPack() {
		String cardActionandName = game.openPack();
		
		if(cardActionandName.charAt(0)=='r') {
			
			String playerName = cardActionandName.substring(1);
			
			
			ImageIcon playerIcon = new ImageIcon(playerName+".jpg");
			Image player = playerIcon.getImage();
			player = player.getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH);
			playerIcon = new ImageIcon(player);
			JLabel lebronLabel = new JLabel(playerIcon);
			lebronLabel.setBounds(130, 105, 150, 250);
			openPackFrame.add(lebronLabel);
		}
		
		else if(cardActionandName.charAt(0)=='a') {

			String playerName = cardActionandName.substring(1);
			
			
			ImageIcon playerIcon = new ImageIcon(playerName+".jpg");
			Image player = playerIcon.getImage();
			player = player.getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH);
			playerIcon = new ImageIcon(player);
			JLabel lebronLabel = new JLabel(playerIcon);
			lebronLabel.setBounds(130, 105, 150, 250);
			openPackFrame.add(lebronLabel);
			
			//add image saying you already have this player
		}
		
		else if(cardActionandName.charAt(0)=='m') {
			//add image that you have max players
		}
		
		//temporary code testing to see if code works
		ImageIcon lebronIcon = new ImageIcon("lebron.jpg");
		Image lebron = lebronIcon.getImage();
		lebron = lebron.getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH);
		lebronIcon = new ImageIcon(lebron);
		JLabel lebronLabel = new JLabel(lebronIcon);
		lebronLabel.setBounds(130, 105, 150, 250);
		openPackFrame.add(lebronLabel);
		openPackFrame.add(menuButton);
	}
	
	public void storage() {
		storageFrame.add(leftButton);
		storageFrame.add(rightButton);
		String name = playerNames[currentLocation];
		
		
		//temporary code testing to see if code works
				ImageIcon playerIcon = new ImageIcon(name + ".jpg");
				Image player = playerIcon.getImage();
				player = player.getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH);
				playerIcon = new ImageIcon(player);
				JLabel playerLabel = new JLabel(playerIcon);
				playerLabel.setBounds(130, 105, 150, 250);
				
				storageFrame.add(playerLabel);	
	}
	
	public void cardRarity() {
		//resizes and moves kobe image on the screen
		ImageIcon kobeIcon = new ImageIcon("kobe.jpg");
		Image kobe = kobeIcon.getImage();
		kobe = kobe.getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH);
		kobeIcon = new ImageIcon(kobe);
		JLabel kobeLabel = new JLabel(kobeIcon);
		kobeLabel.setBounds(130, 105, 150, 250);
		cardRarityFrame.add(kobeLabel);
		
		//add stats image next to kobe card
		
		
		cardRarityFrame.add(menuButton);
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
		if(e.getSource()==openPackButton) {
			menuFrame.setVisible(false);
			openPackFrame.setVisible(true);
		}
		
		else if(e.getSource()==storageButton) {
			menuFrame.setVisible(false);
			storageFrame.setVisible(true);
		}
		else if(e.getSource()==cardRarityButton) {
			menuFrame.setVisible(false);
			cardRarityFrame.setVisible(true);
		}
		else if(e.getSource()==menuButton) {
			openPackFrame.setVisible(false);
			storageFrame.setVisible(false);
			cardRarityFrame.setVisible(false);
			menuFrame.setVisible(true);
		}
		else if(e.getSource()==leftButton) {
			if(currentLocation == 0) {
				currentLocation = 9;
			}
			else {
				currentLocation--;
			}
		}
		else if (e.getSource()==rightButton) {
			if(currentLocation == 9) {
				currentLocation = 0;
			}
			else {
				currentLocation++;
			}
		}
	}
	
	
}
