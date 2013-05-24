package com.absolute.daytracker.ws.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.joda.time.DateTime;
import org.junit.Test;

import com.absolute.daytracker.ws.types.Privacy;
import com.absolute.daytracker.ws.types.Repetition;

public class EventTest {

    @Test
    public void fieldsSetByFullConstructorCanBeRead() {
        DateTime repetitionEndDate = new DateTime(2013, 12, 31, 00, 00, 0);
        User owner = new User();
        owner.setId(100L);
        Location location = new Location("700 E. Birch St. #9783, Brea, CA 92822");
        Event e = new Event(1L, "Every day", "Every day is worth celebrating",
                owner, true, false, location, Privacy.DEFAULT, Repetition.DAILY,
                repetitionEndDate, null, null, null);

        assertThat(e.getId(), is(1L));
        assertThat(e.getTitle(), is("Every day"));
        assertThat(e.getDescription(), is("Every day is worth celebrating"));
        assertThat(e.getOwner(), is(owner));
        assertThat(e.getAllDay(), is(true));
        assertThat(e.getBusy(), is(false));
        assertThat(e.getLocation(), is(location));
        assertThat(e.getPrivacy(), is(Privacy.DEFAULT));
        assertThat(e.getRepetition(), is(Repetition.DAILY));
        assertThat(e.getRepetitionEndDate(), is(repetitionEndDate));
        assertNull(e.getAttendees());
        assertNull(e.getReminders());
        assertNull(e.getOccurrences());
    }

    @Test
    public void fieldsSetByEmptyConstructorAreNull() {
        Event e = new Event();

        assertNull(e.getId());
        assertNull(e.getTitle());
        assertNull(e.getDescription());
        assertNull(e.getOwner());
        assertNull(e.getAllDay());
        assertNull(e.getBusy());
        assertNull(e.getLocation());
        assertNull(e.getPrivacy());
        assertNull(e.getRepetition());
        assertNull(e.getRepetitionEndDate());
        assertNull(e.getAttendees());
        assertNull(e.getReminders());
        assertNull(e.getOccurrences());
    }

    @Test
    public void fieldsSetBySettersCanBeRead() {
        DateTime repetitionEndDate = new DateTime(2013, 12, 31, 00, 00, 0);
        User owner = new User();
        owner.setId(100L);
        Location location = new Location("700 E. Birch St. #9783, Brea, CA 92822");
        Event e = new Event();

        e.setId(1L);
        e.setTitle("Every day");
        e.setDescription("Every day is worth celebrating");
        e.setOwner(owner);
        e.setAllDay(true);
        e.setBusy(false);
        e.setLocation(location);
        e.setPrivacy(Privacy.DEFAULT);
        e.setRepetition(Repetition.DAILY);
        e.setRepetitionEndDate(repetitionEndDate);

        assertThat(e.getId(), is(1L));
        assertThat(e.getTitle(), is("Every day"));
        assertThat(e.getDescription(), is("Every day is worth celebrating"));
        assertThat(e.getOwner(), is(owner));
        assertThat(e.getAllDay(), is(true));
        assertThat(e.getBusy(), is(false));
        assertThat(e.getLocation(), is(location));
        assertThat(e.getPrivacy(), is(Privacy.DEFAULT));
        assertThat(e.getRepetition(), is(Repetition.DAILY));
        assertThat(e.getRepetitionEndDate(), is(repetitionEndDate));
        assertNull(e.getAttendees());
        assertNull(e.getReminders());
        assertNull(e.getOccurrences());
    }

    @Test
    public void toStringProducesExpectedString() {
        StringBuilder sb;
        String expected1;
        String expected2;

        DateTime repetitionEndDate = new DateTime(2013, 12, 31, 00, 00, 0);
        User owner = new User();
        owner.setId(100L);
        Location location = new Location("700 E. Birch St. #9783, Brea, CA 92822");
        Event e1 = new Event(1L, "Every day", "Every day is worth celebrating",
                owner, true, false, location, Privacy.DEFAULT, Repetition.DAILY,
                repetitionEndDate, null, null, null);

        sb = new StringBuilder("Event{");
        sb
            .append("id=1")
            .append(", title=Every day")
            .append(", description=Every day is worth celebrating")
            .append(", owner=User{id=100, email=null, active=null, roles=null}")
            .append(", allDay=true")
            .append(", busy=false")
            .append(", location=700 E. Birch St. #9783, Brea, CA 92822")
            .append(", privacy=DEFAULT")
            .append(", repetition=DAILY")
            .append(", repetitionEndDate=2013-12-31T00:00:00.000-08:00")
            .append(", attendees=null")
            .append(", reminders=null")
            .append(", occurrences=null")
            .append("}");
        expected1 = sb.toString();

        Event e2 = new Event();
        e2.setId(2L);
        e2.setTitle("Best week ever");
        e2.setDescription("Every day is worth celebrating");
        e2.setOwner(owner);
        e2.setAllDay(true);
        e2.setBusy(true);
        e2.setLocation(location);
        e2.setPrivacy(Privacy.PRIVATE);
        e2.setRepetition(Repetition.DAILY);
        e2.setRepetitionEndDate(repetitionEndDate);

        sb = new StringBuilder("Event{");
        sb
            .append("id=2")
            .append(", title=Best week ever")
            .append(", description=Every day is worth celebrating")
            .append(", owner=User{id=100, email=null, active=null, roles=null}")
            .append(", allDay=true")
            .append(", busy=true")
            .append(", location=700 E. Birch St. #9783, Brea, CA 92822")
            .append(", privacy=PRIVATE")
            .append(", repetition=DAILY")
            .append(", repetitionEndDate=2013-12-31T00:00:00.000-08:00")
            .append(", attendees=null")
            .append(", reminders=null")
            .append(", occurrences=null")
            .append("}");
        expected2 = sb.toString();

        assertThat(e1.toString(), is(expected1));
        assertThat(e2.toString(), is(expected2));
    }

    @Test
    public void hashCodeProducesId() {
        Event e = new Event();
        e.setId(100L);
        assertThat(e.hashCode(), is(100));
    }

    @Test
    public void equalsOnlyUsesId() {
        DateTime repetitionEndDate = new DateTime(2013, 12, 31, 00, 00, 0);
        User owner = new User();
        owner.setId(100L);
        Location location = new Location("700 E. Birch St. #9783, Brea, CA 92822");

        Event e1 = new Event();
        e1.setId(5L);
        Event e2 = new Event();
        e2.setId(5L);
        Event e3 = new Event(5L, "Every day", "Every day is worth celebrating",
                owner, true, false, location, Privacy.DEFAULT, Repetition.DAILY,
                repetitionEndDate, null, null, null);
        Event e4 = new Event(6L, "Every day", "Every day is worth celebrating",
                owner, true, false, location, Privacy.DEFAULT, Repetition.DAILY,
                repetitionEndDate, null, null, null);

        assertThat(e1, equalTo(e2));
        assertThat(e1, equalTo(e3));
        assertThat(e2, equalTo(e3));
        assertThat(e3, not(equalTo(e4)));
    }

}
