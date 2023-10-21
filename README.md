# JPrompter

Tiny Java library for producing interactive command line prompts.

#

### Project Requirement

- Java 17

#

### Release

`` mvn release:clean release:prepare -Dmaven.javadoc.skip=true ``

This will create a tag
you can then create a release from the tag on GitHub UI
as soon as you create a release the `maven-publish` GitHub action will be triggered and the artifact will be build and
published to GitHub packages

### Directly Deploye

``mvn release:clean release:prepare release:perform -Dmaven.javadoc.skip=true``

Will create the tag, release and publish the artifact to GitHub packages
