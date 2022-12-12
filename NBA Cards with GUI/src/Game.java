import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Game
{
	private Card[] availableCards;
	private Card[] obtainedCards;
	private String[] rarityNames;
	
	public Game() {
		availableCards = new Card[10];
		obtainedCards = new Card[10];
		rarityNames = new String[]{"Legendary","Rare","Uncommon","Common",};
	}
	
	//sets players/coach to availableCards
	public void availableCards() {
		try{                                                              
			
		Scanner playerScanner = new Scanner(new File("AvailablePlayers"));
				
		
		for(int i = 0; i<availableCards.length-1; i++) {
			if(i!=0) {
				playerScanner.nextLine();//clear newline
			}
			String rarity = playerScanner.nextLine();
			String name= playerScanner.nextLine();
			int percentOfReceiving = playerScanner.nextInt();
			playerScanner.nextLine();//clear newline 
			String team = playerScanner.nextLine();
			int totalPoints = playerScanner.nextInt();
			int totalAssists = playerScanner.nextInt();
			int totalRebounds = playerScanner.nextInt();
			int totalSteals = playerScanner.nextInt();
			double avgPoints= playerScanner.nextDouble();
			double avgAssists = playerScanner.nextDouble();
			availableCards[i] = new Player(rarity, name, percentOfReceiving, team, totalPoints, totalAssists, totalRebounds, totalSteals, avgPoints,avgAssists);
			
		}
		availableCards[9] = new Coach("Rare", "Phil Jackson", 5, 2);
		playerScanner.close();
		}
		catch(Exception e){
			System.out.println("Problem with file");
			e.printStackTrace();
		}
		
	}
	
	//open pack if you have received coach because coach boosts up chances for getting rarer cards
	public Card openPackCoach() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(100);
		if(randomNumber >= 0 && randomNumber <= 3) {
			//kobe
			return availableCards[0];
		}
		else if(randomNumber >= 4 && randomNumber <= 7) {
			//jordan
			return availableCards[1];
		}
		else if(randomNumber >= 8 && randomNumber <= 12) {
			//lebron
			return availableCards[2];
		}
		else if(randomNumber >= 13 && randomNumber <= 17){
			//curry
			return availableCards[3];
		}
		else if (randomNumber >= 18 && randomNumber <= 24){
			//durant
			return availableCards[4];
		}
		else if (randomNumber >= 25 && randomNumber <= 29){
			// Phil Jackson
			return availableCards[9];
		}
		else if (randomNumber >= 29 && randomNumber <= 40){
			//James Harden
			return availableCards[5];
		}
		else if (randomNumber >= 41 && randomNumber <= 62){
			//Lonzo
			return availableCards[6];
		}
		else if (randomNumber >= 62 && randomNumber <= 74){
			//Caruso
			return availableCards[7];
		}
		else if (randomNumber >= 75 && randomNumber <= 99){
			//Pat Bev
			return availableCards[8];
		}
		else{
			return availableCards[10];
		}
	}
	
	//opens a pack without having a coach; default chances
	public Card openPackNoCoach() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(100);
		if(randomNumber >= 0 && randomNumber <= 1) {
			//kobe
			return availableCards[0];
		}
		else if(randomNumber >= 2 && randomNumber <= 3) {
			//jordan
			return availableCards[1];
		}
		else if(randomNumber >= 4 && randomNumber <= 6) {
			//lebron
			return availableCards[2];
		}
		else if(randomNumber >= 7 && randomNumber <= 9){
			//curry
			return availableCards[3];
		}
		else if (randomNumber >= 10 && randomNumber <= 14){
			//durant
			return availableCards[4];
		}
		else if (randomNumber >= 15 && randomNumber <= 19){
			//Phil Jackson
			return availableCards[9];
		}
		else if (randomNumber >= 20 && randomNumber <= 29){
			//James Harden
			return availableCards[5];
		}
		else if (randomNumber >= 30 && randomNumber <= 49){
			//Lonzo
			return availableCards[6];
		}
		else if (randomNumber >= 50 && randomNumber <= 69){
			//Caruso
			return availableCards[7];
		}
		else if (randomNumber >= 70 && randomNumber <= 99){
			//Pat Bev
			return availableCards[8];
		}
		else {
			return availableCards[10];
		}

	}
	
	//checks if obtainedCards has a coach
	public boolean checkCoach() {
		boolean hasCoach = false;
		for(int i = 0; i<obtainedCards.length; i++) {
			if(obtainedCards[i]!=null) {
				if(obtainedCards[i].getName().equals(availableCards[9].getName())) {
				hasCoach = true;
				}
			}
		}
		return hasCoach;
	}
	
	//looks for the available position to put a card
	public int checkCardLocation() {
		int location = 0;
		for(int i = 0; i<obtainedCards.length; i++) {
			if(obtainedCards[i] == null) {
				location = i;
				break;
			}
		}

		return location;
	}
	
	//opens the pack
	//changed from void to String for project 2
	public String openPack() {
		boolean hasCoach = checkCoach();
		Card card;
		boolean ifAdd = true;
		
		if(hasCoach) {
			card = openPackCoach();
		}
		else {
			card = openPackNoCoach();
		}
		
		for(int i = 0; i<obtainedCards.length; i++) {
			if(obtainedCards[i] != null) {
				if(obtainedCards[i].getName().equals(card.getName())) {
				
				obtainedCards[i].toString();
				ifAdd = false;
				
				//for project 2
				//a represents that user already has the card
				return "a" + obtainedCards[i].getName();
				}
			}
		} 
		
		int location = checkCardLocation();
		if(ifAdd) {
		
		obtainedCards[location]=card;
		
		
		//for project 2
		//r represents that user will receive the card
		return "r" + obtainedCards[location].getName();
		}
		else {
			return "a" + obtainedCards[location].getName();
		}
		
		
	}
	
	//opens storage
	public String[] storage() {
		String[] players = new String[]{"Empty", "Empty", "Empty", "Empty", "Empty",
										"Empty", "Empty", "Empty", "Empty", "Empty"};
		
		System.out.println(players[9]);
		for(int i = 0; i < obtainedCards.length; i++){
			if(obtainedCards[i]!=null) {
			players[i] = obtainedCards[i].getName();
			
			}
		}
		
		return players;
	}
	
	
	
	//get player names to GUI
	public String[] getPlayerNames() {
		String [] playerNames = new String [10];
		String[] emptyStorage = new String[10];
		
		for(int i =0; i< obtainedCards.length; i++) {
			
			playerNames [i] = obtainedCards[i].getName(); 
		}
		
		for(int i =0; i< obtainedCards.length; i++) {
			emptyStorage [i] = "Empty"; 
		}
	
		if(obtainedCards[0] != null) {
			return playerNames;
		}
		else {
			return emptyStorage;
		}
	}
}
