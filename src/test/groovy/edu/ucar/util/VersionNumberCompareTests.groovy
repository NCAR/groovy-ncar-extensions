/*
 * Copyright 2016 University Corporation for Atmospheric Research
 * see LICENSE.txt
 */

package edu.ucar.util


class VersionNumberCompareTests extends GroovyTestCase {

    void testCompareNullNull() {
      try {
        VersionNumber.compare(null,null)
      } catch (NullPointerException e) {
        // OK
      }
    }

    void testCompareANull() {
      String empty = ""
      try {
        VersionNumber.compare(empty,null)
      } catch (NullPointerException e) {
        // OK
      }
    }

    void testCompareNullB() {
      String empty = ""
      try {
        VersionNumber.compare(null,empty)
      } catch (NullPointerException e) {
        // OK
      }
    }

    void testCompareSameEmpty() {
        String empty = ""
        assertEquals 0, VersionNumber.compare(empty,empty)
    }

    void testCompareSameSimple() {
        String given = "1.0"
        assertEquals 0, VersionNumber.compare(given,given)
    }

    void testCompareSameFormatted() {
        String a = "1.0"
        String b = "01.00"
        assertEquals 0, VersionNumber.compare(a,b)
    }

    void testCompareSameMixed() {
        String a = "1.2.3.4foo"
        String b = "1.2-3_4foo"
        assertEquals 0, VersionNumber.compare(a,b)
    }

    void testCompareSimple() {
        String a = "1.0"
        String b = "2.0"
        assertEquals(-1,VersionNumber.compare(a,b))
        assertEquals 1, VersionNumber.compare(b,a)
    }

    void testCompareLengths() {
        String a = "1"
        String b = "1.0"
        assertEquals(-1,VersionNumber.compare(a,b))
        assertEquals 1, VersionNumber.compare(b,a)
    }

    void testCompareDifferentMixedVersions() {
        String a = "1"
        String b = "2.0"
        assertEquals(-1,VersionNumber.compare(a,b))
        assertEquals 1, VersionNumber.compare(b,a)
    }

    void testCompareDifferentLengthVersions() {
        String a = "2.3"
        String b = "2.3.4"
        assertEquals(-1,VersionNumber.compare(a,b))
        assertEquals 1, VersionNumber.compare(b,a)

    }

    void testCompareMixedAscii() {
        String a = "1.0"
        String b = "10"
        assertEquals(-1,VersionNumber.compare(a,b))
        assertEquals 1, VersionNumber.compare(b,a)
    }

    void testCompareSimilarBeta() {
        String a = "1.0.0-b1"
        String b = "1.0.0-b2"
        assertEquals(-1,VersionNumber.compare(a,b))
        assertEquals 1, VersionNumber.compare(b,a)
    }

    void testCompareSimilarAlphas() {
        String a = "2.3b4"
        String b = "2.3c1"
        assertEquals(-1,VersionNumber.compare(a,b))
        assertEquals 1, VersionNumber.compare(b,a)
    }

}
