
## CODE-A-THON BACKEND-JAVA,SPRING(WEEK-1)
# CoderHack 

This project is a RESTful API service developed using Spring Boot to manage the Leaderboard for a Coding Platform. It uses MongoDB to persist the data.

## Operations
The API handles CRUD operations for user registrations for a coding contest. Each user has a unique identifier (User ID), a username, a score (ranging from 0 to 100), and badges(Code Ninja, Code Champ, Code Master) awarded based on their score.

### User Registration
- Users must provide a User ID and Username for registration.
- Upon registration, the score is initialized to 0, and badges are empty.
- Users can have a maximum of three unique badges: Code Ninja, Code Champ, and Code Master.

### Score Update
- Score can be updated through PUT requests.
- Badges are awarded based on the score range:
  - 1 <= Score <= 30: Code Ninja
  - 30 <= Score <= 60: Code Champ
  - 60 <= Score <= 100: Code Master

### API Endpoints
- GET /users: Retrieve a list of all registered users.
- GET /users/{userId}: Retrieve the details of a specific user.
- POST /users: Register a new user to the contest.
- PUT /users/{userId}: Update the score of a specific user.
- DELETE /users/{userId}: Deregister a specific user from the contest.

## Postman Collection
You can find the Postman Collection for this project to call api's and test [Postman Collection Link](https://elements.getpostman.com/redirect?entityId=32824438-42ba4ad5-9b2c-422f-8172-9cd33d1574d4&entityType=collection).

## Installation and Setup
1. Clone the repository from GitHub: [Repo Link](https://github.com/somalaraju-harsha/CoderHack)
2. Set up the project locally using Spring Boot.
3. Intall jdk 17 and mongodb in local set up.
4. Configure MongoDB connection settings in the application.properties file.

## Usage
1. Run the application locally.
2. Use Postman or any API testing tool to interact with the endpoints.
3. Refer to the Postman Collection provided in the repository for API requests.

## Testing
- Basic JUnit test cases are provided to verify the functionality.

## To Contribute
1. Fork the repository.
2. Create a new branch.
3. Make your changes and commit them with meaningful messages.
4. Push your changes to your forked repository.
5. Submit a pull request to the main repository.
