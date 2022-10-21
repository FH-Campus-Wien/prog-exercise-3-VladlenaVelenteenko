package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static void oneMonthCalendar(int daysInMonth, int startingDay) {
        int[][] calendar = new int[5][7];
        int day = 1;
        startingDay = startingDay - 1 ;


        for (int zeile = 0; zeile < 5 ; zeile++) {
            for (int spalten = 0; spalten < 7; spalten++) {
                if (zeile == 0 && spalten < startingDay ){
                        calendar[zeile][spalten] = 0;
                }
                else {
                calendar[zeile][spalten] = day;
                if( daysInMonth < day) {
                    calendar[zeile][spalten] = 0;
                }
                day++;
            }}
        }
        for (int zeile = 0; zeile < 5 ; zeile++) {
            for (int spalten = 0; spalten < 7; spalten++) {
                if (zeile == 4 && calendar[zeile][spalten] == 0 ){
                    break;
                }
                if (calendar[zeile][spalten] == 0 ){
                    System.out.print("   ");
                } else {
                    if (calendar[zeile][spalten] < 10 ){
                        System.out.print(" ");
                    }

                    System.out.print(calendar[zeile][spalten] + " ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        oneMonthCalendar(30,2);
    }

    public static long[] lcg(long seed){
        long[] x = new long[10];
        long A = 1103515245L;
        long C = 12345L;
        long M = 2147483648L;

        x[0]=(A*seed+C)%M;

        for (int i = 1; i < 10; i++) {
            x[i]= (A*x[i-1]+C)%M;
        }
        return x;
    }

    public static void guessingGame(int numberToGuess){
        Scanner scanner = new Scanner(System.in);
        int guess,counter;
        counter=0;
        for (int i = 1; i < 11; i++) {
            System.out.print("Guess number "+i+": ");
            guess = scanner.nextInt();
            counter++;
            if(guess>numberToGuess){
                if(i<10)
                    System.out.println("The number AI picked is lower than your guess.");
            }
            else if (guess<numberToGuess){
                if(i<10)
                    System.out.println("The number AI picked is higher than your guess.");
            }
            else{
                System.out.println("You won wisenheimer!");
                break;
            }

        }
        if(counter>=10){
            System.out.println("You lost! Have you ever heard of divide & conquer?");
        }

        scanner.close();
    }

    public static  int randomNumberBetweenOneAndHundred(){
        return (int)Math.floor(Math.random() *100) + 1;
    }

    public static boolean swapArrays(int[] x, int[] y){

        if (x.length==y.length) {
            int[] buffer= new int[x.length];

            for (int i = 0; i < x.length; i++) {
                buffer[i] = x[i];
                x[i] = y[i];
                y[i] = buffer[i];
            }
        }
        return x.length==y.length;
    }

    public static int checkDigit(int[] iban){
        int pruefZiffer = 0;
        int[] buffer = new int[iban.length];

        for (int i = 0; i < iban.length; i++) {
            buffer[i]=i+2;
            buffer[i]=iban[i]*buffer[i];
            pruefZiffer+=buffer[i];
        }
        pruefZiffer%=11;

        pruefZiffer=11-pruefZiffer;

        if(pruefZiffer==10){
            pruefZiffer=0;
        }
        else if(pruefZiffer==11){
            pruefZiffer=5;
        }

        return pruefZiffer;
    }



}


