package ru.stqa.sch.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.sch.addressbook.model.ContactData;
import ru.stqa.sch.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class CreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("test1", null, null);
        app.getGroupHelper().createGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);

        int max = 0;
        for (GroupData q : after) {
            if (q.getId() > max) {
                max = q.getId();
            }
        }
        group.setId(max);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoContactPage();
        ContactData contact = new ContactData("firstName2", "lastName2", "address2",
                "123123", "test2@test.ru", "test1");
        app.getContactHelper().createContact(contact, true);
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

      int max = 0;
      for (ContactData q : after) {
        if (q.getId() > max) {
          max = q.getId();
        }
      }
      contact.setId(max);
      before.add(contact);
      Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
