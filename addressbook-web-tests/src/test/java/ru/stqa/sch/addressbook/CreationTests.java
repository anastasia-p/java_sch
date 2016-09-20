package ru.stqa.sch.addressbook;

import org.testng.annotations.Test;
import org.openqa.selenium.*;

public class CreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("test1", "header1", "footer1"));
        submitGroupCreation();
        returnToGroupPage();
    }

    @Test
    public void testContactCreation() {
        gotoContactPage();
        fillContactForm(new ContactData("firstName2", "lastName2", "address2", "123123", "test2@test.ru"));
        subvitContactCreation();
        returnToHomePage();
    }

}
