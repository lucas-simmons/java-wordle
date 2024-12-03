package edu.unca.csci201;
import java.util.Random;
import java.io.FileNotFoundException;

public class HiddenWord {

	// using "toString" as the method name interferes with a base java method
	public static String tooString() throws FileNotFoundException {
		Random rand = new Random();
		int num = rand.nextInt(2309);
		String answer= WordList.getWord(num);
		String ansUP= answer.toUpperCase();
		String hide = ansUP;
		return hide;
	}

	// used a second parameter so the hidden word wasn't randomized every turn
	public static String evaluateGuess(String guess, String ans) throws FileNotFoundException {
		// for loop inside if statement

		String upGuess= guess.toUpperCase();	
		String out = "";

		//colors
		final String GREEN_BACKGROUND = "\u001B[42m";
		final String YELLOW_BACKGROUND = "\u001b[43m";
		final String BACKGROUND_RESET = "\u001b[0m";//white

		char[] cg = upGuess.toCharArray();
		char[] cans= ans.toCharArray();

		int count=0;
		for (int i =0;i<5;i++) {	
			if (cg[i]==cans[count]) {
				out=out+GREEN_BACKGROUND+"G"+BACKGROUND_RESET;
			}
			else	
			{

				for ( int c = 0;c<5;c++) {
					if (cg[i]==cans[c]) {
						out= out+YELLOW_BACKGROUND+"Y"+BACKGROUND_RESET; 
						break;
					}
					else {
						if ((c==4) && (cg[i]!=cans[c]))  {
							out=out+"_";
							break;

						}
					}

				}

			}
			count++;		

		}
		return out;
	}



	public static void hiddenword(String hidden) throws FileNotFoundException {	


	}

}
