# groovy-ncareol-extensions

Groovy extensions to standard Java and/or Groovy classes,
as used by developers in UCAR-NCAR/EOL.
Includes:

 * String extensions / convenience methods
 * Date formatting extensions

## Deployment

To deploy the project, check that your umask is sufficiently social (e.g. `2`)
and set the build properties described in `gradle.properties.example`.

Use gradle task `uploadArchives` (not `install`).

## License

See LICENSE.txt
