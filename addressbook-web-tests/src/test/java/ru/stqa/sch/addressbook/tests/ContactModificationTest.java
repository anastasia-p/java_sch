package ru.stqa.sch.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.sch.addressbook.model.ContactData;
import ru.stqa.sch.addressbook.model.Contacts;
import ru.stqa.sch.addressbook.model.GroupData;
import ru.stqa.sch.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactModificationTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.contact().checkContact(new ContactData()
                    .withFirstname("firstName2").withLastname("lastName2").withAddress("address2")
                    .withMobilePhone("123123").withEmail("test2@test.ru"), true);
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();
        app.goTo().homePage();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("firstName999").withLastname("lastName999")
                .withAddress("address999").withHomePhone("h999").withMobilePhone("m999").withWorkPhone("w999")
                .withEmail("email111@test.ru").withEmail2("email222@test.ru").withEmail3("email1333@test.ru");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }

}
