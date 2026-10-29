//Programmer: Javan Graber
//Date: 10/29/26

package javanproject;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class MyProject {   
    static Scanner userinput = new Scanner(System.in); 
    public static void main(String[] args) throws FileNotFoundException {
		// Get the file and prepare to scan it
		String fileName = "C:\\Users\\javan\\eclipse-workspace\\javanproject\\facialstats.txt";
		File textFile = new File(fileName);
		Scanner datainput = new Scanner(textFile);
		
		//Initialize the variables
		String full;
		String number1, number2, number3, number4, number5, number6;
		double do1, do2, do3, do4, do5, do6;
		
		//Create the array that will store the names
		String [] allNames;
		allNames = new String [5];
		
		//Create the array that will store all the original numbers
		double [][] measure;
		measure = new double[6][6];
		
		//Create the array that will store the sum of squares % difference for each person 
		//relative to the new person
		double [] sumOfSquares;
		sumOfSquares = new double [5];

		//Create the array that will store all the ratios
		double [][] ratio;
		ratio = new double [6][15];
		int person = 0;
		int i = 0;
		
		System.out.println("I originally had one picture of me in the list. I then took another picture of me and measured it.");
		System.out.println("The measures from the new picture of my face are the ones I will input.");
		//Get the information from the text file
		while (datainput.hasNextLine()) {
			full = datainput.nextLine();
			full = full.trim();
			System.out.println(full);
			
			//Get each of the names
			allNames [i] = full.substring(0, 9);
			i++;
			
			//Get each of the numbers from their substrings
			number1 = full.substring(10, 19);
			number2 = full.substring(20, 29);
			number3 = full.substring(30, 39);
			number4 = full.substring(40, 49);
			number5 = full.substring(50, 59);
			number6 = full.substring(60, 61);
			
			
			//Turn the substrings into doubles
			do1 = Double.parseDouble(number1.trim());
			do2 = Double.parseDouble(number2.trim());
			do3 = Double.parseDouble(number3.trim());
			do4 = Double.parseDouble(number4.trim());
			do5 = Double.parseDouble(number5.trim());
			do6 = Double.parseDouble(number6.trim());
			
			//Assign the doubles to the measurement array
			measure[person][0] = do1;
			measure[person][1] = do2;
			measure[person][2] = do3;
			measure[person][3] = do4;
			measure[person][4] = do5;
			measure[person][5] = do6;
			
			//Add one to the person to continue in the loop
			person++;
		}
		
		//Get the values for the new picture
		for (i = 0; i<= 5; i++) {
			System.out.print("Enter the value number #" + (i + 1) + ": ");
			
			//Assign the new values to the final row in the measurement list
			measure [5][i] = userinput.nextDouble();
			userinput.nextLine();
		}
		
		//Get all the ratios for every single picture
		for (person = 0; person <= 5; person++) {
			ratio[person][0] = measure[person][0] / measure [person][1];
			ratio[person][1] = measure[person][0] / measure [person][2];
			ratio[person][2] = measure[person][0] / measure [person][3];
			ratio[person][3] = measure[person][0] / measure [person][4];
			ratio[person][4] = measure[person][0] / measure [person][5];
			
			ratio[person][5] = measure[person][1] / measure [person][2];
			ratio[person][6] = measure[person][1] / measure [person][3];
			ratio[person][7] = measure[person][1] / measure [person][4];
			ratio[person][8] = measure[person][1] / measure [person][5];
			
			ratio[person][9] = measure[person][2] / measure [person][3];
			ratio[person][10] = measure[person][2] / measure [person][4];
			ratio[person][11] = measure[person][2] / measure [person][5];
			
			ratio[person][12] = measure[person][3] / measure [person][4];
			ratio[person][13] = measure[person][3] / measure [person][5];
			ratio[person][14] = measure[person][4] / measure [person][5];
		}
		
		
		//Compare each of the ratio calculations from each person to the new person and assign the result to the 
		//sum of squares array
		for (person = 0; person < 5; person++) {
			double total = 0;
			for (i = 0; i < 15; i++) {
				double addition = Math.pow(((ratio [5][i] - ratio [person][i]) / ratio [person][i]), 2);
				//Add each individual part to the total
				total += addition;
			}
			
			//Give the total from each person's calculations to the sum of squares array
			sumOfSquares [person] = total;
		}
		
		datainput.close();
		
		//Initialize the variable that will be the smallest number in the sum of squares array
		Double starter = sumOfSquares [0];
		
		for (person = 1; person < 5; person ++) {
			//For each number in the array, check to see if it is the lowest
			if (sumOfSquares [person] < starter) {
				//Assign the lowest to the starter variable
				starter = sumOfSquares [person];
			}
		}
		
		//Initialize the placement of the smallest number
		int placement = 10;
		
		//Find the position of the smallest number by going through the array comparing the values
		for (person = 0; person < 5; person++) {
			//Go through the array comparing each value to the smallest number
			if (sumOfSquares [person] == starter) {
				
				//Assign the place that matches to the placement variable
				placement = person;
			}
		}
		
		//Using that placement, we now take which name was at that placement in the name array and 
		//display that name
		System.out.println("You are: " + allNames [placement]);
		 
    	}
    	
    }
