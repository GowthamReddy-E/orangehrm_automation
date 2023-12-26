package com.satwa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.satwa.pages.Configuration;
import com.satwa.pages.HomePage;
import com.satwa.pages.LoginPage;
import com.satwa.pages.PimPage;
import com.satwa.utils.GlobalVariables;
import com.satwa.utils.ReporterUtil;
import com.satwa.utils.WaitUtils;

public class CreateEmployee extends Configuration {

	@Test
	public void AddEmployee01_AddEmployeeWithUsernameAndPassword() {		
		if (LoginPage.get().isLoginPageDisplayed()) {
			ReporterUtil.get().writeLog(Status.PASS	,"Login page is displayed on launching application","LoginPage");
		} else {
			ReporterUtil.get().writeLog(Status.FAIL	,"Login page is NOT displayed on launching application","Launch Application");
			Assert.fail("Login page is not displayed on launching the application");
		}
		LoginPage.get().login(GlobalVariables.envData.get("username"), GlobalVariables.envData.get("passWord"));
		if (HomePage.get().isPimMenuDisplayed()) {
			ReporterUtil.get().writeLog(Status.PASS	,"Home page PIM Menu is displayed","HomePage Menu Options 1");
			HomePage.get().clickOnPimMenu();
		} else {
			ReporterUtil.get().writeLog(Status.FAIL	,"Home page PIM Menu is NOT displayed ","Trying to Click On Arrow & Click on PIM Menu");
			HomePage.get().clickOnArrowAndPimButton();
			if (HomePage.get().isPimMenuDisplayed()) {
				ReporterUtil.get().writeLog(Status.PASS	,"Now Home page PIM Menu is displayed","HomePage Menu Options 2");
			}else {
				ReporterUtil.get().writeLog(Status.FAIL	,"Home page PIM Menu is NOT displayed","HomePage Menu Options 3");
				Assert.fail("Home page PIM Menu is NOT displayed ");
			}
		}
		if (PimPage.get().isAddEmployeeMenuDisplayed()) {
			PimPage.get().clickOnAddEmp();
			ReporterUtil.get().writeLog(Status.PASS	,"Pim page Add Employee Menu is displayed","PIM Page AddEmployee Menu");
			WaitUtils.constantWait(1000);			
		} else {
			ReporterUtil.get().writeLog(Status.FAIL	,"Pim page Add Employee Menu is displayed","PIM Page AddEmployee Menu Dosnt Show");
			Assert.fail("Pim page Add Employee Menu is NOT displayed ");
		}
		WaitUtils.constantWait(1000);			
		PimPage.get().enterEmpDetails(GlobalVariables.get().empData.get("EMPFIRSTNAME"),GlobalVariables.get(). empData.get("EMPMIDDLENAME"),GlobalVariables.get(). empData.get("EMPLASTNAME"), GlobalVariables.get().empData.get("USERNAME"), GlobalVariables.get().empData.get("PASSWORD"),GlobalVariables.get(). empData.get("CONFIRMPASSWORD"));
		WaitUtils.constantWait(1000);			
		PimPage.get().clickOnSave();
		ReporterUtil.get().writeLog(Status.PASS	,"Employee Added SuccesssFully");
	}



}
