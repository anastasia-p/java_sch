package ru.stqa.sch.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.sch.addressbook.model.ContactData;
import ru.stqa.sch.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class DeletionTests extends TestBase{

    @Test
    public void testGroupDeletion() {
        //app.goTo().groupPage();
        app.group().checkGroup(new GroupData().withName("test1"));
        Set<GroupData> before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedGroup);
        Assert.assertEquals(before, after);
    }


    @Test
    public void testContactDeletion() {
        app.contact().checkContact(new ContactData()
                .withFirstname("firstName2").withLastname("lastName2").withAddress("address2")
                .withMobile("123123").withEmail("test2@test.ru"), true);
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        Assert.assertEquals(before, after);
    }



}
