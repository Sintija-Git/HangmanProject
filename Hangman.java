package HangmanProject;


import java.util.Random; // importing Random that allows system to generate random word from an array

public class Hangman { //an instantiable class that selects random word from words[] and replaces all its characters with underline and whitespace with double whitespace	

	//declare instance variables for class Hangman
		private String wordsArray[] = {"Nelson Mandela", "John F Kennedy", "Salvador Dali", "Albert Einstein", "Anne Frank", "Walt Disney", 
				"Stephen Hawking", "Elvis Presley", "Steve Jobs", "Pablo Picasso", "Neil Armstrong", "Elon Musk", "Michael Jackson", "Mark Zuckerberg", "Barack Obama",
		"Bill Gates", "Lionel Messi", "Greta Thunberg", "Mohammed Ali", "Cristiano Ronaldo", "Oprah Winfrey"};
		
		private String chosenWord; //stores random word
		private String hangman; // stores random words hidden version
		

		public Hangman() {} //declaring default constructor
		
	
		
		public String getChosenWord() { // generate getters for both variables
			return chosenWord;
		}
		
		public String getHangman() {
			return hangman;
		}

		
		public String randomSelection () { //create a method that chooses one random word from wordsArray[]
			Random r = new Random(); // create new object r of type Random
			chosenWord = wordsArray[r.nextInt(wordsArray.length)].toUpperCase(); //generate random word that is stored in variable chosenWord, return string value toUpperCase
			chosenWord = chosenWord.replaceAll(" ", "  "); //replace single whitespace to double whitespace
			return chosenWord;
		} //end method
		
		
		public void HideChosenWord () { // create a method to encrypt the word
			hangman = chosenWord.replaceAll("[a-zA-Z]", "_ ");
		} //end method
		

		
} //end class
