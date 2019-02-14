# UserManagement-Spring-Rest
User Management application

# Project Module
common - Library project module with generic functionality and utilities.<br>
um-webapp - module contains the domain-specific logic and represents the web application.

# Domain Model
User *->* Role *->* Privilege

# Layers of the Application
1. The Persistence layer
2. The Service layer
3. The Web / API layer

# Persistence Setup
The project uses the H2 in-memory DB and persistence-h2.properties

# Application Bootstrap
SecuritySetup class will run during the bootstrap process of Spring and will create some setup data - Privileges, Roles and Users

# Maven
The parent pom defines the versions of all dependencies and some default plugins and plugin configuration.<br>
The sub-modules inherit this config and define their own specific pom config in addition to it.

# Commands
mvn archetype:generate -DgroupId=org.spring -DartifactId=um-parent -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
<br>
cd um-parent
<br>
mvn archetype:generate -DgroupId=org.spring -DartifactId=um-common -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
<br>
mvn archetype:generate -DgroupId=org.spring -DartifactId=um-webapp -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
