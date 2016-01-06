/*
 * Copyright 2016 University Corporation for Atmospheric Research
 * see LICENSE.txt
 */

package edu.ucar.eol.util

/**
 * Utilities to deal with version numbers
 *
 * @author John Allison
 */
class VersionNumber {

  private static String _SEPARATORS = '.-_';

  /**
   * Format and normalize a version number String so that it ASCII-sorts reasonably
   * close to its semantic-sort. Characters . - _ are considered separators
   * and normalized to dot. Number tokens are zero-padded to 2 digits.
   *
   * Motivated by and helpful for building WAR filenames that sort correctly.
   *
   * Example:
   * <code><pre>
   * assert VersionFormatter.format('2.7.0-b1') == '02.07.00.b1'
   * assert '2.7.0-b1' > '2.10.0'  // not what we want!
   * assert VersionFormatter.format('2.7.0-b1') < VersionFormatter.format('2.10.0') 
   * </pre></code>
   *
   * @param version version number string
   * @return the formatted string
   */
  static String formatForAscii(String version) {
    return version?.tokenize(_SEPARATORS).collect{
      if (it =~ /^\d+$/) { it.padLeft(2,'0') } else { it }
      }.join('.')
  }

  /**
   * Compare version number arguments for semantic order.
   *
   * @param a first version number String to compare
   * @param b second version number String to compare
   * @return -1, 0, or +1 when a the lower, same, or higher version number than b
   */
  static int compare(String a, String b) throws NullPointerException {
    if (null == a) throw new NullPointerException()
    if (null == b) throw new NullPointerException()
    if (a.equalsIgnoreCase(b)) return 0
    return compareImpl(a.tokenize(_SEPARATORS),b.tokenize(_SEPARATORS))
  }

  private static int compareImpl(ArrayList a, ArrayList b) {
    if (a.size() == 0) {
      if (b.size() > 0) return -1   // a<b
      if (b.size() == 0) return 0
      }
    if (b.size() == 0) return 1     // a>b

    def i = compareComponent(a.remove(0), b.remove(0))
    if (0 != i) return i

    return compareImpl(a,b)
  }

  private static int compareComponent(String a, String b) {
    if (null == a) throw new NullPointerException()
    if (null == b) throw new NullPointerException()

    def ma = a =~ /^(\d+)(.*)$/
    def mb = b =~ /^(\d+)(.*)$/

    if (ma && mb) {
      // compare leading numerics
      def ia = ma[0][1].toInteger()
      def ib = mb[0][1].toInteger()
      def i = ia.compareTo(ib)
      if (0 != i) return i

      // compare trailing alphas (or mixed alphanumeric)
      return ma[0][2].compareToIgnoreCase(mb[0][2])
    }

    // no leading numerics found so just compare strings
    return a.compareToIgnoreCase(b)
  }

}
