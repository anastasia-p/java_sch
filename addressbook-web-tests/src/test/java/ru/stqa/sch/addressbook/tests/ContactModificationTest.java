package ru.stqa.sch.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.sch.addressbook.model.ContactData;
import ru.stqa.sch.addressbook.model.Contacts;
import ru.stqa.sch.addressbook.model.GroupData;
import ru.stqa.sch.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactModificationTest extends TestBase{

    @Test
    public void testContactModification() {
        app.contact().checkContact(new ContactData()
                .withFirstname("firstName2").withLastname("lastName2").withAddress("address2")
                .withMobilePhone("123123").withEmail("test2@test.ru"), true);
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("firstName2").withLastname("lastName2")
                .withAddress("address2").withMobilePhone("123123").withEmail("test2@test.ru");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }

}
