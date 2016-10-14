package ru.stqa.sch.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.sch.addressbook.model.ContactData;
import ru.stqa.sch.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase{

    public NavigationHelper navigationHelper;

    public ContactHelper(WebDriver wd) {
        super (wd);
    }

    public void subvitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());

     }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void create(ContactData contact, boolean creation) {
        navigationHelper = new NavigationHelper(wd);
        navigationHelper.contactPage();
        fillContactForm(contact, creation);
        subvitContactCreation();
    }

    public void modify(ContactData contact) {
        navigationHelper = new NavigationHelper(wd);
        selectContactById(contact.getId());
        initContactModification();
        fillContactForm(contact, false);
        submitContactModification();
        navigationHelper.homePage();
    }
    public void delete(ContactData deletedContact) {
        navigationHelper = new NavigationHelper(wd);
        selectContactById(deletedContact.getId());
        deleteSelectedContact();
        alert();
        navigationHelper.homePage();
    }

    public boolean isThereAContact() {
        return isElementPresence(By.name("selected[]"));
    }

    public void checkContact(ContactData contact, boolean creation) {
        navigationHelper = new NavigationHelper(wd);
        navigationHelper.homePage();
        if (! isThereAContact()) {
            create(contact, creation);
        }
    }

    public int getContactCount() {
        return elementCount(By.name("selected[]"));
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//tr[@name='entry']"));
        for (WebElement element : elements) {
            String firstName = element.findElement(By.xpath("//td[3]")).getText();
            String lastName = element.findElement(By.xpath("//td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName));
        }
        return contacts;
    }
}
