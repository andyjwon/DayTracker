package com.absolute.daytracker.ws.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.joda.time.DateTime;
import org.junit.Test;

import com.absolute.daytracker.ws.types.Repetition;

public class LocationTest {

    @Test
    public void locationSetByConstructorCanBeRead() {
        Location l = new Location("700 E. Birch St. #9783, Brea, CA 92822");
        assertThat(l.getLocation(), is("700 E. Birch St. #9783, Brea, CA 92822"));
    }

    @Test
    public void locationSetByEmptyConstructorIsNull() {
        Location l = new Location();
        assertNull(l.getLocation());
    }

    @Test
    public void locationSetBySetterCanBeRead() {
        Location l = new Location();
        l.setLocation("700 E. Birch St. #9783, Brea, CA 92822");

        assertThat(l.getLocation(), is("700 E. Birch St. #9783, Brea, CA 92822"));
    }

    @Test
    public void toStringProducesExpectedString() {
        String expected1;
        String expected2;

        Location l1 = new Location("700 E. Birch St. #9783, Brea, CA 92822");
        expected1 = "Location{location=700 E. Birch St. #9783, Brea, CA 92822}";

        Location l2 = new Location();
        l2.setLocation("1 LMU Dr., Los Angeles, CA 90045");
        expected2 = "Location{location=1 LMU Dr., Los Angeles, CA 90045}";

        assertThat(l1.toString(), is(expected1));
        assertThat(l2.toString(), is(expected2));
    }

    @Test
    public void equalsUsesLocationString() {
        Location l1 = new Location();
        l1.setLocation("700 E. Birch St. #9783, Brea, CA 92822");
        Location l2 = new Location();
        l2.setLocation("700 E. Birch St. #9783, Brea, CA 92822");
        Location l3 = new Location();
        l3.setLocation("1 LMU Dr., Los Angeles, CA 90045");
        assertThat(l1, equalTo(l2));
        assertThat(l2, not(equalTo(l3)));
        assertThat(l1, not(equalTo(l3)));
    }

}
