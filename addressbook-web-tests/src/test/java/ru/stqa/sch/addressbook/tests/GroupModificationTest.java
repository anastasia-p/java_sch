package ru.stqa.sch.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.sch.addressbook.model.GroupData;
import ru.stqa.sch.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends TestBase{

    @Test
    public void testGroupModification() {
        app.group().checkGroup(new GroupData().withName("test1"));
        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("test2").withHeader("header2").withFooter("footer2");
        app.group().modify(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }
}