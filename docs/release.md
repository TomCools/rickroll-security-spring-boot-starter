# How to publish something to Maven Central.

Using JReleaser: https://jreleaser.org/guide/latest/examples/maven/index.html

- Set version: `mvn versions:set`
- Stage artifacts: `mvn -Ppublication`
- (Dry) Run JReleaser: `mvn -Djreleaser.dry.run=true jreleaser:full-release`

Afterwards, set next snapshot version.
