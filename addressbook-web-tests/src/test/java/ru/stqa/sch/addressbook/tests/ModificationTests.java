package ru.stqa.sch.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.sch.addressbook.model.ContactData;
import ru.stqa.sch.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ModificationTests extends TestBase{

    @Test
    public void testGroupModification() {
        app.group().checkGroup(new GroupData().withName("test1"));
        Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("test2").withHeader("header2").withFooter("footer2");
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }

    @Test
    public void testContactModification() {
        app.group().checkGroup(new GroupData().withName("test1"));
        app.contact().checkContact(new ContactData()
                .withFirstname("firstName2").withLastname("lastName2").withAddress("address2")
                .withMobile("123123").withEmail("test2@test.ru"), true);
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("firstName2").withLastname("lastName2")
                .withAddress("address2").withMobile("123123").withEmail("test2@test.ru");
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

      before.remove(modifiedContact);
      before.add(contact);
      Assert.assertEquals(before, after);
    }

}
