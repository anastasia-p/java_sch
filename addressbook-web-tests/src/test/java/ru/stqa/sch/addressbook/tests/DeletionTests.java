package ru.stqa.sch.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.sch.addressbook.model.ContactData;
import ru.stqa.sch.addressbook.model.GroupData;

import java.util.List;

public class DeletionTests extends TestBase{

    @Test
    public void testGroupDeletion() {
        //app.goTo().groupPage();
        app.group().checkGroup(new GroupData().withName("test1"));
        List<GroupData> before = app.group().list();
        app.group().selectGroup(before.size() - 1);
        app.group().deleteSelectedGroups();
        app.group().returnToGroupPage();
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }


    @Test
    public void testContactDeletion() {
        app.group().checkGroup(new GroupData().withName("test1"));
        app.getContactHelper().checkContact(new ContactData()
                .withFirstname("firstName2").withLastname("lastName2").withAddress("address2")
                .withMobile("123123").withEmail("test2@test.ru").withGroup("test2"), true);
        app.goTo().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContact();
        app.getHelperBase().alert();
        app.goTo().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }

}
