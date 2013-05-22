package com.absolute.daytracker.ws.resource;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.api.services.calendar.model.Calendar;
import com.absolute.daytracker.ws.util.ServiceException;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CalendarResource {
    /**
     * Possible resource error messages.
     */
    String CALENDAR_OVERSPECIFIED = "calendar.overspecified";
    String CALENDAR_INCONSISTENT = "calendar.inconsistent";
    String CALENDAR_NOT_FOUND = "calendar.not.found";
    String CALENDAR_QUERY_PARAMETERS_MISSING = "calendar.query.parameters.missing";

    /**
     * Returns calendars according to the search parameters
     *
     * @param query
     *            the query
     * @param skip
     *            the number of initial results to skip
     * @param max
     *            the maximum number of results to display
     *
     * @return the (paginated) set of calendars matching the query parameters
     */
    @GET
    List<Calendar> getCalendars(@QueryParam("q") String query,
            @QueryParam("skip") @DefaultValue("0") int skip, @QueryParam("max") @DefaultValue("100") int max);

    /**
     * Creates a calendar for which the server will generate the id.
     *
     * @param calendar
     *            the calendar object to create. The calendar must have a null id.
     * @return A response with HTTP 201 on success, or a response with HTTP 400 and message
     *         <code>calendar.overspecified</code> if the calendar's id is not null.
     */
    @POST
    Response createCalendar(Calendar calendar);

    /**
     * Supposed to save the representation of the calendar with the given id. Inconsistent data should result in HTTP 400,
     * while a successful PUT should return Response.noContent.
     *
     * @param id
     *            the id of the calendar to save.
     * @return A response with HTTP 204 no content on success, or a response with HTTP 400 and message
     *         <code>calendar.inconsistent</code> if checked data does not have the save id as requested in the URL.
     */
    @PUT
    @Path("{id}")
    @RolesAllowed({"administrator", "user", "visitor"})
    Response createOrUpdateCalendar(@PathParam("id") Long id, Calendar calendar);

    /**
     * Returns the calendar with the given id.
     *
     * @param id
     *            the id of the requested calendar.
     * @return the calendar with the given id.
     * @throws ServiceException
     *             if there is no calendar with the given id, causing the framework to generate an HTTP 404.
     */
    @GET
    @Path("{id}")
    Calendar getCalendarById(@PathParam("id") Long id);

    /**
     * Deletes the calendar with the given id.
     *
     * @param id
     *            the id of the calendar requested to be deleted.
     * @return A response with HTTP 204 no content on success, or a response with HTTP 400 otherwise.
     * @throws ServiceException
     *             if there is no calendar with the given id, causing the framework to generate an HTTP 404.
     */
    @DELETE
    @Path("{id}")
    Response removeCalendarById(@PathParam("id") Long id);
}
