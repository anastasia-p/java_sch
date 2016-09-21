package ru.stqa.sch.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.sch.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

    public ContactHelper(FirefoxDriver wd) {
        super (wd);
    }

    public void subvitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
    }
}
