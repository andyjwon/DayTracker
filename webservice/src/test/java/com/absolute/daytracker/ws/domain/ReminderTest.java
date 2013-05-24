package com.absolute.daytracker.ws.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.joda.time.DateTime;
import org.junit.Test;

import com.absolute.daytracker.ws.types.Notification;
import com.absolute.daytracker.ws.types.Repetition;

public class ReminderTest {

    @Test
    public void fieldsSetByConstructorCanBeRead() {
        DateTime dateTime = new DateTime(2013, 5, 31, 10, 30, 0);
        Reminder r = new Reminder(dateTime, Notification.POPUP);
        assertThat(r.getDateTime(), is(dateTime));
        assertThat(r.getNotification(), is (Notification.POPUP));
    }

    @Test
    public void fieldsSetBySetterCanBeRead() {
        DateTime dateTime = new DateTime(2013, 1, 31, 10, 30, 0);
        Reminder r = new Reminder(null, null);
        r.setDateTime(dateTime);
        r.setNotification(Notification.EMAIL);

        assertThat(r.getDateTime(), is(dateTime));
        assertThat(r.getNotification(), is(Notification.EMAIL));
    }

    @Test
    public void toStringProducesExpectedString() {
        String expected1;
        String expected2;

        Reminder r1 = new Reminder(new DateTime(2013, 5, 31, 10, 30, 0), Notification.EMAIL);
        expected1 = "Reminder{dateTime=2013-05-31T10:30:00.000-07:00, notification=EMAIL}";

        Reminder r2 = new Reminder(null, null);
        r2.setDateTime(new DateTime(2013, 7, 4, 12, 00, 0));
        r2.setNotification(Notification.POPUP);
        expected2 = "Reminder{dateTime=2013-07-04T12:00:00.000-07:00, notification=POPUP}";

        assertThat(r1.toString(), is(expected1));
        assertThat(r2.toString(), is(expected2));
    }

    @Test
    public void equalsUsesDateTimeAndNotification() {
        Reminder r1 = new Reminder(new DateTime(2013, 5, 31, 10, 30, 0), Notification.POPUP);
        Reminder r2 = new Reminder(new DateTime(2013, 5, 31, 10, 30, 0), Notification.POPUP);
        Reminder r3 = new Reminder(new DateTime(2013, 5, 31, 10, 30, 0), Notification.EMAIL);
        Reminder r4 = new Reminder(new DateTime(2013, 7, 31, 10, 30, 0), Notification.POPUP);

        assertThat(r1, equalTo(r2));
        assertThat(r1, not(equalTo(r3)));
        assertThat(r2, not(equalTo(r3)));
        assertThat(r1, not(equalTo(r4)));
        assertThat(r2, not(equalTo(r4)));
        assertThat(r3, not(equalTo(r4)));
    }

}
