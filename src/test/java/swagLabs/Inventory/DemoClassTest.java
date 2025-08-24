package swagLabs.Inventory;

import org.testng.Assert;
import org.testng.annotations.Test;

import swagLabs.GenericUtilities.BaseClass;

public class DemoClassTest extends BaseClass{
	int a=0;
	@Test(retryAnalyzer = swagLabs.GenericUtilities.RetryAnalyserImplementation.class)
	public void demo() {
		System.out.println(a++);
		Assert.fail();
	}
}
