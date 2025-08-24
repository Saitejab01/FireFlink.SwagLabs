package swagLabs.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer{
	int count = 0;
	int recount = 2;
	@Override
	public boolean retry(ITestResult result) {
		while (count<recount) {
			count++;
			return true;
		}
		return false;
	}

}
