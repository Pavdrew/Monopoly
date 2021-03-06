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
	
	private void playerMenu() throws IOException {
		int playerLocation = players[turn].location;
		boolean playerReRoll = false;
		List<String> menuItems = new ArrayList<>();
		menuItems.add("Roll Again");
		menuItems.add("End turn");
		menuItems.add("Buy & Sell Houses");
		menuItems.add("Mortage Property");
		menuItems.add("Trade");
		menuItems.add("Forfeit to Bank");
		menuItems.add("Forfeit to Player");
		String[] menuItemsArray = new String[menuItems.size()];
		menuItemsArray = menuItems.toArray(menuItemsArray);
		int selection = ConsoleIO.promptForMenuSelection("Make your menu selection ", menuItemsArray, false);
		switch(selection) {
		case 1:
			if(playerReRoll == true) {
				
			} else {
				System.out.println("You have not rolled doubles, you must end your turn.");
			}
			break;

		case 2: 
			if(players[turn].money < 0) {
				System.out.println("You have negative balance you cannot end your turn.");
			} 
			else if(playerReRoll == true) {
				System.out.println("You rolled doubles, you must r-roll.");
			} else {
				
			}
			break;
		case 3: 
			construction();
			break;
		case 4:
			mortage();
			break;
		case 5: 
			sellTo();
			break;
		case 6:
			if(players[playerLocation].owner != null) {
				System.out.println("You cannot forfeit to a bank if you are in debt to a player");
			} else {
				forfeitToBank();
			}
			break;
		case 7: 
			if(players[playerLocation].owner == null) {
				System.out.println("You cannot forfeit to a bank if you are not in debt to a player.");
			} else {
				forfeitToPlayer();
			}
			break;

		default:
			throw new IllegalArgumentException("Invalid Number"); 
			
		}
		
	}

	private void forfeitToPlayer() {
		//give all cash and properties to the player's spot they landed on
	}

	private void forfeitToBank() {
		//remove player from array and set all their properties to unowned
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
	
}


