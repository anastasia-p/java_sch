package ru.stqa.sch.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.sch.addressbook.model.ContactData;
import ru.stqa.sch.addressbook.model.GroupData;

public class CreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().fillContactForm(new ContactData("firstName2", "lastName2", "address2", "123123", "test2@test.ru"));
        app.getContactHelper().subvitContactCreation();
        app.getNavigationHelper().gotoHomePage();
    }

}
