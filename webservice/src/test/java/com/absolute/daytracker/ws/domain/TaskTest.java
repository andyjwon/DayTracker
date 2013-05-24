package com.absolute.daytracker.ws.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.joda.time.DateTime;
import org.junit.Test;

import com.absolute.daytracker.ws.types.Repetition;

public class TaskTest {

    @Test
    public void fieldsSetByFullConstructorCanBeRead() {
        DateTime date = new DateTime(2013, 5, 31, 10, 30, 0);
        DateTime deadline = new DateTime(2013, 6, 1, 10, 30, 0);
        Task t = new Task(null, 1, date, deadline, 0, false, Repetition.NONE, null, 1);

        assertNull(t.getId());
        assertThat(t.getPriority(), is(1));
        assertThat(t.getDate(), is(date));
        assertThat(t.getDeadline(), is(deadline));
        assertThat(t.getQuantityCompleted(), is(0));
        assertThat(t.getCompleted(), is(false));
        assertThat(t.getRepetition(), is(Repetition.NONE));
        assertNull(t.getRepetitionEndDate());
        assertThat(t.getQuantity(), is(1));
    }

    @Test
    public void fieldsSetByPartialConstructorCanBeRead() {
        DateTime date = new DateTime(2013, 5, 31, 10, 30, 0);
        DateTime deadline = new DateTime(2013, 6, 1, 10, 30, 0);
        Task t = new Task(null, 1, date, deadline, Repetition.NONE, null, 1);

        assertNull(t.getId());
        assertThat(t.getPriority(), is(1));
        assertThat(t.getDate(), is(date));
        assertThat(t.getDeadline(), is(deadline));
        assertThat(t.getQuantityCompleted(), is(0));
        assertThat(t.getCompleted(), is(false));
        assertThat(t.getRepetition(), is(Repetition.NONE));
        assertNull(t.getRepetitionEndDate());
        assertThat(t.getQuantity(), is(1));
    }

    @Test
    public void fieldsSetByEmptyConstructorAreNull() {
        Task t = new Task();
        assertNull(t.getId());
        assertNull(t.getPriority());
        assertNull(t.getDate());
        assertNull(t.getDeadline());
        assertNull(t.getQuantityCompleted());
        assertNull(t.getCompleted());
        assertNull(t.getRepetition());
        assertNull(t.getRepetitionEndDate());
        assertNull(t.getQuantity());
    }

    @Test
    public void fieldsSetBySettersCanBeRead() {
        DateTime date = new DateTime(2013, 5, 31, 10, 30, 0);
        DateTime deadline = new DateTime(2013, 6, 2, 10, 30, 0);
        DateTime repetitionEndDate = new DateTime(2013, 6, 1, 10, 30, 0);
        Task t = new Task();
        t.setId(1L);
        t.setPriority(2);
        t.setDate(date);
        t.setDeadline(deadline);
        t.setQuantityCompleted(1);
        t.setCompleted(false);
        t.setRepetition(Repetition.DAILY);
        t.setRepetitionEndDate(repetitionEndDate);
        t.setQuantity(2);

        assertThat(t.getId(), is(1L));
        assertThat(t.getPriority(), is(2));
        assertThat(t.getDate(), is(date));
        assertThat(t.getDeadline(), is(deadline));
        assertThat(t.getQuantityCompleted(), is(1));
        assertThat(t.getCompleted(), is(false));
        assertThat(t.getRepetition(), is(Repetition.DAILY));
        assertThat(t.getRepetitionEndDate(), is(repetitionEndDate));
        assertThat(t.getQuantity(), is(2));
    }

    @Test
    public void toStringProducesExpectedString() {
        StringBuilder sb;
        String expected1;
        String expected2;

        DateTime date = new DateTime(2013, 5, 31, 10, 30, 0);
        DateTime deadline = new DateTime(2013, 6, 1, 10, 30, 0);
        Task t1 = new Task(null, 1, date, deadline, 0, false, Repetition.NONE, null, 1);

        sb = new StringBuilder("Task{");
        sb
            .append("id=null")
            .append(", priority=1")
            .append(", date=2013-05-31T10:30:00.000-07:00")
            .append(", deadline=2013-06-01T10:30:00.000-07:00")
            .append(", quantityCompleted=0")
            .append(", completed=false")
            .append(", repetition=NONE")
            .append(", repetitionEndDate=null")
            .append(", quantity=1")
            .append("}");
        expected1 = sb.toString();

        DateTime repetitionEndDate = new DateTime(2013, 6, 1, 10, 30, 0);
        Task t2 = new Task();
        t2.setId(1L);
        t2.setPriority(2);
        t2.setDate(date);
        t2.setDeadline(deadline);
        t2.setQuantityCompleted(1);
        t2.setCompleted(false);
        t2.setRepetition(Repetition.DAILY);
        t2.setRepetitionEndDate(repetitionEndDate);
        t2.setQuantity(2);


        sb = new StringBuilder("Task{");
        sb
            .append("id=1")
            .append(", priority=2")
            .append(", date=2013-05-31T10:30:00.000-07:00")
            .append(", deadline=2013-06-01T10:30:00.000-07:00")
            .append(", quantityCompleted=1")
            .append(", completed=false")
            .append(", repetition=DAILY")
            .append(", repetitionEndDate=2013-06-01T10:30:00.000-07:00")
            .append(", quantity=2")
            .append("}");
        expected2 = sb.toString();
        assertThat(t1.toString(), is(expected1));
        assertThat(t2.toString(), is(expected2));
    }

    @Test
    public void hashCodeProducesId() {
        Task t = new Task();
        t.setId(100L);
        assertThat(t.hashCode(), is(100));
    }

    @Test
    public void equalsUsesId() {
        Task task1 = new Task();
        task1.setId(5L);
        Task task2 = new Task();
        task2.setId(5L);
        Task task3 = new Task();
        task3.setId(500L);
        assertThat(task1, equalTo(task2));
        assertThat(task2, not(equalTo(task3)));
        assertThat(task1, not(equalTo(task3)));
    }

}
