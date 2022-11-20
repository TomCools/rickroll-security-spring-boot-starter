# How to publish something to Maven Central.

https://itnext.io/publishing-artifact-to-maven-central-b160634e5268


- Build release artifacts: clean install -Prelease
- Check GPG signature: gpg --verify target/*.pom.asc
- Deploy on Sonatype: clean deploy -Prelease