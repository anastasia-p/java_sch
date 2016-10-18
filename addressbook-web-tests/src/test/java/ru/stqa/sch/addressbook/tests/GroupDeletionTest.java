package ru.stqa.sch.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.sch.addressbook.model.GroupData;
import ru.stqa.sch.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTest extends TestBase{

    @Test
    public void testGroupDeletion() {
        app.group().checkGroup(new GroupData().withName("test1"));
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size() - 1));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.without(deletedGroup)));
    }
}
