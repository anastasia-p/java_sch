package ru.stqa.sch.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.sch.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactFullInfoTest extends TestBase {

  @Test
  public void testFullInfo() {
    app.contact().checkContact(new ContactData()
            .withFirstname("firstName2").withLastname("lastName2").withAddress("address2")
            .withHomePhone("111").withMobilePhone("222").withWorkPhone("333")
            .withEmail("test2@test.ru").withEmail2("test @   test").withEmail3("@"), true);
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    String contactInfoFromFullForm = app.contact().infoFromFullForm(contact);

    assertThat(mergeData(contact), equalTo(cleaned(contactInfoFromFullForm)));
  }

  private String mergeData(ContactData contact) {
    return Arrays.asList(contact.getFirstname(), contact.getLastname(),
            contact.getAddress(), contact.getAllPhones(), contact.getAllEmails())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactFullInfoTest::cleaned)
            .collect(Collectors.joining());
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replace("M:", "").replace("H:", "").replace("W:", "").replaceAll("\\([^)]+\\)", "");
  }
}
