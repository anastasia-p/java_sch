package ru.stqa.sch.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.sch.addressbook.model.ContactData;
import ru.stqa.sch.addressbook.model.GroupData;

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

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresence(By.name("new_group")));
        }
     }

    public void selectContact() {
        click(By.name("selected[]"));
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

    public void createContact(ContactData contact, boolean creation) {
        navigationHelper = new NavigationHelper(wd);
        navigationHelper.gotoContactPage();
        fillContactForm(contact, creation);
        subvitContactCreation();
    }

    public boolean isThereAContact() {
        return isElementPresence(By.name("selected[]"));
    }

    public void checkContact(ContactData contact, boolean creation) {
        navigationHelper = new NavigationHelper(wd);
        navigationHelper.gotoHomePage();
        if (! isThereAContact()) {
            createContact(contact, creation);
        }
    }

    public int getContactCount() {
        return elementCount(By.name("selected[]"));
    }
}
