package com.onlinestore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.onlinestore.base.BaseClass;
import com.onlinestore.pages.IndexPage;

public class IndexPageTest extends BaseClass {
	private IndexPage indexPage;
	
	@Test(groups = "Smoke")
	public void verifyLogo()  {
		indexPage= new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		String actTitle = indexPage.getOnlineStoreTitle();
		Assert.assertEquals(actTitle, "Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
	}
}
