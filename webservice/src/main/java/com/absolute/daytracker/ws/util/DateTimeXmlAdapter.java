package com.absolute.daytracker.ws.util;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;

public class DateTimeXmlAdapter extends XmlAdapter<Date, DateTime> {

    @Override
    public DateTime unmarshal(Date date) throws Exception {
        return new DateTime(date.getTime());
    }

    @Override
    public Date marshal(DateTime dateTime) throws Exception {
        return new Date(dateTime.getMillis());
    }
}
