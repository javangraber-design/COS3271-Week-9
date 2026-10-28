//Programmer: Javan Graber
//Date: 10/27/26

package javanproject;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;


public class MyProject {   
    static Scanner userinput = new Scanner(System.in); 
    public static void main(String[] args) throws FileNotFoundException {
		// Get the file and prepare to scan it
		String fileName = "C:\\Users\\javan\\eclipse-workspace\\javanproject\\mypracticenumberfile.txt";
		File textFile = new File(fileName);
		Scanner datainput = new Scanner(textFile);
		
		//Initialize the variables
		String all;
		int words = 0;
		int letters = 0;
		int sentences = 0;
		String number1, number2, number3, number4, number5, number6;
		double flt1, flt2, flt3, flt4, flt5, flt6;
		double totalSum = 0;

		int[] counter = new int[26];
		
		//Get every character of the text file
		while (datainput.hasNextLine()) {
			words++;
			all = datainput.nextLine();
			all = all.trim();
			System.out.println(all);
			
			number1 = all.substring(0, 9);
			number2 = all.substring(10, 19);
			number3 = all.substring(20, 29);
			number4 = all.substring(30, 39);
			number5 = all.substring(40, 49);
			number6 = all.substring(50, 59);
			
			flt1 = Double.parseDouble(number1.trim());
			flt2 = Double.parseDouble(number2.trim());
			flt3 = Double.parseDouble(number3.trim());
			flt4 = Double.parseDouble(number4.trim());
			flt5 = Double.parseDouble(number5.trim());
			flt6 = Double.parseDouble(number6.trim());
			
			totalSum += flt1 + flt2 + flt3 + flt4 + flt5 + flt6;
			
			System.out.println(flt1 + " " + flt2 + " " + flt3 + " " + flt4 + " " + flt5 + " " + flt6 + " ");
			System.out.format("Total sum = %.4f\n", totalSum);
			System.out.println();
			//Scan through each of the characters
			for (int j = 0; j < all.length(); j++) {
				
				//Count the words
				if ((all.charAt(j) == ' ') && (all.charAt(j + 1) != ' ')) {
					words++;
				}
				
				//Count the sentences
				if ((all.charAt(j) == '.') || (all.charAt(j) == '!') || (all.charAt(j) == '?')){
					sentences++;
				}
				
				//To find if it is an a, b, c, etc., get its ASCII value and take away the lowest outcome from it
				//This will leave 0-25, which can then be assigned to the respective letter for both capitals and lower case letters
				int ascii = (int) (all.charAt(j));
				if ((ascii >= 97) && (ascii <= 122)) {
					counter[ascii - 97]++;
				}
				if ((ascii >= 65) && (ascii <= 90)) {
					counter[ascii - 65]++;
				}
			
			}
		}
		datainput.close();
		
		//Count the occurrences of each letter
		for (int j = 0; j <= 25; j++) {
			letters += counter[j];
		}
		//Display the number of words, letters, and sentences
		System.out.println();
		System.out.println();
		System.out.println("Number of words: " + words);
		System.out.println("Number of letters: " + letters);
		System.out.println("Number of sentences: " + sentences);
		System.out.println("Total Sum: " + totalSum);
		
		//Convert the values to floats to perform the calculations and display the averages
		float fltLetters = letters;
		float fltWords = words;
		float averageLetters = fltLetters / fltWords;
		System.out.format("Average number of letters per word = %.1f\n", averageLetters);
		
		float fltSentences = sentences;
		float averageWords = fltWords / fltSentences;
		System.out.format("Average number of words per sentence = %.1f\n", averageWords);
		System.out.println("\nProgram ended ...");
    	
    	}
    	
    }
