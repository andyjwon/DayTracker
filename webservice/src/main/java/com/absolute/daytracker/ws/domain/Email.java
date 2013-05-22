package com.absolute.daytracker.ws.domain;

import com.google.common.base.Objects;

public class Email {
    private String email;

    public Email(String email) {
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Email) {
            return email.equals(Email.class.cast(o).toString());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("email", this.email)
                .toString();
    }

}
