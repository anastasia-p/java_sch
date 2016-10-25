package ru.stqa.sch.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.sch.addressbook.model.ContactData;
import ru.stqa.sch.addressbook.model.Contacts;
import ru.stqa.sch.addressbook.model.GroupData;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddToGroupTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.contact().checkContact(new ContactData()
                    .withFirstname("firstName1").withLastname("lastName1")
                    .withAddress("address1").withHomePhone("h1").withMobilePhone("m1").withWorkPhone("w1")
                    .withEmail("email111@test.ru").withEmail2("email222@test.ru").withEmail3("email1333@test.ru"), true);
        }

        if (app.db().groups().size() == 0) {
            app.group().checkGroup(new GroupData().withName("test1").withHeader("header1").withFooter("footer1"));
        }
    }

    @Test
    public void testContactAddToGroup() {
        Contacts before = app.db().contacts();
        app.goTo().homePage();
        ContactData addedContact = before.iterator().next();
        //app.contact().addToGroup(addedContact);
        Contacts after = app.db().contacts();
        System.out.println("RESULT -----> " + before);

    }

}
