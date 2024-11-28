package crud;

public class IdNotFoundException extends Exception {
	IdNotFoundException(String exceptionMessage){
		System.out.println(exceptionMessage);
	}
}
