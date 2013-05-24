package com.absolute.daytracker.ws.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class EmailTest {

    @Test
    public void emailSetByConstructorCanBeRead() {
        Email e = new Email("daytracker@example.com");
        assertThat(e.getEmail(), is("daytracker@example.com"));
    }

    @Test
    public void emailSetByEmptyConstructorIsNull() {
        Email e = new Email();
        assertNull(e.getEmail());
    }

    @Test
    public void emailSetBySetterCanBeRead() {
        Email e = new Email();
        e.setEmail("daytracker2@example.com");

        assertThat(e.getEmail(), is("daytracker2@example.com"));
    }

    @Test
    public void toStringProducesExpectedString() {
        String expected1;
        String expected2;

        Email e1 = new Email("daytracker@example.org");
        expected1 = "daytracker@example.org";

        Email e2 = new Email();
        e2.setEmail("daytracker@example.com");
        expected2 = "daytracker@example.com";

        assertThat(e1.toString(), is(expected1));
        assertThat(e2.toString(), is(expected2));
    }

    @Test
    public void equalsUsesEmailString() {
        Email e1 = new Email();
        e1.setEmail("daytracker@example.com");
        Email e2 = new Email();
        e2.setEmail("daytracker@example.com");
        Email e3 = new Email();
        e3.setEmail("dt@absolutetech.org");
        assertThat(e1, equalTo(e2));
        assertThat(e2, not(equalTo(e3)));
        assertThat(e1, not(equalTo(e3)));
    }

}
