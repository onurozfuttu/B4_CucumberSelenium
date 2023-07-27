package com.krafttech.pages;

import com.krafttech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserProfilePage extends BasePage{
    @FindBy(xpath = "//ul[@role='tablist']//li")
    public List<WebElement> subMenu;
    public void navigateToOverviewMenu(String tab){
        WebElement tabElement= Driver.get().findElement(By.xpath("//li/button[.='"+tab+"']"));
        tabElement.click();
    }


}
