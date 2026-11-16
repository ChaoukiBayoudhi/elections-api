# Elections API

A spring-boot application based on Entity Control Boundary and Data Transfert Objects.

## Tech stack

- Java 15, built with Maven
- Spring Boot 2.4.2
- Spring Web (REST controllers)
- Spring Data JPA (Hibernate)
- Spring Data REST
- Spring Boot Actuator
- Springfox Swagger
- Lombok
- PostgreSQL driver
- H2 database
- Database: PostgreSQL (`electiondb` in `application.properties`)

## Data model

| Entity | Fields |
|---|---|
| `Candidate` | id, name, birthDate, listPosition, photo, electors, activities, listOfCandidate |
| `Activity` | id, title, activityDate, duration, place, type, candidateOwner, activityJustification |
| `CandidatesList` | id, name, slogan, state, electionStatement, electionSymbol, canditates, lists |
| `Elector` | id, age, state, scientificLevel, candidates, lists |
| `Justification` | code, content, type, activity |
| `ElectorList` | id, score, elector, list |

## REST endpoints

Found in the controllers (`ActivityController`):

| Method | Path |
|---|---|
| GET | `/all` |
| POST | `/add` |
| GET | `/{id}` |
| DELETE | `/delete/{id}` |
| PUT | `/update/{id}` |

## Project structure

- `tn.esb.lbc.electionsapi`: ElectionsApiApplication
- `tn.esb.lbc.electionsapi.Commun`: Web
- `tn.esb.lbc.electionsapi.Configuration`: SwaggerConfiguration
- `tn.esb.lbc.electionsapi.Domain`: Activity, Candidate, CandidatesList, Elector, ElectorList, ElectorListId, Justification
- `tn.esb.lbc.electionsapi.Enumerations`: ActivityType, JustificationType, Level
- `tn.esb.lbc.electionsapi.Repository`: ActivityRepository, CandidateListRepository, CandidateRepository, ElectorListRepository
- `tn.esb.lbc.electionsapi.Services`: ActivityService, CandidateListService, CandidateService
- `tn.esb.lbc.electionsapi.Web`: ActivityController, CandidateController, CandidateListController
- Tests: 1 test class

## How to run

Requirements: a JDK 15+ and Maven (or the included Maven wrapper).
Create the `electiondb` database and set your own username and password in `src/main/resources/application.properties`.

```bash
./mvnw spring-boot:run
```

The API then listens on `http://localhost:9592`.

---

Author: [Chaouki Bayoudhi](https://github.com/ChaoukiBayoudhi)
