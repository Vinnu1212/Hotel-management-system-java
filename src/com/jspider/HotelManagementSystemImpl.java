package com.jspider;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelManagementSystemImpl implements HotelManagementSystem {

	Scanner sc = new Scanner(System.in);
	Map<Integer, Food> db = new LinkedHashMap<Integer, Food>();
	int totalcost = 0;

	@Override
	public void addFood() {

		db.put(1, new Food(1, "Chicken biriyani", 240, 5));
		db.put(2, new Food(2, "Mushroom biriyani", 210, 7));
		db.put(3, new Food(3, "Paneer biriyani", 220, 3));
		db.put(4, new Food(4, "fish biriyani", 230, 8));
		db.put(5, new Food(5, "Mutton biriyani", 330, 4));
		System.out.println("Food Menu Created");
	}

	@Override
	public void displayFood() {
		Set<Integer> keys = db.keySet();
		for (int key : keys) {
			System.out.println("Enter " + key + " -> " + db.get(key));
		}

	}

	@Override
	public void orderFood() {
		/*
		 * 1. get the food object based on id/choice ->get()
		 * 2.accept quantity -> set new Quantity
		 * 3.calculate cost
		 * 4.cost-> total bill
		 * 5.InvalidQuantityException
		 *
		 */
		System.out.println("Select Food:");
		int id = sc.nextInt();
		Food food = db.get(id);
		System.out.println("Ordering " + food.getName());

		System.out.println("Enter a Quantity:");
		int quantity = sc.nextInt();

		if (quantity <= food.getQuantity()) {
			food.setQuantity(food.getQuantity() - quantity);
			int currentCost = food.getCost() * quantity;
			totalcost = totalcost + currentCost;
			System.out.println("Ordered " + quantity + " " + food.getName() + " at the cost of Rs." + currentCost);
		} else {
			try {
				throw new InvalidQuantityException("Invalid Quantity Entered");
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}

		}

	}

	@Override
	public void checkOut() {
		if (totalcost != 0) {
			System.out.println("Total Bill: Rs." + totalcost);
		} else {
			System.out.println("No Food Items Added");
		}

	}

}
