package crud;

public class OptionNotFoundException extends Exception{
	OptionNotFoundException(String exceptionMessage){
		System.out.println(exceptionMessage);
	}
}
