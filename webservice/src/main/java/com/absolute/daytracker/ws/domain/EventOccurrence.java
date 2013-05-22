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

@Entity
@XmlRootElement
public class EventOccurrence {
    private Long id;
    private Long eventId;
    private DateTime from;
    private DateTime to;

    public EventOccurrence() {
        // no-arg constructor
    }

    public EventOccurrence(Long eventId, DateTime from, DateTime to) {
        this.eventId = eventId;
        this.from = from;
        this.to = to;
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
    public DateTime getFrom() {
        return from;
    }

    public void setFrom(DateTime from) {
        this.from = from;
    }

    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    @XmlJavaTypeAdapter(value = DateTimeXmlAdapter.class)
    public DateTime getTo() {
        return to;
    }

    public void setTo(DateTime to) {
        this.to = to;
    }
}
