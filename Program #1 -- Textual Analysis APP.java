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
		String fileName = "C:\\Users\\javan\\eclipse-workspace\\javanproject\\mypracticefile.txt";
		File textFile = new File(fileName);
		Scanner datainput = new Scanner(textFile);
		
		//Initialize the variables
		String s;
		int words = 0;
		int letters = 0;
		int sentences = 0;

		int[] counter = new int[26];
		
		//Get every character of the text file
		while (datainput.hasNextLine()) {
			words++;
			s = datainput.nextLine();
			s = s.trim();
			System.out.println(s);
			
			//Scan through each of the characters
			for (int j = 0; j < s.length(); j++) {
				
				//Count the words
				if ((s.charAt(j) == ' ') && (s.charAt(j + 1) != ' ')) {
					words++;
				}
				
				//Count the sentences
				if ((s.charAt(j) == '.') || (s.charAt(j) == '!') || (s.charAt(j) == '?')){
					sentences++;
				}
				
				//To find if it is an a, b, c, etc., get its ASCII value and take away the lowest outcome from it
				//This will leave 0-25, which can then be assigned to the respective letter for both capitals and lower case letters
				int ascii = (int) (s.charAt(j));
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
