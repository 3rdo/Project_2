
import java.util.Scanner;



public class Test 
{
	
	
	public static void main(String[] args) {
		GUI gui = new GUI();
		
		
		
		Game game = new Game();
		game.availableCards();
		String input = "m";
		
		while(!input.equalsIgnoreCase("c")) {
		Scanner scanner = new Scanner(System.in);
		if(input.equalsIgnoreCase("m")) {
		System.out.println("Enter P to Open a Pack");
		System.out.println("Enter S to View Storage");
		System.out.println("Enter R to View Cards' Rarity");
		System.out.println("Enter M for the Menu");
		System.out.println("Enter C to Stop Program");
		input = scanner.nextLine();
		}
		
		if(input.equalsIgnoreCase("p")) {
			game.openPack();
			
		}
		else if(input.equalsIgnoreCase("s")) {
			game.storage();
		}
		else if(input.equalsIgnoreCase("r")) {
			game.viewCardRarity();
		}
		else if(input.equalsIgnoreCase("c")) {
			break;
		}
		else {
			System.out.println("Enter a Valid Letter");
		}
		input = scanner.nextLine();
		}
		
		System.out.println("Game Over");
			
	}

	
}
