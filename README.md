# groovy-ncareol-extensions

Groovy extensions to standard Java and/or Groovy classes,
as used by developers in UCAR-NCAR/EOL.
Includes:

 * String extensions / convenience methods
 * Date formatting extensions
 * BreakException

## Versions

Beginning with version 2.0.0, this module uses the newer
`META-INF/services/org.codehaus.groovy.runtime.ExtensionModule`
file for Groovy 2.2.x+.

Versions 1.x used the old-style extension mechanism
`org.codehaus.groovy.runtime.m12n.ExtensionModuleScanner.MODULE_META_INF_FILE`
which works with up to at least Groovy 2.1.9 and 2.2.1.

There is some overlap in Groovy support for both methods.
All versions of this module may work with a given Groovy version.

The specified Groovy version should be kept in sync with that
specified by the latest version of Grails.
This module is developed and tested with the latest Java8 (JDK 1.8.x).

## Deployment

To deploy the project, check that your umask is sufficiently social (e.g. `2`)
and set the Maven URL property described in `gradle.properties.example`.

Use gradle task `uploadArchives` (not `install`).

## License

See LICENSE.txt
