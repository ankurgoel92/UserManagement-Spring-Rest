
# User Management Rest Api using Spring

### Building the Project
------------
- JDK 8
- Running the standard maven build :
`mvn clean install`
- Building in eclipse :
Create a new Maven run configuration and set the :
    - **Base directory to:** ${project_loc}
    - **Goals:** *clean install*

### Project Modules
------------

| Module             | Description                                                                                         |
| -------------      | -------------                                                                                       |
|**um-common-client**| holds common, generic infrastructure to build a client for the REST API                             |    
|**um-common-test**  | holds common testing infrastructure that it not domain specific                                     |    
|**um-common**       | holds common, generic infrastructure (utilities, abstract classes, etc) that are not domain specific|    
|**um-client**       | holds the actual domain-specific client logic                                                       |    
|**um-ui**           | holds the simple front-end app                                                                      |    
|**um-webapp**       | holds the actual, domain specific REST API                                                          |    

###### The front-end artifacts
----
- Main front-end HTML file - **index.html**
- A simple template file - **home.html**
- Main JS file - **hello.js**

> **Note:** It is a plain vanilla AngularJS front end for consuming the server side APIs and rendering the data on screen.

### Domain Model
------------
**User \*->\* Role \*->\* Privilege**

### Layers of the Application
------------
1. The Persistence layer
2. The Service layer
3. The Web / API layer

### Persistence Setup
------------
The project uses the H2 in-memory DB and persistence-h2.properties

### Application Bootstrap
------------
SecuritySetup class will run during the bootstrap process of Spring and will create some setup data - Privileges, Roles and Users

### Maven
------------
The parent pom defines the versions of all dependencies and some default plugins and plugin configuration.
The sub-modules inherit this config and define their own specific pom config in addition to it.
