package com.absolute.daytracker.ws.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.absolute.daytracker.ws.dao.util.QueryBuilder;
import com.absolute.daytracker.ws.domain.EventOccurrence;

public class EventOccurrenceDaoHibernateImpl extends HibernateDaoSupport implements EventOccurrenceDao {

    @Override
    public EventOccurrence getEventOccurrenceById(Long id) {
        return getHibernateTemplate().get(EventOccurrence.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<EventOccurrence> getEventOccurrences(Long eventId,
            int skip, int max) {
        return createEventOccurrenceQuery(eventId)
                .build(getSession())
                .setFirstResult(skip)
                .setMaxResults(max)
                .list();
    }

    @Override
    public EventOccurrence createEventOccurrence(EventOccurrence eventOccurrence) {
        getHibernateTemplate().save(eventOccurrence);
        return eventOccurrence;
    }

    @Override
    public void createOrUpdateEventOccurrence(EventOccurrence eventOccurrence) {
        getHibernateTemplate().saveOrUpdate(eventOccurrence);
    }

    @Override
    public void removeEventOccurrenceById(Long id) {
        EventOccurrence eventOccurrence = getHibernateTemplate().get(EventOccurrence.class, id);
        getHibernateTemplate().delete(eventOccurrence);
    }

    /**
     * Returns a base HQL query object (no pagination) for the given parameters
     * for eventOccurrences.
     *
     * @param query String for database query
     * @param active Flag whether eventOccurrence sought is active
     * @return HQL query object for given parameters
     */
    private QueryBuilder createEventOccurrenceQuery(Long eventId) {
        QueryBuilder builder = new QueryBuilder(
            "select e from eventoccurrence e",
            "order by id"
        );

        if (eventId != null) {
            builder.clause("e.eventid like :eventId", "%" + eventId + "%");
        }

        return builder;
    }

}
