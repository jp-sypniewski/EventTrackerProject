## Event Tracker Project

### Week 12-14 Skill Distillery Project

#### Overview

This project consists of a JPA Project and custom MySQL database paired with a Spring Boot app to publish a REST API.  The project contains a single-page application (SPA), written in Javascript, with data accessed via API and XMLHttpRequest.

The database includes tables for tasks, users, and teams.  The main object, a task, has a name, a status (enum), a due date, and a team.  The database also tracks creation and updates of each task object.  A team object has a list of tasks and a list of users.  A user has a team, and the typical username, email, and password.

The Javascript front end displays information about all tasks for team 1.  The count of task completion status is displayed immediately below, followed by a form to add a new task to team 1.  By clicking on a task/row within the initial display table, the detail view of a single task is shown, accompanied by a form to update the task or delete the task.  The front end loaded to EC2 can accessed at: http://3.12.14.177:8080/EventTrackerREST/

#### Concepts/Technologies Used

- REST API
- Javascript XMLHttpRequest, HTML
- Postman route testing
- Spring Boot
- JPA, Spring Data JPA
- JUnit JPA entity testing
- MySQL
- AWS EC2, Tomcat
- Dependency management (Gradle)

#### Routes

All routes are relative to:
http://3.12.14.177:8080/EventTrackerREST/

| Return Type | Route                 | Functionality                  |
|-------------|-----------------------|--------------------------------|
| `List<Task>`  |`GET api/teams/{teamId}/tasks`            | Gets all tasks for a team                     |
| `Task`        |`GET api/teams/{teamId}/tasks/{taskId}`   | Gets one task by id, needs team id            |
| `Task`        |`POST api/teams/{teamId}/tasks`           | Creates a new task for a team                 |
| `Task`        |`PUT api/teams/{teamId}/tasks/{taskId}`   | Replaces an existing task by id, needs team id|
| `-`           |`DELETE api/teams/{teamId}/posts/{taskId}`| Deletes an existing task by id, needs team id |
||||
| `List<Team>`  |`GET api/teams`                           | Gets all teams                                |
| `Team`        |`GET api/teams/{teamId}`                  | Gets one team                                 |
| `Team`        |`POST api/teams`                          | Creates a new team                            |
| `Team`        |`PUT api/teams/{teamId}`                  | Replaces an existing team                     |

#### Lessons Learned

- Grab managed item for Update
  - Merely saveAndFlush-ing an object, without first grabbing a managed object, results in the creation of a new row.  This can be useful when both the current and updated object must later be referenced, however an issue with grabbing only the most up-to-date objects arises.  This issue can be averted by turning off a boolean in the current object (and thus initializing the boolean as on during object creation).
- Project setup is worth the time investment
  - Follow the instructions.  If the instructions are not perfect, update the instructions the first time an issue is found.
- Importance of HTTP status codes
  - Checking the status code of an API response allows specific changes to be displayed to the user.  When writing an API, the way the routes are used and checked should be taken into heavy consideration.

#### Future Updates

- Modify JS front end for greater functionality
  - Nothing provided for team, user objects
- API Updates
  - Provide for user objects
