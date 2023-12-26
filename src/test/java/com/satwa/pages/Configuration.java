package com.satwa.pages;

import java.lang.reflect.Method;

import org.openqa.selenium.Cookie;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.satwa.utils.GenericUtil;
import com.satwa.utils.DataUtil;
import com.satwa.utils.Driver;
import com.satwa.utils.EventUtil;
import com.satwa.utils.GlobalVariables;
import com.satwa.utils.ReporterUtil;

public class Configuration extends GlobalVariables{

	@Parameters("env")
	@BeforeSuite
	public void setUpExecution(@Optional String env) {
		env = (env==null)?"qa":env.toLowerCase();
		EventUtil.killProcesses();
		switch (env) {
		case "qa":
			envData = (new DataUtil()).getPropertyData(CONFIG_FOLDER_PATH+"\\EnvInfo_QA.properties");
			break;
		case "dev":
			envData = (new DataUtil()).getPropertyData(CONFIG_FOLDER_PATH+"\\EnvInfo_Dev.properties");
			break;
		default:
			envData = (new DataUtil()).getPropertyData(CONFIG_FOLDER_PATH+"\\EnvInfo_stage.properties");
			break;
		}

		GenericUtil gen=new GenericUtil();
		//		gen.deleteAllFiles(GlobalVariables.get().ALLURE_REPORT_FOLDER_PATH);
		gen.deleteAllFiles(GlobalVariables.get().REPORT_FOLDER_PATH);
		gen.deleteAllFiles(GlobalVariables.get().SCREENSHOT_FOLDER_PATH);


	}

	@BeforeTest
	public void initializeReport(ITestContext context) {
		ReporterUtil.set(new ReporterUtil());
		String suiteName = context.getCurrentXmlTest().getSuite().getName();
		String testName = context.getCurrentXmlTest().getName();
		ReporterUtil.get().initializeReport(suiteName+"_"+ testName);
	}

	@AfterTest
	public void finalizeExecution() {
		ReporterUtil.get().finalizeReport();
	}


	@Parameters("browser")
	@BeforeMethod
	public void intializeTest(@Optional String browser, Method method, ITestContext context) {
		Driver driverUtil = new Driver();
		driverUtil.initializeDriver(browser, envData.get("loginPage"));
		Driver.set(driverUtil.getWebDriver());
		GlobalVariables.set(new GlobalVariables());
		GlobalVariables.get().tcName = method.getName();	
		ReporterUtil.get().addTest(GlobalVariables.get().tcName);
	}

	@BeforeMethod(groups = "companies")
	public void setUpPages() {
		DataUtil.set(new DataUtil());
		LoginPage.set(new LoginPage(Driver.get()));
		HomePage.set(new HomePage(Driver.get()));
		PimPage.set(new PimPage(Driver.get()));
		String tcId = GlobalVariables.get().tcName.split("_")[0];	
		//		GlobalVariables.get().tcData = DataUtil.get().getTCData(DATA_FILES_PATH+"CompanyData.xlsx", tcId.replaceAll("[0-9]{1,}", ""), tcId);
		GlobalVariables.get().empData = DataUtil.get().getTCData(DATA_FILES_PATH+"AddEmployee.xlsx", tcId.replaceAll("[0-9]{1,}", ""), tcId);

	}

	@AfterMethod
	public void afterMethod() {
		Driver.get().quit();

	}


}
