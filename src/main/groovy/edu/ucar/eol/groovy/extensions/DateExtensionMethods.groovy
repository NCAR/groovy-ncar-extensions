/*
 * Copyright 2016 University Corporation for Atmospheric Research
 * see LICENSE.txt
 */

package edu.ucar.eol.groovy.extensions

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Extensions to {@code Date}
 *
 * @author jja@ucar.edu
 * @see Date
 */
class DateExtensionMethods {

  private static final HTTP_FORMAT = "EEE, dd MMM yyyy HH:mm:ss 'GMT'";

  /**
   * Format a Date for HTTP headers (i.e. conforming to RFC-1123).
   *
   * Note that a new DateFormat instance is created for every
   * invocation of this method (for thread safety).
   *
   * Copied and updated from Groovy's DateGroovyMethods.
   *
   * @param self a Date
   * @return String representation of this date formatted for use in HTTP headers
   * @see org.codehaus.groovy.runtime.DateGroovyMethods.format()
   */
  static String formatHttp(Date self) {
    SimpleDateFormat sdf = new SimpleDateFormat(HTTP_FORMAT,Locale.US);
    TimeZone tz = TimeZone.getTimeZone('GMT');
    sdf.setTimeZone(tz);
    return sdf.format(self);
  }

}
