package crud;

public class MenuItem {

	private int menuId;
	private String menuName;
	private int menuPrice;
	
	public MenuItem(int id,String name,int price) {
		this.menuId = id;
		this.menuName = name;
		this.menuPrice = price;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	@Override
	public String toString() {
		return menuId+"     "+menuName+"     "+menuPrice;
	}
	

}
