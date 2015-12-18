import java.util.Scanner;

public class YahtzeeGame
{
	/* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */
	static final int numSides = 6;
	public YahtzeeDie die1;
	public YahtzeeDie die2;
	public YahtzeeDie die3;
	public YahtzeeDie die4;
	public YahtzeeDie die5;


	public YahtzeeScorecard scorecard;
	public Scanner scan;

	/* initializes the dice and scoreboard */
	public YahtzeeGame()
	{
		die1 = new YahtzeeDie(numSides);
		die2 = new YahtzeeDie(numSides);
		die3 = new YahtzeeDie(numSides);
		die4 = new YahtzeeDie(numSides);
		die5 = new YahtzeeDie(numSides);

		scorecard = new YahtzeeScorecard();
		scan = new Scanner(System.in);
	}

	/* check to see if the game is over, and while the game is not over call the method takeTurn()
	once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
	final scorecard and return the grand total */
	public int playGame()
	{
		for(int i = 0; i < 13; i ++)
		{
			takeTurn();
		}

		return 0;
	}

	/* 	1. call rollDice()
		2. call printDice()
		3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		4. call chooseFrozen()
		5. call rollDice()
		6. call printDice()
		7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		8. call chooseFrozen()
		9. call rollDice()
		10. call printDice()
		11. call markScore()
	*/
	private void takeTurn()
	{
		String input1 = "";

		rollDice();
		printDice();
		System.out.println("would you like to roll again? (y/n) (1)");
		input1 = scan.nextLine();

		if(input1.equals("n"))
		{
			markScore();
		}
		else
		{
			chooseFrozen();
			rollDice();
			printDice();
			System.out.println("would you like to roll again? (y/n) (2)");
			input1 = scan.nextLine();

			if(input1.equals("n"))
			{
				markScore();
			}
			else
			{
				chooseFrozen();
				rollDice();
				printDice();
				markScore();
			}
		}
	}

	/* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
	private void rollDice()
	{
		if(die1.isFrozen() == false)
		{
			die1.rollDie();
		}
		if(die2.isFrozen() == false)
		{
			die2.rollDie();
		}
		if(die3.isFrozen() == false)
		{
			die3.rollDie();
		}
		if(die4.isFrozen() == false)
		{
			die4.rollDie();
		}
		if(die5.isFrozen() == false)
		{
			die5.rollDie();
		}
		die1.unfreezeDie();
		die2.unfreezeDie();
		die3.unfreezeDie();
		die4.unfreezeDie();
		die5.unfreezeDie();
	}

	/* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
	private void chooseFrozen()
	{
		String input2 = "";
		System.out.println("enter which dice you would like to be frozen (1-5)");
		input2 = scan.nextLine();
		switch (input2) {
			case "1": die1.freezeDie(); break;
			case "2": die2.freezeDie(); break;
			case "3": die3.freezeDie(); break;
			case "4": die4.freezeDie(); break;
			case "5": die5.freezeDie(); break;
			default:
				System.out.println("invalid");
		}

	}

	/* Should print the value of all five dice separated by a tab (\t) to the console */
	private void printDice()
	{
		System.out.println(die1.getValue() + "\t" + die2.getValue() + "\t" + die3.getValue() + "\t" + die4.getValue() + "\t" + die5.getValue() + "\t");
	}

	/* 1. Print a scoreboard
	   2. Ask the user where they would like to mark their score.
	   3. Call appropriate function
	   4. If false is returned the user entered an invalid number, so ask the user to try again	*/
	private void markScore()
	{
		String input3 = "";
		scorecard.printScoreCard();
		System.out.println("where would you like to mark your score? \n 1 = ones \n" +
				" 2 = twos \n" +
				" 3 = threes \n" +
				" 4 = fours \n" +
				" 5 = fives \n" +
				" 6 = sixes \n" +
				" 7 = three of a kind \n" +
				" 8 = four of a kind \n" +
				" 9 = full house \n" +
				" 10 = small straight \n" +
				" 11 = large straight \n" +
				" 12 = yahtzee \n" +
				" 13 = chance");
		input3 = scan.nextLine();
		switch (input3)
		{
			case "1": scorecard.markOnes(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue()); break;
			case "2": scorecard.markTwos(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(),die5.getValue()); break;
			case "3": scorecard.markThrees(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(),die5.getValue()); break;
			case "4": scorecard.markFours(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(),die5.getValue()); break;
			case "5": scorecard.markFives(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(),die5.getValue()); break;
			case "6": scorecard.markSixes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(),die5.getValue()); break;
			case "7": scorecard.markThreeOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(),die5.getValue()); break;
			case "8": scorecard.markFourOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(),die5.getValue()); break;
			case "9": scorecard.markFullHouse(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(),die5.getValue()); break;
			case "10": scorecard.markSmallStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(),die5.getValue()); break;
			case "11": scorecard.markLargeStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(),die5.getValue()); break;
			case "12": scorecard.markYahtzee(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); break;
			case "13": scorecard.markChance(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue()); break;
		}


	}
}