package ru.stqa.sch.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.sch.addressbook.model.ContactData;
import ru.stqa.sch.addressbook.model.GroupData;

public class ModificationTests extends TestBase{

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().checkGroup(new GroupData("test1", null, null));
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", "header2", "footer2"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }

    @Test
    public void testContactModification() {
        app.getGroupHelper().checkGroup(new GroupData("test1", null, null));
        app.getContactHelper().checkContact(new ContactData("firstName2", "lastName2", "address2",
                "123123", "test2@test.ru", "test1"), true);
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("firstName3", "lastName3", "address3", "234234",
                "test3@test.ru", null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}
