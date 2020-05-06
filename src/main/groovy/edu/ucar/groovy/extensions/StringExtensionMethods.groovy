/*
 * Copyright 2014 University Corporation for Atmospheric Research
 * see LICENSE.txt
 */

package edu.ucar.groovy.extensions

/**
 * Extensions to {@code String}
 *
 * @author jja@ucar.edu
 * @see String
 */
class StringExtensionMethods {

  /**
   * Returns a string no longer than length,
   * with "..." appended if the original string was longer.
   * Breaks the string at the last non-letter so the excerpt is readable.
   * If length is less than three, then "..." is not appended.
   *
   * @param length maximum length of returned string
   * @return the excerpted string
   */
  static String excerpt(String self, Integer length=255) {
    if (null == length) length=255
    if (length < 0) return null
    if (self.length() <= length) return self
    if (length <= 3) return self.substring(0,length)
    def i
    for (i=length-3; i>0 && Character.isLetter(self.codePointAt(i)); i--) ;
    if (i==0) i=length-3;
    return self.substring(0,i) + '...'
  }

  /**
   * Returns a new string that has had the last character removed from the given string.
   * Like Perl's chop().
   *
   * @return the new shortened string
   */
  static String chop(String self) {
    try { return self.substring(0,self.length()-1) }
    catch (IndexOutOfBoundsException) { return '' }
  }

  /**
   * Returns a string consisting of the original string,
   * appended by a specified string the specified number of times.
   * <p>
   * {@code "foo".append("bar",2) == "foobarbar"}
   * <p>
   * append(String) is append(string,1), like StringBuilder.append()
   *
   * @param suffix the string to append
   * @param n the number of times to append suffix
   * @return the new string
   * @see StringBuilder#append(String)
   */
  static String append(String self, String suffix, Integer n=1) {
    if (n<=0) return self
    if (!suffix?.length()) return self
    return self + suffix * n
  }

  /**
   * Returns a boolean indicating if the string is blank
   * (empty or contains only whitespace).
   * <p>
   * i.e. the trimmed version of the original string has zero length.
   *
   * @return whether the string is blank
   */
  static boolean isBlank(String self) {
    return self.trim().length() == 0
  }

  /**
   * Returns a boolean indicating if the string is not blank
   * (contains non-whitespace).
   * <p>
   * i.e. the trimmed version of the original string has non-zero length.
   *
   * @return whether the string is not blank
   */
  static boolean isNotBlank(String self) {
    return self.trim().length() > 0
  }

  /**
   * modified from http://langref.org/groovy/strings/reversing-a-string/textwrap
   */
  static String fill(String self, Integer width=80, String prefix='') {
    def out = ''
    def remaining = self.replaceAll('\\s+',' ')
    while (remaining) {
      def next = prefix + remaining
      def found = -1
      if (next.length() > width) found = next.lastIndexOf(' ', width)
      if (found == -1) {
        remaining = ''
      } else {
        remaining = next.substring(found + 1)
        next = next.substring(0,found)
      }
      out += next + '\n'
    }
    return out
  }

}
