package alex.andrew.monoplyproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import interfaces.ConsoleIO;

public class Game {
	int numPlayers = 0;
	int turn = 0;
	Player[] players;
	String[] pieces = { "TOPHAT", "BATTLESHIP", "DINOSAUR", "THIMBLE", "BOOT", "DOG", "CANNON", "RACECAR" };

	public void init() throws IOException {
		System.out.println("Welcome to Monopoly");
		numPlayers = ConsoleIO.promptForInt("How many Players are going to play", 2, 8);
		players = new Player[numPlayers];
		setUpPlayers();

	}

	public void run() {
		printCurrentPlayer();
		printBoard();
		rollDice();
	}
			

	
private void printCurrentPlayer() {
		System.out.println(players[turn].name + "'s turn");
		System.out.println("Piece: " + players[turn].piece);
		System.out.println("Cash: " + players[turn].money);

	}
	
	private void printBoard1() {
		GameBoard board = new GameBoard();
		board.init();
		board.gameBoard();
	}
	
private void rollDice() {
		Die die = new Die();
		int playerRoll = die.roll();
		System.out.println("You rolled a " + playerRoll);

		while (die.doubleRoll == true) {
			System.out.println("It was a Double");
			playerRoll = die.roll();
		}

	}
	
	private void setUpPlayers() throws IOException {
		boolean[] takenPiece = new boolean[8];
		for (int i = 0; i < takenPiece.length; i++) {
			takenPiece[i] = false;
		}

		int selection = 0;
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player();
			players[i].name = ConsoleIO.promptForInput("Enter player " + (i + 1) + "'s name", false);
			players[i].money = 1500;

			boolean pieceTaken = true;
			while (pieceTaken) {
				selection = ConsoleIO.promptForMenuSelection("Choose a piece: ", pieces, false) - 1;
				if (selection > -1) {
					pieceTaken = checkPiece(selection, takenPiece);
				} else {
					pieceTaken = true;
				}
			}

			switch (selection) {
			case 0:
				takenPiece[0] = true;
				players[i].piece = pieces[0];
				break;
			case 1:
				takenPiece[1] = true;
				players[i].piece = pieces[1];
				break;
			case 2:
				takenPiece[2] = true;
				players[i].piece = pieces[2];
				break;
			case 3:
				takenPiece[3] = true;
				players[i].piece = pieces[3];
				break;
			case 4:
				takenPiece[4] = true;
				players[i].piece = pieces[4];
				break;
			case 5:
				takenPiece[5] = true;
				players[i].piece = pieces[5];
				break;
			case 6:
				takenPiece[6] = true;
				players[i].piece = pieces[6];
				break;
			case 7:
				takenPiece[7] = true;
				players[i].piece = pieces[7];
				break;
			default:
				throw new IllegalArgumentException("Invalid Number");
			}
			
		}
		randomizeOrder(players);
		playerTurn();

	}

	private Player[] randomizeOrder(Player[] players) {
		Random random = new Random();

		for (int i = 0; i < players.length; i++) {
			int randomPosition = random.nextInt(players.length);
			Player temp = players[i];
			players[i] = players[randomPosition];
			players[randomPosition] = temp;
		}
		return players;
	}
	
	private void playerTurn() {
		Player[] playersTurn = new Player[players.length];
		printBoard1();
		playerMenu();
	}
	
	private void changeTurn() {
		
	}
	
	private void playerMenu() {
		List<String> menuItems = new ArrayList<>();
		String[] menuItemsArray = new String[menuItems.size()];
		menuItemsArray = menuItems.toArray(menuItemsArray);
		int selection = ConsoleIO.promptForMenuSelection("Select an option from the menu: ", menuItemsArray, false);
		switch(selection) {
		case 1: 
			menuItems.add("End turn");
			move();
			break;
		case 2:
			if(players[turn].money < 0) {
				menuItems.remove("End turn");
			}
			break;
		case 3: 
			menuItems.add("Buy & Sell Houses");
			construction();
			break;
		case 4:
			menuItems.add("Mortage Property");
			mortage();
			break;
		case 5: 
			menuItems.add("Trade");
			sellTo();
			break;
		case 6: 
			menuItems.add("Forfeit to Bank");
			break;
		case 7: 
			menuItems.remove("Forfeit to Bank");
			break;
		case 8: 
			menuItems.add("Forfeit to Player");
			break;
		case 9: 
			if(players) {
				menuItems.remove("Forfeit to Player");
			}
			break;
		default:
			throw new IllegalArgumentException("Invalid Number"); 
			
		}
		String[] menu = menuItems.toArray(new String[menuItems.size()]);
	}

	private void buyAuctionMenu() {
		String[] buyAuctionArray = {"Purchase Property", "Auction"};
		int selection = ConsoleIO.promptForMenuSelection("Choose an option ", buyAuctionArray, false);
		switch(selection) {
		case 1:
			purchaseProperty();
			break;
		case 2:
			auction();
			break;
		throw new IllegalArgumentException("Invalid Number");
		}
	}
	
	private void move() {
		
	}
	
	private void construction() {
		
	}
	
	private void mortage() {
		
	}
	
	private boolean checkPiece(int selection, boolean[] takenPiece) {
		boolean isTaken = true;
		if (takenPiece[selection] != false) {
			System.out.println("That Piece already taken");
			isTaken = true;
		} else {
			isTaken = false;
		}
		return isTaken;
	}
	
	private void auction() throws IOException {
		int[] bid = new int[players.length];
		boolean stillAuctioning = true;
		while(stillAuctioning) {
			
		for(int i=0;i<players.length;i++) {
			bid[i] = ConsoleIO.promptForInt("Select an amount " + players[i] + " would like to bid for *property name*", 0, players[i].money);
		}
		
		Arrays.sort(bid);
		
		stillAuctioning = endAuction(bid);
		if(stillAuctioning = false) {
			break;
		}
		stillAuctioning = ConsoleIO.promptForBool("Is it alright if *property* goes to *player* for *bid*?", "no", "yes");
		}
		transaction(bid[players.length]);
	}
	
	private void transaction(int bid) {
		
	}
	
	private boolean endAuction(int[] bid) {
		boolean auctionContinues = true;
		int biggerBid = 0;
		for(int i=0;i<players.length;i++) {
			if(bid[4] > players[i].money) {
				biggerBid++;
			}
		}
		if (biggerBid >= 3){
			auctionContinues = false;
		}
		else {
			auctionContinues = true;
		}
		return auctionContinues;
	}
	
	private void sellTo() throws IOException {
		
		int buyer = ConsoleIO.promptForInt("What player would you like to sell to?", 0, players.length);
		if(turn == buyer) {
			System.out.println("You cannot sell to yourself");
		}
		else {
			int price = ConsoleIO.promptForInt("What amount would you like to sell the property for?", 0, 999999);
			if(players[buyer].money > price) {
				ConsoleIO.promptForBool("Does the buyer accept this price?", "yes", "no");
			}
		}
	}

	private void purchaseProperty() {
		PropertyDeeds propertyCost = new PropertyDeeds();
		Player player = new Player();
		int propertySquare = player.location;
		Integer propertyCost1 = propertyCost.arrayPropertiesCost[propertySquare];
		player.money -= propertyCost1;
}
	public void drawChance(int randomNumber) {
		Square[] sqr = new Square[160];
		if (randomNumber == 0) {
			System.out.println("Advance to Go");
			sqr[0] = sqr[players[turn].location];
		}
		if (randomNumber == 1) {
			System.out.println("Pay poor Tax $15");
			players[turn].money -= 15;
		}
		if (randomNumber == 2) {
			System.out.println("You have been elected Chairman of the Board. Pay each Player $50");
			for (int i = 0; i < players.length; i++) {
				players[turn].money += 50;
			}
			players[turn].money -= 100;
		}
		if (randomNumber == 3) {
			System.out.println("Advance to St. Charles Place");
			sqr[11] = sqr[players[turn].location];
		}
		if (randomNumber == 4) {
			System.out.println("Advance to Illinois Ave");
			sqr[24] = sqr[players[turn].location];
		}
		if (randomNumber == 5) {
			System.out.println(
					"Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total 10 times the amount thrown");
		}
		if (randomNumber == 6) {
			System.out.println(
					"Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank");
		}
		if (randomNumber == 7) {
			System.out.println("Bank pays you dividend of $50");
			players[turn].money += 50;
		}
		if (randomNumber == 8) {
			System.out.println("Get out of Jail Free");
		}
		if (randomNumber == 9) {
			System.out.println("Go Back Three 3 Spaces");
			sqr[players[turn].location] = sqr[players[turn].location - 3];
		}
		if (randomNumber == 10) {
			System.out.println("Go to Jail");
			sqr[30] = sqr[players[turn].location];
		}
		if (randomNumber == 11) {
			System.out.println(
					"Make general repairs on all your property: For each house pay $25, For each hotel pay $100");
		}
		if (randomNumber == 12) {
			System.out.println("Take a trip to Reading Railroad");
			sqr[5] = sqr[players[turn].location];
		}
		if (randomNumber == 13) {
			System.out.println("Take a walk on the Boardwalk. Advance token to Boardwalk");
			sqr[39] = sqr[players[turn].location];
		}
		if (randomNumber == 14) {
			System.out.println("Your building and loan matures. Receive $150");
			players[turn].money += 150;
		}
	}

	public void drawCC(int randomNumber) {
		Square[] sqr = new Square[160];
		if (randomNumber == 0) {
			System.out.println("Advance to Go");
			sqr[0] = sqr[players[turn].location];
		}
		if (randomNumber == 1) {
			System.out.println("Bank error in your favor. Collect $200");
			players[turn].money += 200;
		}
		if (randomNumber == 2) {
			System.out.println("Doctor's fees. Pay $50");
			players[turn].money += 50;
		}
		if (randomNumber == 3) {
			System.out.println("From sale of stock you get $50");
			players[turn].money += 50;
		}
		if (randomNumber == 4) {
			System.out.println("Grand Opera Night  Collect $50 from every player for opening night seats");
			for (int i = 0; i < players.length; i++) {
				players[i].money -= 50;
			}
			players[turn].money += 100 * players.length;
		}
		if (randomNumber == 5) {
			System.out.println("Holiday Fund matures. Receive $100");
			players[turn].money += 100;
		}
		if (randomNumber == 6) {
			System.out.println("Income tax refund. Collect $20");
			players[turn].money += 20;
		}
		if (randomNumber == 7) {
			System.out.println("It's your birthday. Collect $10 from every player");
			for (int i = 0; i < players.length; i++) {
				players[i].money -= 10;
			}
			players[turn].money += 20 * players.length;
		}
		if (randomNumber == 8) {
			System.out.println("Life insurance matures. Collect $100 ");
			players[turn].money += 100;
		}
		if (randomNumber == 9) {
			System.out.println("Hospital Fees. Pay $50");
			players[turn].money -= 50;
		}
		if (randomNumber == 10) {
			System.out.println("School fees Pay $50");
			players[turn].money -= 50;
		}
		if (randomNumber == 11) {
			System.out.println("Receive $25 consultancy fee");
			players[turn].money += 25;
		}
		if (randomNumber == 12) {
			System.out.println("You are assessed for street repairs: Pay $40 per house and $115 per hotel you own");
		}
		if (randomNumber == 13) {
			System.out.println("You have won second prize in a beauty contest. Collect $10");
			players[turn].money += 10;
		}
		if (randomNumber == 14) {
			System.out.println("You inherit $100");
			players[turn].money += 100;
		}
	}
}


