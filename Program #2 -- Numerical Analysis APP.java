//Programmer: Javan Graber
//Date: 10/28/26

package javanproject;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class MyProject {   
    static Scanner userinput = new Scanner(System.in); 
    public static void main(String[] args) throws FileNotFoundException {
		// Get the file and prepare to scan it
		String fileName = "C:\\Users\\javan\\eclipse-workspace\\javanproject\\mypracticenumberfile.txt";
		File textFile = new File(fileName);
		Scanner datainput = new Scanner(textFile);
		
		//Initialize the variables
		String full;
		int amount = 0;
		String number1, number2, number3, number4, number5, number6;
		double do1, do2, do3, do4, do5, do6;
		double totalSum = 0;
		
		//Initialize the list of all the numbers
		ArrayList<Double> numberList = new ArrayList<Double>();
		
		//Get the information from the text file
		while (datainput.hasNextLine()) {
			amount++;
			full = datainput.nextLine();
			full = full.trim();
			System.out.println(full);
			
			//Get each of the substrings
			number1 = full.substring(0, 9);
			number2 = full.substring(10, 19);
			number3 = full.substring(20, 29);
			number4 = full.substring(30, 39);
			number5 = full.substring(40, 49);
			number6 = full.substring(50, 59);
			
			//Turn the substrings into doubles and add them to the list
			do1 = Double.parseDouble(number1.trim());
			numberList.add(do1);
			do2 = Double.parseDouble(number2.trim());
			numberList.add(do2);
			do3 = Double.parseDouble(number3.trim());
			numberList.add(do3);
			do4 = Double.parseDouble(number4.trim());
			numberList.add(do4);
			do5 = Double.parseDouble(number5.trim());
			numberList.add(do5);
			do6 = Double.parseDouble(number6.trim());
			numberList.add(do6);
			
			//Find the total sum of the numbers to later get the average
			totalSum += do1 + do2 + do3 + do4 + do5 + do6;
			
			//Scan through to find the number of numbers
			for (int j = 0; j < full.length(); j++) {
				
				//Count the numbers
				if ((full.charAt(j) == ' ') && (full.charAt(j + 1) != ' ')) {
					amount++;
				}
			}
		}
		datainput.close();
		
		//Sort the list
		System.out.println();
		Collections.sort(numberList);
		
		//Find the smallest and largest numbers
		Double smallest = Collections.min(numberList);
		System.out.println("Smallest number: " + smallest);
		
		Double largest = Collections.max(numberList);
		System.out.println("Largest number: " + largest);
		
		//Display the number of numbers
		System.out.println("Number of numbers: " + amount);
		
		//Display the mean
		System.out.println("Average (mean) of the data: " + (totalSum / 18));
		
		//Find the range
		double range = largest - smallest;
		System.out.println("The range of the numbers is: " + range);
    	}
    	
    }
