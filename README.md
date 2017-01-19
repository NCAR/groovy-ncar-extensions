# groovy-ncareol-extensions

Groovy extensions to standard Java and/or Groovy classes,
as used by developers in UCAR-NCAR/EOL.
Includes:

 * String extensions / convenience methods
 * Date formatting extensions
 * BreakException

## Versions

Versions 1.x uses the old-style extension mechanism
`org.codehaus.groovy.runtime.m12n.ExtensionModuleScanner.MODULE_META_INF_FILE`
which works with up to at least Groovy 2.1.9.

Beginning with version 2.0.0, the module will use the newer
`META-INF/services/org.codehaus.groovy.runtime.ExtensionModule`
file for Groovy 2.2.x+.

There is some overlap in Groovy support for both methods.
All versions of this module may work with a given Groovy version.

Versions 1.x of this module have worked with both Java7 and Java8.

## Deployment

To deploy the project, check that your umask is sufficiently social (e.g. `2`)
and set the build properties described in `gradle.properties.example`.

Use gradle task `uploadArchives` (not `install`).

## License

See LICENSE.txt
