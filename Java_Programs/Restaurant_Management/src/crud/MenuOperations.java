package crud;

import java.util.ArrayList;
import java.util.Iterator;

public class MenuOperations {
    private ArrayList<MenuItem> menuItem;
 
    public MenuOperations() {
        menuItem = new ArrayList<>();
    }

        public void addMenuItem(int id,String name,int price) {
            menuItem.add(new MenuItem(id,name,price));
            System.out.println("New menu added successully :)");
        }
     
        public void displayAllMenuItem() {
            if(menuItem.isEmpty()) {
            	System.out.println("The menu is empty !");
            	return;
            }
            System.out.println("Menu Items:");
            System.out.println("Id"+"    	 "+"Name"+"  	   "+"Price");
            for(MenuItem item: menuItem) {
            	System.out.println(item.toString());
            }
        }
     
        public void updateMenuItem(String oldName,String newName,int newPrice) {
            for (MenuItem item : menuItem) {
                if(item.getMenuName().equalsIgnoreCase(oldName)) {
                	item.setMenuName(newName);
                	item.setMenuPrice(newPrice);
                	System.out.println("Menu item updated successfully :)");
                }
            }
        }
     
        public void deleteMenuItem(int id) {
        	try {
        		Iterator<MenuItem> iteratorMenuItem = menuItem.iterator();
        		int menuIndex=-1;
        		while(iteratorMenuItem.hasNext()) {
        			Object checkMenuItem=((MenuItem) iteratorMenuItem.next()).getMenuId();
        			menuIndex++;
        			if((int)checkMenuItem == id) {
        				menuItem.remove(menuIndex);
        				System.out.println("Menu item removed successfully !");
        				return;
        			}
        		}
        		throw new IdNotFoundException("Unable to find the menu id : "+ id);
        	}
        	catch(IdNotFoundException idExecption) {
        		idExecption.printStackTrace();
	            }
           }
}