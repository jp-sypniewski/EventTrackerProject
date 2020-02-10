## Event Tracker Project

### Week 12-14 Skill Distillery Project

#### Overview

This project consists of a JPA Project and custom MySQL database paired with a Spring Boot app to publish a REST API.

The database includes tables for tasks, users, and teams.  The main object, a task, has a name, a status (enum), a due date, and a team.  The database also tracks creation and updates of each task object.  A team object has a list of tasks and a list of users.  A user has a team, and the typical username, email, and password.

#### Concepts/Technologies Used

- REST API
- Postman route testing
- Spring Boot
- JPA, Spring Data JPA
- JUnit JPA entity testing
- MySQL
- AWS EC2, Tomcat
- Dependency management (Gradle)

#### Routes

All routes are relative to:
http://3.12.14.177:8080/EventTracker
[not yet working]

| Return Type | Route                 | Functionality                  |
|-------------|-----------------------|--------------------------------|
| `List<Task>`  |`GET api/teams/{teamId}/tasks`            | Gets all tasks for a team                     |
| `Task`        |`GET api/teams/{teamId}/tasks/{taskId}`   | Gets one task by id, needs team id            |
| `Task`        |`POST api/teams/{teamId}/tasks`           | Creates a new task for a team                 |
| `Task`        |`PUT api/teams/{teamId}/tasks/{taskId}`   | Replaces an existing task by id, needs team id|
| `-`           |`DELETE api/teams/{teamId}/posts/{taskId}`| Deletes an existing task by id, needs team id |

#### Lessons Learned

- Grab managed item for Update
  - Merely saveAndFlush-ing an object, without first grabbing a managed object, results in the creation of a new row.  This can be useful when both the current and updated object must later be referenced, however an issue with grabbing only the most up-to-date objects arises.  This issue can be averted by turning off a boolean in the current object (and thus initializing the boolean as on during object creation).
- Project setup is worth the time investment
  - Follow the instructions.  If the instructions are not perfect, update the instructions the first time an issue is found.
