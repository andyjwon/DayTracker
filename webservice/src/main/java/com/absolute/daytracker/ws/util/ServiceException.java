package com.absolute.daytracker.ws.util;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@SuppressWarnings("serial")
public class ServiceException extends WebApplicationException {

    public ServiceException(int status, String message) {
        super(Response.status(status)
                .header("Content-type", "text/plain")
                .entity(status + " " + message)
                .build());
    }

    public ServiceException(Response.Status status, String message) {
        this(status.getStatusCode(), message);
    }
}
