package edu.unca.csci201;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;
public class WordList {

	public static int size() throws FileNotFoundException  {
		int lineCount=0;
		String num;
		Scanner fileScan;
		fileScan = new Scanner(new File("wordlist.txt"));

		while (fileScan.hasNext()) {
			fileScan.nextLine();
			lineCount++;
		}

		return lineCount;
	}

	public static  String getWord(int index) throws FileNotFoundException {
		Scanner fileScan;
		fileScan = new Scanner(new File("answerlist.txt"));
		int lineCount = 0;
		while (fileScan.hasNext()) {
			fileScan.nextLine();
			lineCount++;
		}
		String[] lines = new String[lineCount];
		fileScan = new Scanner(new File("answerlist.txt"));
		int count=0;
		while (fileScan.hasNext()) {
			lines[count]= fileScan.nextLine();
			count++;
		}
		return lines[index];
	}

	public static boolean inList(String word) throws FileNotFoundException {
		Scanner fileScan;
		fileScan = new Scanner(new File("wordlist.txt"));
		int lineCount = 0;
		while (fileScan.hasNext()) {
			fileScan.nextLine();
			lineCount++;
		}
		String[] lines = new String[lineCount];
		fileScan = new Scanner(new File("wordlist.txt"));
		int count=0;
		while (fileScan.hasNext()) {
			lines[count]= fileScan.nextLine();
			count++;
		}
		boolean check = false;
		for (int i=0;i<size();i++) {
			if (word==lines[i]) {
				check=true;
			}
		}

		return check;
	}


	public static void wordlist(String[] args) throws FileNotFoundException {	





	}
}
