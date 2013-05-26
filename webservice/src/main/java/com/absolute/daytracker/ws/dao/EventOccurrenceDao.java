package com.absolute.daytracker.ws.dao;

import java.util.List;

import com.absolute.daytracker.ws.domain.EventOccurrence;

public interface EventOccurrenceDao {

    /**
     * Returns the eventOccurrence with the given id, or null if no such eventOccurrence exists.
     */
    EventOccurrence getEventOccurrenceById(Long id);

    /**
     * Returns a paginated set of eventOccurrences that match the required query term,
     * skipping the first <code>skip</code> results and returning at most
     * <code>max</code> results.
     */
    List<EventOccurrence> getEventOccurrences(Long eventId, int skip, int max);

    /**
     * Saves the given eventOccurrence, which should have a null id.
     */
    EventOccurrence createEventOccurrence(EventOccurrence eventOccurrence);

    /**
     * Updates or saves the given eventOccurrence, which should have a non-null id.
     */
    void createOrUpdateEventOccurrence(EventOccurrence eventOccurrence);

    /**
     * Deletes an eventOccurrence by the given eventOccurrence ID.
     */
    void removeEventOccurrenceById(Long id);

}
