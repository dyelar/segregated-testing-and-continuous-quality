# Segregated Testing Example

This project provides example code for integrating unit tests and integration tests under a single project, while still getting the code coverage data into SonarQube.  Be aware, the Integration Tests and Coverage will all show up under the Unit Tests Coverage, rather than split out, but the coverage should show up accruately.

The pom projects contained under the parent-poms directory are meant to show how you can split out pieces of the configuration to make it common across your projects.  An _mvn install_ will need to be done in each directory before you can play around with the _standard-project_ example.

## Slides

I've put the slides from my KCDC 2014 presentation on segregated-testing and continuous qualityy using SonarQube into the slides directory.  They are in LibreOffice Presenter format.

## License

This code in the segregated-testing-example is licensed under the Apache 2.0 License.  If for some reason this conflicts with a license you would like to use, please feel free to email me and we can discuss putting it under an appropriate Free Software license, which is compatible.

&copy; 2014 Matthew M. Copeland
