package ru.stqa.sch.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.sch.addressbook.appmanager.HelperBase;
import ru.stqa.sch.addressbook.model.ContactData;
import ru.stqa.sch.addressbook.model.GroupData;

public class DeletionTests extends TestBase{

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().checkGroup(new GroupData("test1", null, null));
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }


    @Test
    public void testContactDeletion() {
        app.getGroupHelper().checkGroup(new GroupData("test1", null, null));
        app.getContactHelper().checkContact(new ContactData("firstName2", "lastName2", "address2",
                "123123", "test2@test.ru", "test1"), true);
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getHelperBase().alert();
        app.getNavigationHelper().gotoHomePage();
    }

}
