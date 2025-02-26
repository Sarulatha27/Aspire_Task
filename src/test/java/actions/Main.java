package actions;

public class Main {
	public static void main(String[] args) {
		String string = "Happy Testing";
		
		int length= string.length();
		
		for(int i=0;i<length;i++) {
			System.out.println(string.charAt(i));
		}
	}
}
