package edu.ucar.groovy

@Singleton
class BreakException extends Exception {

/*
 * if this begins to fail in jdk7 due to:
 *   va.lang.IncompatibleClassChangeError:
 *   the number of constructors during runtime
 *   and compile time for java.lang.Exception do not match
 *
 * then add constructors, especially the no-arg ctor, that call super:
 *
   public BreakException() { super() }
   public BreakException(String message) { super(message) } 
 *
 */

}
