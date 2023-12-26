package com.satwa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.satwa.utils.EventUtil;

public class PimPage extends EventUtil{

	private WebDriver driver;

	private static ThreadLocal<PimPage> threadLocal = new ThreadLocal<>();

	public static void set(PimPage pimPage) {
		threadLocal.set(pimPage);
	}

	public static PimPage get() {
		return threadLocal.get();
	}

	public PimPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//a[normalize-space()='Add Employee']")
	private WebElement btnAddEmployee;

	@FindBy(xpath ="//input[@placeholder='First Name']")
	private WebElement txtEmpFirstName;

	@FindBy(xpath ="//input[@placeholder='Middle Name']")
	private WebElement txtEmpMiddleName;

	@FindBy(xpath ="//input[@placeholder='Last Name']")
	private WebElement txtEmpLastName;

	@FindBy(xpath ="//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
	private WebElement rdBtnCreateLogin;

	@FindBy(xpath ="//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/form[@class='oxd-form']/div[@class='orangehrm-employee-container']/div[@class='orangehrm-employee-form']/div[@class='oxd-form-row']/div[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement txtUserName;

	@FindBy(xpath ="//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
	private WebElement btnPasswd;

	@FindBy(xpath ="//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
	private WebElement btnCnfrmPasswd;

	@FindBy(xpath ="//button[normalize-space()='Save']")
	private WebElement btnSave;

	public boolean isAddEmployeeMenuDisplayed() {
		return checkElementExists(btnAddEmployee);
	}

	public void clickOnAddEmp() {
		clickElement(btnAddEmployee);
	}

	public void enterEmpDetails(String empFirstName, String empMiddleName, String empLastName,String empUserName, String empPasswd,String empCnfrmPasswd) {
		enterValue(txtEmpFirstName,empFirstName );
		enterValue(txtEmpMiddleName,empMiddleName );
		enterValue(txtEmpLastName,empLastName );
		clickElement(rdBtnCreateLogin);
		enterValue(txtUserName,empUserName );
		enterValue(btnPasswd,empPasswd );
		enterValue(btnCnfrmPasswd,empCnfrmPasswd);
	}

	public void clickOnSave() {
		clickElement(btnSave);
	}
}
