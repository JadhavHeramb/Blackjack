package com.herby.bjgame;

import java.util.Scanner;

public class Welcome {

	public void greet() throws InterruptedException {
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Would you like to play Blackjack ?");
			System.out.println("Y/N");
			char input = sc.nextLine().toLowerCase().charAt(0);
			if (input == 'y') {
				System.out.println("Welcome to the table. Please take a seat");
				FirstDraw firstDraw = new FirstDraw();
				firstDraw.firstPlay();
				Thread.sleep(1000); // wait for 1 second
				firstDraw.play() ;
				

			} else if (input == 'n') {
				System.out.println("Thank you for visiting");
				System.out.println("Have a great day ! ");
				Exit exit = new Exit();
				exit.exit();
			} else {
				System.out.println("Please enter 'y' or 'n'");
				greet();
			}
		}
	}

}
