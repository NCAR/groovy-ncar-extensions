/*
 * Copyright 2014 University Corporation for Atmospheric Research
 * see LICENSE.txt
 */

package edu.ucar.groovy.extensions

class StringFillTests extends GroovyTestCase {

    void testFillEmpty() {
        String empty = ""
        assertEquals empty, empty.fill()
        assertEquals empty, empty.fill(2)
        assertEquals empty, empty.fill(22)
        assertEquals empty, empty.fill(0)
    }

    void testFillRealCitation() {
        String citation = 'Volkamer, R., University of Colorado. 2013. GV AMAX-DOAS Data, Version 1.0. UCAR/NCAR - Earth Observing Laboratory. http://data.eol.ucar.edu/dataset/352.082. Accessed 01 Apr 2015.'
        String filledCitation = '''\
 Volkamer, R., University of Colorado. 2013. GV AMAX-DOAS Data, Version 1.0.
 UCAR/NCAR - Earth Observing Laboratory.
 http://data.eol.ucar.edu/dataset/352.082. Accessed 01 Apr 2015.
'''

      println ':::'+citation.fill(78,' ')+':::'
        assertEquals filledCitation, citation.fill(78,' ')
    }

}
