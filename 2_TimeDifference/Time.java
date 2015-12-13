/* by Jiashan Wu
16 September 2015 */

import java.util.Scanner;

public class Time {

	public static void main(String[] args){
		
		int firstTime, secondTime;
		int differenceSeconds, differenceMinutes, differenceHours;
		String sZero = "";
		String mZero = "";
		String negSign = "";
		String outString = "Time difference: ";
		
		// get times from user
		Scanner myScanner = new Scanner(System.in);
		System.out.print("Enter first time: ");
		firstTime = myScanner.nextInt();
		System.out.print("Enter second time: ");
		secondTime = myScanner.nextInt();

		// calculate total seconds for first time
		int fTotalSeconds = calculateTotalSec(firstTime);
		// calculate total seconds for second time
		int sTotalSeconds = calculateTotalSec(secondTime);
		// calculate total difference in seconds
		int dTotalSeconds = fTotalSeconds - sTotalSeconds;

		// if negative,insert negative sign
		if (dTotalSeconds < 0) {
			dTotalSeconds = Math.abs(dTotalSeconds);
			negSign = "-";
		}

		// if total seconds are smaller than 60
		if (dTotalSeconds < 60) {
			System.out.println(outString + negSign + dTotalSeconds); 

		// if total seconds are equals to or larger than 60	
		} else {
			
			differenceSeconds = dTotalSeconds % 60; // 30
			differenceMinutes = dTotalSeconds / 60; // 55
			
			// if total minutes are smaller than 60 
			if (differenceMinutes < 60) {

				// if seconds smaller than 10, add a 0 to seconds 
				if (differenceSeconds < 10) {
					sZero = "0";
				}
				
				System.out.println(outString + negSign + Integer.toString(differenceMinutes) 
					+ sZero + Integer.toString(differenceSeconds));

			// if total minutes are equals to or larger than 60	
			} else {
				
				differenceHours = differenceMinutes / 60;
				differenceMinutes = differenceMinutes % 60;
				
				// if seconds smaller than 10, add a 0 to seconds
				if (differenceSeconds < 10) {
					sZero = "0";
				} 

				// if minutes smaller than 10, add a 0 to minutes
				if (differenceMinutes < 10) {
					mZero = "0";
				} 
			
				System.out.println(outString + negSign + Integer.toString(differenceHours) 
					+ mZero + Integer.toString(differenceMinutes) 
					+ sZero + Integer.toString(differenceSeconds));
			}
		}		
	} // end of main

	private static int calculateTotalSec(int time){
		int seconds = time % 100;  
		int minutes = (time % 10000 - time % 100) / 100; 
		int hours = (time % 1000000 - time % 10000) / 10000; 
		return seconds + minutes * 60 + hours * 60 * 60; 
	}
}


