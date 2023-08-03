package com.krafttech.stepDefinitions;

import com.krafttech.pages.DashboardPage;
import com.krafttech.pages.LoginPage;
import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefs {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("The user enters teacher credentials")
    public void the_user_enters_teacher_credentials() {
        loginPage.login(ConfigurationReader.get("teacherEmail"), ConfigurationReader.get("teacherPassword"));
    }

    @Then("The user should be able to login")
    public void the_user_should_be_able_to_login() {
        String actual = Driver.get().getCurrentUrl();
        String expected = "https://www.krafttechexlab.com/index";
        Assert.assertEquals(expected, actual);
    }

    @When("The user enters student credentials")
    public void the_user_enters_student_credentials() {
        loginPage.login(ConfigurationReader.get("studentEmail"), ConfigurationReader.get("studentPassword"));
    }

    @When("The user enters developer credentials")
    public void the_user_enters_developer_credentials() {
        loginPage.login(ConfigurationReader.get("developerEmail"), ConfigurationReader.get("developerPassword"));
    }

    @When("The user enters SDET credentials")
    public void the_user_enters_sdet_credentials() {
        System.out.println("I enter SDET userEmail and password and click login button");
    }

    @When("The user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String string, String string2) {
        loginPage.login(string, string2);
    }

    @Then("Validate that username is {string}")
    public void validate_that_username_is(String string) {
        String expected = string;
        String actual = loginPage.getUserAccountName();
        Assert.assertEquals(expected, actual);
    }

    @Then("Validate the warning message is {string}")
    public void validate_the_warning_message_is(String expectedMessage) {
        BrowserUtils.waitFor(1);
        String actualWarningMessage = loginPage.getWarningMessage(expectedMessage);
        Assert.assertEquals(expectedMessage,actualWarningMessage);
    }

    @When("The user enters {string} and row number {int}")
    public void the_user_enters_and_row_number(String sheetName, Integer rowNumber) {
       // ExcelUtil excelUtil = new ExcelUtil("src/test/resources/KT_B4_DDF_test.xlsx",sheetName);
       // List<Map<String, String>> dataList = excelUtil.getDataList();
       // loginPage.login(dataList.get(rowNumber).get("username"),dataList.get(rowNumber).get("password"));
        loginPage.login(loginPage.getDataList(sheetName).get(rowNumber).get("username"),
                loginPage.getDataList(sheetName).get(rowNumber).get("password"));
    }
    @Then("The user verify that account name is equal {string} {int}")
    public void the_user_verify_that_account_name_is_equal(String sheetName, Integer rowNumberForName) {
        String actualUsername = loginPage.userAccountName.getText();
        System.out.println("actualUsername = " + actualUsername);

       // Assert.assertEquals(actualUsername,dataList.get(rowNumberForName).get("name"));
        Assert.assertEquals(loginPage.getDataList(sheetName).get(rowNumberForName).get("name"), actualUsername);
    }

    @Then("The user verify that job name is equal {int} in the {string}")
    public void the_user_verify_that_job_name_is_equal_in_the(Integer rowNumberForJob, String sheetName) {
        String actualJob = dashboardPage.getProfileDetails(loginPage.getDataList(sheetName).get(rowNumberForJob).get("job"));
        Assert.assertEquals(loginPage.getDataList(sheetName).get(rowNumberForJob).get("job"),actualJob);
    }

}
