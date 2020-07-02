/*
 * Copyright 2020 University Corporation for Atmospheric Research
 * see LICENSE
 */

package edu.ucar.groovy.extensions

class StringCaseTests extends GroovyTestCase {

    void testCaseEmpty() {
        String empty = ""
        assertEquals empty, empty.toCamelCase()
        assertEquals empty, empty.to_snake_case()
        assertEquals empty, empty.toSpaceCase()
        assertEquals empty, empty.toHyphenCase()
        assertEquals empty, empty.toDotCase()
    }

    void testAllLower() {
        String expected = 'foobar'
        assertEquals expected, expected.toCamelCase()
        assertEquals expected, expected.to_snake_case()
        assertEquals expected, expected.toSpaceCase()
        assertEquals expected, expected.toHyphenCase()
        assertEquals expected, expected.toDotCase()
    }

    void testAllPunctToSnake() {
        assertEquals '___','___'.to_snake_case()
        assertEquals '...','...'.to_snake_case()
        assertEquals '---','---'.to_snake_case()
    }

    void testAllPunctToSpace() {
        assertEquals '___','___'.toSpaceCase()
        assertEquals '...','...'.toSpaceCase()
        assertEquals '---','---'.toSpaceCase()
    }

    void testAllSpace() {
        // special case: whitespace always gets trimmed
        assertEquals '','   '.to_snake_case()
        assertEquals '','   '.toSpaceCase()
    }

    void testAllPunct() {
        String expected = ''
        assertEquals expected, ' '.toCamelCase()
        assertEquals expected, '   '.toCamelCase()
        assertEquals expected, '-'.toCamelCase()
        assertEquals expected, '---'.toCamelCase()
        assertEquals expected, '_'.toCamelCase()
        assertEquals expected, '___'.toCamelCase()
        assertEquals expected, '.'.toCamelCase()
        assertEquals expected, '...'.toCamelCase()
    }

    void testBasicToCamelCase() {
        String expected = "fooBarBahz"
        assertEquals expected, 'foo_bar_bahz'.toCamelCase()
        assertEquals expected, "  foo bar bahz  ".toCamelCase()
        assertEquals expected, 'foo.Bar.bahz'.toCamelCase()
        assertEquals expected, 'foo-bar-bahz'.toCamelCase()
        assertEquals expected, '--foo-bar-bahz--'.toCamelCase()
        assertEquals expected, 'foo. Bar-bahz'.toCamelCase()
    }

    void testCamelToCamel() {
        // unsatisfactory in actual usage
        String expected = "fooBarBahz"
        assertEquals expected, expected.toCamelCase()
    }

    void testSnakeToSnake() {
        // unsatisfactory in actual usage
        String expected = "foo_bar_bahz"
        assertEquals expected, expected.to_snake_case()
    }

    void testAllUpper() {
        // unsatisfactory in actual usage when we probably want no change (?)
        // but we're not dealing with env vars now
        String expected = 'f_o_o_b_a_r'
        assertEquals expected, "FOOBAR".to_snake_case()
    }

}
