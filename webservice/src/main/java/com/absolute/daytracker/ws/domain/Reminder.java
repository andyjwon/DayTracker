package com.absolute.daytracker.ws.domain;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.absolute.daytracker.ws.types.Notification;
import com.absolute.daytracker.ws.util.DateTimeXmlAdapter;
import com.google.common.base.Objects;

@Embeddable
@XmlRootElement
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

    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    @XmlJavaTypeAdapter(value=DateTimeXmlAdapter.class)
    public DateTime getDateTime() {
        return dateTime;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Notification getNotification() {
        return notification;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Reminder) {
            return dateTime.equals(Reminder.class.cast(o).getDateTime())
                    && notification.equals(Reminder.class.cast(o).getNotification());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("dateTime", this.dateTime)
                .add("notification", this.notification)
                .toString();
    }
}
