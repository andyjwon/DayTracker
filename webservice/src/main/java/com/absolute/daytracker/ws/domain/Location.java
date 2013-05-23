package com.absolute.daytracker.ws.domain;

import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;

@Embeddable
@XmlRootElement
public class Location {
    private String location;

    public Location(String location) {
        this.location = location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Lob
    public String getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Location) {
            return location.equals(Location.class.cast(o).toString());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("location", this.location)
                .toString();
    }
}
