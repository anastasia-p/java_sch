package ru.stqa.sch.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(FirefoxDriver wd) {
        super (wd);
    }

    public void gotoContactPage() {
        click(By.linkText("add new"));
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void gotoHomePage() {
        click(By.linkText("home"));
    }
}