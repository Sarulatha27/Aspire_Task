package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	public int count = 0;
	private static final int maxCount = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		if(count < maxCount) {
			count++; 
			return true;
		}
		return false;
	}
	

}
