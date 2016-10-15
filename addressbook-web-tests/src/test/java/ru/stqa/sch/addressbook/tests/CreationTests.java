package ru.stqa.sch.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.sch.addressbook.model.ContactData;
import ru.stqa.sch.addressbook.model.Contacts;
import ru.stqa.sch.addressbook.model.GroupData;
import ru.stqa.sch.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class CreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test1");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.goTo().contactPage();
    ContactData contact = new ContactData()
            .withFirstname("firstName2").withLastname("lastName2").withAddress("address2")
            .withMobilePhone("123123").withEmail("test2@test.ru");
    app.contact().create(contact, true);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
