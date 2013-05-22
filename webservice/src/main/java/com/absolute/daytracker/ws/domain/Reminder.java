package com.absolute.daytracker.ws.domain;

import org.joda.time.DateTime;

import com.absolute.daytracker.ws.types.Notification;

public class Reminder {
    private DateTime dateTime;
    private Notification notification;

    public Reminder(DateTime dateTime, Notification notification) {
        this.dateTime = dateTime;
        this.notification = notification;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Notification getNotification() {
        return notification;
    }
}
