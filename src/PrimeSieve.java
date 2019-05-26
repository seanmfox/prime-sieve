/*
Name: Sean Fox
Date: 5-25-19
Class: CIT-130
Purpose: Assignment 3, Part 1 -  Implement the Sieve of Eratosthene algorithm
*/

import java.util.Scanner;

public class PrimeSieve {

    public static void main(String[] args) {

        System.out.print("Enter the highest number (greater than 2) to check: ");
        Scanner scanner = new Scanner(System.in);

        int maxNumber = scanner.nextInt();

        int[] numberSet = new int[maxNumber - 1];

        for(int index = 0, value = 2; index < numberSet.length; index++, value++)
            numberSet[index] = value;

        /*
        Loop over the array of numbers.  For any number that is not zero,
        change all of the multiples for that number to zero.  Any number that
        is not zero at the conclusion of the loop is a prime number.
        */
        for(int currentValue: numberSet)
            if(currentValue != 0)
                for(int index = currentValue * 2 - 2; index < numberSet.length; index += currentValue)
                    numberSet[index] = 0;

        System.out.println("The prime numbers between 2 and " + maxNumber + " are:");

        int rowLength = 0;

        for(int number: numberSet)
            if(number != 0) {
                if(rowLength > 9) {
                    System.out.println(number);
                    rowLength = 1;
                } else {
                    System.out.print(number + " ");
                    rowLength++;
                }
            }
    }
}
