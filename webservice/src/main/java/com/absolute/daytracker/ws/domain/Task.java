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

import com.absolute.daytracker.ws.types.Repetition;
import com.absolute.daytracker.ws.util.DateTimeXmlAdapter;
import com.google.common.base.Objects;

@Entity
@XmlRootElement
public class Task {
    private Long id;
    private Integer priority;
    private DateTime date;
    private DateTime deadline;
    private Integer quantityCompleted;
    private Boolean completed;
    private Repetition repetition;
    private DateTime repetitionEndDate;
    private Integer quantity;

    public Task() {
        // no-arg constructor
    }

    public Task(Long id, Integer priority, DateTime date, DateTime deadline, Repetition repetition,
            DateTime repetitionEndDate, Integer quantity) {
        this(id, priority, date, deadline, 0, false, repetition, repetitionEndDate, quantity);
    }

    public Task(Long id, Integer priority, DateTime date, DateTime deadline, Integer quantityCompleted,
            Boolean completed, Repetition repetition, DateTime repetitionEndDate, Integer quantity) {
        this.id = id;
        this.priority = priority;
        this.date = date;
        this.deadline = deadline;
        this.quantityCompleted = quantityCompleted;
        this.completed = completed;
        this.repetition = repetition;
        this.repetitionEndDate = repetitionEndDate;
        this.quantity = quantity;
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    @XmlJavaTypeAdapter(value=DateTimeXmlAdapter.class)
    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    @XmlJavaTypeAdapter(value=DateTimeXmlAdapter.class)
    public DateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(DateTime deadline) {
        this.deadline = deadline;
    }

    public Integer getQuantityCompleted() {
        return quantityCompleted;
    }

    public void setQuantityCompleted(Integer quantityCompleted) {
        this.quantityCompleted = quantityCompleted;
        if (this.quantityCompleted == this.quantity) {
            setCompleted(true);
        }
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Repetition getRepetition() {
        return repetition;
    }

    public void setRepetition(Repetition repetition) {
        this.repetition = repetition;
    }

    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    @XmlJavaTypeAdapter(value=DateTimeXmlAdapter.class)
    public DateTime getRepetitionEndDate() {
        return repetitionEndDate;
    }

    public void setRepetitionEndDate(DateTime repetitionEndDate) {
        this.repetitionEndDate = repetitionEndDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Task) {
            return id == Task.class.cast(o).getId();
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
                .add("priority", this.priority)
                .add("date", this.date)
                .add("deadline", this.deadline)
                .add("quantityCompleted", this.quantityCompleted)
                .add("completed", this.completed)
                .add("repetition", this.repetition)
                .add("repetitionEndDate", this.repetitionEndDate)
                .add("quantity", this.quantity)
                .toString();
    }

}
