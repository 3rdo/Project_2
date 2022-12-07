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
	private JFrame frame;
	private JButton openPackButton;
	private JButton storageButton;
	private JButton cardRarityButton;
	private JPanel panel;
	private JButton menuButton;
	
	public GUI() {
		frame = new JFrame();
		
		openPackButton = new JButton("Open Pack");
		storageButton = new JButton("Storage");
		cardRarityButton = new JButton("Card Rarity");
		menuButton = new JButton("Menu");
		
		openPackButton.addActionListener(this);
		storageButton.addActionListener(this);
		cardRarityButton.addActionListener(this);
		menuButton.addActionListener(this);
		
		openPackButton.setBounds(200, 175, 100, 50);
		storageButton.setBounds(200, 235, 100, 50);
		cardRarityButton.setBounds(200, 295, 100, 50);
		menuButton.setBounds(400, 250, 50, 20);
		
		
		
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("NBA Cards");
		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	public void menu() {
		
		frame.add(openPackButton);
		frame.add(storageButton);
		frame.add(cardRarityButton);
		
		
	}
	
	public void openPack() {
		//temporary code testing to see if code works
		ImageIcon lebronIcon = new ImageIcon("lebron.jpg");
		Image lebron = lebronIcon.getImage();
		lebron = lebron.getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH);
		lebronIcon = new ImageIcon(lebron);
		JLabel lebronLabel = new JLabel(lebronIcon);
		lebronLabel.setBounds(130, 105, 150, 250);
		frame.add(lebronLabel);
		frame.add(menuButton);
	}
	
	public void storage() {
		//temporary code testing to see if code works
				ImageIcon lebronIcon = new ImageIcon("lebron.jpg");
				Image lebron = lebronIcon.getImage();
				lebron = lebron.getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH);
				lebronIcon = new ImageIcon(lebron);
				JLabel lebronLabel = new JLabel(lebronIcon);
				lebronLabel.setBounds(130, 105, 150, 250);
				
				frame.add(lebronLabel);	
	}
	
	public void cardRarity() {
		//resizes and moves kobe image on the screen
		ImageIcon kobeIcon = new ImageIcon("kobe.jpg");
		Image kobe = kobeIcon.getImage();
		kobe = kobe.getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH);
		kobeIcon = new ImageIcon(kobe);
		JLabel kobeLabel = new JLabel(kobeIcon);
		kobeLabel.setBounds(130, 105, 150, 250);
		frame.add(kobeLabel);
		
		
		frame.add(menuButton);
		
		
	}
	
	public void checkAction() {
		
		if(openPackButton.isEnabled()) {
			openPack();
		}
		else if(cardRarityButton.isEnabled()) {
			cardRarity();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
		System.out.println("in action performed");
		
	}
	
	
}
