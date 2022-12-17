import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class GUI implements ActionListener
{
	//INSTANCE VARIABLES
	
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
	
	private JLabel cardLabel;
	private JLabel alreadyLabel;
	private JLabel playerStatsLabel;
	
	private Game game;
	private String[] playerNames;
	private int currentLocation;
	private boolean check;
	
	
	public GUI() {	
		//creates an object of our original game class
		game = new Game();
		//sets the players to the array in game
		game.availableCards();
		
		//Frames used to show gui
		//Frames are different for each as they show different things
		menuFrame = new JFrame();
		openPackFrame = new JFrame();
		storageFrame = new JFrame();
		cardRarityFrame = new JFrame();
		
		//buttons that can cause the frame to change
		openPackButton = new JButton("Open Pack");
		storageButton = new JButton("Storage");
		cardRarityButton = new JButton("Rarest Card");
		menuButton = new JButton("Menu");
		leftButton= new JButton("<");
		rightButton = new JButton(">");

		//allows buttons to know when its clicked
		openPackButton.addActionListener(this);
		storageButton.addActionListener(this);
		cardRarityButton.addActionListener(this);
		menuButton.addActionListener(this);
		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
		
		//sets button size and location
		openPackButton.setBounds(190, 175, 110, 50);
		storageButton.setBounds(190, 235, 110, 50);
		cardRarityButton.setBounds(190, 295, 110, 50);
		menuButton.setBounds(400, 20, 70, 20);
		leftButton.setBounds(10, 260, 50, 20);
		rightButton.setBounds(430, 260, 50, 20);
		
		//sets up when you open a pack
		openPackFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		openPackFrame.setTitle("Opening Pack");
		openPackFrame.setSize(500, 500);
		openPackFrame.setLayout(null);
		openPackFrame.setVisible(true);
		
		//sets up when you are on the menu
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setTitle("NBA Cards");
		menuFrame.setSize(500, 500);
		menuFrame.setLayout(null);
		menuFrame.add(openPackButton);
		menuFrame.add(storageButton);
		menuFrame.add(cardRarityButton);
		menuFrame.setVisible(true);
		
		
		//sets up when you are in storage
		storageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		storageFrame.setTitle("Storage");
		storageFrame.setSize(500, 500);
		storageFrame.setLayout(null);
		ImageIcon playerIcon = new ImageIcon("Empty.png");
		playerStatsLabel = new JLabel(playerIcon);
		storageFrame.add(playerStatsLabel);
		storageFrame.setVisible(false);
		
		//sets up when you are in cardrarity
		cardRarityFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cardRarityFrame.setTitle("Storage");
		cardRarityFrame.setSize(500, 500);
		cardRarityFrame.setLayout(null);
		cardRarity();
		cardRarityFrame.setVisible(false);
		
		//used so that labels won't cause a nullpointer exception
		check = false;

		//creates an array of all the player's names
		playerNames = new String[10];
		for(int i = 0; i <playerNames.length;i++) {
			playerNames[i] = "Empty";
		}
		
		currentLocation = 0;
	}
	
	
	
	public void openPack() {
		
		
		String cardActionandName = game.openPack();
		
		String playerName = cardActionandName.substring(1);
		if(cardActionandName.charAt(0)=='r') {
			
			
			check = false;
			
			//resizes and positions the image of player
			ImageIcon playerIcon = new ImageIcon(playerName+".png");
			Image player = playerIcon.getImage();
			player = player.getScaledInstance(183, 315, java.awt.Image.SCALE_SMOOTH);
			playerIcon = new ImageIcon(player);
			cardLabel = new JLabel(playerIcon);
			cardLabel.setBounds(100, 55, 183, 315);
			openPackFrame.add(cardLabel);
		}
			
			else if(cardActionandName.charAt(0)=='a') {
				
				
				check = true;
				//add image that says you already have this player
				ImageIcon alreadyIcon = new ImageIcon("AlreadyHaveCard.png");
				Image already = alreadyIcon.getImage();
				already = already.getScaledInstance(236, 34, java.awt.Image.SCALE_SMOOTH);
				alreadyIcon = new ImageIcon(already);
				alreadyLabel = new JLabel(alreadyIcon);
				alreadyLabel.setBounds(80, 230, 236, 34);
				openPackFrame.add(alreadyLabel);
				
				//resizes and positions the image of player
				ImageIcon playerIcon = new ImageIcon(playerName+".png");
				Image player = playerIcon.getImage();
				player = player.getScaledInstance(183, 315, java.awt.Image.SCALE_SMOOTH);
				playerIcon = new ImageIcon(player);
				cardLabel = new JLabel(playerIcon);
				cardLabel.setBounds(100, 55, 183, 315);
				openPackFrame.add(cardLabel);
			}
			
		
		
		//adds button to frame
		openPackFrame.add(menuButton);
		
	}
	
	public void storage() {
		//calls the storage from the game class to know what players are obtained
		String[] temp = game.storage();
		
		for(int i = 0; i<temp.length; i++) {
			playerNames[i]=temp[i];
			
		}
		
		String name = playerNames[currentLocation];
		
		
			if(!name.equals("Empty")) {
				
				//shows the player image
				ImageIcon playerIcon = new ImageIcon(name + ".png");
				Image player = playerIcon.getImage();
				player = player.getScaledInstance(183, 315, java.awt.Image.SCALE_SMOOTH);
				playerIcon = new ImageIcon(player);
				cardLabel = new JLabel(playerIcon);
				cardLabel.setBounds(70, 80, 183, 315);
				
				storageFrame.add(cardLabel);	
				
				/*
				 * 
				 * 
				 * 
				 */
				
				//shows player stats image
				playerIcon = new ImageIcon(name + " Stats.png");
				player = playerIcon.getImage();
				player = player.getScaledInstance(148, 166, java.awt.Image.SCALE_SMOOTH);
				playerIcon = new ImageIcon(player);
				playerStatsLabel = new JLabel(playerIcon);
				playerStatsLabel.setBounds(263, 167, 148, 166);
				
				storageFrame.add(playerStatsLabel);
			}
			else {
				//shows empty picture when array contains "Empty"
				ImageIcon playerIcon = new ImageIcon("Empty.png");
				Image player = playerIcon.getImage();
				player = player.getScaledInstance(183, 315, java.awt.Image.SCALE_SMOOTH);
				playerIcon = new ImageIcon(player);
				cardLabel = new JLabel(playerIcon);
				cardLabel.setBounds(70, 80, 183, 315);
				
				storageFrame.add(cardLabel);
				
				/*
				 * 
				 * 
				 * 
				 */
				//shows empty stats picture when array contains "Empty"
				
				playerIcon = new ImageIcon("Empty Stats.png");
				player = playerIcon.getImage();
				player = player.getScaledInstance(148, 166, java.awt.Image.SCALE_SMOOTH);
				playerIcon = new ImageIcon(player);
				playerStatsLabel = new JLabel(playerIcon);
				playerStatsLabel.setBounds(263, 167, 148, 166);
				
				storageFrame.add(playerStatsLabel);
			}
			
			//adds all the buttons to navigate the frame
			storageFrame.add(leftButton);
			storageFrame.add(rightButton);
			storageFrame.add(menuButton);
	}
	
	public void cardRarity() {
		//resizes and moves kobe image on the screen
		ImageIcon kobeIcon = new ImageIcon("Kobe Bryant.png");
		Image kobe = kobeIcon.getImage();
		kobe = kobe.getScaledInstance(183, 315, java.awt.Image.SCALE_SMOOTH);
		kobeIcon = new ImageIcon(kobe);
		cardLabel = new JLabel(kobeIcon);
		cardLabel.setBounds(158, 92, 183, 315);
		cardRarityFrame.add(cardLabel);
		
		cardRarityFrame.add(menuButton);
		
		//add stats image next to kobe card
		
		
		cardRarityFrame.add(menuButton);
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		//controls what frames are showing
		
		if(e.getSource()==openPackButton) {
			menuFrame.setVisible(false);
			openPack();
			openPackFrame.setVisible(false);
			openPackFrame.setVisible(true);
		}
		
		else if(e.getSource()==storageButton) {
			menuFrame.setVisible(false);
			storage();
			storageFrame.setVisible(false);
			storageFrame.setVisible(true);
			
		}
		else if(e.getSource()==cardRarityButton) {
			menuFrame.setVisible(false);
			cardRarityFrame.setVisible(true);
			cardRarity();
		}
		else if(e.getSource()==menuButton) {
			openPackFrame.setVisible(false);
			storageFrame.setVisible(false);
			cardRarityFrame.setVisible(false);
			menuFrame.setVisible(true);
			openPackFrame.remove(cardLabel);
			if(check) {
			openPackFrame.remove(alreadyLabel);
			}
			storageFrame.remove(cardLabel);
			storageFrame.remove(playerStatsLabel);
			currentLocation = 0;
			
			
			
		}
		else if(e.getSource()==leftButton) {
			if(currentLocation == 0) {
				currentLocation = 9;
			}
			else {
				currentLocation--;
			}
			storageFrame.remove(cardLabel);
			storageFrame.remove(playerStatsLabel);
			
			storage();
			storageFrame.setVisible(false);
			storageFrame.setVisible(true);
			
			
			
		}
		else if (e.getSource()==rightButton) {
			if(currentLocation == 9) {
				currentLocation = 0;
			}
			else {
				currentLocation++;
			}
			
			storageFrame.remove(cardLabel);
			storageFrame.remove(playerStatsLabel);
			
			storage();
			storageFrame.setVisible(false);
			storageFrame.setVisible(true);
			
		}
	}
	
	
}
