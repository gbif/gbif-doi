[![Build Status](https://builds.gbif.org/job/gbif-doi/badge/icon?plastic)](https://builds.gbif.org/job/gbif-doi/)
[![Quality Gate Status](https://sonar.gbif.org/api/project_badges/measure?project=org.gbif%3Agbif-doi&metric=alert_status)](https://sonar.gbif.org/dashboard?id=org.gbif%3Agbif-doi) 
[![Coverage](https://sonar.gbif.org/api/project_badges/measure?project=org.gbif%3Agbif-doi&metric=coverage)](https://sonar.gbif.org/dashboard?id=org.gbif%3Agbif-doi)


# gbif-doi

This project provides [DOI](https://en.wikipedia.org/wiki/Digital_object_identifier) services used by the IPT, Portal and Registry web services. 
This library is capable of connecting with [DataCite REST JSON:API](https://github.com/gbif/datacite-rest-client) to assign and manage DOIs, 
the functionality exposed by this library is accessible through the interface [DoiService](/src/main/java/org/gbif/doi/service/DoiService.java), which
provides methods to: resolve, register, reserve, delete and update DOIs and the related metadata.

**IMPORTANT:** Verson 2.0 and higher stopped supporting MDS and EZID services. 

Datacite DOI Fabrica: [test](https://doi.test.datacite.org), [prod](https://doi.datacite.org)

## To build this project

Execute the Maven command passing as parameter GBIF's datacite password.

```
  mvn clean package verify -Ddatacite.password=***** -Ddatacite.api.base.url=https://api.test.datacite.org -Ddatacite.user=GBIF.GBIF
```

Properties can be changed. Note that the password is also required when releasing; supply it as an environment variable:

```
  export MAVEN_OPTS='-Ddatacite.password=*****'
```

## Profiles
- **coverage** - enable unit tests coverage calculating with jacoco-maven-plugin

- **integration-tests** - for launching integration tests. 
Includes maven-failsafe-plugin with configurations 
and code coverage by integration tests with jacoco-maven-plugiin
