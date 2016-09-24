package ru.stqa.sch.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver wd) {
        super (wd);
    }

    public void gotoContactPage() {
        if (isElementPresence(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")) {
            return;
        }
        click(By.linkText("add new"));
    }

    public void gotoGroupPage() {
        if (isElementPresence(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresence(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));
    }

    public void gotoHomePage() {
        if (isElementPresence(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }
}
