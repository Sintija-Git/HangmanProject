package HangmanProject;

import java.util.Scanner; //import Scanner

public class HangmanApp { //class that contains main method 
	

	public static void main(String[] args) {
		
		//declare local variables
		String chosenWord, hangman;
		char letter;
		boolean isUsedLetter, isInHangman, wordCompleted;
		char playAgain = 0;
		int total, won, lost;
		
		
		HangmanStatistics stats = new HangmanStatistics(); // create an object of type HangmanStatistics to access its methods and properties
		
		
		//create game intro
		System.out.println("----------------------------------------------");
		System.out.println("--------------------WELCOME-------------------");
		System.out.println("----------------------TO----------------------");	
		System.out.println("-----------------H-A-N-G-M-A-N----------------");
		System.out.println("----------------------------------------------");
		System.out.println("Outstanding people in history and modern times!");
		System.out.println ();
		
		
	do { //start do while loop
	
	//declare local variables lives & usedLetters inside do while loop that allows them to reset before each new game
	int lives = 8; 
	String usedLetters = "";
	
	
	Hangman game = new Hangman(); //create an object of type Hangman to access its methods and properties
	game.randomSelection(); //call methods randomSelection & HideChosenWord
	game.HideChosenWord(); 
	chosenWord = game.getChosenWord(); //retrieve and store values of instance variables in chosenWord & hangman
	hangman = game.getHangman(); 
		
	
	
	Scanner sc = new Scanner(System.in); //create object of type Scanner for user input
	System.out.println ("Press ENTER to start the game!"); 
	sc.nextLine();

	
	System.out.println("Let the H-A-N-G-M-A-N begin!");
	System.out.println("\n");

	
	//display lives available and word to guess	
	System.out.println("You are given " + lives + " lives!\n"
										+ "Used letters: " + usedLetters + "\n"
										+ "Word to guess:\n" + hangman + "\n");

	
	
	while (lives>0) { //initiate while loop with condition lives > 0
	System.out.println("Enter the letter: "); //ask for user input
	letter = sc.next().toUpperCase().charAt(0); //that is stored in local char variable letter + toUpperCase
	String specialCharacters = "\"~`!?#$%^&*()-'+=<>,.;:'\\1234567890/"; //declare String variable that holds all special characters
	if (specialCharacters.contains(letter+ "")) { 
	System.out.println("This is not a letter!"); //message to show if char is special character
	continue; // proceed with while loop
	} //end if

	
	
	if (usedLetters.contains(letter+"")) { //check if usedLetters contains users input
		isUsedLetter = true; 
		System.out.println("You ALREADY guessed letter " + letter); //message shows if statement true
		System.out.println("Live(s) remaining: " + lives);
		System.out.println("Used letters: " + usedLetters);
		System.out.println();
		System.out.print(hangman + "\n");
		continue; // proceed with while loop
	} //end if
	
	
	//method that converts String usedLetters to char []
	usedLetters = usedLetters + letter + " "; //store user input into String usedLetters and ads whitespace
	char [] usedLettersArray = usedLetters.toCharArray(); //string to char []
	usedLetters = String.copyValueOf(usedLettersArray); //with copyValueOf() return a String that represents the characters of a char array
	
	
	
	if(chosenWord.contains(letter+"")) { //check if word contains users input
		isInHangman = true; //if yes, returns true
		
		System.out.println("Correct! Letter " + letter + " is in the word!\n" //message to show
												+ "Live(s) remaining: " + lives + "\n" 
												+ "Used letters: " + usedLetters + "\n" ); 
												
		
		
		for (int i = 0; i < chosenWord.length(); i++) { //for loop to traverse through each index of the chosenWord
			if (chosenWord.charAt(i) == letter && hangman.charAt(i) != letter) { //check if word at i = letter and if hangman at the same i does not!
				hangman = hangman.replaceAll("_ ", "_"); //replace hangman from underline space to only "_" to have the same length for both variables
				String progress; //create new variable that stores guess progression 
				progress = hangman.substring(0, i) + letter + hangman.substring(i + 1);//using substring modify word by cutting first part from 0-i out, adding letter and adding the rest after i back to string
				progress = progress.replaceAll("_", "_ "); //adds back spaces to show progression hangman to the player
				hangman = progress; 
			}//end inner if	loop
		} //end for
		
		System.out.print(hangman + "\n");
		
		
		
	} else { //else letter is not in the word
	lives--; // decrement lives -1
	System.out.println("Wrong! Letter " + letter + " is not in the word!\n" //message to show
										+ "Live(s) remaining: " + lives + "\n"
										+ "Used letters: " + usedLetters + "\n"
										+ hangman + "\n");
//	lives--; // decrement lives -1
	
	} //end if
	
	
	
	if (hangman.equalsIgnoreCase(chosenWord)) { //compares if hangman == chosenWord aka hangman is fully guessed
		wordCompleted = true; //if so, returns true
		System.out.println("\nCongratulations! You won!\n"
				+ "You guessed the word: " + chosenWord + "\n"
				+ "Live(s) remaining: " + lives);
		
		stats.AddGamesWon(); //call method AddGamesWon
		break; //to break the loop
	} //end if
	
	
	}//end while loop with condition (lives>0)
			
	
	
	if (lives == 0) { // if lives == 0, game over message
	System.out.println("\n");
	System.out.println("GAME OVER! \n"
						+ "Better luck next time!\n"
						+ "The word you couldn't find: " + chosenWord);
	stats.AddGamesLost(); //call method AddGamesLost
	} //end if
	 
	
	
	System.out.println("Would you like to guess another word? (y/n)"); //ask if user would like to play more
	playAgain = sc.next().toUpperCase().charAt(0);
	if (playAgain!='Y') {
	continue; // proceed 
	} //end if
	
	
	} while (playAgain =='Y'); //exit do while loop if condition playAgain != char 'Y'
	
	
	total = stats.getTotalGames(); //retrieve game statistics and store them in local variables total, won, lost
	won = stats.getGamesWon();
	lost =  stats.getGamesLost();
		
	System.out.println("*************************"); //display game statistics after exiting do while loop and finishing game!
	System.out.println("Game statistics:\n"
						+ "Game(s) played: " + total + "\n"		
						+ "Game(s) won: " + won +"\n"
						+ "Game(s) lost: " + lost + "\n"
						+ "Thank you for the game! :)");

	
	} //end main
}//end class