**How to run:**
1. Clone or download the files from the repository.
2. Using your favorite IDE, load the maven project then run the following commands:
	- mvn clean install
	- mvn clean spring-boot:run

**Environment requirements:**

- Maven
- Java JDK 11+
- Java JRE 19

**API Endpoints:**

/api/v1/flights [GET/POST]

/api/v1/flights/{airlineCode} [GET]


**In PROD Environment**
- More tests will be added as business logic expands
- Validators will be implemented
- Spring security, OAuth and other security measures will be implemented
- Separate profiles for dev, testing, and integration will be used
- Cloud services may be used 

DB:
- Liquibase will be used

Repo:
- There will be additional branches for qa and staging. As well as feature and hotfix branches.
- Pull request will be enforced

