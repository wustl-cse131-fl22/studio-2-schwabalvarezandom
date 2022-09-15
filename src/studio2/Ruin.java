package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Start amount?");
		double startAmount = in.nextDouble();
		System.out.println("Start winChance?");
		double winChance = in.nextDouble();
		System.out.println("Start winLimit?");
		double winLimit = in.nextDouble();
		System.out.println("Total Simulations?");
		double totalSimulations = in.nextDouble();
		int simCount = 0;
		int counter = 0;
		int loseCounter = 0 ;
		double initialTotalSimulations = totalSimulations;
		boolean winLose = false;
		double initialAmount = startAmount;
		double ruinRate = 0;
		double winLoss = 0; 
		double expectedRuinRate = 0;
		
		
		while (totalSimulations > 0) {
			counter = 0;
			while (startAmount > 0 && startAmount < winLimit) {
				
				winLoss = Math.random();
				
				if (winLoss > (winChance/100)) {
					startAmount--;
					winLose = false;
					//System.out.println("you lose " + startAmount);
				} else if (winLoss < (winChance/100)) {
					startAmount++;
					winLose = true;
					//System.out.println("you win " + startAmount);
				}
			
				counter++;
			}
			totalSimulations--;
			simCount++;
			if (winLose) {
				System.out.println("Simulation " + simCount + ": " + counter + "Win");

			} else if (!winLose) {
				System.out.println("Simulation " + simCount + ": " + counter + "Lose");
				loseCounter++;
			}
			startAmount = initialAmount;
		}
		System.out.println("Losses: " + loseCounter + " Simulations: " + initialTotalSimulations);
		
		if (winChance == 0.5) {
			expectedRuinRate = (1 - (initialAmount/winLimit));
		} else {
			double a = 0;
			a = ((1-(winChance/100))/(winChance/100));
			expectedRuinRate = (((double)Math.pow(a, initialAmount)) - ((double)Math.pow(a, winLimit)))/(1-((double)Math.pow(a, winLimit)));
		}
		System.out.println("Ruin Rate from Simulation: " + (loseCounter/initialTotalSimulations) + " Expected RuinRate: " + expectedRuinRate);
		
		
	}

}
