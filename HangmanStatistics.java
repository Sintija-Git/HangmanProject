package HangmanProject;

public class HangmanStatistics { //an instantiable class that keeps the track of games won/lost/total
	
	//declaring instant variables
	private int gamesWon;
	private int gamesLost;
	
	
	public HangmanStatistics() {} //declaring default constructor

	
	public int getGamesWon() { // getter for gamesWon
		return this.gamesWon;
	}
	
	
	public int AddGamesWon () { // method to add +1 to gamesWon when called
		return gamesWon += 1;
	} //end
	
	
	public int getGamesLost() { //getter for gamesLost
		return this.gamesLost;
	}
	
	public int AddGamesLost () { // method to add +1 to gamesLost when called
		return gamesLost += 1;
	} //end
	
	
	public int getTotalGames() { //getter for totalGames
		return gamesLost + gamesWon; //returns sum of won and lost games
		}
	
} //end class
