/*
 * Copyright 2016 University Corporation for Atmospheric Research
 * see LICENSE.txt
 */

package edu.ucar.eol.util


class VersionNumberFormatTests extends GroovyTestCase {

    void testFormatNull() {
        String empty = ""
        assertEquals empty, VersionNumber.formatForAscii(null)
    }

    void testFormatEmpty() {
        String empty = ""
        assertEquals empty, VersionNumber.formatForAscii(empty)
    }

    void testFormatSimple() {
        String given = "1.0"
        String expected = "01.00"
        assertEquals expected, VersionNumber.formatForAscii(given)
    }

    void testFormatBeta() {
        String given = "2.1.0-b3"
        String expected = "02.01.00.b3"
        assertEquals expected, VersionNumber.formatForAscii(given)
    }

    void testFormatMixed() {
        String given = "2.1.0-b3_foobar"
        String expected = "02.01.00.b3.foobar"
        assertEquals expected, VersionNumber.formatForAscii(given)
    }

    void testFormatOverflow() {
        String given = "22.345.0"
        String expected = "22.345.00"
        assertEquals expected, VersionNumber.formatForAscii(given)
    }

}
