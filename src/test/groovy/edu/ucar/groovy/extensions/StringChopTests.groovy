/*
 * Copyright 2014 University Corporation for Atmospheric Research
 * see LICENSE.txt
 */

package edu.ucar.groovy.extensions


class StringChopTests extends GroovyTestCase {

    void testChopSimple() {
        String given = "abc"
        String expected = "ab"
        assertEquals expected, given.chop()
    }

    void testChopEmpty() {
        String empty = ""
        assertEquals empty, empty.chop()
    }

    void testChopShortString() {
        String given = "a"
        String empty = ""
        assertEquals empty, given.chop()
    }

}
