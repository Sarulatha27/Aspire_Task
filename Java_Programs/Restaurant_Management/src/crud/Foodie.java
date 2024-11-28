package crud;

import java.util.Scanner;

public class Foodie {
	public void foodieRestaurant() {
		MenuOperations menuOperations = new MenuOperations();
		Scanner scanner = new Scanner(System.in);
		        int enterOptionNumber;
		 
		        do {
		        	System.out.println("\nWelcome to Foodie restaurant :)");
		            System.out.println("Restaurant Menu Management: ");
		            System.out.println("1. Add Menu Item");
		            System.out.println("2. Display All Menu Item");
		            System.out.println("3. Update Menu Item");
		            System.out.println("4. Delete Menu Item");
		            System.out.println("5. Exit");
		            System.out.print("Enter your choice: ");
		            enterOptionNumber = scanner.nextInt();
		            
		            try {
		            	switch (enterOptionNumber) {
		            	case 1:
		            		System.out.print("Enter menu item id: ");
		            		int id = scanner.nextInt();
		            		scanner.nextLine();
		            		System.out.print("Enter menu item name: ");
		            		String name = scanner.nextLine();
		            		System.out.print("Enter item price: ");
		            		int price = scanner.nextInt();
		            		menuOperations.addMenuItem(id,name, price);
		            		break;
		            		
		            	case 2:
		            		menuOperations.displayAllMenuItem();
		            		break;
		            		
		            	case 3:
		            		System.out.print("Enter the name of the item to update: ");
		            		String oldName = scanner.nextLine();
		            		System.out.print("Enter new item name: ");
		            		String newName = scanner.nextLine();
		            		System.out.print("Enter new item price: ");
		            		int newPrice = scanner.nextInt();
		            		menuOperations.updateMenuItem(oldName, newName, newPrice);
		            		break;
		            		
		            	case 4:
		            		System.out.print("Enter the id of the item to delete: ");
		            		int menuId = scanner.nextInt();
		            		menuOperations.deleteMenuItem(menuId);
		            		break;
		            		
		            	case 5:
		            		System.out.println("Thanks for visiting...");
		            		break;
		            		
		            	default:
		            		throw new OptionNotFoundException("Invalid option. Please enter correctly.");
		            	}
		            }
		        catch(OptionNotFoundException optionException) {
		        	optionException.printStackTrace();
		            }
		        } while (enterOptionNumber != 5);
		    }
}
