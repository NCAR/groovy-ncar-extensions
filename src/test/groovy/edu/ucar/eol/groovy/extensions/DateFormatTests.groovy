/*
 * Copyright 2016 University Corporation for Atmospheric Research
 * see LICENSE.txt
 */

package edu.ucar.eol.groovy.extensions

import java.util.Date
import java.sql.Time
import java.sql.Timestamp

class DateFormatTests extends GroovyTestCase {

    private static final String EXPECTED_DATE_0_HTTP = 'Thu, 01 Jan 1970 00:00:00 GMT';

    void testDateZero() {
        Date given = new Date(0L)
        assertEquals EXPECTED_DATE_0_HTTP, given.formatHttp()
    }

    void testTimeZero() {
        Time given = new Time(0L)
        assertEquals EXPECTED_DATE_0_HTTP, given.formatHttp()
    }

    void testTimestampZero() {
        Timestamp given = new Timestamp(0L)
        assertEquals EXPECTED_DATE_0_HTTP, given.formatHttp()
    }

    void testTimestampToday() {
        // approximate time of writing the test
        Timestamp given = new Timestamp(1453845244000L)
        String expected = 'Tue, 26 Jan 2016 21:54:04 GMT'
        assertEquals expected, given.formatHttp()
    }

    void testTimestampTodayWithMillis() {
        // approximate time of writing the test
        Timestamp given = new Timestamp(1453845244999L)
        String expected = 'Tue, 26 Jan 2016 21:54:04 GMT'
        assertEquals expected, given.formatHttp()
    }

}
