package com.absolute.daytracker.ws.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.joda.time.DateTime;
import org.junit.Test;

public class EventOccurrenceTest {

    @Test
    public void fieldsSetByFullConstructorCanBeRead() {
        DateTime start = new DateTime(2013, 5, 31, 10, 30, 0);
        DateTime end = new DateTime(2013, 6, 1, 10, 30, 0);
        EventOccurrence t = new EventOccurrence(1L, 100000L, start, end);

        assertThat(t.getId(), is(1L));
        assertThat(t.getEventId(), is(100000L));
        assertThat(t.getStart(), is(start));
        assertThat(t.getEnd(), is(end));
    }

    @Test
    public void fieldsSetByEmptyConstructorAreNull() {
        EventOccurrence t = new EventOccurrence();
        assertNull(t.getId());
        assertNull(t.getEventId());
        assertNull(t.getStart());
        assertNull(t.getEnd());
    }

    @Test
    public void fieldsSetBySettersCanBeRead() {
        DateTime start = new DateTime(2013, 5, 31, 10, 30, 0);
        DateTime end = new DateTime(2013, 6, 1, 10, 30, 0);
        EventOccurrence t = new EventOccurrence();
        t.setId(2L);
        t.setEventId(20000L);
        t.setStart(start);
        t.setEnd(end);

        assertThat(t.getId(), is(2L));
        assertThat(t.getEventId(), is(20000L));
        assertThat(t.getStart(), is(start));
        assertThat(t.getEnd(), is(end));
    }

    @Test
    public void toStringProducesExpectedString() {
        StringBuilder sb;
        String expected1;
        String expected2;

        DateTime start = new DateTime(2013, 5, 31, 00, 00, 0);
        DateTime end = new DateTime(2013, 6, 30, 23, 59, 59);
        EventOccurrence e1 = new EventOccurrence(1L, 1L, start, end);

        sb = new StringBuilder("EventOccurrence{");
        sb
            .append("id=1")
            .append(", eventId=1")
            .append(", start=2013-05-31T00:00:00.000-07:00")
            .append(", end=2013-06-30T23:59:59.000-07:00")
            .append("}");
        expected1 = sb.toString();

        EventOccurrence e2 = new EventOccurrence();
        e2.setId(2L);
        e2.setEventId(1L);
        e2.setStart(new DateTime(2013, 7, 1, 00, 00, 0));
        e2.setEnd(new DateTime(2013, 8, 31, 11, 59, 0));

        sb = new StringBuilder("EventOccurrence{");
        sb
            .append("id=2")
            .append(", eventId=1")
            .append(", start=2013-07-01T00:00:00.000-07:00")
            .append(", end=2013-08-31T11:59:00.000-07:00")
            .append("}");
        expected2 = sb.toString();

        assertThat(e1.toString(), is(expected1));
        assertThat(e2.toString(), is(expected2));
    }

    @Test
    public void hashCodeProducesId() {
        EventOccurrence t = new EventOccurrence();
        t.setId(100L);
        assertThat(t.hashCode(), is(100));
    }

    @Test
    public void equalsOnlyUsesId() {
        DateTime start = new DateTime(2013, 5, 31, 10, 30, 0);
        DateTime end = new DateTime(2013, 6, 1, 10, 30, 0);

        EventOccurrence e1 = new EventOccurrence();
        e1.setId(5L);
        EventOccurrence e2 = new EventOccurrence();
        e2.setId(5L);
        EventOccurrence e3 = new EventOccurrence(5L, 100000L, start, end);
        EventOccurrence e4 = new EventOccurrence(4L, 100000L, start, end);

        assertThat(e1, equalTo(e2));
        assertThat(e1, equalTo(e3));
        assertThat(e2, equalTo(e3));
        assertThat(e3, not(equalTo(e4)));
    }

}
