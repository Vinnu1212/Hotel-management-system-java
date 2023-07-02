package com.jspider;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		System.out.println("Welcome to Navaranga hotel");
		System.out.println("---------------------------");

		Scanner sc = new Scanner(System.in);
		HotelManagementSystem hotel = new HotelManagementSystemImpl();

		hotel.addFood();
		System.out.println("--------------------"); 
		int input = 1;

		while (input == 1) {

			System.out.println("1:Order Food\n2:CheckOut");
			System.out.println("Enter Choice:");
			int choice = sc.nextInt();

			switch (choice) {
				case 1:
					hotel.displayFood();
					hotel.orderFood();
					break;
				case 2:
					hotel.checkOut();
					System.out.println("Thank you!!!");
					System.exit(0);
				default:
					try {
						throw new InvalidChoiceException("INVALID CHOICE!");
					} catch (Exception e) {
						System.out.println(e.getMessage());

					}

			}
			System.out.println("-------------------------");
			System.out.println("Enter 1 to Continye,Any Other Number To Exit");
			input = sc.nextInt();
			System.out.println("--------------");

		}
		hotel.checkOut();
		System.out.println("Thank you");

	}

}
