package com.absolute.daytracker.ws.domain;

import org.joda.time.DateTime;

import com.absolute.daytracker.ws.types.Repetition;

public class Task {
    private Long id;
    private Integer priority;
    private DateTime date;
    private DateTime deadline;
    private Boolean completed;
    private Repetition repetition;
    private DateTime repetitionEndDate;
    private Integer quantity;

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

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public DateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(DateTime deadline) {
        this.deadline = deadline;
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

}
