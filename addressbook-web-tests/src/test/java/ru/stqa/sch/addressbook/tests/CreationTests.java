package ru.stqa.sch.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.sch.addressbook.model.ContactData;
import ru.stqa.sch.addressbook.model.GroupData;

public class CreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("test1", "header1", "footer1"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

    @Test
    public void testContactCreation() {
        app.gotoContactPage();
        app.fillContactForm(new ContactData("firstName2", "lastName2", "address2", "123123", "test2@test.ru"));
        app.subvitContactCreation();
        app.returnToHomePage();
    }

}
