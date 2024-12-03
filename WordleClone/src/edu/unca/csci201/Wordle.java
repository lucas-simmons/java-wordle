package edu.unca.csci201;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Wordle {

	public static void play() throws FileNotFoundException {
		Scanner scword = new Scanner(System.in);
		System.out.println("Welcome to my Wordle Clone!");
		System.out.println("Press enter to play with a random word,");
		System.out.println("or enter a nonnegative integer to pick that word from the list:");
		String inp= scword.nextLine();


		String hidden=HiddenWord.tooString();
		String g1=null;
		// picking a word manually
		if (inp!="") {
			int num=Integer.parseInt(inp);
			String needup=WordList.getWord(num);
			hidden = needup.toUpperCase();
		}
		//overall loop for the game
		for (int count=1;count<7;count++) {

			System.out.println("Please enter guess number "+count+":");
			g1 = scword.nextLine();


			// Invalid guess
			while (g1.length()!=5) {

				//show
				for (int p=0;p<g1.length();) {

					String show="show";
					if (g1.charAt(p)==show.charAt(p)) {

						if (p==3) {
							System.out.println(hidden);								
							break;
						}
						p++;
					}
					else {
						System.out.println("Invalid guess. Please try again");
						break;
					}
				}
				System.out.println("Please enter guess number "+count+":");
				g1 = scword.nextLine();		
			}


			//guess
			System.out.println(g1.toUpperCase());
			System.out.println(HiddenWord.evaluateGuess(g1,hidden));

			//winning
			for (int q=0;q<5;q++) {
				String g2=g1.toUpperCase();
				if (g2.charAt(q)!=hidden.charAt(q)) {
					break;
				}
				if (g2.charAt(q)==hidden.charAt(4)) {
					System.out.println("Congratulations!");
					System.out.println("You won in "+count+" turns!");
					System.exit(0);
				}
			}

			if (count==6) {
				System.out.println("You lost");
				System.out.println("Answer was: "+hidden);
			}
		}
	}



	public static void wordle() {


	}


}
