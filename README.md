#gbif-doi

This project provides [DOI](https://en.wikipedia.org/wiki/Digital_object_identifier) services used by the IPT, Portal and Registry web services. 
This library is capable of connecting with either [DataCite](https://www.datacite.org/) or [EZID](http://ezid.cdlib.org/) to assign and manage DOIs, 
the functionality exposed by this library is accessible through the interface [DoiService](/src/main/java/org/gbif/doi/service/DoiService.java), which
provides methods to: resolve, register, reserve, delete and update DOIs and the related metadata.

##To build this project

Execute the Maven command passing as parameter GBIF's datacite password.

```
  mvn clean package verify -Ddatacite.password=*****
```

Note that the password is also required when releasing; supply it as an environment variable:

```
  export MAVEN_OPTS='-Ddatacite.password=*****'
```

##How to use this library

The consumer of this library must decide which provider of the service [DoiService](/src/main/java/org/gbif/doi/service/DoiService.java) that they prefer to use. The provided implementations are [DataCiteService](/src/main/java/org/gbif/doi/service/datacite/DataCiteService.java) and [EzidService](/src/main/java/org/gbif/doi/service/ezid/EzidService.java);
both implementations require an username and password to connect to the specific service.
