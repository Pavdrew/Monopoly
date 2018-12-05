package alex.andrew.monoplyproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import interfaces.ConsoleIO;

public class Game {
	Player[] players;
	String[] pieces = { "TOPHAT", "BATTLESHIP", "DINOSAUR", "THIMBLE", "BOOT", "DOG", "CANNON", "RACECAR" };

	public void init() throws IOException {
		System.out.println("Welcome to Monopoly");
		int numPlayers = ConsoleIO.promptForInt("How many Players are going to play", 2, 8);
		players = new Player[numPlayers];
		setUpPlayers();

	}

	public void run() {
			/*
			 * Game Starts Print Board Prompt for menu for First player (roll, trade/sell, mortgage, buid houses)
			 * 	if(roll)
			 * 		add roll amount to player location
			 * 			if(property is unowned)
			 * 				player can buy property or it goes up for auction
			 * 			if(property is owned)
			 * 				player pays rent to the owner of the property
			 * 			if(player lands on cc or chance)
			 * 				randomize cc or chacne card and apply to player
			 * 			if(pass GO)
			 * 				give player $200	
			 * 	if(trade/sell)
			 * 		Trade: switch properties with players
			 * 		Sell: sell a property to other player(amount is dictated by the player trying to sell)
			 * 	if(mortgage)
			 * 		Sell property to bank for half price
			 * 	if(build)
			 * 		if(there is a monopoly on properties)
			 * 			buy a house
			 * 			if(there are 4 houses on a property)
			 * 				player can buy a house
			 * 	
			 	*/ 
			printBoard();
	}

	private void printBoard() {
		GameBoard board = new GameBoard();
		board.gameBoard();
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
	
	private void playerMenu() {
		List<String> menuItems = new ArrayList<>();
		String[] menuItemsArray = new String[menuItems.size()];
		menuItemsArray = menuItems.toArray(menuItemsArray);
		int selection = ConsoleIO.promptForMenuSelection("Select an option from the menu: ", menuItemsArray, false);
		switch(selection) {
		case 1: 
			menuItems.add("End turn");
			break;
		case 2:
			if(players[i].money < 0) {
				menuItems.remove("End turn");
			}
			break;
		case 3: 
			menuItems.add("Buy & Sell Houses");
			break;
		case 4:
			menuItems.add("Mortage Property");
			break;
		case 5: 
			menuItems.add("Trade");
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
			
		}
		String[] menu = menuItems.toArray(new String[menuItems.size()]);
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
			bid[i] = ConsoleUI.promptForInt("Select an amount " + players[i] + " would like to bid for *property name*", 0, players[i].money);
		}
		
		Arrays.sort(bid);
		
		stillAuctioning = endAuction(bid);
		if(stillAuctioning = false) {
			break;
		}
		stillAuctioning = ConsoleUI.promptForBool("Is it alright if *property* goes to *player* for *bid*?", "no", "yes");
		}
		transaction(bid[players.length]);
	}

	private void transaction(int bid) {
		// TODO Auto-generated method stub
		
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
		
		//Select property
		
		int buyer = ConsoleUI.promptForInt("What player would you like to sell to?", 0, players.length);
		if(turn == buyer) {
			System.out.println("You cannot sell to yourself");
		}
		else {
			int price = ConsoleUI.promptForInt("What amount would you like to sell the property for?", 0, 999999);
			if(players[buyer].money > price) {
				ConsoleUI.promptForBool("Does the buyer accept this price?", "yes", "no");
			}
		}
	}
}
