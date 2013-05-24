package com.absolute.daytracker.ws.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.absolute.daytracker.ws.util.DateTimeXmlAdapter;
import com.google.common.base.Objects;

@Entity
@XmlRootElement
public class EventOccurrence {
    private Long id;
    private Long eventId;
    private DateTime start;
    private DateTime end;

    public EventOccurrence() {
        // no-args constructor
    }

    public EventOccurrence(Long id, Long eventId, DateTime start, DateTime end) {
        this.id = id;
        this.eventId = eventId;
        this.start = start;
        this.end = end;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlAttribute
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    @XmlJavaTypeAdapter(value = DateTimeXmlAdapter.class)
    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    @XmlJavaTypeAdapter(value = DateTimeXmlAdapter.class)
    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof EventOccurrence) {
            return id == EventOccurrence.class.cast(o).getId();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.id.intValue();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", this.id)
                .add("eventId", this.eventId)
                .add("start", this.start)
                .add("end", this.end)
                .toString();
    }
}
