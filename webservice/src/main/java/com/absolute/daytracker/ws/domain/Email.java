package com.absolute.daytracker.ws.domain;

import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlRootElement;

@Embeddable
@XmlRootElement
public class Email {
    private String email;

    public Email() {
        // no-args constructor
    }

    public Email(String email) {
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Lob
    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Email) {
            return email.equals(Email.class.cast(o).getEmail());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return email;
    }

}
