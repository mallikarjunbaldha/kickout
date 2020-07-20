package com.practise.naveenautomation;

import java.util.Scanner;

public class Java_Programs {
	static boolean checkLeapYear(int year){
		boolean leap = false;
		if(year%4==0) {
			if(year%100==0) {
				if(year%400==0) 
					leap = true;
					else 
					leap = false;	
			}
			else 
				leap = true;
		}
		else 
			leap = false;
			return leap;
	}
	public static void main(String[] args) {
		System.out.println(checkLeapYear(1697));
		
		}
	}


