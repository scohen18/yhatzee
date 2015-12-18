import java.util.Scanner;

public class YahtzeeDriver
{
	/*
	1. Creates a new instance of the YahtzeeGame class
	2. Calls the playGame method on the Yahtzee object
	3. Asks user if they would like to play again
	4. When the user is done playing, prints the number of games played, min, max, and average score
	*/
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		String input = "";
		int maxScore = 0;
		int minScore = 0;
		int avgScore = 0;
		int numGames = 0;
		do {
			int score;
			YahtzeeGame myGame=new YahtzeeGame();
			System.out.println("Welcome to Sam's APCSA Yahtzee Game!");
			score=myGame.playGame();

			numGames ++;
			if(score <= minScore)
			{
				score = minScore;
			}
			if(score >= maxScore)
			{
				score = maxScore;
			}
			avgScore += score;
			System.out.println("would you like to play again? (y/n)");
			input = scan.nextLine();
		} while(input == "y");

		avgScore = avgScore / numGames;
		System.out.println("you played a total of " + numGames + " games. Your minimum score was " + minScore + " points and you maximum score was "+ maxScore + " points. You average score was " + avgScore + " points.");

	}
}
