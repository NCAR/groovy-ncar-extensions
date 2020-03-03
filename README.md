# groovy-ncareol-extensions

Groovy extensions to standard Java and/or Groovy classes,
as used by developers in UCAR-NCAR/EOL.
Includes:

 * String extensions / convenience methods
 * Date formatting extensions
 * BreakException

## Version compatibilities

Version 3.x of this module uses the
`META-INF/groovy/org.codehaus.groovy.runtime.ExtensionModule`
file for Groovy 2.5.x+. This is the master branch of the repo.

Version 2.0.0 of this module uses the
`META-INF/services/org.codehaus.groovy.runtime.ExtensionModule`
file for Groovy 2.2.x+.

Versions 1.x used the old-style extension mechanism
`org.codehaus.groovy.runtime.m12n.ExtensionModuleScanner.MODULE_META_INF_FILE`
which works with Groovy up to at least 2.1.9 and 2.2.1.

There is some overlap in Groovy support for both methods of the previous two methods.
Versions 1.x and 2.x of this module may work with any random given Groovy version.
Version 3.x+ of this module will probably only work with Groovy 2.5+.

In general, an attempt will be made to keep the Groovy version
targeted by this module in sync with that specified by the latest version of Grails.
(Currently: Grails 4.0.1, Groovy 2.5.6)

This module is developed and tested with the latest Java8 (OpenJDK 1.8.x).

## Deployment

To deploy the project, check that your umask is sufficiently social (e.g. `2`)
and set the Maven URL property described in `gradle.properties.example`.

Use gradle task `uploadArchives` (not `install`).

## License

See LICENSE.txt
