package com.herby.bjgame;

import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FirstDraw  {
	Random random = new Random();
	Welcome wel = new Welcome();
	Scanner sc = new Scanner(System.in);
	int drawForDealer = random.nextInt(10) + 1; // to draw first card from List (use random on array)
	int drawForPlayer = random.nextInt(10) + 1;
	List<Integer> player = new ArrayList<Integer>(); // List of player cards
	List<Integer> dealer = new ArrayList<Integer>(); // List of dealer cards
    
	
	public void firstPlay() throws InterruptedException {
		System.out.println("Here's the distribution for cards");
		Thread.sleep(1000);
		player.add(0, drawForPlayer);
		dealer.add(0, drawForDealer);

		System.out.println("Dealer Card " + dealer.get(0)); // First Draw of Cards for dealer
		Thread.sleep(1000); // wait for 1 second
		System.out.println("Player Card " + player.get(0)); // First Draw of Cards for player
	}

	public void play() throws InterruptedException {
		System.out.println("Please Type h (Hit) / s (Stay)");
		char option = sc.nextLine().toLowerCase().charAt(0);

		if (option == 'h') {
			hit();
		} else if (option == 's') {
			stopForPlayer();
		}
		else
		{
			play();
		}

	}

	public void hit() throws InterruptedException // Player hit (show list of cards)
	{
		player.add(random.nextInt(10) + 1);
		System.out.println("Player's Card " + player);
		Thread.sleep(200);
		int addition = 0;
		      
		{
				Object sum[] = player.toArray();
				for (int i = 0; i < sum.length; i++) {
					addition = addition + (Integer) sum[i];
				}
				
		if (addition > 21)
		{
			
			stopForPlayer();
			System.out.println("You Burst. Dealer Won ! ");
			wel.greet();
		}
		else if 
		(addition == 21)
		{
			System.out.println("Blackjack ! ");
			wel.greet();
		}
		else 
		play();
		}
	}

	public void stopForPlayer() throws InterruptedException // Player stay (addition of cards)

	{
		int addition = 0;
		Object sum[] = player.toArray();
		for (int i = 0; i < sum.length; i++) {
			addition = addition + (Integer) sum[i];

		}
		System.out.println("Player's total is : "+addition);
        stopForDealer();
		
	}

	public void stopForDealer() throws InterruptedException {
		int sum = 0;
		int finalSum = 0;
		do {
			dealer.add(random.nextInt(10) + 1);
			Thread.sleep(500);
			System.out.println("Dealer's Card :" + dealer);
			Object[] add = dealer.toArray();
			for (int i = 0; i < add.length; i++) {

				sum = sum + (Integer) add[i];

			}

			finalSum = sum + dealer.indexOf(0);

		} while (finalSum <= 21);

		playerTotal();
		dealerTotal();
		Thread.sleep(500) ;
		winner();
		
	}
	
	public void playerTotal()
	{
		int addition = 0;
		Object sum[] = player.toArray();
		for (int i = 0; i < sum.length; i++) {
			addition = addition + (Integer) sum[i];

		}
		System.out.println("Player's total is : "+addition);
	}
	
	public void dealerTotal()
	{
		int addition = 0;
		Object sum[] = dealer.toArray();
		for (int i = 0; i < sum.length; i++) {
			addition = addition + (Integer) sum[i];

		}
		System.out.println("Dealer's total is : "+addition);
	}
	
	public void winner () throws InterruptedException
	{
		Object arr1[] = player.toArray();
		Object arr2[] = dealer.toArray();
		
		int add1 = 0 ;
		for (int i = 0 ; i<arr1.length ; i++)
		{
			add1 = add1 + (Integer)arr1[i] ;
		}
		int add2 = 0 ;
		for (int i = 0 ; i<arr2.length ; i++)
		{
			add2 = add2 + (Integer)arr2[i] ;
		}
		
		if (add1 > add2 && (add1 <=21))
		{
			System.out.println("Congratulations ! You won");
			wel.greet();
			
		}
		else if (add1 == add2)
		{
			System.out.println("Push");
			wel.greet();
		}
		
		else if (add1 < add2 && (add2 <=21))
		{
			System.out.println("You lose to Dealer");
			wel.greet();
		}
	}
}
