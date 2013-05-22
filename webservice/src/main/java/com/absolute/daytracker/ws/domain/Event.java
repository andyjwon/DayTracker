package com.absolute.daytracker.ws.domain;

import java.util.List;

import org.joda.time.DateTime;

import com.absolute.daytracker.ws.types.Privacy;
import com.absolute.daytracker.ws.types.Repetition;
import com.google.common.base.Objects;

public class Event {
    private Long id;
    private String title;
    private String description;
    private User owner;
    private Boolean allDay;
    private Boolean busy;
    private Location location;
    private Privacy privacy;
    private Repetition repetition;
    private DateTime repetitionEndDate;
    private List<Email> attendees;
    private List<Reminder> reminders;
    private List<EventOccurrence> occurrences;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

    public Boolean getBusy() {
        return busy;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    public Repetition getRepetition() {
        return repetition;
    }

    public void setRepetition(Repetition repetition) {
        this.repetition = repetition;
    }

    public DateTime getRepetitionEndDate() {
        return repetitionEndDate;
    }

    public void setRepetitionEndDate(DateTime repetitionEndDate) {
        this.repetitionEndDate = repetitionEndDate;
    }

    public List<Email> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Email> attendees) {
        this.attendees = attendees;
    }

    public boolean addAttendee(Email attendee) {
        return attendees.contains(attendee) ? false : attendees.add(attendee);
    }

    public List<Reminder> getReminders() {
        return reminders;
    }

    public void setReminders(List<Reminder> reminders) {
        this.reminders = reminders;
    }

    public boolean addReminder(Reminder reminder) {
        return reminders.contains(reminder) ? false : reminders.add(reminder);
    }

    public List<EventOccurrence> getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(List<EventOccurrence> occurrences) {
        this.occurrences = occurrences;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Event) {
            return id == Event.class.cast(o).getId();
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
                .add("title", this.title)
                .add("description", this.description)
                .add("owner", this.owner)
                .add("allDay", this.allDay)
                .add("busy", this.busy)
                .add("location", this.location)
                .add("privacy", this.privacy)
                .add("repetition", this.repetition)
                .add("repetitionEndDate", this.repetitionEndDate)
                .add("attendees", this.attendees)
                .add("reminders", this.reminders)
                .add("occurrences", this.occurrences)
                .toString();
    }

}
